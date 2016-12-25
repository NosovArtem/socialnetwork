package com.sbertech.javaschool.controller;

import com.sbertech.javaschool.messaging.MessageSender;
import com.sbertech.javaschool.model.User;
import com.sbertech.javaschool.model.UserInformation;
import com.sbertech.javaschool.model.UserInformationResponse;
import com.sbertech.javaschool.repository.UserRepository;
import com.sbertech.javaschool.service.SecurityService;
import com.sbertech.javaschool.service.SecurityUtil;
import com.sbertech.javaschool.service.ServiceImages;
import com.sbertech.javaschool.service.UserService;
import com.sbertech.javaschool.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageSender messageSender;

    @Autowired
    SecurityUtil securityUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        User currentUser = securityUtil.getCurrentUser();
        currentUser.setAvatarBase64(ServiceImages.encodeImageInBase64(currentUser.getAvatar()));

        List<User> collect = currentUser.getFriends()
                .stream()
                .peek(u -> {
                            byte[] avatar = u.getAvatar();
                            String image64 = ServiceImages.encodeImageInBase64(avatar);
                            u.setAvatarBase64(image64);
                        }
                ).collect(Collectors.toList());

        model.addAttribute("listFriends", collect);
        model.addAttribute("user", currentUser);

        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }


    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public String adduserinfo(Model model) {
        model.addAttribute("userInfoForm", new UserInformation());

        return "userinfo";
    }


    @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
    public String adduserinfo(@ModelAttribute("userInfoForm") UserInformation userInfoForm, BindingResult bindingResult, Model model) {
        //Сделать валидацию по всем полям.
      /*  userValidator.validate(userInfoForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }*/
        UserInformation userInformation = userInfoForm;
        userInformation.setUserId(securityUtil.getCurrentUserId());

        UserInformationResponse userInformationResponse = new UserInformationResponse();
        userInformationResponse.setUserInformation(userInformation);
        userInformationResponse.setCommand("UPDATE");

        messageSender.sendMessage(userInformationResponse);

        return "redirect:/welcome";
    }


    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam("fileUpload") MultipartFile fileUpload) throws Exception {

        User user = securityUtil.getCurrentUser();

        user.setAvatar(fileUpload.getBytes());
        userRepository.save(user);

        return "welcome";
    }

    @RequestMapping(value = "/friends/{id}", method = RequestMethod.GET)
    public String showFriend(Model model, @PathVariable("id") Long id) throws UnsupportedEncodingException {
        User user = userRepository.findById(id);
        user.setAvatarBase64(ServiceImages.encodeImageInBase64(user.getAvatar()));
        model.addAttribute("user", user);
        return "friends";
    }

}
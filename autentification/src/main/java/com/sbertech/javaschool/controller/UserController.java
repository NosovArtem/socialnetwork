package com.sbertech.javaschool.controller;

import com.sbertech.javaschool.messaging.MessageSender;
import com.sbertech.javaschool.messaging.dto.UserInformationDTO;
import com.sbertech.javaschool.model.User;
import com.sbertech.javaschool.model.UserInformation;
import com.sbertech.javaschool.repository.UserInformationRepository;
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
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
public class UserController {

    @Autowired
    UserInformationRepository userInformationRepository;

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
        model.addAttribute("user", currentUser);

        List<User> collect = currentUser.getFriends()
                .stream()
                .peek(u -> {
                            byte[] avatar = u.getAvatar();
                            String image64 = ServiceImages.encodeImageInBase64(avatar);
                            u.setAvatarBase64(image64);
                        }
                ).collect(Collectors.toList());
        model.addAttribute("listFriends", collect);

        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }


    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public String adduserinfoform(Model model) {

        UserInformation userInformation = userInformationRepository.findByUserid(securityUtil.getCurrentUserId());
        if (userInformation == null) {
            userInformation = new UserInformation();
        }

        model.addAttribute("userInfoForm", userInformation);

        return "userinfo";
    }


    @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
    public String adduserinfo(@ModelAttribute("userInfoForm") UserInformation userInformation, BindingResult bindingResult, Model model) {
        //Сделать валидацию по всем полям.
      /*  userValidator.validate(userInfoForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }*/

        UserInformationDTO userInformationDTO = new UserInformationDTO();
        userInformationDTO.setFirstName(userInformation.getFirstName());
        userInformationDTO.setLastName(userInformation.getLastName());
        userInformationDTO.setCity(userInformation.getCity());
        userInformationDTO.setMobilePhone(userInformation.getMobilePhone());
        userInformationDTO.setNativeLanguage(userInformation.getNativeLanguage());
        userInformationDTO.setReligion(userInformation.getReligion());
        userInformationDTO.setInterests(userInformation.getInterests());
        userInformationDTO.setFavoriteMusic(userInformation.getFavoriteMusic());
        userInformationDTO.setFavoriteBook(userInformation.getFavoriteBook());
        userInformationDTO.setFavoriteFilm(userInformation.getFavoriteFilm());

        userInformationDTO.setUserId(securityUtil.getCurrentUserId());

        messageSender.sendMessage(userInformationDTO);

        return "redirect:/welcome";
    }


    @RequestMapping(value = "/managefriends", method = RequestMethod.GET)
    public String showFriends(Model model) {
        List<User> allWithoutMe = userRepository.findAllWithoutMe(securityUtil.getCurrentUserId());
        Set<User> friends = securityUtil.getCurrentUser().getFriends();

        List<UserDTO> users = allWithoutMe.stream().map(u -> {
            u.setAvatarBase64(ServiceImages.encodeImageInBase64(u.getAvatar()));
            UserDTO userDTO = new UserDTO();
            userDTO.setUser(u);
            userDTO.setFriend(friends.contains(u));
            return userDTO;
        }).collect(Collectors.toList());

        model.addAttribute("users", users);
     /*   "redirect:/userinfo";*/
        return "managefriends";
    }

    @RequestMapping(value = "/managefriends", method = RequestMethod.POST)
    public String manageFriends(HttpServletRequest request, HttpServletResponse response, Model model) {
        if (request.getParameter("userId") != null) {
            Long userId = Long.valueOf(request.getParameter("userId"));
            User currentUser = securityUtil.getCurrentUser();
            if (request.getParameter("add") != null) {
                currentUser.getFriends().add(userRepository.findById(userId));
            } else if (request.getParameter("remove") != null) {
                Set<User> listWithoutUser = currentUser.getFriends()
                        .stream().filter(u -> !Objects.equals(u.getId(), userId)).collect(Collectors.toSet());
                currentUser.setFriends(listWithoutUser);
            }
            userRepository.save(currentUser);
        }

        return showFriends(model);
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
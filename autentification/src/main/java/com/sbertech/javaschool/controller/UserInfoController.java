package com.sbertech.javaschool.controller;


import com.sbertech.javaschool.model.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sbertech.javaschool.messaging.MessageSender;
import com.sbertech.javaschool.model.UserInformationResponse;

@Controller
public class UserInfoController {

    @Autowired
    MessageSender messageSender;


    @RequestMapping(value = "/info" , method = RequestMethod.GET)
    public ResponseEntity<UserInformation> sendOrder() {

        UserInformation userInformation = new UserInformation();
        userInformation.setUserId(2L);
        userInformation.setFavoriteFilm("Film");
        userInformation.setFavoriteMusic("Music");
        userInformation.setFavoriteBook("Book");

        UserInformationResponse  userInformationResponse = new UserInformationResponse();
        userInformationResponse.setUserInformation(userInformation);
        userInformationResponse.setCommand("UPDATE");

        UserInformationResponse  userInformationResponse1 = new UserInformationResponse();
        userInformationResponse1.setUserInformation(userInformation);
        userInformationResponse1.setCommand("GET");


        messageSender.sendMessage(userInformationResponse);
        messageSender.sendMessage(userInformationResponse1);


        System.out.println("Ok");
        return new ResponseEntity(HttpStatus.OK);
    }
}

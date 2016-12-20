package ru.nosov.javaschool.userinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nosov.javaschool.userinfo.dao.UserInformationDao;
import ru.nosov.javaschool.userinfo.messaging.MessageSender;
import ru.nosov.javaschool.userinfo.model.UserInformation;
import ru.nosov.javaschool.userinfo.model.UserInformationCommand;
import ru.nosov.javaschool.userinfo.model.UserInformationResponse;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    UserInformationDao userInformationDao;
    @Autowired
    UserInformationDao userInformationDao1;

    @Autowired
    MessageSender messageSender;


    @Override
    public void procedure(UserInformationResponse userInformationResponse) {

        if (userInformationResponse.getCommand().equals("GET")) {
            userInformationResponse.setUserInformation(findByUserId(userInformationResponse.getUserInformation().getUserId()));

        } else if (userInformationResponse.getCommand().equals("UPDATE")){
            save(userInformationResponse.getUserInformation());
        }

        messageSender.sendMessage(userInformationResponse);



    }



    @Override
    public void save(UserInformation userInformation) {
        userInformationDao.save(userInformation);
    }

    @Override
    public UserInformation findByUserId(Long userId) {
        return userInformationDao1.findByUserId(userId);
    }
}

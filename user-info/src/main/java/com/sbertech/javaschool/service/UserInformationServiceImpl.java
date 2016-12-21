package com.sbertech.javaschool.service;

import com.sbertech.javaschool.messaging.MessageSender;
import com.sbertech.javaschool.model.UserInformation;
import com.sbertech.javaschool.model.UserInformationData;
import com.sbertech.javaschool.model.UserInformationResponse;
import com.sbertech.javaschool.repository.UserInformationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    UserInformationDataRepository userInformationDataRepository;

    @Autowired
    MessageSender messageSender;

    @Override
    public void procedure(UserInformationResponse userInformationResponse) {

        if (userInformationResponse.getCommand().equals("GET")) {
            userInformationResponse.setUserInformation(this.findByUserid(userInformationResponse.getUserInformation().getUserId()));

        } else if (userInformationResponse.getCommand().equals("UPDATE")) {
            this.save(userInformationResponse.getUserInformation());
        }

        messageSender.sendMessage(userInformationResponse);
    }

    @Override
    public void save(UserInformation userInformation) {
        UserInformationData userInformationData = new UserInformationData();
        userInformationData.setUserId(userInformation.getUserId());
        userInformationData.setFirstName(userInformation.getFirstName());
        userInformationData.setLastName(userInformation.getLastName());
        userInformationData.setCity(userInformation.getCity());
        userInformationData.setMobilePhone(userInformation.getMobilePhone());
        userInformationData.setNativeLanguage(userInformation.getNativeLanguage());
        userInformationData.setReligion(userInformation.getReligion());
        userInformationData.setInterests(userInformation.getInterests());
        userInformationData.setFavoriteMusic(userInformation.getFavoriteMusic());
        userInformationData.setFavoriteBook(userInformation.getFavoriteBook());
        userInformationData.setFavoriteFilm(userInformation.getFavoriteFilm());

        userInformationDataRepository.save(userInformationData);

    }

    @Override
    public UserInformation findByUserid(Long userid) {

        UserInformationData u = userInformationDataRepository.findByUserid(userid);
        UserInformation userInformation = new UserInformation();

        userInformation.setUserId(u.getUserId());
        userInformation.setFirstName(u.getFirstName());
        userInformation.setLastName(u.getLastName());
        userInformation.setCity(u.getCity());
        userInformation.setMobilePhone(u.getMobilePhone());
        userInformation.setNativeLanguage(u.getNativeLanguage());
        userInformation.setReligion(u.getReligion());
        userInformation.setInterests(u.getInterests());
        userInformation.setFavoriteMusic(u.getFavoriteMusic());
        userInformation.setFavoriteBook(u.getFavoriteBook());
        userInformation.setFavoriteFilm(u.getFavoriteFilm());

        return userInformation;
    }
}

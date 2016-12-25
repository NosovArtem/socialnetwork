package com.sbertech.javaschool.service;

import com.sbertech.javaschool.model.UserInformation;
import com.sbertech.javaschool.messaging.dto.UserInformationDTO;
import com.sbertech.javaschool.repository.UserInformationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    UserInformationDataRepository userInformationDataRepository;

    @Override
    public void procedure(UserInformationDTO userInformationResponse) {
        this.save(userInformationResponse);
    }

    @Override
    public void save(UserInformationDTO userInformationDTO) {
        UserInformation userInformation = new UserInformation();

        userInformation.setUserId(userInformationDTO.getUserId());
        userInformation.setFirstName(userInformationDTO.getFirstName());
        userInformation.setLastName(userInformationDTO.getLastName());
        userInformation.setCity(userInformationDTO.getCity());
        userInformation.setMobilePhone(userInformationDTO.getMobilePhone());
        userInformation.setNativeLanguage(userInformationDTO.getNativeLanguage());
        userInformation.setReligion(userInformationDTO.getReligion());
        userInformation.setInterests(userInformationDTO.getInterests());
        userInformation.setFavoriteMusic(userInformationDTO.getFavoriteMusic());
        userInformation.setFavoriteBook(userInformationDTO.getFavoriteBook());
        userInformation.setFavoriteFilm(userInformationDTO.getFavoriteFilm());

        userInformationDataRepository.save(userInformation);
    }

}

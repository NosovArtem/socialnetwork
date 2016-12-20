package ru.nosov.javaschool.userinfo.service;

import ru.nosov.javaschool.userinfo.model.UserInformation;
import ru.nosov.javaschool.userinfo.model.UserInformationResponse;

public interface UserInformationService {

    void procedure(UserInformationResponse userInformationResponse);

    void save(UserInformation userInformation);

    UserInformation findByUserId(Long userId);
}

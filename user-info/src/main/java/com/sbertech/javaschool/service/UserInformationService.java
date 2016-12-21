package com.sbertech.javaschool.service;

import com.sbertech.javaschool.model.UserInformation;
import com.sbertech.javaschool.model.UserInformationResponse;

public interface UserInformationService {

    void procedure(UserInformationResponse userInformationResponse);

    void save(UserInformation userInformation);

    UserInformation findByUserid(Long userid);
}

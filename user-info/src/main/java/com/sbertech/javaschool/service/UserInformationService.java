package com.sbertech.javaschool.service;

import com.sbertech.javaschool.messaging.dto.UserInformationDTO;

public interface UserInformationService {

    void procedure(UserInformationDTO userInformationResponse);

    void save(UserInformationDTO userInformation);
}

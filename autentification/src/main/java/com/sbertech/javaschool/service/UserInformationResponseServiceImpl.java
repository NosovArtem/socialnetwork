package com.sbertech.javaschool.service;


import com.sbertech.javaschool.model.UserInformationResponse;
import org.springframework.stereotype.Service;

@Service
public class UserInformationResponseServiceImpl implements UserInformationResponseService{


    @Override
    public void procedure(UserInformationResponse userInformationResponse) {
        System.out.println("Welcome");
        // TODO: 21.12.2016 Получили данные от user сервиса
        //Можно сделать процедуру при отправке и при получении.

    }
}

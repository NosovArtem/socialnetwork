package com.sbertech.javaschool.service;

import com.sbertech.javaschool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class SecurityUtil {

    @Autowired
    private UserRepository userRepository;


    public com.sbertech.javaschool.model.User getCurrentUser() {
        User userDetail = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetail.getUsername();
        return userRepository.findByUsername(name);
    }

    public Long getCurrentUserId() {
        return getCurrentUser().getId();
    }

}




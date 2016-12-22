package com.sbertech.javaschool.service;

import com.sbertech.javaschool.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}

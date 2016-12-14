package ru.nosov.autentification.service;

import ru.nosov.autentification.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}

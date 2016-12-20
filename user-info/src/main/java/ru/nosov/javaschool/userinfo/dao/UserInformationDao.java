package ru.nosov.javaschool.userinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nosov.javaschool.userinfo.model.UserInformation;

public interface UserInformationDao extends JpaRepository<UserInformation, Long> {

    UserInformation findByUserId(Long userId);
}

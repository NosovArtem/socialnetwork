package com.sbertech.javaschool.repository;

import com.sbertech.javaschool.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {
    UserInformation findByUserid(Long userid);
}

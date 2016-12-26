package com.sbertech.javaschool.repositories;

import com.sbertech.javaschool.models.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationDataRepository extends JpaRepository<UserInformation, Long> {

    UserInformation findByUserid(Long userid);
}

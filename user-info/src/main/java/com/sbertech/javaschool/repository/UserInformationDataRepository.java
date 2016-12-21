package com.sbertech.javaschool.repository;

import com.sbertech.javaschool.model.UserInformationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationDataRepository extends JpaRepository<UserInformationData, Long> {

    UserInformationData findByUserid(Long userid);
}

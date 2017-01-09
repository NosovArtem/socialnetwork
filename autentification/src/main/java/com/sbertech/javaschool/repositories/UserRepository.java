package com.sbertech.javaschool.repositories;

import com.sbertech.javaschool.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findById(Long id);

    @Query("SELECT u FROM User u WHERE u.id <> :id")
    List<User> findAllWithoutMe(@Param("id") Long id);
}

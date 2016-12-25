package com.sbertech.javaschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sbertech.javaschool.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Photo findByUserId(Long userId);
}

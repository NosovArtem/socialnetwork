package ru.nosov.javaschool.photo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nosov.javaschool.photo.model.Photo;

public interface PhotoDao extends JpaRepository<Photo, Long> {
}

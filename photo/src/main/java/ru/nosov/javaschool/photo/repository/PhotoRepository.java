package ru.nosov.javaschool.photo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nosov.javaschool.photo.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}

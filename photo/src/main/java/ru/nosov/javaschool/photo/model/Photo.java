package ru.nosov.javaschool.photo.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "photo")
public class Photo  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "path_to_origin_photo")
    private String pathToOriginalPhoto;

    @Column(name = "path_to_medium_photo")
    private String pathToMediumPhoto;

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", userId=" + userId +
                ", pathToOriginalPhoto='" + pathToOriginalPhoto + '\'' +
                ", pathToMediumPhoto='" + pathToMediumPhoto + '\'' +
                ", file=" + file +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPathToOriginalPhoto() {
        return pathToOriginalPhoto;
    }

    public void setPathToOriginalPhoto(String pathToOriginalPhoto) {
        this.pathToOriginalPhoto = pathToOriginalPhoto;
    }

    public String getPathToMediumPhoto() {
        return pathToMediumPhoto;
    }

    public void setPathToMediumPhoto(String pathToMediumPhoto) {
        this.pathToMediumPhoto = pathToMediumPhoto;
    }

    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Photo() {
    }
}


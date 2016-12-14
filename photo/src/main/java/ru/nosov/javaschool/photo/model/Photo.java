package ru.nosov.javaschool.photo.model;

import org.springframework.web.multipart.MultipartFile;

public class Photo {

    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}


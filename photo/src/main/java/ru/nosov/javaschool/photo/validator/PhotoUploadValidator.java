package ru.nosov.javaschool.photo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.nosov.javaschool.photo.model.Photo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PhotoUploadValidator implements Validator {
    private final static List<String> listTypeFile = new ArrayList<>(Arrays.asList("JPEG", "PNG", "TIF", "JPG"));

    @Override
    public boolean supports(Class clazz) {
        //just validate the Photo instances
        return Photo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Photo file = (Photo) target;

        String fullType = file.getFile().getContentType();
        int index = fullType.lastIndexOf("/");
        String type = fullType.substring(index + 1).toUpperCase();

        if (!listTypeFile.contains(type)) {
            errors.rejectValue("file", "uploadForm.selectFile",
                    "Incorrect format. Please select a" + listTypeFile + " format!");
        }


        if (file.getFile().getSize() == 0) {
            errors.rejectValue("file", "uploadForm.selectFile",
                    "Please select an empty file!");
        }
    }


}


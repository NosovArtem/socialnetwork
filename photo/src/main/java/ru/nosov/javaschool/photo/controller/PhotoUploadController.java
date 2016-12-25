package ru.nosov.javaschool.photo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.nosov.javaschool.photo.model.Photo;
import ru.nosov.javaschool.photo.validator.PhotoUploadValidator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class PhotoUploadController {

    @Autowired
    PhotoUploadValidator fileValidator;

    @RequestMapping(value = "/fileUploadForm", method = RequestMethod.GET)
    public ModelAndView getUploadForm(
            @ModelAttribute("uploadedFile") Photo uploadedFile,
            BindingResult result) {
        return new ModelAndView("fileUploadForm");
    }


    @RequestMapping(value = "/submitFileUpload", method = RequestMethod.POST)
    public ModelAndView fileUploaded(
            @ModelAttribute("uploadedFile") Photo uploadedFile,
            BindingResult result) {

        MultipartFile file = uploadedFile. getFile();
        fileValidator.validate(uploadedFile, result);

        String fileName = file.getOriginalFilename();

        if (result.hasErrors()) {
            return new ModelAndView("fileUploadForm");
        }

        byte[] b = new byte[32 * 1024];
        try {

            File newFile = new File("C:\\test\\" + fileName);
            if (!newFile.exists()) {
                newFile.createNewFile();
            }

            try (BufferedInputStream bfis = new BufferedInputStream(file.getInputStream());
                 BufferedOutputStream bfos = new BufferedOutputStream(new FileOutputStream(newFile));) {

                int len = 0;
                for (int readNum; (readNum = bfis.read(b)) != -1; ) {
                    bfos.write(b, 0, readNum);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new ModelAndView("fileUploadSuccess", "fileName", fileName);
    }

}


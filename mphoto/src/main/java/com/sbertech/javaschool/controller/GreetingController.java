package com.sbertech.javaschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

@Controller
public class GreetingController {


    @Autowired
    private Environment env;


    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("uploadfile") MultipartFile uploadfile) {

        String s = new String();
        //Получить имя пользователя зайти или создать папку с именем пользователя и.т.д
/*
          File f = new File(pathDest);
    if (!f.exists()) {
      f.mkdirs();
    }
*/

        String filename = uploadfile.getOriginalFilename();
        String directory = env.getProperty("netgloo.paths.uploadedFiles");
        String filepath = Paths.get(directory, filename).toString();

        try (BufferedOutputStream stream =
                     new BufferedOutputStream(new FileOutputStream(new File(filepath)));){
            // Get the filename and build the local file path

            // Save the file locally
            stream.write(uploadfile.getBytes());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    } // method uploadFile

}

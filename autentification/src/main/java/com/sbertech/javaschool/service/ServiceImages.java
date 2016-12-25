package com.sbertech.javaschool.service;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class ServiceImages {

    public static String encodeImageInBase64(byte[] array) {
        if (array == null) {
            return "";
        }
        byte[] encodeBase64 = Base64.encodeBase64(array);
        String base64Encoded = null;
        try {
            base64Encoded = new String(encodeBase64, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "data:image/jpg;base64," + base64Encoded;
    }
}

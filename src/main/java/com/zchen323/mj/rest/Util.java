package com.zchen323.mj.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Util {

    private static String BASE_URL = "https://raw.githubusercontent.com/zchen323/MJ/master/src/cat/";

    public static List<Catelog> loadCateLog() throws IOException {
        ObjectMapper om = new ObjectMapper();
        List<Catelog> result = null;
        result = om.readValue(new URL(BASE_URL + "catelogs.json"), new ArrayList<Catelog>().getClass());
        System.out.println(om.writeValueAsString(result));

        return result;
    }

    public static List<Image> loadImages(String id) throws IOException {
        ObjectMapper om = new ObjectMapper();
        ImageInfo info = om.readValue(new URL(BASE_URL + id + ".json"), ImageInfo.class);

        List<Image> result = new ArrayList<>();
        for(Image image : info.getImages()){
            image.setHref(info.getBaseURL() + image.getName());
        }
        return info.getImages();
    }
}

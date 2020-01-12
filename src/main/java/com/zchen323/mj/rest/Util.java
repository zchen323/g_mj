package com.zchen323.mj.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Util {

    private static String BASE_URL = "https://raw.githubusercontent.com/zchen323/PhotoLinks/master/src/";

    public static List<Catelog> loadCateLog(String type) throws IOException {
        String urlString = null;
        if("z".equalsIgnoreCase(type)){
            urlString = BASE_URL + "z/catalog/catalog.json";
        }else if("c".equalsIgnoreCase(type)){
            urlString = BASE_URL + "c/catalog/catalog.json";
        }
        List<Catelog> result = new ArrayList<>();
        if(urlString != null) {
            ObjectMapper om = new ObjectMapper();
            result = om.readValue(new URL(urlString), new ArrayList<Catelog>().getClass());
            System.out.println(om.writeValueAsString(result));
        }
        return result;
    }

    public static List<Image> loadImages(String type, String id) throws IOException {
        String urlString = null;
        if("c".equalsIgnoreCase(type)){
            urlString = BASE_URL + "c/contents/" + id + ".json";
        }else if("z".equalsIgnoreCase(type)){
            urlString = BASE_URL + "z/contents/" + id + ".json";
        }

        List<Image> result = new ArrayList<>();
        if(urlString != null){
            ObjectMapper om = new ObjectMapper();
            ImageInfo info = om.readValue(new URL(urlString), ImageInfo.class);


            for(Image image : info.getImages()){
                if(image.getHref() == null || image.getHref().isEmpty()) {
                    image.setHref(info.getBaseURL() + image.getName());
                }
            }
            result = info.getImages();
        }
        return result;
    }
}

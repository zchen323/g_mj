package com.zchen323.mj.rest;

import java.util.ArrayList;
import java.util.List;

public class ImageInfo {
    private String baseURL;
    private String id;
    private List<Image> images = new ArrayList<>();


    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}

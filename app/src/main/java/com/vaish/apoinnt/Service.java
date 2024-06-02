package com.vaish.apoinnt;


import java.util.Collection;
import java.util.List;

public class Service {
    private int imageResId;
    private String name;

    public Service(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getItems() {
        return null;
    }
}

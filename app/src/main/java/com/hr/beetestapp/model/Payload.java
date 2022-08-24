
package com.hr.beetestapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {
    private String name;
    private String titles;
    private String imageUrl;
    private String descriptions;
    private String dynamicCategories;
    private String levelV2;

    public Payload(String name, String titles, String imageUrl, String descriptions, String dynamicCategories, String levelV2) {
        this.name = name;
        this.titles = titles;
        this.imageUrl = imageUrl;
        this.descriptions = descriptions;
        this.dynamicCategories = dynamicCategories;
        this.levelV2 = levelV2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getDynamicCategories() {
        return dynamicCategories;
    }

    public void setDynamicCategories(String dynamicCategories) {
        this.dynamicCategories = dynamicCategories;
    }

    public String getLevelV2() {
        return levelV2;
    }

    public void setLevelV2(String levelV2) {
        this.levelV2 = levelV2;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "name='" + name + '\'' +
                ", titles='" + titles + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", dynamicCategories='" + dynamicCategories + '\'' +
                ", levelV2='" + levelV2 + '\'' +
                '}';
    }
}

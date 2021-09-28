package com.example.search;

public class Model {

    private int image;
    private String country_name;
    private String capital;
    private String region;
    private String popln;
    private String bor;
    private String lang;

    Model(int image, String country_name, String capital, String region,String popln,String bor,String lang) {

        this.image = image;
        this.country_name = country_name;
        this.capital = capital;
        this.region = region;
        this.popln = popln;
        this.region =region;
        this.lang = lang;
    }

    public int getImage() {
        return image;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getPopln() {
        return popln;
    }

    public String getBor() {
        return bor;
    }

    public String getLang() {
        return lang;
    }
}

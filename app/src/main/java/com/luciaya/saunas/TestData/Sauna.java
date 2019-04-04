package com.luciaya.saunas.TestData;

import java.util.UUID;

public class Sauna {
    private UUID mUUID;
    private String name;
    private String description;
    private int price;
    private int number_of_persons;
    private String urlFirstPicture;
    private String urlSecondPicture;
    private String urlThirdPicture;
    private int number_of_hours;
    private boolean sauna_of_month;
    private String address;

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
    }

    public String getUrlThirdPicture() {
        return urlThirdPicture;
    }

    public void setUrlThirdPicture(String urlThirdPicture) {
        this.urlThirdPicture = urlThirdPicture;
    }

    public Sauna(UUID uuid, String name, String description, int price, int number_of_persons,
                 String urlFirstPicture, String urlSecondPicture, String urlThirdPicture,
                 int number_of_hours, boolean sauna_of_month, String address) {
        this.mUUID = uuid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.number_of_persons = number_of_persons;
        this.urlFirstPicture = urlFirstPicture;
        this.urlSecondPicture = urlSecondPicture;
        this.urlThirdPicture = urlThirdPicture;
        this.number_of_hours = number_of_hours;
        this.sauna_of_month = sauna_of_month;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber_of_persons() {
        return number_of_persons;
    }

    public void setNumber_of_persons(int number_of_persons) {
        this.number_of_persons = number_of_persons;
    }

    public String getUrlFirstPicture() {
        return urlFirstPicture;
    }

    public void setUrlFirstPicture(String urlFirstPicture) {
        this.urlFirstPicture = urlFirstPicture;
    }

    public String getUrlSecondPicture() {
        return urlSecondPicture;
    }

    public void setUrlSecondPicture(String urlSecondPicture) {
        this.urlSecondPicture = urlSecondPicture;
    }

    public String getUrlTirdPicture() {
        return urlThirdPicture;
    }

    public void setUrlTirdPicture(String urlTirdPicture) {
        this.urlThirdPicture = urlTirdPicture;
    }

    public int getNumber_of_hours() {
        return number_of_hours;
    }

    public void setNumber_of_hours(int number_of_hours) {
        this.number_of_hours = number_of_hours;
    }

    public boolean isSauna_of_month() {
        return sauna_of_month;
    }

    public void setSauna_of_month(boolean sauna_of_month) {
        this.sauna_of_month = sauna_of_month;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

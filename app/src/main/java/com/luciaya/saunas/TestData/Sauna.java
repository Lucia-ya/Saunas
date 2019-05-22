package com.luciaya.saunas.TestData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Sauna {
    private UUID mUUID;
    private String name;
    private String description;
    private int price;
    private int number_of_persons;
    String[] imagesUrl;
    private int number_of_hours;
    private boolean sauna_of_month;
    private String address;
    private String workingHours;
    private String rentDescription;
    private List<Review> reviews;

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
    }

    public Sauna(UUID uuid, String name, String description, int price, int number_of_persons,
                 String[] imagesUrl, int number_of_hours, boolean sauna_of_month, String address,
                 String workingHours, String rentDescription, ArrayList<Review> reviews) {
        this.mUUID = uuid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.number_of_persons = number_of_persons;
        this.imagesUrl = imagesUrl;
        this.number_of_hours = number_of_hours;
        this.sauna_of_month = sauna_of_month;
        this.address = address;
        this.workingHours = workingHours;
        this.rentDescription = rentDescription;
        this.reviews = reviews;
    }

    public String getRentDescription() {
        return rentDescription;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public String getName() {
        return name;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber_of_persons() {
        return number_of_persons;
    }

    public String[] getImagesUrl() {
        return imagesUrl;
    }

    public int getNumber_of_hours() {
        return number_of_hours;
    }

    public boolean isSauna_of_month() {
        return sauna_of_month;
    }

    public String getAddress() {
        return address;
    }

}


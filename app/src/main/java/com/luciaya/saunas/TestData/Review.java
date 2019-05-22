package com.luciaya.saunas.TestData;

public class Review {
    String name;
    String mDate;
    String description;
    boolean like;
    String email;
    String phone;

    public Review(String name, String date, String description, boolean like) {
        this.name = name;
        mDate = date;
        this.description = description;
        this.like = like;
    }

    public Review(String name, String date, String description, boolean like, String email, String phone) {
        this.name = name;
        mDate = date;
        this.description = description;
        this.like = like;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return mDate;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLike() {
        return like;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

package com.wordle.royale.models;

public class User extends UserTemplate {

    private String userName;
    private int score;


    public User(String hei) {
        super(hei);
    }

    @Override
    public void setUserName(String name) {
        this.userName = name;

    }


}

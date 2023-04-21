package com.wordle.royale.v2.model;

import com.wordle.royale.v2.model.UserTemplate;

public class User extends UserTemplate {

    private String userName;
    private int score;


    public User(String userName) {
        super(userName);
    }

    @Override
    public void setUserName(String name) {
        this.userName = name;

    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }
}



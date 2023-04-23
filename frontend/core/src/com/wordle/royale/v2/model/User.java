package com.wordle.royale.v2.model;

public abstract class User {

    protected String userName;
    protected int score;

    public User() {
        this.userName = "";
        this.score = 0;
    }

    public String getName() {
        return userName;
    };

    public void setScore(int score) {
        this.score += score;
    };

    public int getScore() {
        return score;
    };

}

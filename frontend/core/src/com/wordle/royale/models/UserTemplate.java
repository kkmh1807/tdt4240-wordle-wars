package com.wordle.royale.models;

public abstract class UserTemplate {

    protected String userName;
    protected int score;

    public UserTemplate(String userName) {
        super();
        createUser(userName);
    }

    public abstract void setUserName(String name);

    public void createUser(String name) {
        setUserName(name);
        setScore(0);
    }

    public String getName() {
        return userName;
    };

    public void setScore(int score) {
        this.score = score;
    };

    public int getScore() {
        return score;
    };

}

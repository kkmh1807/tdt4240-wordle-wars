package com.wordle.royale.v2.model;

public abstract class UserTemplate {

    protected String userName;
    protected int score;

    public UserTemplate(String userName) {
        createUser(userName);
    }

    public abstract void setUserName(String name);

    private void createUser(String name) {
        setUserName(name);
        setScore(0);
    }

    public String getName() {
        return userName;
    };

    public abstract void setScore(int score);

    public int getScore() {
        return score;
    };

}

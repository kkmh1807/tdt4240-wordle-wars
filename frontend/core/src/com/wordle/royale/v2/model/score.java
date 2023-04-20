package com.wordle.royale.v2.model;

public class score {
    public int getScore() {
        return score;
    }

    public String getUsername() {
        return username;
    }

    private int score;
    private String username;

    public score(String username, int score) {
        this.score = score;
        this.username = username;
    }
}

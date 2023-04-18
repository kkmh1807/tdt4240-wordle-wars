package com.wordle.royale.v3.model;

public class letter {
    private String letter;
    private int status;
    private int placement;

    public letter(String letter, Integer status, Integer placement){
        this.letter = letter;
        this.placement = placement;
        this.status = status;
    }

    public String getLetter() {
        return letter;
    }

    public int getStatus() {
        return status;
    }

    public int getPlacement() {
        return placement;
    }
}

package com.wordle.royale.v2.model;

import java.util.ArrayList;

public class guessedWord {
    ArrayList<com.wordle.royale.v2.model.letter> guessLetters;

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    Boolean isCorrect;

    public ArrayList<letter> getGuessLetters() {
        return guessLetters;
    }

    public guessedWord(){
        guessLetters = new ArrayList<com.wordle.royale.v2.model.letter>();
        isCorrect = false;
    }

    public void insertLetter(letter letter){
        guessLetters.add(letter);
    }

    public void printGuess(){
        for (int i = 0; i < guessLetters.size(); i++) {
            String letter = guessLetters.get(i).getLetter();
            Integer status = guessLetters.get(i).getStatus();
            Integer placement = guessLetters.get(i).getPlacement();
            System.out.println("Letter: "+letter+" Placement: "+ placement + " Word includes letter: " +status);
        }
    }

    public int getYellow() {
        int yellow = 0;
        for (int i = 0; i < guessLetters.size(); i++) {

            int status = guessLetters.get(i).getStatus();
            yellow += status;
        }
        return yellow;
    }

    public int getGreen(){
        int green = 0;
        for (int i = 0; i < guessLetters.size(); i++) {
            int placement = guessLetters.get(i).getPlacement();
            green += placement;
        }
        return green;
    }
}

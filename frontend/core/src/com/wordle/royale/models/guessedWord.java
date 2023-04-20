package com.wordle.royale.models;

import java.util.ArrayList;

public class guessedWord {
    ArrayList<letter> guessLetters;

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
        guessLetters = new ArrayList<letter>();
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
}

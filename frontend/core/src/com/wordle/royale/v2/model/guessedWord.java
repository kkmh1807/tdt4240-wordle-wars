package com.wordle.royale.v2.model;

import java.util.ArrayList;

public class guessedWord {
    ArrayList<letter> guessLetters;

    public ArrayList<letter> getGuessLetters() {
        return guessLetters;
    }

    public guessedWord(){
        guessLetters = new ArrayList<letter>();
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

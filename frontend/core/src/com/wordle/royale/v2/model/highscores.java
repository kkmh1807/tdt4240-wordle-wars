package com.wordle.royale.v2.model;

import com.wordle.royale.v2.model.score;

import java.util.ArrayList;

public class highscores {
    ArrayList<score> highscoreList;

    public highscores(){
        highscoreList = new ArrayList<score>();
    }

    public ArrayList<score> getHighscoreList() {
        return highscoreList;
    }

    public void addHighscore(String username, Integer score){
        highscoreList.add(new score(username, score));
    }

    public void printScores(){
        for (int i = 0; i < highscoreList.size(); i++) {
            String name = highscoreList.get(i).getUsername();
            Integer score = highscoreList.get(i).getScore();
            System.out.println(i+1+". "+ name + " : " +score);
        }
    }
}

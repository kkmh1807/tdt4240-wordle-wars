package com.wordle.royale.v2.model.other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.wordle.royale.v2.model.network.ScoreApiService;
import com.wordle.royale.v2.model.score;

import java.util.ArrayList;

public class HighScore {
    ArrayList<score> highscoreList;

    public ArrayList<score> getHighscoreList() {
        return highscoreList;
    }

    public void addHighscore(String username, Integer score) {
        highscoreList.add(new score(username, score));
    }

    public void printScores() {
        for (int i = 0; i < highscoreList.size(); i++) {
            String name = highscoreList.get(i).getUsername();
            Integer score = highscoreList.get(i).getScore();
            System.out.println(i + 1 + ". " + name + " : " + score);
        }
    }

    public HighScore() {
        highscoreList = new ArrayList<score>();
    }
}

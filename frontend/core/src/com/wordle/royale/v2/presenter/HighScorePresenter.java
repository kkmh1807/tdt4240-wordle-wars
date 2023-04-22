package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.wordle.royale.v2.model.network.ScoreApiService;
import com.wordle.royale.v2.model.other.HighScore;
import com.wordle.royale.v2.model.other.ScreenController;


public class HighScorePresenter {
    private ScoreApiService ScoreAPI;
    private ScreenController parent;
    HighScore highScore;


    public HighScore getHighScore() {
        return highScore;
    }

    public HighScorePresenter(ScreenController parent) {
        this.parent = parent;
        highScore = new HighScore();

        ScoreAPI = new ScoreApiService();
        ScoreAPI.getHigscores(new ScoreApiService.CallbackPostScore<com.wordle.royale.v2.model.other.HighScore>() {
            @Override
            public void onSuccess(com.wordle.royale.v2.model.other.HighScore highscores) {
                highScore = highscores;
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Failed to fetch scores");
                highScore = new HighScore();
                highScore.addHighscore("Network error", 0);
            }
        });
    }

    public void changeScreensFunc(int i) {
        parent.changeScreens(i);
    }

    public interface changeScreens {
        void setupChangeToMenu();
        void setupChangeToGame();
    }
}

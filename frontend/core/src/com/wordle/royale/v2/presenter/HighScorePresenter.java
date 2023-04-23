package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.network.ScoreApiService;
import com.wordle.royale.v2.model.other.HighScore;
import com.wordle.royale.v2.model.other.ScreenController;


public class HighScorePresenter extends AbstractPresenter{
    private ScoreApiService ScoreAPI;
    HighScore highScore;




    public HighScorePresenter(ScreenController screenController, Stage stage) {
        super(stage, screenController);
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

    public HighScore getHighScore() {
        return highScore;
    }

    public interface changeScreens {
        void setupChangeToMenu();
        void setupChangeToGame();
    }
}

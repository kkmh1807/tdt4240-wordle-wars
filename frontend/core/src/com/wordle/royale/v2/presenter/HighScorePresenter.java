package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.other.ScreenController;

public class HighScorePresenter extends AbstractPresenter{

    public HighScorePresenter(ScreenController screenController, Stage stage) {
        super(stage, screenController);
    }

    public interface changeScreens {
        void setupChangeToMenu();
        void setupChangeToGame();
    }
}

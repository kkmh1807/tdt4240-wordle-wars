package com.wordle.royale.v2.presenter;

import com.wordle.royale.v2.model.other.ScreenController;

public class HighScorePresenter {
    private ScreenController parent;


    public HighScorePresenter(ScreenController parent) {
        this.parent = parent;
    }

    public void changeScreensFunc(int i) {
        parent.changeScreens(i);
    }


    public interface changeScreens {
        void setupChangeToMenu();
        void setupChangeToGame();
    }
}

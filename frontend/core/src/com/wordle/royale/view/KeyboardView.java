package com.wordle.royale.view;

import com.wordle.royale.model.ScreenController;
import com.wordle.royale.presenter.GameScreenPresenter;
import com.wordle.royale.presenter.KeyBoardPresenter;

public class KeyboardView {
    private KeyBoardPresenter keyBoardPresenter;
    private GameScreenPresenter gameScreenPresenter;

    public KeyboardView(ScreenController screenController, GameScreenPresenter gameScreenPresenter) {
        this.keyBoardPresenter = new KeyBoardPresenter(screenController, gameScreenPresenter);


    }


    public void draw() {
    }
}

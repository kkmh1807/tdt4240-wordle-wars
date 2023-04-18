package com.wordle.royale.v3.view;

import com.wordle.royale.v3.model.ScreenController;
import com.wordle.royale.v3.presenter.GameScreenPresenter;
import com.wordle.royale.v3.presenter.KeyBoardPresenter;

public class KeyboardView {
    private KeyBoardPresenter keyBoardPresenter;
    private GameScreenPresenter gameScreenPresenter;

    public KeyboardView( ScreenController screenController, GameScreenPresenter gameScreenPresenter) {
        this.keyBoardPresenter = new KeyBoardPresenter(screenController, gameScreenPresenter);


    }


    public void draw() {
    }
}

package com.wordle.royale.controller;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.wordle.royale.ScreenController;
import com.wordle.royale.models.Keyboard;
import com.wordle.royale.screens.GameScreen;
import com.wordle.royale.screens.WordRow;

public class WordleController {

    private WordRow wordRow;
    private Keyboard keyboard;
    private ScreenController parent;
    private GameScreen gameScreen;

    public WordleController(ScreenController parent) {
        this.parent = parent;
        gameScreen = new GameScreen();
        parent.setScreen(gameScreen);
        keyboard = new Keyboard(this);
        wordRow = new WordRow(50, 800);
        gameScreen.addActor(keyboard);
        gameScreen.addActor(wordRow);
    }

    public void handleKeyBoardInput(Character character) {
        wordRow.handleCharacterChange(character);
    }

}

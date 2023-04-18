package com.wordle.royale.test.controller;


import com.wordle.royale.test.models.Keyboard;
import com.wordle.royale.test.screens.GameScreen;
import com.wordle.royale.test.screens.TextTileGrid;
import com.wordle.royale.test.screens.WordRow;
import com.wordle.royale.v3.model.ScreenController;

public class WordleController {

    private WordRow wordRow;
    private Keyboard keyboard;
    private ScreenController parent;
    private GameScreen gameScreen;
    private TextTileGrid textTileGrid;

    public WordleController(ScreenController parent) {
        this.parent = parent;
        gameScreen = new GameScreen();
        parent.setScreen(gameScreen);
        keyboard = new Keyboard(this);
        textTileGrid = new TextTileGrid(50, 600);
        //wordRow = new WordRow(50, 800);
        gameScreen.addActor(keyboard);
        gameScreen.addActor(textTileGrid);
    }

    public void handleKeyBoardInput(String s) {
        if (textTileGrid.getActiveRow().getIndex() == 5 && s.equals("Enter")) {
            this.textTileGrid.nextRow();
            return;
        }

        if(textTileGrid.getActiveRow().getIndex() >= 0 && s.equals("Del")) {
            this.textTileGrid.getActiveRow().removeCharacter();
            return;
        }

        if (textTileGrid.getActiveRow().getIndex() < 5) {
            if (s.equals("Enter")) {
                return;
            }
            this.textTileGrid.getActiveRow().handleCharacterChange(s);
        }
    }

}

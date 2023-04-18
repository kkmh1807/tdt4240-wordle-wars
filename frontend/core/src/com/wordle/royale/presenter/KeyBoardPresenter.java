package com.wordle.royale.presenter;

import com.wordle.royale.model.Keyboard;
import com.wordle.royale.model.ScreenController;
import com.wordle.royale.model.actors.TextTileGrid;
import com.wordle.royale.view.GameScreen;

public class KeyBoardPresenter {
    private ScreenController parent;
    private GameScreen gameScreen;
    private Keyboard keyboard;
    private TextTileGrid textTileGrid;
    private GameScreenPresenter gameScreenPresenter;


    public KeyBoardPresenter(ScreenController parent, GameScreenPresenter gameScreenPresenter) {
        this.parent = parent;
        gameScreen = new GameScreen(parent);
        parent.setScreen(gameScreen);
        keyboard = new Keyboard(this);
        textTileGrid = new TextTileGrid(50, 600);
        //wordRow = new WordRow(50, 800);
        this.gameScreenPresenter = gameScreenPresenter;
        gameScreenPresenter.addActor(keyboard);
        gameScreenPresenter.addActor(textTileGrid);

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

    public interface View {

    }


}

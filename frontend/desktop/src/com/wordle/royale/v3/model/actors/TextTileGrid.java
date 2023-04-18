package com.wordle.royale.v3.model.actors;

import com.badlogic.gdx.scenes.scene2d.Group;

public class TextTileGrid extends Group {
    //private ArrayList<WordRow> textTileGrid = new ArrayList<>();
    private int activeRowIndex;

    public TextTileGrid(float x, float y) {
        this.activeRowIndex = 5;
        for (int i = 0; i < 6; i++) {
            this.addActor(new WordRow(x, y+(i)*270));
        }
    }

    public WordRow getActiveRow() {
        return (WordRow) this.getChildren().get(activeRowIndex);
    }

    public void nextRow() {
        if(activeRowIndex > 0) {
            activeRowIndex--;
        }
    }


}



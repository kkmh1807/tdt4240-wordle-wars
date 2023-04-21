package com.wordle.royale.v2.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.wordle.royale.v2.view.WordRow;

public class TextTileGrid extends Group {
    //private ArrayList<WordRow> textTileGrid = new ArrayList<>();
    private int activeRowIndex;
    private float width = (Gdx.graphics.getWidth()-(25*6))/5f;
    private float height = ((Gdx.graphics.getHeight()-900)/6f);

    public TextTileGrid(float x, float y) {
        this.activeRowIndex = 5;
        for (int i = 0; i < 6; i++) {
            this.addActor(new WordRow(x, y+(i*(height)), width, height));
        }
    }

    public WordRow getActiveRow() {
        return (WordRow) this.getChildren().get(activeRowIndex);
    }

    public int getActiveRowIndex() {
        return activeRowIndex;
    }

    public void setActiveRowIndex(int index) {
        this.activeRowIndex = index;
    }


    public void nextRow() {
        if(activeRowIndex > 0) {
            activeRowIndex--;
        }
    }


}



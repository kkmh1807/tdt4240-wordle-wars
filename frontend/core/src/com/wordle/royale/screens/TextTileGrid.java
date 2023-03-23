package com.wordle.royale.screens;

import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;

public class TextTileGrid{
    private TextRow textRow;
    private ArrayList<TextRow> textTileGrid;
    private ArrayList<Float> position;

    public TextTileGrid() {
        for(int i = 0; i < 5; i++) {
            textTileGrid.add(textRow);
        }
    }

    public void TextTileGridShow() {

    }

    public void draw(Float[] scale, Batch batch, Float[] positions) {
        setPosition(positions[0], positions[1]);
        setScale(scale[0], scale[1]);
        textRow.draw(scale, batch, positions);
    }

    private void setScale(float v, float v1) {
        for(TextRow textRow: textTileGrid) {
            textRow.setScale(v, v1);
        }
    }

    private void setPosition(float v, float v1) {
        for(TextRow textRow: textTileGrid) {
            textRow.setPosition(v, v1);
        }
    }
}

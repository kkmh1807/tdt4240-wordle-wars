package com.wordle.royale.screens;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public class TextTileGrid{
    private TextRow textRow;
    private ArrayList<TextRow> textTileGrid;
    private ArrayList<Float> position;

    private TextTile textTile;
    private ArrayList<TextTile> textTileArray;

    public TextTileGrid(Stage stage) {

        for (int i = 0; i < 5; i++) {
            textTileArray.add(new TextTile(stage));
        }
    }

}



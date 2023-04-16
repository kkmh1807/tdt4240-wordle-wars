package com.wordle.royale.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public class TextTileGrid extends Group {
    private ArrayList<WordRow> textTileGrid = new ArrayList<>();

    public TextTileGrid(Stage stage) {
        for (int i = 0; i < 5; i++) {
        }
    }

    public ArrayList<WordRow> getTextRows() {
        return textTileGrid;
    }

}



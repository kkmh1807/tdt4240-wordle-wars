package com.wordle.royale.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public class TextTileGrid extends Actor {
    private ArrayList<WordRow> textTileGrid = new ArrayList<>();
    private Group textRowGroup;
    private float startPointX = Gdx.graphics.getWidth() /4;
    private float startPointy = Gdx.graphics.getHeight() /2 + 150 + 150 + 150 + 150/3 + 150/3 + (150/3/2);

    public TextTileGrid(Stage stage) {
        textRowGroup = new Group();
        float currentY = startPointy;
        for (int i = 0; i < 5; i++) {
            WordRow tr = new WordRow(startPointX, currentY);
            textTileGrid.add(tr);
            currentY -= 200;
            textRowGroup.addActor(tr);
        }
    }

    public ArrayList<WordRow> getTextRows() {
        return textTileGrid;
    }

    public Group getGroup() {
        return textRowGroup;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for(WordRow tr : textTileGrid) {
            tr.draw(batch, parentAlpha);
        }
    }

}



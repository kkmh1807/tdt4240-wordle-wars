package com.wordle.royale.screens;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public class TextRow {
    private TextTile textTile;
    private ArrayList<TextTile> textTiles;

    public TextRow(Stage stage) {
        for(int i = 0; i < 5; i++) {
            textTiles.add(new TextTile(stage));
        }
    }

    /*public void draw(Float[] scale, Batch batch, Float[] positions) {
        setPosition(positions[0], positions[1]);
        setScale(scale[0], scale[1]);
        for(TextTile textTile: textTiles) {
            textTile.draw(scale, batch, positions);
        }
    }

    public void setPosition(float v, float v1) {
        for(TextTile textTile: textTiles) {
            textTile.setPosition(v, v1);
        }
    }

    public void setScale(float v, float v1) {
        for(TextTile textTile: textTiles) {
            textTile.setScale(v, v1);
        }
    }

*/
}



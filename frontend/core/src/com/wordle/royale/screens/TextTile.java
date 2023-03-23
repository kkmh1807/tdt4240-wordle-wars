package com.wordle.royale.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class TextTile {
    private final float width = Gdx.graphics.getWidth()/10;
    private final float height = Gdx.graphics.getHeight()/10;
    private char chr;
    private TextField textField;
    private Skin skin;

    public TextTile() {
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        textField = new TextField("Quit Game", skin, "default");
        textField.setScale(1f, 2f);
        textField.setPosition(Gdx.graphics.getWidth() /2f - textField.getWidth()/2f, Gdx.graphics.getHeight()/2f);

    }

    public void draw(Float[] scale, Batch batch, Float[] positions) {
        setPosition(positions[0], positions[1]);
        setScale(scale[0], scale[1]);
        textField.draw(batch, 1);
    }

    public void setPosition(float v, float v1) {
        textField.setPosition(v,v1);

    }

    public void setScale(float v, float v1) {
        textField.setScale(v,v1);
    }
}

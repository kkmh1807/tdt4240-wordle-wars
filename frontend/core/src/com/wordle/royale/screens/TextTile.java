package com.wordle.royale.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class TextTile extends Actor {
    private final float width = Gdx.graphics.getWidth()/10;
    private final float height = Gdx.graphics.getHeight()/10;
    private char chr;
    private TextField textField;
    private Skin skin;
    private Texture texture;
    private Stage stage;



    public TextTile(Stage stage) {
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        textField = new TextField("", skin, "default");
        textField.setPosition(  Gdx.graphics.getWidth() /2f - textField.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        textField.setWidth(60f);
        textField.setHeight(60f);
        texture = new Texture("craftacular/raw/text-field.9.png");

        stage.addActor(textField);

    }
    /*
    @Override
    public void draw(Batch batch, float parentAlpha) {
        textField.draw(batch, parentAlpha);

    }

     */

/*
    @Override
    public boolean addListener(EventListener listener) {
        Gdx.app.log("MyTag", "my debug message");
        return super.addListener(listener);
    }

 */
    /*

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
    */

    @Override
    public void act(float delta) {
        super.act(delta);
    }



}

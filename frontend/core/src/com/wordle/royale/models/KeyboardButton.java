package com.wordle.royale.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class KeyboardButton extends Actor {

    private char character;
    private TextButton button;
    private Skin skin;


    public KeyboardButton(final Character character, float x, float y, float width, float height) {
        this.character = character;
        this.skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        this.button = new TextButton(character.toString(), skin, "default");
        this.button.setTransform(true);
        this.button.setPosition(x, y);
        this.button.setHeight(height);
        this.button.setWidth(width);
        setTouchable(Touchable.enabled);
        setX(x);
        setY(y);
        setHeight(height);
        setWidth(width);
        setBounds(getX(), getY(), getWidth()*2, getHeight()*2);
        this.button.setScale(1, 2);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.out.println(character);
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        button.draw(batch, parentAlpha);
    }
}

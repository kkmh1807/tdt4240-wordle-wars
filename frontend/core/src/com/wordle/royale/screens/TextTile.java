package com.wordle.royale.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class TextTile extends Actor {
    private String chr;
    private TextField textField;
    private Skin skin;
    private BitmapFont character;
    private Sprite tile;
    private Stage stage;
    private int index;

    public TextTile(int index, float x, float y, float width, float height) {
        this.index = index;
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        character = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"), false);
        tile = new Sprite(new Texture("craftacular/raw/slider.9.png"));
        character.getData().setScale(2.5f, 2.5f);
        setTouchable(Touchable.enabled);
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setBounds(getX(), getY(), getWidth(), getHeight());
        chr = " ";
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(tile,getX(),getY(), getWidth(), getHeight());
        character.draw(batch, chr.toString(),getX() + getWidth()/2- (character.getXHeight()/4), getY() + getHeight()/2+(character.getXHeight()/2));
    }

    public void setCharacter(String s) {
        this.chr = s;
    }

}

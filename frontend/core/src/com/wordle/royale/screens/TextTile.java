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
    private final float width = Gdx.graphics.getWidth()/10;
    private final float height = Gdx.graphics.getHeight()/10;
    private String chr;
    private TextField textField;
    private Skin skin;
    private BitmapFont character;
    private Sprite tile;
    private Stage stage;

    public TextTile(float x, float y) {
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        character = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"), false);
        tile = new Sprite(new Texture("craftacular/raw/slider.9.png"));
        character.getData().setScale(1.5f, 2.5f);
        setTouchable(Touchable.enabled);
        setX(x);
        setY(y);
        setWidth(100);
        setHeight(150);
        setBounds(getX(), getY(), getWidth(), getHeight());
        addListener(new InputListener() {
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("down");
                return true;
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("up");
            }
        });
        chr = "y";
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(tile,getX(),getY(), getWidth(), getHeight());
        character.draw(batch, chr,getX() + getWidth()/2, getY() + getHeight());
    }

    public void setCharacter(String c) {
        this.chr = c;
    }

}

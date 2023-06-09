package com.wordle.royale.v2.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class TextTile extends Actor {
    private String chr;
    private Skin skin;
    private BitmapFont character;
    private Sprite tile;
    private Stage stage;
    private int index;
    private Color color;

    public TextTile(int index, float x, float y, float width, float height) {
        this.index = index;
        this.color = new Color(Color.WHITE.cpy());
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
        batch.setColor(color);
        batch.draw(tile,getX(),getY(), getWidth(), getHeight());
        character.draw(batch, chr,getX() + getWidth()/2- (character.getXHeight()/4), getY() + getHeight()/2+(character.getXHeight()/2));
        batch.setColor(Color.WHITE);
    }

    public void setColor(Color color) {
        this.color =  color.cpy();
    }

    public Color getColor() {
        return this.color;
    }

    public void setCharacter(String s) {
        this.chr = s;
    }

    public String getChr() {
        return chr;
    }
}

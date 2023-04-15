package com.wordle.royale.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.util.ArrayList;

public class TextRow extends Actor {
    private ArrayList<TextTile> textTiles = new ArrayList<>();
    private float startPointX;
    private float startPointY;


    public TextRow(float startPointX, float startPointY) {
        this.startPointX = startPointX;
        this.startPointY = startPointY;
        setTouchable(Touchable.enabled);
        setX(0);
        setY(startPointY);
        setWidth(Gdx.graphics.getWidth());
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

            }
        });
        initTiles();

    }

    private void initTiles() {
        float currentX = startPointX;
        for (int i = 0; i < 5; i++) {
            TextTile tt = new TextTile(currentX, startPointY);
            textTiles.add(tt);
            currentX += 110;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for(TextTile tt : textTiles) {
            tt.draw(batch, parentAlpha);
        }
    }

}



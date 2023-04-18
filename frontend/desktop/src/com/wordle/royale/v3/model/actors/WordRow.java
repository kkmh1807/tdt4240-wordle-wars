package com.wordle.royale.v3.model.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.util.ArrayList;

public class WordRow extends Actor {
    private ArrayList<com.wordle.royale.v3.model.actors.TextTile> textTiles = new ArrayList<>();
    private float startPointX;
    private float startPointY;
    private int index = 0;


    public WordRow(float startPointX, float startPointY) {
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

    public int getIndex() {
        return index;
    }

    public void handleCharacterChange(String s) {
        if(index < 5) {
            System.out.println(index);
            textTiles.get(index).setCharacter(s);
            index+=1;
            System.out.println(index);

        }
    }

    public void removeCharacter() {
        if (index == 0) {
            return;
        }
        textTiles.get(index-1).setCharacter(" ");
        index -= 1;
    }

    private void initTiles() {
        float currentX = startPointX;
        for (int i = 0; i < 5; i++) {
            com.wordle.royale.v3.model.actors.TextTile tt = new com.wordle.royale.v3.model.actors.TextTile(i, currentX, startPointY);
            textTiles.add(tt);
            currentX += 270;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for(TextTile tt : textTiles) {
            tt.draw(batch, parentAlpha);
        }
    }
}



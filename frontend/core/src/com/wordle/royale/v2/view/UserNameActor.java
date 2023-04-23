package com.wordle.royale.v2.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class UserNameActor extends Actor {

    private BitmapFont userInput;
    private Skin skin;
    private String userName;
    private GlyphLayout layout;
    private Sprite background;

    public UserNameActor() {
        background = new Sprite(new Texture("craftacular/raw/slider.9.png"));
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        userInput = new BitmapFont(Gdx.files.internal("craftacular/raw/font-title-export.fnt"));
        userName = "";
        layout = new GlyphLayout(userInput, userName);
        userInput.getData().setScale(1f, 1.5f);
    }

    public void updateUsername(String s) {
        if(userName.length() >= 15) {
            return;
        }
        userName += s;
        if(userName.length() > 13) {
            userInput.getData().scale(-0.09f);
        }
        layout.setText(userInput, userName);
    }

    public void removeCharacter() {
        if(userName.length() > 0) {
            userName = userName.substring(0, userName.length() - 1);
        }
        if(userName.length() > 13) {
            userInput.getData().scale(0.09f);
        }
        layout.setText(userInput, userName);
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(background,getX(),getY(), getWidth(), getHeight());
        userInput.draw(batch, userName,(Gdx.graphics.getWidth()/2f) - layout.width/2f, (Gdx.graphics.getHeight()/2f) + layout.height*2);
    }



}

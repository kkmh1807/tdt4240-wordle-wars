package com.wordle.royale.v2.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.wordle.royale.v2.presenter.GameScreenPresenter;

public class KeyboardButton extends Actor implements GameScreenPresenter.keyboardButton{

    private String character;
    private TextButton button;
    private Skin skin;
    private GameScreenPresenter presenter;

    public KeyboardButton(final GameScreenPresenter presenter, final String character, float x, float y, float width, float height)  {
        this.presenter = presenter;
        this.character = character;
        this.skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        this.button = new TextButton(character.toString(), skin, "default");
        this.button.setTransform(true);
        this.button.setPosition(x, y);
        this.button.setHeight(height);
        this.button.setWidth(width);
        this.button.getLabel().setFontScale(3,4);
        setTouchable(Touchable.enabled);
        setX(this.button.getX());
        setY(this.button.getY());
        setHeight(this.button.getHeight());
        setWidth(this.button.getWidth());
        setBounds(getX(), getY(), getWidth(), getHeight());
        this.button.setScale(1, 1);

        handleKeyBoardInput();
    }

    public void setTextScale(float x, float y) {
        this.button.getLabel().setFontScale(x, y);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        button.draw(batch, parentAlpha);
    }

    @Override
    public void handleKeyBoardInput() {
        //Use presenter interface for ui input
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                presenter.handleKeyBoardInput(character);
            }
        });
    }
}

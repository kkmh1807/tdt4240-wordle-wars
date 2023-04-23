package com.wordle.royale.v2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.wordle.royale.v2.presenter.GameScreenPresenter;
import com.wordle.royale.v2.presenter.IKeyboard;
import com.wordle.royale.v2.view.KeyboardButton;

public class Keyboard extends Group{

    private char[] characters;
    private IKeyboard presenter;


    public Keyboard(IKeyboard presenter) {
        this.presenter = presenter;
        this.characters = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
        initializeKeyboardButtons();
    }

    //index 19
    //bredde 1,5 knapp
    private float btnWidth = ((Gdx.graphics.getWidth()-150)/10f);
    private float gap = btnWidth/9f;

    private void initializeKeyboardButtons() {
        for (int i = 0; i < characters.length; i++) {
            if(i <= 9) {
                this.addActor(new KeyboardButton(presenter, "" + characters[i], 25+(i*(btnWidth+gap)), 410, btnWidth, 160));
            }
            if(i > 9 && i <= 18) {
                this.addActor(new KeyboardButton(presenter, "" + characters[i], 25+(btnWidth/2f)+((i-10)*(btnWidth+gap)), 230, btnWidth, 160));
            }
            if(i > 18) {
                if(i == 19) {
                    KeyboardButton btn = new KeyboardButton(presenter, "OK", 25, 50, btnWidth*1.5f, 160);
                    btn.setTextScale(2f,3f);
                    this.addActor(btn);
                }
                this.addActor(new KeyboardButton(presenter, "" + characters[i], 25+(btnWidth*1.5f)+gap+((i-19)*(btnWidth+gap)), 50, btnWidth, 160));
            }
        }
        KeyboardButton del = new KeyboardButton(presenter, "Del", 25+(btnWidth*1.5f)+gap+((characters.length-19)*(btnWidth+gap)), 50, btnWidth*1.5f, 160);
        del.setTextScale(2f, 3f);
        this.addActor(del);
    }
}

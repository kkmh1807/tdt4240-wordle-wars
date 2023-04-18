package com.wordle.royale.v3.model;

import com.badlogic.gdx.scenes.scene2d.Group;

import com.wordle.royale.v3.presenter.KeyBoardPresenter;

public class Keyboard extends Group{

    private char[] characters;
    private KeyBoardPresenter keyBoardPresenter;



    public Keyboard(KeyBoardPresenter keyBoardPresenter) {
        this.keyBoardPresenter = keyBoardPresenter;
        this.characters = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
        initializeKeyboardButtons();
    }

    //index 19
    //bredde 1,5 knapp

    private void initializeKeyboardButtons() {
        for (int i = 0; i < characters.length; i++) {
            if(i <= 9) {
                this.addActor(new KeyboardButton(keyBoardPresenter, "" + characters[i], 50+(i*140), 410, 120, 160));
            }
            if(i > 9 && i <= 18) {
                this.addActor(new KeyboardButton(keyBoardPresenter, "" + characters[i], 50+60+((i-10)*140), 230, 120, 160));
            }
            if(i > 18) {
                if(i == 19) {
                    KeyboardButton btn = new KeyboardButton(keyBoardPresenter, "Enter", 50, 50, 180, 160);
                    btn.setTextScale(1.5f,2.5f);
                    this.addActor(btn);
                }
                this.addActor(new KeyboardButton(keyBoardPresenter, "" + characters[i], 50+200+((i-19)*140), 50, 120, 160));
            }
        }
        KeyboardButton del = new KeyboardButton(keyBoardPresenter, "Del", 50+200+((characters.length-19)*140), 50, 180, 160);
        del.setTextScale(1.5f, 2.5f);
        this.addActor(del);
    }
}

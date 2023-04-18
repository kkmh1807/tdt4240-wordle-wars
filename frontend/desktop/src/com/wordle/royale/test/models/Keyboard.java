package com.wordle.royale.test.models;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.wordle.royale.test.controller.WordleController;

public class Keyboard extends Group{

    private char[] characters;
    private WordleController controller;


    public Keyboard(WordleController controller) {
        this.controller = controller;
        this.characters = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
        initializeKeyboardButtons();
    }

    //index 19
    //bredde 1,5 knapp

    private void initializeKeyboardButtons() {
        for (int i = 0; i < characters.length; i++) {
            if(i <= 9) {
                this.addActor(new KeyboardButton(controller, "" + characters[i], 50+(i*140), 410, 120, 160));
            }
            if(i > 9 && i <= 18) {
                this.addActor(new KeyboardButton(controller, "" + characters[i], 50+60+((i-10)*140), 230, 120, 160));
            }
            if(i > 18) {
                if(i == 19) {
                    KeyboardButton btn = new KeyboardButton(controller, "Enter", 50, 50, 180, 160);
                    btn.setTextScale(1.5f,2.5f);
                    this.addActor(btn);
                }
                this.addActor(new KeyboardButton(controller, "" + characters[i], 50+200+((i-19)*140), 50, 120, 160));
            }
        }
        KeyboardButton del = new KeyboardButton(controller, "Del", 50+200+((characters.length-19)*140), 50, 180, 160);
        del.setTextScale(1.5f, 2.5f);
        this.addActor(del);
    }
}

package com.wordle.royale.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.wordle.royale.controller.WordleController;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Keyboard extends Group{

    private char[] characters;
    private WordleController controller;


    public Keyboard(WordleController controller) {
        this.controller = controller;
        this.characters = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
        initializeKeyboardButtons();
    }

    private void initializeKeyboardButtons() {
        for (int i = 0; i < characters.length; i++) {
            if(i <= 9) {
                this.addActor(new KeyboardButton(controller, characters[i], 50+(i*140), 460, 120, 160));
            }
            if(i > 9 && i <= 18) {
                this.addActor(new KeyboardButton(controller, characters[i], 50+60+((i-10)*140), 280, 120, 160));
            }
            if(i > 18) {
                this.addActor(new KeyboardButton(controller, characters[i], 50+180+((i-19)*140), 100, 120, 160));
            }
        }
    }
}

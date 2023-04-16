package com.wordle.royale.models;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Keyboard extends Group {

    private char[] characters;

    public Keyboard() {
        this.characters = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
        initializeKeyboardButtons();
        System.out.println(this.getChildren());
    }

    private void initializeKeyboardButtons() {
        for (int i = 0; i < 2; i++) {
            this.addActor(new KeyboardButton(characters[i],i*100, i*100, 60, 80));
        }
    }

}

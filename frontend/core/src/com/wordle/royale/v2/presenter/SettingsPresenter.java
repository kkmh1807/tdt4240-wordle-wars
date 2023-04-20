package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.other.AppPreferences;
import com.wordle.royale.v2.model.other.ScreenController;

public class SettingsPresenter {
    ScreenController parent;
    Stage stage;

    public SettingsPresenter(ScreenController parent, Stage stage) {
        this.parent = parent;
        this.stage = stage;
    }


    public void addActor(Actor actor) {
        this.stage.addActor(actor);
    }


    public void changeScreensFunc(int i) {
        parent.changeScreens(i);
    }

    public void toggleMusic() {
        boolean musicEnabled = parent.getPreferences().getMusic();
        parent.getPreferences().setMusic(!musicEnabled);
    }

    public boolean musicStatus() {
        return parent.getPreferences().getMusic();
    }

    public interface SettingsScreen {
        void addActor(Actor actor);
        void changeScreens(int i);
        void toggleMusic();
        boolean musicStatus();
    }
}

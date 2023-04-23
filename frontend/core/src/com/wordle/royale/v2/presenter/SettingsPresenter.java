package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.other.AppPreferences;
import com.wordle.royale.v2.model.other.ScreenController;

public class SettingsPresenter extends AbstractPresenter{

    public SettingsPresenter(ScreenController screenController, Stage stage) {
        super(stage, screenController);
    }

    public void toggleMusic() {
        boolean musicEnabled = screenController.getPreferences().getMusic();
        screenController.getPreferences().setMusic(!musicEnabled);
    }

    public boolean musicStatus() {
        return screenController.getPreferences().getMusic();
    }

    public interface SettingsScreen {
        void addActor(Actor actor);
        void changeScreens();
        void toggleMusic();
        boolean musicStatus();
    }
}

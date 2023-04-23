package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.other.AppPreferences;
import com.wordle.royale.v2.model.other.ScreenController;

public class SettingsPresenter {
    ScreenController parent;
    Stage stage;
    Music music;

    public SettingsPresenter(ScreenController parent, Stage stage) {
        this.parent = parent;
        this.stage = stage;
        music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
        music.setLooping(true);
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

    public boolean getMusicPreferences() {
        return parent.getPreferences().getMusic();
    }

    public void musicEnable() {
        if(getMusicPreferences()) {
            music.play();
        } else {
            music.stop();
        }
    }
    public void stopMusic() {
        music.stop();
    }

    public interface SettingsScreen {
        void addActor(Actor actor);
        void changeScreens();
        void toggleMusic();
        boolean musicStatus();

    }
}

package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.other.ScreenController;
import com.wordle.royale.v2.view.screens.MenuScreen;

public class MenuScreenPresenter {
    private ScreenController parent;
    private Stage stage;
    private Music music;

    public MenuScreenPresenter(ScreenController parent, Stage stage) {
        this.parent = parent;
        this.stage = stage;
        music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
        music.setLooping(true);
    }

    public void changeScreensFunc(int i) {
        parent.changeScreens(i);

    }

    public void musicEnabled() {
        if(parent.getPreferences().getMusic()){
            music.play();
        }
    }
    public void addActor(Actor actor) {
        stage.addActor(actor);
    }
    public interface changeScreens {
        void changeToTutorialScreen();
        void changeToGameScreen();
        void changeToHighscoreScreen();
        void changeToSettings();
        void addActor(Actor actor);
    }
}

package com.wordle.royale.v3.presenter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v3.model.ScreenController;

import utils.WordleTimer;

public class GameScreenPresenter {

    ScreenController parent;
    Music music;
    Stage stage;
    WordleTimer timer = WordleTimer.getInstance();
   // BitmapFont timerText = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"), false);

    public GameScreenPresenter(Stage stage, ScreenController parent) {
        this.stage = stage;
        this.parent = parent;
        Gdx.input.setInputProcessor(stage);
        this.music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));

    }
    public void addActor(Actor actor) {
        this.stage.addActor(actor);
    }



    public void musicControls() {

        if (parent.getPreferences().getMusic()) {
            this.music.setLooping(true);
            this.music.play();
        }
        if (timer.getInterval().equals("0:00")) {
            timer.stop();
            music.stop();
            parent.changeScreens(ScreenController.MENU);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (music.isPlaying()) {

                music.pause();
                System.out.println(music.isPlaying());
            } else {
                music.play();
                System.out.println(music.isPlaying());
            }
        }
    }



    public interface View {
        void handleKeyBoardInput();
    }


}

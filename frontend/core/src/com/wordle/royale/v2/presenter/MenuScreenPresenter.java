package com.wordle.royale.v2.presenter;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.other.ScreenController;


public class MenuScreenPresenter extends AbstractPresenter{

    public MenuScreenPresenter(ScreenController screenController, Stage stage) {
        super(stage, screenController);
    }


    public boolean getMusicPreferences() {
        return screenController.getPreferences().getMusic();
    }


    public void addActor(Actor actor) {
        stage.addActor(actor);
    }

    public void startMusicOn() {
        screenController.startMusic();
    }
    public void stopMusic() {
        screenController.stopMusic();
    }





    public interface changeScreens {
        void changeToTutorialScreen();
        void changeToGameScreen();
        void changeToHighscoreScreen();
        void changeToSettings();
        void addActor(Actor actor);
    }
}

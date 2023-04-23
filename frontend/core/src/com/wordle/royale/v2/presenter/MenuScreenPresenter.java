package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.other.ScreenController;
import com.wordle.royale.v2.view.screens.MenuScreen;

public class MenuScreenPresenter extends AbstractPresenter{

    public MenuScreenPresenter(ScreenController screenController, Stage stage) {
        super(stage, screenController);
    }

    public interface changeScreens {
        void changeToTutorialScreen();
        void changeToGameScreen();
        void changeToHighscoreScreen();
        void changeToSettings();
        void addActor(Actor actor);
    }
}

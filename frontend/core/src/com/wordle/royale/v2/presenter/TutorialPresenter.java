package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.other.ScreenController;

public class TutorialPresenter extends AbstractPresenter{

    public TutorialPresenter(ScreenController screenController, Stage stage) {
        super(stage, screenController);
    }

    public interface TutorialScreen {
        void addActor(Actor actor);
        void changeScreens();
    }
}

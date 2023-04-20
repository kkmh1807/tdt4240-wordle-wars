package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.other.ScreenController;

public class TutorialPresenter {
    Stage stage;
    ScreenController parent;

    public TutorialPresenter(ScreenController parent, Stage stage) {
        this.stage = stage;
        this.parent = parent;
    }


    public void addActor(Actor actor) {
        this.stage.addActor(actor);
    }

    public void changeScreensFunc(int i) {
        parent.changeScreens(i);
    }

    public interface TutorialScreen {
        void addActor(Actor actor);
        void changeScreens();
    }
}

package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.other.ScreenController;

public abstract class AbstractPresenter {

    final Stage stage;
    final ScreenController screenController;

    public AbstractPresenter(Stage stage, ScreenController screenController) {
        this.stage = stage;
        this.screenController = screenController;
    }

    public void addActor(Actor actor) {
        this.stage.addActor(actor);
    }

    public void changeScreens(int i) {
        this.screenController.changeScreens(i);
    };

}

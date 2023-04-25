package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.Keyboard;
import com.wordle.royale.v2.model.Player;
import com.wordle.royale.v2.model.User;
import com.wordle.royale.v2.model.other.ScreenController;
import com.wordle.royale.v2.view.UserNameActor;

public class LobbyScreenPresenter extends AbstractPresenter implements IKeyboard {

    private UserNameActor userNameActor;
    private Keyboard keyboard;

    public LobbyScreenPresenter(ScreenController screenController, Stage stage) {
        super(stage, screenController);
        userNameActor = new UserNameActor();
        keyboard = new Keyboard(this);
        addActor(userNameActor);
        addActor(keyboard);
    }

    @Override
    public void handleKeyBoardInput(String s) {
        if (s.equals("OK")) {
            return;
        }
        if (s.equals("Del")) {
            userNameActor.removeCharacter();
            return;
        }
        userNameActor.updateUsername(s);
    }

    public void startGame() {
        if(userNameActor.getUserName().length() > 0){
            Player.getInstance().setName(userNameActor.getUserName());
            changeScreens(ScreenController.GAME);
        }
    }

}

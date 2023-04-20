package com.wordle.royale.v2.presenter;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.wordle.royale.v2.model.Keyboard;
import com.wordle.royale.v2.model.guessedWord;
import com.wordle.royale.v2.model.network.ApiService;
import com.wordle.royale.v2.model.other.ScreenController;
import com.wordle.royale.v2.view.screens.GameScreen;
import com.wordle.royale.v2.view.TextTileGrid;
import com.wordle.royale.v2.view.WordRow;

public class GameScreenPresenter {

    private WordRow wordRow;
    private Keyboard keyboard;
    private ScreenController parentScreen;
    private GameScreen gameScreen;
    private TextTileGrid textTileGrid;
    private Stage stage;

    private ApiService api = new ApiService();
    private int word_id;

    public GameScreenPresenter(ScreenController parentScreen, Stage stage) {
        this.stage = stage;
        this.parentScreen = parentScreen;
        keyboard = new Keyboard(this);
        textTileGrid = new TextTileGrid(25, 600);
        //wordRow = new WordRow(50, 800);
        getWord();
        this.addActor(keyboard);
        this.addActor(textTileGrid);
        /*
         * if (parent.getPreferences().getMusic()) {
         * music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
         * music.setLooping(true);
         * music.play();
         * }
         */
    }

    public void addActor(Actor actor) {
        this.stage.addActor(actor);
    }
    public boolean checkTimer(utils.WordleTimer timer) {
        if(timer.getInterval().equals("0:00")) {
            timer.stop();
            //music.stop();
            parentScreen.changeScreens(ScreenController.MENU);
            return true;
        }
        return false;
    }
    public void getWord() {
        api.getNewWord(new ApiService.CallbackNewWord<Integer>() {
            @Override
            public void onSuccess(Integer wordID) {
                setWord_id(wordID);
                System.out.println("Your wordID:  " + wordID);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Failed to connect to API");
            }
        });
    }
    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public int getWord_id() {
        return word_id;
    }

    public void handleKeyBoardInput(String s) {
        if (textTileGrid.getActiveRow().getIndex() == 5 && s.equals("OK")) {
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                word.append(textTileGrid.getActiveRow().getChar(i));
            }
            guess(word.toString().toLowerCase());
            return;
        }

        if(textTileGrid.getActiveRow().getIndex() >= 0 && s.equals("Del")) {
            this.textTileGrid.getActiveRow().removeCharacter();
            return;
        }

        if (textTileGrid.getActiveRow().getIndex() < 5) {
            if (s.equals("OK")) {
                return;
            }
            this.textTileGrid.getActiveRow().handleCharacterChange(s);
        }
    }

    public void guess(String word) {
        api.guessWord(word, getWord_id(), new ApiService.CallbackGuessWord<Boolean, guessedWord>() {
            @Override
            public void onSuccess(Boolean valid, guessedWord guessedWord) {
                System.out.println("Is a valid word:  " + valid);
                guessedWord.printGuess();
                for (int i = 0; i < 5; i++) {
                    int place = guessedWord.getGuessLetters().get(i).getPlacement();
                    int exists = guessedWord.getGuessLetters().get(i).getStatus();
                    textTileGrid.getActiveRow().updateTileXColor(i, place, exists);
                }
                textTileGrid.nextRow();

                // Gets placement-status for first letter
                // System.out.println(guessedWord.getGuessLetters().get(0).getPlacement());
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Word not in list");
            }
        });
    }

    public void musicControls() {

    }


    public interface gameScreenView {
        void handleKeyBoardInput(String s);
    }

    public interface keyboardButton {
        void handleKeyBoardInput();
    }


}

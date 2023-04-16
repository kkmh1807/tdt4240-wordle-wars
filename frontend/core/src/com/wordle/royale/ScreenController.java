
package com.wordle.royale;

import com.badlogic.gdx.Game;

import com.wordle.royale.controller.WordleController;
import com.wordle.royale.screens.GameScreen;
import com.wordle.royale.screens.HighScoreScreen;
import com.wordle.royale.screens.MenuScreen;
import com.wordle.royale.screens.SettingsScreen;
import com.wordle.royale.screens.TutorialScreen;


public class ScreenController extends Game {


    //private LoadingScreen loadingScreen;
    //private PreferencesScreen preferencesScreen;
    private MenuScreen menu;
    private WordleController game;
    private SettingsScreen settings;
    private HighScoreScreen highScore;
    private TutorialScreen tutorial;


    //private modeGetFucked = mode
    //private MainScreen mainScreen;
    // private EndScreen endScreen;

    public final static int MENU = 0;
    public final static int GAME = 1;
    public final static int SETTINGS = 2;
    public final static int TUTORIAL = 3;
    public final static int HIGHSCORES = 4;


    public final static float GAME_WORLD_WIDTH = 1280;
    public final static float GAME_WORLD_HEIGHT = 720;


    @Override
    public void create() {

        menu = new MenuScreen(this);
        setScreen(menu);
    }
    public void changeScreens(int screen){
        switch(screen){
            case MENU:
                if(menu == null) menu = new MenuScreen(this); // added (this)
                this.setScreen(menu);
                break;

            case GAME:
                if(game == null) game = new WordleController(this);
                break;

            case SETTINGS:
                if(settings == null) settings = new SettingsScreen(this); //added (this)
                this.setScreen(settings);
                break;

            case TUTORIAL:
                if(tutorial == null) tutorial = new TutorialScreen(this); //added (this)
                this.setScreen(tutorial);
                break;


            case HIGHSCORES:
                if(highScore == null) highScore = new HighScoreScreen(this);  // added (this)
                this.setScreen(highScore);
                break;


        }
    }


}

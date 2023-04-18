package com.wordle.royale.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.model.ScreenController;
import com.wordle.royale.presenter.GameScreenPresenter;
import com.wordle.royale.utils.WordleTimer;

public class GameScreen implements Screen, GameScreenPresenter.View {

    private SpriteBatch batch;
    private Music music;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    public final static float aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();

    private GameScreenPresenter gameScreenPresenter;
    private KeyboardView keyboardView;

    private ScreenController parent;
    private WordleTimer timer;

    private BitmapFont timerText;

    public GameScreen(ScreenController parent) {
        this.parent = parent;

    }



    @Override
    public void show() {


        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();
        timer = WordleTimer.getInstance();
        timer.start();
        timerText = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"), false);
        gameScreenPresenter = new GameScreenPresenter(stage, parent);

        camera = new OrthographicCamera();
        viewport = new StretchViewport(ScreenController.GAME_WORLD_WIDTH * aspectRatio,
                ScreenController.GAME_WORLD_HEIGHT, camera);
        viewport.apply();

        keyboardView = new KeyboardView(parent, gameScreenPresenter);
    }


    /*

    public void addActor(Actor actor) {
        this.stage.addActor(actor);
    }

     */

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameScreenPresenter.musicControls();
        /*
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
        */


        batch.begin();

        stage.draw();



       timerText.getData().setScale(1.5f, 2.5f);
        timerText.draw(batch, timer.getInterval(), (Gdx.graphics.getWidth() / 2f) - timerText.getXHeight(),
                Gdx.graphics.getHeight() - 20);


        stage.act();



        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }

    @Override
    public void handleKeyBoardInput() {
        
    }
}

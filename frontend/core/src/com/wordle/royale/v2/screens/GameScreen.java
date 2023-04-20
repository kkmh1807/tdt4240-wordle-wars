package com.wordle.royale.v2.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.v2.model.other.ScreenController;
import com.wordle.royale.v2.presenter.GameScreenPresenter;

import utils.WordleTimer;

public class GameScreen implements Screen, GameScreenPresenter.gameScreenView{

    private SpriteBatch batch;
    private Music music;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    public final static float aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();


    private ScreenController parent;
    private WordleTimer timer;

    private BitmapFont timerText;
    private GameScreenPresenter presenter;

    public GameScreen(ScreenController parent) {
        this.parent = parent;
    }

    @Override
    public void show() {




        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();
        presenter = new GameScreenPresenter(parent, stage);

        timer = WordleTimer.getInstance();
        timer.start();
        timerText = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"), false);
        camera = new OrthographicCamera();
        viewport = new StretchViewport(ScreenController.GAME_WORLD_WIDTH * aspectRatio,
                ScreenController.GAME_WORLD_HEIGHT, camera);
        viewport.apply();
        Gdx.input.setInputProcessor(stage);
    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(presenter != null) {
            presenter.checkTimer(timer);

        }



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
    public void handleKeyBoardInput(String s) {
        presenter.handleKeyBoardInput(s);
    }
}

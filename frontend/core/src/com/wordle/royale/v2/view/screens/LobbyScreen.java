package com.wordle.royale.v2.view.screens;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.v2.model.Keyboard;
import com.wordle.royale.v2.model.User;
import com.wordle.royale.v2.model.other.HighScore;
import com.wordle.royale.v2.model.other.ScreenController;

import com.wordle.royale.v2.presenter.HighScorePresenter;
import com.wordle.royale.v2.presenter.LobbyScreenPresenter;

import java.awt.TextField;

public class LobbyScreen implements Screen {

    private User user;
    private Stage stage;
    private SpriteBatch batch;
    private LobbyScreenPresenter presenter;
    private final float GAME_WORLD_WIDTH = Gdx.graphics.getWidth();
    private final float GAME_WORLD_HEIGHT = Gdx.graphics.getHeight();
    private ScreenController screenController;
    private Viewport viewport;
    private OrthographicCamera camera;
    private GlyphLayout layout;
    protected Skin skin;
    private BitmapFont textTitle;
    private TextButton gameButton;
    public final static float aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();


    public LobbyScreen(ScreenController screenController) {
        this.screenController = screenController;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();
        presenter = new LobbyScreenPresenter(screenController, stage);

        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        textTitle = new BitmapFont(Gdx.files.internal("craftacular/raw/font-title-export.fnt"));
        textTitle.getData().setScale(1f, 1.5f);

        camera = new OrthographicCamera();
        viewport = new StretchViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);
        viewport.apply();
        layout = new GlyphLayout(textTitle, "Enter your legend name");

        gameButton = new TextButton("Start Game", skin, "default");
        gameButton.pad(20f);
        gameButton.setTransform(true);
        gameButton.setScale(1, 2f);
        gameButton.setPosition(Gdx.graphics.getWidth() / 2f - gameButton.getWidth() / 2f,
                Gdx.graphics.getHeight() / 2f - gameButton.getHeight() * 4);
        gameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                presenter.startGame();
            }
        });

        Gdx.input.setInputProcessor(stage);
        presenter.addActor(gameButton);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        textTitle.draw(batch, "Enter your legend name", (Gdx.graphics.getWidth()/2f) - layout.width / 2, Gdx.graphics.getHeight() - layout.height * 2f);
        stage.draw();

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
}

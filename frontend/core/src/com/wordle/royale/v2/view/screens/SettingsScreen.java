package com.wordle.royale.v2.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.v2.model.other.ScreenController;
import com.wordle.royale.v2.presenter.SettingsPresenter;

public class SettingsScreen implements Screen, SettingsPresenter.SettingsScreen {
    private SpriteBatch batch;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private final float GAME_WORLD_WIDTH = Gdx.graphics.getWidth();
    private final float GAME_WORLD_HEIGHT = Gdx.graphics.getHeight();

    private TextButton mainMenu;

    private ScreenController parent;
    private TextButton toggleMusic;
    private SettingsPresenter presenter;

    public SettingsScreen(ScreenController parent) {
        this.parent = parent;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();

        presenter = new SettingsPresenter(parent, stage);

        presenter.musicEnable();


        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        float aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport = new FillViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);
        viewport.apply();

        mainMenu = new TextButton("To main Menu", skin, "default");
        mainMenu.setScale(1f, 2f);
        mainMenu.setTransform(true);
        mainMenu.setPosition(Gdx.graphics.getWidth() / 2f - mainMenu.getWidth() / 2f, mainMenu.getHeight());

        changeScreens();

        Gdx.input.setInputProcessor((stage));
        addActor(mainMenu);

        if (presenter.getMusicPreferences()) {
            toggleMusic = new TextButton("Music is enabled", skin, "default");
        } else {
            toggleMusic = new TextButton("Music is disabled", skin, "default");
        }
        toggleMusic.setScale(1f, 2f);
        toggleMusic.setTransform(true);

        toggleMusic.setPosition(Gdx.graphics.getWidth() / 2f - toggleMusic.getWidth() / 2f, Gdx.graphics.getHeight()/2f);

        addActor(toggleMusic);

        toggleMusic();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // camera.update();

        if (musicStatus()) {
            toggleMusic.setText("Music is enabled");
        } else {
            toggleMusic.setText("Music is disabled");
        }

        batch.begin();

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

    @Override
    public void addActor(Actor actor) {
        presenter.addActor(actor);
    }

    @Override
    public void changeScreens() {
        mainMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                presenter.stopMusic();
                presenter.changeScreensFunc(ScreenController.MENU);
            }
        });
    }

    @Override
    public void toggleMusic() {
        toggleMusic.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                presenter.toggleMusic();
            }
        });
    }

    @Override
    public boolean musicStatus() {
        return presenter.getMusicPreferences();
    }
}

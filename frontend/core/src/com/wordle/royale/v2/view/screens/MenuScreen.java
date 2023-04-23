package com.wordle.royale.v2.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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
import com.wordle.royale.v2.model.other.ScreenController;
import com.wordle.royale.v2.presenter.MenuScreenPresenter;

public class MenuScreen implements Screen, MenuScreenPresenter.changeScreens {
    private SpriteBatch batch;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private final float GAME_WORLD_WIDTH = Gdx.graphics.getWidth();
    private final float GAME_WORLD_HEIGHT = Gdx.graphics.getHeight();
    private TextButton startGameButton;
    private TextButton tutorialButton;
    private TextButton settingsButton;
    private TextButton highScoreButton;
    private ScreenController parent;
    private MenuScreenPresenter presenter;

    private BitmapFont title;
    private GlyphLayout layout;



    public MenuScreen(ScreenController parent) {
        this.parent = parent;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();
        presenter = new MenuScreenPresenter(parent, stage);

        title = new BitmapFont(Gdx.files.internal("craftacular/raw/font-title-export.fnt"));
        title.getData().setScale(1.5f, 2f);
        layout = new GlyphLayout(title, "Wordle Wars");

        float aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport = new StretchViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);
        viewport.apply();

        startGameButton = new TextButton("Start Game", skin, "default");
        startGameButton.setScale(2f,2f);
        startGameButton.setTransform(true);
        startGameButton.setPosition(Gdx.graphics.getWidth() / 2f - startGameButton.getWidth(),
                Gdx.graphics.getHeight() / 2f + startGameButton.getHeight() * 2);

        tutorialButton = new TextButton("Tutorial", skin, "default");

        tutorialButton.pad(20f);
        tutorialButton.setTransform(true);
        tutorialButton.setScale(2f, 2f);
        tutorialButton.setPosition(Gdx.graphics.getWidth() / 2f - tutorialButton.getWidth(),
                Gdx.graphics.getHeight() / 2f);

        settingsButton = new TextButton("Settings", skin, "default");

        settingsButton.pad(20f);
        settingsButton.setTransform(true);
        settingsButton.setScale(2f, 2f);
        settingsButton.setPosition(Gdx.graphics.getWidth() / 2f - settingsButton.getWidth(),
                Gdx.graphics.getHeight() / 2f - settingsButton.getHeight() * 2);

        // Remember to remove line 80 to 92, used for testing
        highScoreButton = new TextButton("Highscore", skin, "default");

        highScoreButton.pad(20f);
        highScoreButton.setTransform(true);
        highScoreButton.setScale(2f, 2f);
        highScoreButton.setPosition(Gdx.graphics.getWidth() / 2f - highScoreButton.getWidth(),
                Gdx.graphics.getHeight() / 2f - highScoreButton.getHeight() * 4);

        changeToGameScreen();
        changeToHighscoreScreen();
        changeToSettings();
        changeToTutorialScreen();

        Gdx.input.setInputProcessor(stage);

        addActor(highScoreButton);
        addActor(startGameButton);
        addActor(tutorialButton);
        addActor(settingsButton);
        presenter.startMusicOn();
        if(presenter.getMusicPreferences()) {
            presenter.startMusicOn();
        } else {
            presenter.stopMusic();
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        title.draw(batch, "Wordle Wars", Gdx.graphics.getWidth() / 2f - layout.width / 2,
                Gdx.graphics.getHeight() - layout.height * 2);

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
    public void changeToTutorialScreen() {
        tutorialButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                presenter.changeScreens(ScreenController.TUTORIAL);
            }
        });
    }

    @Override
    public void changeToGameScreen() {
        startGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                presenter.changeScreens(ScreenController.LOBBY);
            }
        });

    }

    @Override
    public void changeToHighscoreScreen() {
        highScoreButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                presenter.changeScreens(ScreenController.HIGHSCORES);
            }
        });
    }

    @Override
    public void changeToSettings() {
        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                presenter.changeScreens(ScreenController.SETTINGS);
            }

        });

    }

    @Override
    public void addActor(Actor actor) {
        presenter.addActor(actor);
    }
}

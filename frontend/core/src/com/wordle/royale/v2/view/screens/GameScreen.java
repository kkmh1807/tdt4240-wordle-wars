package com.wordle.royale.v2.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.v2.model.Player;
import com.wordle.royale.v2.model.other.ScreenController;
import com.wordle.royale.v2.presenter.GameScreenPresenter;

import com.wordle.royale.v2.model.utils.WordleTimer;

public class GameScreen implements Screen, GameScreenPresenter.gameScreenView {

    private SpriteBatch batch;

    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    public final static float aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
    private ScreenController parent;
    private WordleTimer timer;
    private BitmapFont timerText;

    private BitmapFont feedback;
    private BitmapFont playerScore;
    private GlyphLayout scoreLayout;
    private GlyphLayout layout;
    private GlyphLayout timerLayout;
    private GameScreenPresenter presenter;

    private TextButton exitButton;

    public GameScreen(ScreenController parent) {
        this.parent = parent;
    }

    @Override
    public void show() {
        stage = new Stage();
        presenter = new GameScreenPresenter(parent, stage);
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        feedback = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"));
        playerScore = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"));
        feedback.getData().setScale(2f, 2f);
        playerScore.getData().setScale(2f, 2f);
        layout = new GlyphLayout(feedback, " ");
        scoreLayout = new GlyphLayout(playerScore, "Score: " + (Player.getInstance().getScore()+presenter.getLastRowScore()));
        timer = WordleTimer.getInstance();
        timer.start();
        exitButton = new TextButton("Exit", skin, "default");
        exitButton.pad(20f);
        exitButton.setTransform(true);
        exitButton.setWidth(125);
        exitButton.setHeight(100);
        exitButton.setPosition(25,
                Gdx.graphics.getHeight() - exitButton.getHeight() - 40);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                timer.stop();
                timer = null;
                Player.getInstance().destroyUser();
                presenter.changeScreens(ScreenController.MENU);

            }
        });
        presenter.addActor(exitButton);

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
        scoreLayout = new GlyphLayout(playerScore, "Score: " + Player.getInstance().getScore()+ " ("+presenter.getLastRowScore()+")");

        batch.begin();

        if (presenter.isTimeUp()) {
            presenter.changeScreens(ScreenController.GAMEOVER);
        }

        stage.draw();
        feedback.draw(batch, getFeedbackFunc(), (Gdx.graphics.getWidth() / 2f) - layout.width / 2,
                Gdx.graphics.getHeight() - (layout.height + (layout.height /2)));
        timerText.getData().setScale(1.5f, 2.5f);
        timerText.draw(batch, timer.getInterval(), (Gdx.graphics.getWidth() / 2.5f) - timerLayout.width / 2,
                Gdx.graphics.getHeight() - timerLayout.height);
        playerScore.draw(batch, "Score: "+Player.getInstance().getScore()+ " ("+presenter.getLastRowScore()+")", (Gdx.graphics.getWidth()) - scoreLayout.width - scoreLayout.width/10f,
                Gdx.graphics.getHeight() - timerLayout.height);
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
    public String getFeedbackFunc() {
        timerLayout = new GlyphLayout(timerText, timer.getInterval());
        layout.setText(feedback, presenter.getFeedback());
        return presenter.getFeedback();
    }
}

package com.wordle.royale.screens;

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
import com.wordle.royale.utils.WordleTimer;

public class GameScreen implements Screen {

    private SpriteBatch batch;
    private Music music;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    public final static float aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();

    public GameScreen() {
    }

    private ScreenController parent;
    private WordleTimer timer;

    private BitmapFont timerText;

    public GameScreen(ScreenController parent) {
        this.parent = parent;
    }

    @Override
    public void show() {

        /*
         * if (parent.getPreferences().getMusic()) {
         * music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
         * music.setLooping(true);
         * music.play();
         * }
         */

        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();
        timer = WordleTimer.getInstance();
        timer.start();
        timerText = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"), false);
        camera = new OrthographicCamera();
        viewport = new StretchViewport(ScreenController.GAME_WORLD_WIDTH * aspectRatio,
                ScreenController.GAME_WORLD_HEIGHT, camera);
        viewport.apply();
        Gdx.input.setInputProcessor(stage);
    }

    public void addActor(Actor actor) {
        this.stage.addActor(actor);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // camera.update();

        if (timer.getInterval().equals("0:00")) {
            timer.stop();
            //music.stop();
            parent.changeScreens(ScreenController.MENU);
        }

        batch.begin();
        // batch.setProjectionMatrix(camera.combined);
        /*
         * Table table = new Table();
         * table.add(label1);
         * table.add(name1).width(100);
         * table.row();
         * table.add(addressLabel1);
         * table.add(addressText1).width(100);
         * 
         */

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

}

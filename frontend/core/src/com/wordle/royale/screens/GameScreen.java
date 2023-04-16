package com.wordle.royale.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.WordleController;
import com.wordle.royale.models.Keyboard;
import com.wordle.royale.models.KeyboardButton;

public class GameScreen implements Screen {

    private SpriteBatch batch;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private final float GAME_WORLD_WIDTH = Gdx.graphics.getWidth();
    private final float GAME_WORLD_HEIGHT = Gdx.graphics.getHeight();
    private TextTileGrid textTileGrid;
    private TextField textField;
    private TextTile textTile;
    private ShapeRenderer shapeRenderer;

    private float startPointX = Gdx.graphics.getWidth() /4;
    private float startPointy = Gdx.graphics.getHeight() /2 + 150 + 150 + 150 + 150/3 + 150/3 + (150/3/2);



    private TextButton quitGameButton;
    private WordleController parent;


    public GameScreen(WordleController parent) {
        this.parent = parent;

    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();

        float aspectRatio = (float) Gdx.graphics.getHeight()/ (float) Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport = new FillViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);
        viewport.apply();

        KeyboardButton btn = new KeyboardButton('C', Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f, 60, 80);
        KeyboardButton btn2 = new KeyboardButton('A', Gdx.graphics.getWidth()/2f + 20, Gdx.graphics.getHeight()/2f+ 20, 60, 80);
        Keyboard kb = new Keyboard();
        stage.addActor(kb);

        WordRow tr = new WordRow(startPointX, startPointy);
        stage.addActor(tr);

        Gdx.input.setInputProcessor((stage));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        stage.act(Gdx.graphics.getDeltaTime());
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


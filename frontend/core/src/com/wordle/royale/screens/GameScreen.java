package com.wordle.royale.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.WordleController;
import utils.timer;

public class GameScreen implements Screen {

    private SpriteBatch batch;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private final float GAME_WORLD_WIDTH = Gdx.graphics.getWidth();
    private final float GAME_WORLD_HEIGHT = Gdx.graphics.getHeight();

    private TextButton quitGameButton;

    private WordleController parent;
    private utils.timer timer;

    private BitmapFont timerText;

    public GameScreen(WordleController parent) {
        this.parent = parent;
    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();
        timer = new timer();
        timer.start();
        timerText = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"), false);



        float aspectRatio = (float) Gdx.graphics.getHeight()/ (float) Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport = new FillViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);
        viewport.apply();

        quitGameButton = new TextButton("Quit Game", skin, "default");
        quitGameButton.setScale(1f, 2f);
        quitGameButton.setTransform(true);
        quitGameButton.setPosition(Gdx.graphics.getWidth() /2f - quitGameButton.getWidth()/2f, Gdx.graphics.getHeight()/2f);




        quitGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                timer.stop();
                parent.changeScreens(WordleController.MENU);
            }
        });


        Gdx.input.setInputProcessor((stage));
        stage.addActor(quitGameButton);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // camera.update();


        if (timer.getInterval().equals("0:00")) {
            timer.stop();
            parent.changeScreens(WordleController.MENU);
        }

        batch.begin();
//        batch.setProjectionMatrix(camera.combined);
        /*Table table = new Table();
        table.add(label1);
        table.add(name1).width(100);
        table.row();
        table.add(addressLabel1);
        table.add(addressText1).width(100);

         */
        stage.draw();
        timerText.getData().setScale(1.5f, 2.5f);
        timerText.draw(batch, timer.getInterval(), (Gdx.graphics.getWidth() / 2f) - timerText.getXHeight(), Gdx.graphics.getHeight() - 20);



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


package com.wordle.royale.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.WordleController;

public class HighScoreScreen implements Screen {

    private SpriteBatch batch;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private final float GAME_WORLD_WIDTH = Gdx.graphics.getWidth();
    private final float GAME_WORLD_HEIGHT = Gdx.graphics.getHeight();

    private TextButton backToMenu;
    private TextButton playAgain;

    private WordleController parent;

    public HighScoreScreen(WordleController parent) {
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

        backToMenu = new TextButton("To main menu", skin, "default");
        backToMenu.setScale(1f, 2f);
        backToMenu.setTransform(true);
        backToMenu.setPosition(Gdx.graphics.getWidth() /2f - backToMenu.getWidth()/2f, Gdx.graphics.getHeight()/2f);


        playAgain = new TextButton("To main menu", skin, "default");
        playAgain.setScale(1f, 2f);
        playAgain.setTransform(true);
        playAgain.setPosition(Gdx.graphics.getWidth() /2f - playAgain.getWidth()/2f, Gdx.graphics.getHeight()/2f - playAgain.getHeight()*2);


        playAgain.addListener((new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                parent.changeScreens(WordleController.GAME);
            }
        }));

        backToMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                parent.changeScreens(WordleController.MENU);
            }
        });


        Gdx.input.setInputProcessor((stage));
        stage.addActor(backToMenu);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // camera.update();




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



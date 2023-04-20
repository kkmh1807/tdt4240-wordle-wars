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

public class TutorialScreen implements Screen {

    private SpriteBatch batch;
    private BitmapFont tutorialText;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private final float GAME_WORLD_WIDTH = Gdx.graphics.getWidth();
    private final float GAME_WORLD_HEIGHT = Gdx.graphics.getHeight();

    private TextButton backToMenu;

    private ScreenController parent;

    public TutorialScreen(ScreenController parent) {
        this.parent = parent;
    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();
        tutorialText = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"), false);

        float aspectRatio = (float) Gdx.graphics.getHeight()/ (float) Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport = new FillViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);
        viewport.apply();

        backToMenu = new TextButton("To main menu", skin, "default");
        backToMenu.setScale(1f, 2f);
        backToMenu.setTransform(true);
        backToMenu.setPosition(Gdx.graphics.getWidth() /2f - backToMenu.getWidth()/2f, backToMenu.getHeight()*2);


        backToMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                parent.changeScreens(ScreenController.MENU);
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
        tutorialText.getData().setScale(1f, 1.5f);
        tutorialText.draw(batch, "You have six tries to guess the\nfive-letter Wordle of the day.\nType in your guess and submit\nyour word by hitting the “enter”\nkey on the Wordle keyboard.\n" +
                "\nThe color of the tiles will\nchange after you submit your\nword.\nA yellow tile indicates that you\npicked the right letter but it’s\nin the wrong spot.\nThe green tile indicates that\nyou picked the right letter in\nthe correct spot. The gray tile\nindicates that the letter you\npicked is not included\nin the word at all.\n\nContinue until you solve the\nWordle or run out of guesses.\nGood luck!", Gdx.graphics.getWidth()/4f ,Gdx.graphics.getHeight() - backToMenu.getHeight()*2);
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


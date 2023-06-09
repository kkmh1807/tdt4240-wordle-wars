package com.wordle.royale.v2.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.v2.model.other.ScreenController;
import com.wordle.royale.v2.presenter.TutorialPresenter;

public class TutorialScreen implements Screen, TutorialPresenter.TutorialScreen {

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
    private TutorialPresenter presenter;

    public TutorialScreen(ScreenController parent) {
        this.parent = parent;
    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();

        presenter = new TutorialPresenter(parent, stage);
        tutorialText = new BitmapFont(Gdx.files.internal("craftacular/raw/font-export.fnt"), false);

        float aspectRatio = (float) Gdx.graphics.getHeight()/ (float) Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport = new StretchViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);
        viewport.apply();

        backToMenu = new TextButton("To main menu", skin, "default");
        backToMenu.setScale(2f, 2f);
        backToMenu.setTransform(true);
        backToMenu.setPosition(Gdx.graphics.getWidth() /2f - backToMenu.getWidth(), backToMenu.getHeight()*2);

        changeScreens();
        Gdx.input.setInputProcessor((stage));
        addActor(backToMenu);

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
        tutorialText.getData().setScale(2f, 2f);
        tutorialText.draw(batch, "You have six tries to guess the\nfive-letter Wordle word.\nType in your guess and submit\nyour word by hitting the “enter”\nkey on the Wordle keyboard.\n" +
                "\nThe color of the tiles will\nchange after you submit your\nword.\nA yellow tile indicates that you\npicked the right letter but it’s\nin the wrong spot,\nthis will give you 5 points.\nThe green tile indicates that\nyou picked the right letter in\nthe correct spot, this will\ngive you 10 points.\nThe gray tile\nindicates that the letter you\npicked is not included\nin the word at all.\n\nContinue until you solve the\nWordle or run out of guesses.\nYour best guess is what\ngives you points.\n\nGood luck!", 0,Gdx.graphics.getHeight() - backToMenu.getHeight()*2);
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
        backToMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                presenter.changeScreens(ScreenController.MENU);
            }
        });
    }
}


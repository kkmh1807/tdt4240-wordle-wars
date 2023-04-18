package com.wordle.royale.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.model.ScreenController;

public class SettingsScreen implements Screen {
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

    public SettingsScreen(ScreenController parent) {
        this.parent = parent;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();

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

        mainMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                parent.changeScreens(ScreenController.MENU);
            }
        });

        Gdx.input.setInputProcessor((stage));
        stage.addActor(mainMenu);

        if (parent.getPreferences().getMusic()) {
            toggleMusic = new TextButton("Music is enabled", skin, "default");
        } else {
            toggleMusic = new TextButton("Music is disabled", skin, "default");
        }
        toggleMusic.setScale(1f, 2f);
        toggleMusic.setTransform(true);

        toggleMusic.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean musicEnabled = parent.getPreferences().getMusic();
                parent.getPreferences().setMusic(!musicEnabled);
            }
        });

        table.add(toggleMusic);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // camera.update();

        if (parent.getPreferences().getMusic()) {
            toggleMusic.setText("Music is enabled");
        } else {
            toggleMusic.setText("Music is disabled");
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

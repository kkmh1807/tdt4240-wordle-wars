package com.wordle.royale.v2.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.v2.model.Player;
import com.wordle.royale.v2.model.other.ScreenController;
import com.wordle.royale.v2.presenter.GameOverPresenter;
import com.wordle.royale.v2.presenter.HighScorePresenter;

public class GameOverScreen implements Screen, GameOverPresenter.changeScreens {

    private SpriteBatch batch;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private final float GAME_WORLD_WIDTH = Gdx.graphics.getWidth();
    private final float GAME_WORLD_HEIGHT = Gdx.graphics.getHeight();
    private TextButton backToMenu;
    private TextButton playAgain;
    private BitmapFont userName;
    private GlyphLayout userNameLayout;
    private BitmapFont userScore;
    private GlyphLayout userScoreLayout;
    private ScreenController parent;
    private BitmapFont title;
    private GlyphLayout layout;
    private BitmapFont font;
    private HighScorePresenter presenter;

    public GameOverScreen(ScreenController parent) {
        this.parent = parent;
    }

    @Override
    public void show() {
        title = new BitmapFont(Gdx.files.internal("craftacular/raw/font-title-export.fnt"));
        title.getData().setScale(1.5f, 2f);
        userScore = new BitmapFont(Gdx.files.internal("craftacular/raw/font-title-export.fnt"));
        userName = new BitmapFont(Gdx.files.internal("craftacular/raw/font-title-export.fnt"));
        userScore.getData().setScale(1f, 1f);
        userName.getData().setScale(1f, 1f);
        userNameLayout = new GlyphLayout(userName, Player.getInstance().getName());
        userScoreLayout = new GlyphLayout(userScore, "Score: " + Player.getInstance().getScore());

        layout = new GlyphLayout(title, "Game over");
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("craftacular/skin/craftacular-ui.json"));
        stage = new Stage();
        presenter = new HighScorePresenter(parent,stage);
        float aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport = new StretchViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);
        viewport.apply();
        backToMenu = new TextButton("To main menu", skin, "default");
        backToMenu.setScale(2f, 2f);
        backToMenu.setTransform(true);
        backToMenu.setPosition(Gdx.graphics.getWidth() / 2f - backToMenu.getWidth(), backToMenu.getHeight());
        playAgain = new TextButton("Play again", skin, "default");
        playAgain.setScale(2f, 2f);
        playAgain.setTransform(true);
        playAgain.setPosition(Gdx.graphics.getWidth() / 2f - playAgain.getWidth(),
                Gdx.graphics.getHeight() / 3f - playAgain.getHeight() * 2f);
        setupChangeToMenu();
        changeToGameScreen();
        Gdx.input.setInputProcessor((stage));
        stage.addActor(backToMenu);
        stage.addActor(playAgain);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        userNameLayout.setText(userName, Player.getInstance().getName());
        userScoreLayout.setText(userScore, "Score: " + Player.getInstance().getScore());

        batch.begin();
        title.draw(batch, "Game over", Gdx.graphics.getWidth()/2f - (layout.width/2), Gdx.graphics.getHeight()- layout.height*2);
        userName.draw(batch, Player.getInstance().getName(), Gdx.graphics.getWidth()/2f - userNameLayout.width/2, Gdx.graphics.getHeight()/2f + userNameLayout.height*2);
        userScore.draw(batch,"Score: "+ Player.getInstance().getScore(), Gdx.graphics.getWidth()/2f - userScoreLayout.width/2, Gdx.graphics.getHeight()/2f );
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
    public void setupChangeToMenu() {
        backToMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Player.getInstance().destroyUser();
                presenter.changeScreens(ScreenController.MENU);
            }
        });
    }

    @Override
    public void changeToGameScreen() {
        playAgain.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Player.getInstance().resetScore();
                presenter.changeScreens(ScreenController.GAME);
            }
        });

    }
}

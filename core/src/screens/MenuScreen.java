package screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.wordle.royale.WordleController;

public class MenuScreen implements Screen {
    private SpriteBatch batch;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    private TextureAtlas atlas;
    protected Skin skin;
    private final float GAME_WORLD_WIDTH = 1280;
    private final float GAME_WORLD_HEIGHT = 720;
    private Label label1;
    private TextField name1;
    private Label addressLabel1;
    private TextField addressText1;
    private TextureRegionDrawable someButtonImage;
    private TextButton startGameButton;
    private TextButton exitButton;
    private TextButton settingsButton;
    private WordleController parent;

    public MenuScreen(WordleController parent) {
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
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();

        startGameButton = new TextButton("Start Game", skin, "default");

        startGameButton.pad(20f);
        startGameButton.setTransform(true);
        startGameButton.setScale(0.5f);
        startGameButton.setPosition(Gdx.graphics.getWidth() /2f - startGameButton.getWidth()/4, Gdx.graphics.getHeight()/2f + 25);

        exitButton = new TextButton("Exit", skin, "default");

        exitButton.pad(20f);
        exitButton.setTransform(true);
        exitButton.setScale(0.5f);
        exitButton.setPosition(Gdx.graphics.getWidth() /2f - exitButton.getWidth()/4, Gdx.graphics.getHeight()/2f -50);


        settingsButton = new TextButton("Click me", skin, "default");

        settingsButton.pad(20f);
        settingsButton.setTransform(true);
        settingsButton.setScale(0.4f);
        settingsButton.setPosition(Gdx.graphics.getWidth() /2f - settingsButton.getWidth()/5, Gdx.graphics.getHeight()/2f -125);

        startGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                parent.changeScreens(WordleController.MENU);
            }
        });

        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });

        settingsButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

            }
        });

        Gdx.input.setInputProcessor(stage);
        label1 = new Label("Name:", skin);
        name1 = new TextField("", skin);
        addressLabel1 = new Label("Address:", skin);
        addressText1 = new TextField("", skin);



        stage.addActor(startGameButton);
        stage.addActor(exitButton);
        stage.addActor(settingsButton);
        //stage.addActor(label1);

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


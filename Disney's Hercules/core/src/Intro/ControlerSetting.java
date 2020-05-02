package Intro;

import com.Hercules.game.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ControlerSetting implements Screen {

    private Main game;
    private Texture background;
    public Stage stage;
    private Viewport viewport;
    private Skin skin;
    private BitmapFont FONT;
    private Label.LabelStyle font;
    public CheckBox cb;

    public ControlerSetting(Main game) {
        this.game = game;
        cb = new CheckBox("ARROWS", new Skin(Gdx.files.internal("Fonts\\uiskin.json")));
        background = new Texture(Gdx.files.internal("Intros\\0.jpg"));
        viewport = new StretchViewport(Main.WIDTH, Main.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, ((Main) game).batch);
        Gdx.input.setInputProcessor(stage);
        FONT = new BitmapFont(Gdx.files.internal("Fonts\\HUD.fnt"));
        font = new Label.LabelStyle(FONT, null);// MAKE THE STAGE ACCEPTS EVENTS
        if (Main.down == 20&&Main.up==19) {
            cb.setChecked(true);
        } else {
            cb.setChecked(false);
        }
        createBasicSkin();
        Buttons();

    }

    void Buttons() {

        Label up = new Label("UP", font);
        up.setPosition(Gdx.graphics.getWidth() / 2 - 500 + Main.x, Gdx.graphics.getHeight() / 2 + 200 + Main.y);
        Label down = new Label("DOWN", font);
        down.setPosition(up.getX(), up.getY() - 80);
        Label right = new Label("RIGHT", font);
        right.setPosition(down.getX(), down.getY() - 80);
        Label left = new Label("LEFT", font);
        left.setPosition(right.getX(), right.getY() - 80);
        Label sword1 = new Label("SWORD 1", font);
        sword1.setPosition(left.getX(), left.getY() - 80);
        Label sword2 = new Label("SWORD 2", font);
        sword2.setPosition(sword1.getX(), sword1.getY() - 80);
        Label push = new Label("PUSH", font);
        push.setPosition(sword2.getX(), sword2.getY() - 80);
        Label smallpush = new Label("SMALL PUSH", font);
        smallpush.setPosition(push.getX(), push.getY() - 80);
        stage.addActor(up);
        stage.addActor(down);
        stage.addActor(right);
        stage.addActor(left);
        stage.addActor(sword1);
        stage.addActor(sword2);
        stage.addActor(push);
        stage.addActor(smallpush);
        final TextField up1 = new TextField("", new Skin(Gdx.files.internal("Fonts\\uiskin.json")));
        up1.setPosition(up.getX() + 400, up.getY());
        up1.setMaxLength(1);
        up1.setSize(300, 50);
        stage.addActor(up1);
        final TextField down1 = new TextField("", new Skin(Gdx.files.internal("Fonts\\uiskin.json")));
        down1.setPosition(down.getX() + 400, down.getY());
        down1.setSize(300, 50);
        down1.setMaxLength(1);
        stage.addActor(down1);
        final TextField right1 = new TextField("", new Skin(Gdx.files.internal("Fonts\\uiskin.json")));
        right1.setPosition(right.getX() + 400, right.getY());
        right1.setSize(300, 50);
        right1.setMaxLength(1);
        stage.addActor(right1);
        final TextField left1 = new TextField("", new Skin(Gdx.files.internal("Fonts\\uiskin.json")));
        left1.setPosition(left.getX() + 400, left.getY());
        left1.setSize(300, 50);
        left1.setMaxLength(1);
        stage.addActor(left1);
        final TextField sword11 = new TextField(String.valueOf(Main.sword1), new Skin(Gdx.files.internal("Fonts\\uiskin.json")));
        sword11.setPosition(sword1.getX() + 400, sword1.getY());
        sword11.setSize(300, 50);
        sword11.setMaxLength(1);
        stage.addActor(sword11);
        final TextField sword22 = new TextField(String.valueOf(Main.sword2), new Skin(Gdx.files.internal("Fonts\\uiskin.json")));
        sword22.setPosition(sword2.getX() + 400, sword2.getY());
        sword22.setSize(300, 50);
        sword22.setMaxLength(1);
        stage.addActor(sword22);
        final TextField push1 = new TextField(String.valueOf(Main.push), new Skin(Gdx.files.internal("Fonts\\uiskin.json")));
        push1.setPosition(push.getX() + 400, push.getY());
        push1.setSize(300, 50);
        push1.setMaxLength(1);
        stage.addActor(push1);
        final TextField smallpush1 = new TextField(String.valueOf(Main.smallpush), new Skin(Gdx.files.internal("Fonts\\uiskin.json")));
        smallpush1.setPosition(smallpush.getX() + 400, smallpush.getY());
        smallpush1.setSize(300, 50);
        smallpush1.setMaxLength(1);
        stage.addActor(smallpush1);
        TextButton save = new TextButton("Save", skin);
        save.setPosition(Gdx.graphics.getWidth() / 2 + 400 + Main.x, Gdx.graphics.getHeight() / 2 - 100 + Main.y);
        save.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new StartMenu(game));
                if (cb.isChecked()==false &&(up1.getText().isEmpty() || down1.getText().isEmpty() || right1.getText().isEmpty() || left1.getText().isEmpty() || sword11.getText().isEmpty() || sword22.getText().isEmpty() || push1.getText().isEmpty() || smallpush1.getText().isEmpty())) {
                    Label error = new Label("on of the text fields is empty !", font);
                    error.setPosition(Gdx.graphics.getWidth() / 2 + Main.x, Gdx.graphics.getHeight() / 2 + Main.y);
                    stage.addActor(error);
                } else {
                    if(cb.isChecked()==true ){
                        
                    }
                    else{
                    Main.up = up1.getText().charAt(0);
                    Main.down = down1.getText().charAt(0);
                    Main.left = left1.getText().charAt(0);
                    Main.right = right1.getText().charAt(0);
                    Main.sword1 = sword11.getText().charAt(0);
                    Main.sword2 = sword22.getText().charAt(0);
                    Main.push = push1.getText().charAt(0);
                    Main.smallpush = smallpush1.getText().charAt(0);}
                    game.setScreen(new StartMenu(game));
                }

            }
        });
        stage.addActor(save);
        cb.setPosition(Gdx.graphics.getWidth() / 2 + 400 + Main.x, Gdx.graphics.getHeight() / 2 + Main.y);
        cb.setSize(300, 50);
        cb.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (cb.isChecked()) {
                    Main.up = 19;
                    Main.down = 20;
                    Main.right = 22;
                    Main.left = 21;
                    up1.setTouchable(Touchable.disabled);
                    down1.setTouchable(Touchable.disabled);
                    left1.setTouchable(Touchable.disabled);
                    right1.setTouchable(Touchable.disabled);
                } else {
                    up1.setTouchable(Touchable.enabled);
                    down1.setTouchable(Touchable.enabled);
                    left1.setTouchable(Touchable.enabled);
                    right1.setTouchable(Touchable.enabled);
                }
            }
        });
        stage.addActor(cb);

    }

    private void createBasicSkin() {
        BitmapFont font = new BitmapFont(Gdx.files.internal("Fonts\\Menu.fnt"));
        skin = new Skin();
        skin.add("default", font);

        // CREATE A TEXTURE
        Pixmap pixmap = new Pixmap((int) Gdx.graphics.getWidth() / 4, (int) Gdx.graphics.getHeight() / 10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.DARK_GRAY);
        pixmap.fill();
        skin.add("Background", new Texture(pixmap));

        // CREATE A BUTTON STYLE
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("Background", Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("Background", Color.YELLOW);
        textButtonStyle.checked = skin.newDrawable("Background", Color.GREEN);
        textButtonStyle.over = skin.newDrawable("Background", Color.BLUE);  // HOVER
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Main.batch.begin();
        Main.batch.draw(background, 0, 0, Main.WIDTH, Main.HEIGHT);
        Main.batch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void show() {
    }

    @Override
    public void resize(int width, int height) {
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
    }

}

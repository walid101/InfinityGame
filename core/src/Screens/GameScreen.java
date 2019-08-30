package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.wallegameone.IG;

import java.util.ArrayList;

import Decoders.GifDecoder;

import Extra.Dialogue;
import ScreenMod.mouseControl;

public class GameScreen implements Screen
{
    Animation<TextureRegion> animation;
    Dialogue converse;
    Dialogue converse2;
    boolean stop = false;
    float elapsed;
    Texture back;
    IG thisGame;
    Music music2;
    Texture click;
    //These are the x, and y for click, also
    //Height and width for click
    int clickX = 208;
    int clickY = 170;
    int i = 0;
    int j = 0;
    int k = 0;
    int vel = 2;
    int clickWidth = 63;
    int clickHeight = 60;

    Texture clickCen;
    int click2X = 400;
    int click2Y = 240;

    Texture clickBar;
    int barClickX = 520;
    int barClickY = 240;

    mouseControl control;//includes methods to help decode
                         //user input, go to the mouseControl
                         //class for more information.
    ArrayList<String> des1;

    //These are the descriptions presented to user
    //when they hover over the rotating circles
    Dialogue log1;
    Dialogue log2;
    Dialogue log3;
    Dialogue log4;

    //These are the encapsulating methods that hold textures
    //allowing them to rotate, these are currently holding
    //the circle textures
    TextureRegion reg;
    TextureRegion centReg;
    TextureRegion barReg;

    boolean con1Comp = false;
    public GameScreen(IG game)
    {

        thisGame = game;
        back = new Texture("backGame1.jpg");
        control = new mouseControl(thisGame);
        click = new Texture("click.png");
        reg = new TextureRegion(click);

        clickCen = new Texture("click.png");
        centReg = new TextureRegion(clickCen);

        clickBar = new Texture("click.png");
        barReg = new TextureRegion(clickBar);
        music2 = Gdx.audio.newMusic(Gdx.files.internal("Scene2Music.mp3"));//the music here needs to be changed,
        //we will add the music in later.

        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("backgroundRain.gif").read());

        converse = new Dialogue("Ugh..............", "Where am I..........", "..Ugh My head...", "SONNY:", "SonnyIcon.png", 3);//Last one always goes first
        converse2 = new Dialogue("the last thing I remember was that doctor.......", "....who was he?....and why did he have the governmential signet?...", ".........", "SONNY:","SonnyIcon.png", 4);
        log1 = new Dialogue("This is the store, " , "here you can buy new armaments", "for your characters, PRESS TO ENTER", "STORE", 3);
        log2 = new Dialogue("This is the NEXT WORLD", "please finish the current challenges first", " and then move forward, PRESS TO ENTER", "NEW WORLD", 3);
        log3 = new Dialogue("This is the Local bar", "Wait a minute, did you hear that crash?", "better check it out, PRESS TO ENTER", "first mission", 3 );

    }
    @Override
    public void show()
    {
        music2.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        thisGame.batch.begin();
        thisGame.batch.enableBlending();
        elapsed += Gdx.graphics.getDeltaTime();

        if (music2.isPlaying() == false && stop == false) {
            music2.play();
        }
        thisGame.batch.draw(back, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        thisGame.batch.draw(animation.getKeyFrame(elapsed), 20.0f, 20.0f);
        i += vel;
        j += vel;
        k += vel;
        thisGame.batch.draw(reg, clickX, clickY, clickWidth / 2, clickHeight / 2, clickWidth, clickHeight, 1, 1, i, true);
        //LOCATION TEST PURPOSES
/**
 if(control.isHovering(Gdx.graphics.getWidth(), 0, Gdx.graphics.getHeight(), 0))
 {
 System.out.println("" + Gdx.input.getX() + " , " + Gdx.input.getY());
 }
 **/
        if (control.isHovering(clickX + clickWidth, clickX, clickY + clickHeight, clickY)) {
            log1.drawStaticDialogue(thisGame.batch, clickX, click2Y, Gdx.graphics.getWidth()/6);
            i+=vel;
            if (control.isClicked()) {
                System.out.println("Enter Store");
                music2.pause();
                thisGame.setScreen(new Store(thisGame));
                stop = true;
            }
        }

        thisGame.batch.draw(centReg, click2X, click2Y, clickWidth / 2, clickHeight / 2, clickWidth, clickHeight, 1, 1, j, true);
        if (control.isHovering(click2X + clickWidth, click2X, click2Y + clickHeight, click2Y)) {
            j+=vel;
            log2.drawStaticDialogue(thisGame.batch, click2X, click2Y, 2);
            if (control.isClicked()) {
                System.out.println("Enter New World");
                //THIS IS TEMPORARY :: IT IS FOR TESTING SKILL TREE DATE: 8/15/19
                //
                thisGame.setScreen(new SkillTree(thisGame));

                //
                stop = false;
            }
        }

        thisGame.batch.draw(barReg, barClickX, click2Y, clickWidth / 2, clickHeight / 2, clickWidth, clickHeight, 1, 1, k, true);
        if (control.isHovering(barClickX + clickWidth, barClickX, barClickY + clickHeight, barClickY)) {
            k+=vel;
            log3.drawStaticDialogue(thisGame.batch, barClickX, barClickY, 20);
            if (control.isClicked()) {
                System.out.println("Enter Bar");
                thisGame.setScreen( new Bar(thisGame));
            }
        }
        if(converse.isComplete()){converse.dispose();
        con1Comp = true;
        }
        else {
            converse.drawDialogue(thisGame.batch, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/4);
        }
        if(con1Comp == true && converse2.isComplete() == false)
        {
            converse2.drawDialogue(thisGame.batch, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/4);

        }
        else
        {
            if(converse2 != null)
            {
                converse2.dispose();
            }
        }
        thisGame.batch.end();
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
    public void dispose()
    {
        thisGame.dispose();
    }
}

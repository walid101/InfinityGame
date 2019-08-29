package Screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.wallegameone.IG;

import javax.swing.GroupLayout;

import Characters.Being;
import ScreenMod.PixelAdapt;
import ScreenMod.mouseControl;
import Slider.Slider;

public class MenuScreen implements Screen
{
    int slideCount = 0;
    int spWidth = 150;
    int spHeight = 160;


    boolean movedRight = false;
    boolean movedLeft = false;
    int hVel = 1;
    int wVel = 1;
    int accel = 1;
    int slideWidth = 100;
    int slideHeight = 120;
    int slideMovement = 3;
    Texture img;
    Texture slide1;
    Texture slide2;
    Texture slide3;
    int slidX1;
    int slidX2;
    int slidX3;
    int slideWidth1 = slideWidth;
    int slideWidth2 = slideWidth;
    int slideWidth3 = slideWidth;

    int slideHeight1 = slideHeight;
    int slideHeight2 = slideHeight;
    int slideHeight3 = slideHeight;
    int tempX1;
    int tempX2;
    int tempX3;
    Texture blueLight;
    Texture background;
    Texture secondBack;
    Texture start;
    Texture save;
    Texture options;
    Texture slideArr1, slideArr2;
    boolean finished = false;
    int slideX1, slideX2, slideY;
    int arrWidth, arrHeight;
    Sprite Start;
    int startX, startY, sWidth, sHeight, saveWidth, saveHeight, oWidth, oHeight;
    int saveX, saveY , optionsX, optionsY;
    int screenWidth;
    int screenHeight;
    int imgW;
    int imgH;
    IG game;
    Being firstLife;
    mouseControl control;
    public int thisX = 640;
    public int thisY = 480;
    PixelAdapt adpt;
    Slider mySlides;
    Music music;
    public MenuScreen(IG newGame)
    {

        game = newGame;
        music = Gdx.audio.newMusic(Gdx.files.internal("Japan Spring.mp3"));
        control = new mouseControl(newGame);
        //the following text was a test to see if the class worked;
        firstLife = new Being(game,"Skeleton", "skeleton.png", 100, 200, 10,20,30);
        adpt = new PixelAdapt(thisX,thisY,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //Start, Save, Options Controls Area
        sWidth = adpt.conX(150);
        sHeight = adpt.conY(50);
        saveWidth = sWidth;
        saveHeight = sHeight - adpt.conY(9);
        oWidth = sWidth;
        oHeight = sHeight;

        startX = adpt.conX(Gdx.graphics.getWidth()/2 - sWidth/2);
        startY = adpt.conY(Gdx.graphics.getHeight()/2 - sHeight/2 + 135);

        saveX = startX;
        saveY = startY - sHeight + adpt.conY(3);

        optionsX = startX;
        optionsY = saveY - saveHeight - adpt.conY(15);
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        //This Area is for slider control: we will need to space it out in relation to the previous Textures


        arrWidth = 45;
        arrHeight = 55;

        slideY = optionsY - adpt.conY(125);
        slideX1 = startX - arrWidth - adpt.conX(80);
        slideX2 = startX + sWidth + adpt.conX(80);

        /////////////////////////////////////////////////////////////////// Slider arrows date Started: 8/2/2019
        //Date completed: 8/2/2019

        slidX1 = slideX1 + 60 - 10 + 3;
        slidX2 = slideX2 - arrWidth - 60 - 10 + 3;
        slidX3 = Gdx.graphics.getWidth()/2 - slideWidth/2 + 9 - 38 + 3;




    }
    @Override
    public void show()
    {
        music.play();
        img = new Texture("badlogic.jpg");
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        imgH = img.getHeight();
        imgW = img.getWidth();
        background = new Texture("MainMenuBack.jpg");
        secondBack = new Texture("background.jpg");
        blueLight = new Texture("bluelight.jpg");
        start = new Texture("START.png");
        Start = new Sprite(start, startX, startY, sWidth,sHeight);

        save = new Texture("SAVE.png");
        options = new Texture("OPTIONS.png");

        slideArr1 = new Texture("left.png"); //I am using this as a test because there is no internet connection
        slideArr2 = new Texture("right.png");//Same as the first condition


        slide1 = new Texture("hydra.jpg");
        slide2 = new Texture("Psycho.png");
        slide3 = new Texture("Bio.png");

    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.enableBlending();
        game.batch.begin();
        game.batch.draw(secondBack, 0,0,Gdx.graphics.getWidth() + 50, Gdx.graphics.getHeight());

        if(control.isHovering(startX + sWidth,startX, startY + sHeight, startY))
        {
            //System.out.println(Gdx.graphics.getWidth() + " , " + Gdx.graphics.getHeight());
            game.batch.draw(blueLight, startX - adpt.conX(30), startY , sWidth + adpt.conX(60), sHeight);
            //System.out.println(sWidth + " , " + sHeight + " ,, " + startX + " , " + startY + ",,,,," + (startY + sHeight) + " , " + Gdx.input.getY());
        }
        //Result 1: (635,71) :: (889,79);
        //Result 2: (622, 100) :: (871,112);
        //Height: 540
        //Width: 897

        game.batch.draw(start,startX,startY, sWidth, sHeight);

        if(control.isHovering(saveX + saveWidth, saveX, saveY + saveHeight, saveY))
        {
            game.batch.draw(blueLight, saveX - adpt.conX(30), saveY, saveWidth + adpt.conX(60), saveHeight);
        }
        game.batch.draw(save, saveX, saveY, saveWidth, saveHeight);

        if(control.isHovering(optionsX + oWidth, optionsX, optionsY + oHeight, optionsY))
        {
            game.batch.draw(blueLight, optionsX - adpt.conX(30), optionsY, oWidth + adpt.conX(60), oHeight);
        }
        game.batch.draw(options, optionsX, optionsY, oWidth, oHeight);

        //Testing because no internet (Date: 8/2/2019):, Internet found after date: 8/3/2019 at time 7:46, now continuing::
        
        //Drawing arrows on top as slides go under the arrows::
        game.batch.draw(slideArr1, slideX1, slideY, arrWidth, arrHeight);
        game.batch.draw(slideArr2, slideX2, slideY, arrWidth, arrHeight);

        game.batch.draw(slide1, slidX1, slideY - 40 , slideWidth1, slideHeight1);
        game.batch.draw(slide2, slidX2, slideY - 40, slideWidth2,slideHeight2);
        game.batch.draw(slide3, slidX3, slideY - 40 - 20, spWidth, spHeight);
        if(control.isHovering(slideX1 + arrWidth, slideX1, slideY + arrHeight, slideY))
        {

            if(control.isClicked()) {
                /**
                 if (movedRight == true) {
                 slideMovement = 0;
                 }

                 slideMovementL();
                 **/
                slideCount--;
            }
        }
        if(control.isHovering(slideX2 + arrWidth, slideX2, slideY + arrHeight, slideY))
        {

            if(control.isClicked()) {
                /**
                 if (movedLeft == true) {
                 slideMovement = 0;
                 }
                 slideMovementR();
                 **/

                slideCount++;
            }
        }
        if(control.isHovering(startX + sWidth, startX, startY + sHeight, startY))
        {
            if(control.isClicked())
            {
                music.dispose();
                img.dispose();
                slide1.dispose();
                slide2.dispose();
                slide3.dispose();
                background.dispose();
                slideArr1.dispose();
                slideArr2.dispose();
                start.dispose();
                save.dispose();
                options.dispose();
                game.setScreen(new GameScreen(game));
            }
        }
        if(Math.abs(slideCount) % 3 == 0)
        {
            game.batch.draw(slide1, slidX1, slideY - 40 , slideWidth1, slideHeight1);
            game.batch.draw(slide2, slidX2, slideY - 40, slideWidth2,slideHeight2);
            game.batch.draw(slide3, slidX3, slideY - 40 - 20, spWidth, spHeight);//MIDDLE
        }
        if(Math.abs(slideCount) % 3 == 1)
        {
            game.batch.draw(slide2, slidX1, slideY - 40, slideWidth2, slideHeight2);
            game.batch.draw(slide3, slidX2,slideY - 40, slideWidth2,slideHeight2);
            game.batch.draw(slide1, slidX3, slideY - 40 - 20, spWidth, spHeight);
        }
        if(Math.abs(slideCount) % 3 == 2)
        {
            game.batch.draw(slide3, slidX1,slideY - 40, slideWidth2, slideHeight2);
            game.batch.draw(slide1, slidX2,slideY - 40, slideWidth2, slideHeight2);
            game.batch.draw(slide2, slidX3, slideY - 40 - 20, spWidth, spHeight);
        }
        //THE FOLLOWING CODE IS JUST FOR EXPERIMENTAL PURPOSES
        if(control.isHovering(saveX + saveWidth, saveX, saveY + saveHeight,saveY))
        {
            if(control.isClicked()) {
                music.pause();
            }
        }
        if(control.isHovering(optionsX + oWidth, optionsX, optionsY + oHeight, optionsY))
        {
            if(control.isClicked())
            {
                music.play();
            }
        }


        ////////////////////////////////////////
        game.batch.end();
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
        game.batch.dispose();
        music.dispose();
        img.dispose();

    }
    public boolean slid(Sprite first, Sprite second, Sprite third, int vel)
    {
        //first.setPosition()
        return false;
    }
    public void slideMovementR()
    {
        slidX1 +=slideMovement;
        slidX2 += slideMovement;
        slidX3 += slideMovement;
        /**
        slideMovement += accel;
        movedRight = true;
        movedLeft = false;
         **/

    }
    public void slideMovementL()
    {
        int mid = Gdx.graphics.getWidth()/2;
        if(slidX2 + slideWidth2/2 >= mid )
        {
            slideWidth2 += wVel;
            slideHeight2 += hVel;
        }
        else
        {
            slideWidth2 -= wVel;
            slideHeight2 -= hVel;
        }
        slidX1 -= slideMovement;
        slidX2 -= slideMovement;
        slidX3 -= slideMovement;
        /**slideMovement += accel;
        movedRight = false;
        movedLeft = true;
         **/
    }
    public void deCel()
    {
        slideMovement -= accel;
    }
    public void Acc()
    {
        slideMovement += accel;
    }



}

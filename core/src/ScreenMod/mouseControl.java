package ScreenMod;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.wallegameone.IG;

public class mouseControl
{
    IG mouseGame;
    public int x = Gdx.input.getX();
    public int y = Gdx.input.getY();
    public int deltaX = Gdx.input.getDeltaX();
    public int deltaY = Gdx.input.getDeltaY();
    public mouseControl(IG game)
    {
        mouseGame = game;
    }
    public boolean isHovering(int x2, int x1, int y2, int y1) // Range here is needed
    {
        int myY = Gdx.graphics.getHeight() - Gdx.input.getY();
        //Note: x2 is always the larger value, x1 is the smaller value, same for Y
        if (Gdx.input.getX() <=x2 && Gdx.input.getX() >= x1)
        {
            if(myY <= y2 && myY  >= y1)
            {
                return true;
            }

        }
        return false;
    }
    public boolean isClicked()
    {
        return Gdx.input.justTouched();
    }
    public boolean onSpot(int x2, int x1, int y2, int y1)
    {
        if(isHovering( x2,  x1,  y2,  y1))
        {
            return isClicked();
        }
        return false;
    }
    public int getX()
    {
        return Gdx.input.getX();
    }
    public int getY()
    {
        return Gdx.input.getY();
    }
}

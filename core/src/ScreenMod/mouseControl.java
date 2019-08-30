//AUTHOR NOTE: FULL DOCUMENTED as of 8/22/19
package ScreenMod;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.wallegameone.IG;

public class mouseControl
{

    IG mouseGame;//declaring on which game control should be operating on.
    public int x = Gdx.input.getX();//X-val of mouse position
    public int y = Gdx.input.getY();//Y-val of mouse position
    public int deltaX = Gdx.input.getDeltaX();//change in x-position
    public int deltaY = Gdx.input.getDeltaY();//change in y-position
    public mouseControl(IG game)
    {
        mouseGame = game;//instantiated game to central game instance;
    }

    /*
    Returns true if mouse is hovering over a certain square index
    Parameters: must input 4 integers, the first pair makes up
    the x-horizantal boundary, and the second pair makes the
    y-vertical boundary, the first of each pair must be greater
    than the second, respectively.

    Precondition: input 4 integers, x2>x1, y2>y1
    Postcondition: returns true if mouse x,y position is within
    bounds.

    Exceptions: throws IllegalArgumentException if(X2<X1 || Y2<Y1)
     */
    public boolean isHovering(int x2, int x1, int y2, int y1) // Range here is needed
    {
        int myY = Gdx.graphics.getHeight() - Gdx.input.getY();//this step flips mouse Y-val
        //as it is flipped relative to the screen's y-val.
        //Cheching if parameters follow rule:
        if(x2>x1 || y2>y1)
        { throw new IllegalArgumentException("Illegal Inputs for isHovering method call" +
                                             "your first number must be greater than your second \n" +
                                             "your third number must be greater than your fourth");}

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
    /*
    Returns true if user clicks the mouse
    precondition: user either clicks or does not click the mouse
    postcondition: boolean response on whether user clicked is returned
    parameters: N/A
     */
    public boolean isClicked()
    {
        return Gdx.input.justTouched();
    }
    /*
    This is a getter method, returns x-val of mouse position
    precondition: call method
    postcondition: returns x-val of mouse position
    parameters: N/A
     */
    public int getX()
    {
        return Gdx.input.getX();
    }
    /*
    this is a getter method, returns y-val of mouse position
    precondition: call method
    postcondition: returns y-val of mouse condition
    parameters: N/A
     */
    public int getY()
    {
        return Gdx.input.getY();
    }
}

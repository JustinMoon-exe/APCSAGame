import greenfoot.*;
import java.util.List;
/**
 * The fog/light class
 * I used photoshop to make the image, just a radial gradient from black to transparent
 *  
 */
public class FOG extends Actor
{

    private int speed = 5;   
    //The light moves in sync with the player, the only diffrence being that players cant go through walls

    public FOG()
    {
        speed = 5;

    }

    public void act() 
    {
        if(Greenfoot.isKeyDown("A"))
        {
            moveLeft();
        }
        if(Greenfoot.isKeyDown("D"))
        {
            moveRight();
        }
        if(Greenfoot.isKeyDown("W"))
        {
            moveUp();
        }
        if(Greenfoot.isKeyDown("S")) 
        {
            moveDown(); 
        }

    }
    //exact same movement code except for collision
    public void moveRight()    {

        setLocation(getX() + speed, getY());

    }

    public void moveLeft()    {

        setLocation (getX() - speed, getY());

    }

    public void moveUp()
    {

        setLocation (getX(), getY() - speed);

    }

    public void moveDown()
    {

        setLocation (getX(), getY() + speed);

    }


    
}

/**
 * 
 * The player code used a lot of diffrent elements that we learned and puts them all together with the help of some other sources
 * 
 */
import greenfoot.*;
import java.util.List;
public class Player extends Actor
{

    private int speed = 0;                          
    private Class[] barrier = new Class[0];

    private int Points = 0;

    public Player()
    {
        speed = 5;
        setBlockingClasses(  new Class[]{Wall.class}  );
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

        Actor enemy = getOneIntersectingObject(Enemy.class);
        //this bit checks to see if the player hat been hit
        if (enemy != null) {

            //getWorld().removeObject(this); //maybe the source of the bug that brings up console when the player dies
            Greenfoot.setWorld(new LoseScreen()); //removes them

        }

        if( (this.getX() >= 550) && (this.getX() <= 630) && (this.getY() >= 30) && (this.getY() <= 120)){

            Greenfoot.setWorld(new EndScreen());
            //if the player reaches the end zone, they are sent to the endscreen
        }
    }

    /**
     * Movement in every direction is done separatley. There was probably a more efficient way but this got the job done
     * 
     */

    public void moveRight()    {
        if(canMoveRight()){

            setLocation(getX() + speed, getY());
        }
    }

    public void moveLeft()    {
        if(canMoveLeft()){
            setLocation (getX() - speed, getY());
        }
    }

    public void moveUp()
    {
        if(canMoveUp()){
            setLocation (getX(), getY() - speed);
        }
    }

    public void moveDown()
    {
        if(canMoveDown()){
            setLocation (getX(), getY() + speed);
        }
    }

    /**
     * When the player clicks a button(WASD), this part checks to see if there is a wall there. 
     * 
     */
    public boolean canMoveLeft()
    {
        for(Class c: barrier)
        {
            List<Actor> bs = getIntersectingObjects(c);
            for(Actor b: bs)
            {
                if(b.getX() < this.getX()){
                    return false; //this bit right here is what causes the stickiness of the walls, essentially blocking all movement unless it is away
                }
            }
        }
        return true;
    }

    public boolean canMoveRight()
    {
        for(Class c: barrier)
        {
            List<Actor> bs = getIntersectingObjects(c);
            for(Actor b: bs)
            {
                if(b.getX() > this.getX()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canMoveUp()
    {
        for(Class c: barrier)
        {
            List<Actor> bs = getIntersectingObjects(c);
            for(Actor b: bs)
            {
                if(b.getY() < this.getY()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canMoveDown()
    {
        for(Class c: barrier)
        {
            List<Actor> bs = getIntersectingObjects(c);
            for(Actor b: bs)
            {
                if(b.getY() > this.getY()){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Had some issues with my wall codes(
     * User Jamers helped my here
     */
    protected void setBlockingClasses(Class[] c)

    {
        barrier = c;
    }

    /**
     * checks to see if the player is intersecting with the flag
     * 
     */
    public boolean foundFlag()

    {
        Actor Flag = getOneObjectAtOffset(0, 0, Flag.class);
        if(Flag != null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Part of before when the flag was a burger, Found it kind of funny so now it is here
     * May also be a cause of the console bug
     */
    public void eatFlag()
    {
        Actor Flag = getOneObjectAtOffset(0, 0, Flag.class);
        if(Flag != null) {
            // eat the Flag...
            getWorld().removeObject(Flag);
            Points = Points + 1; 
        }
    }

}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player gets here after they get hit by an enemy cell
 * 
 * @author (Justin) 
 * @version today)
 */
public class LoseScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * Brings in text and an enemy
     */
    public LoseScreen()
    {    

        super(1000, 700, 1);
        getBackground().drawImage(new GreenfootImage("You Lost!", 100, null, null), 330, 100);

        addObject(new Enemy(), 500, 350);

        getBackground().drawImage(new GreenfootImage("Click shift to try again!", 60, null, null), 250, 500);
        

    }

    /**
     * When the player hit shift, take them to the start screen
     * 
     */

    public void act(){
        if(Greenfoot.isKeyDown("shift")){
            Greenfoot.setWorld(new StartScreen());
        }
    }
}

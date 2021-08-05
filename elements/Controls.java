import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Presents to the player what the controls are and the main gameplay mechanic
 * 
 */
public class Controls extends World
{
    /**
     * Words are brought in along with the player icon
     * 
     */
    public Controls()

    {    

        super(1000, 700, 1);
        getBackground().drawImage(new GreenfootImage("Use WASD to move!", 100, null, null), 140, 50);
        getBackground().drawImage(new GreenfootImage("Click the flag to escape!", 100, null, null), 50, 150);

        addObject(new Player(), 500, 350);

        getBackground().drawImage(new GreenfootImage("The light is NOT affected by walls", 60, null, null), 130, 420);
        getBackground().drawImage(new GreenfootImage("but YOU are!", 60, null, null), 370, 500);
        getBackground().drawImage(new GreenfootImage("Click space to Start", 60, null, null), 270, 580);

    }

    /**
     * When the player hits space, go to the main gameworld
     * 
     */
    public void act(){

        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new World1());
        }
    }
}

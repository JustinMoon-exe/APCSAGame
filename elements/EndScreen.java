import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player gets here after reaching the flag
 * Shows the score
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    private int time = Score.setScore();

    /**
     * Brings in the words, score and player icon
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        getBackground().drawImage(new GreenfootImage("You Escaped!", 100, null, null), 240, 100);

        addObject(new Player(), 500, 350);

        getBackground().drawImage(new GreenfootImage("Your Score was: " + time, 60, null, null), 240, 400);
        getBackground().drawImage(new GreenfootImage("Press shift to restart", 60, null, null), 270, 500);

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

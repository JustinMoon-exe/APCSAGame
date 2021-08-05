import greenfoot.*; 

/**
 *Sends the time too the endscreen world
 *Does not do much else
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends TimerActor
{
    /**
     * Score is the time taken in millis divided by 100, giving a nice biggish number to work with
     * 
     */    
    public static int setScore(){
        return(millisElapsed/100);

    }
}

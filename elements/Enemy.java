/**
 * The Enemy's code is very similar to the player's inthat they have the same system stoping them from going through walls
 * 
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
import java.util.Random;

public class Enemy extends Actor
{
    private Class[] barrier = new Class[0];  
    private int move;
    private Random rand = new Random();
    private int speed = 2;

    /**
     * Sets the wall class as a blocking class
     */
    public Enemy(){
        setBlockingClasses(  new Class[]{Wall.class}  );
    }

    public void act(){
        move = rand.nextInt(50); //used a random number generator to make the cell's movemement very sporadic. This took some tuning and I'm still not very happy with it

        if (move == 0){
            moveLeft();
        }
        else if (move == 1){
            moveRight();
        }
        else if (move == 2){
            moveUp();
        }
        else if (move ==3){
            moveDown();
        }
        else{
            move(0);
        }

    }
    //the cells move in 20 unit increments
    public void moveRight(){
        if(canMoveRight()){

            setLocation(getX() + 20, getY());
        }
    }

    public void moveLeft(){
        if(canMoveLeft()){
            setLocation (getX() - 20, getY());
        }
    }

    public void moveUp(){
        if(canMoveUp()){
            setLocation (getX(), getY() - 20);
        }
    }

    public void moveDown(){
        if(canMoveDown()){
            setLocation (getX(), getY() + 20);
        }
    }
    //exact same code as the player. Wanted to make one over arching class to simplify things but it did not work 
    public boolean canMoveLeft(){
        for(Class c: barrier)
        {
            List<Actor> bs = getIntersectingObjects(c);
            for(Actor b: bs)
            {
                if(b.getX() < this.getX()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canMoveRight(){
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

    public boolean canMoveUp(){
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

    public boolean canMoveDown(){
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

    protected void setBlockingClasses(Class[] c){
        barrier = c;
    }

}


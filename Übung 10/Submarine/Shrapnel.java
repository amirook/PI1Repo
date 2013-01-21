import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shrapnel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shrapnel extends Crashable
{
    private int movementspeed;
    
    public void handleCrash(Submarine submarine)
    {
        if ( submarine != null ) {
            WorldManager.gameOver = true;
        }
    }
    
    /** winkel und geschwindigkeit in welchen das erstellte Shrapnle fliegt*/
    public Shrapnel (int arc,int movementspeed) 
    {
        this.setRotation(arc);
        this.movementspeed = movementspeed;
    } 
    
    /**
     * Act - do whatever the Shrapnel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(movementspeed);
        removeIfExitingWorld();
    }    
}

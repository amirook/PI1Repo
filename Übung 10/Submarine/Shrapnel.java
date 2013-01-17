import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shrapnel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shrapnel extends Enemy
{
    private int movementspeed;

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
    
    //Shrapnel entfernen wenn es den Spielfeldrand berührt
    private void removeIfExitingWorld()
    {
        int width = getWorld().getWidth();
        int height = getWorld().getHeight();
        int imagew = getImage().getWidth();
        int imageh = getImage().getHeight();
        int myX = this.getX();
        int myY = this.getY();
        if (myX>=width-(imagew/2) || myX<=0+(imagew/2) || myY>=height-(imageh/2) || myY<=0+(imageh/2)){
            getWorld().removeObject(this);
        }
    }
}

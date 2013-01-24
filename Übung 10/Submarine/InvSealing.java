import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InvSealing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvSealing extends Obstacle
{
    /**
     * Act - do whatever the InvSealing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public InvSealing(){
        super(Hammer.class);
        beatenSound = "explosion.wav";
    } 
}

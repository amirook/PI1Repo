import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boje extends Obstacle
{
    /**
     * Act - do whatever the Boje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Boje()
    {
        super(Hammer.class);
        beatenSound = "explosion.wav";
    }  
}

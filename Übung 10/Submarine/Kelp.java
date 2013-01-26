import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Seetang here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kelp extends Obstacle
{
    public Kelp(String picture)
    {
        super(Scissor.class);
        beatenSound = "explosion.wav";
        setImage(picture);
    }
}

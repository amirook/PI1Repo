import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rockwall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rockwall extends Obstacle
{
    public Rockwall(){
        super(Hammer.class);
        beatenSound = "explosion.wav";
    }
}

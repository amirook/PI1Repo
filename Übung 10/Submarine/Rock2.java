import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock2 extends Obstacle
{
    public Rock2(){
        super(Hammer.class);
        beatenSound = "explosion.wav";
    }
}

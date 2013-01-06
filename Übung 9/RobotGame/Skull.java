import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ein Totenschädel. Spielt eine traurige Melodie ab. (Übungsblatt 2)
 * 
 * @author Thomas Röfer 
 * @version 01.11.2012
 */
public class Skull extends Collider
{
    /**
     * Spielt eine traurige Melodie ab, wenn es eine Überschneidung mit einem
     * Actor gibt. Das Abspielen wird nur gestartet, wenn es bei der vorherigen
     * Ausführung keine Überschneidung gab.
     */
    public void act() 
    {
        if (newCollisionWith(Robot.class)) {
            Game.playSound("sad-trombone.wav", this);
        }
        turn(1);
    }    
}

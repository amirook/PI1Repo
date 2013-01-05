import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ein Smiley. Spielt einen fröhlichen Ausruf ab. (Übungsblatt 2)
 * 
 * @author Thomas Röfer 
 * @version 01.11.2012
 */
public class Smiley extends Collider
{
    /**
     * Spielt einen fröhlichen Ausruf ab, wenn es eine Überschneidung mit einem
     * Actor gibt. Das Abspielen wird nur gestartet, wenn es bei der vorherigen
     * Ausführung keine Überschneidung gab.
     */
    public void act() 
    {
        if (newCollisionWith(Robot.class)) {
            Greenfoot.playSound("hooray.wav");
        }
    }    
}

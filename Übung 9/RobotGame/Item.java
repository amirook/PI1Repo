import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ein Objekt, das aufgehoben werden kann. (Übungsblatt 8)
 * 
 * @author Thomas Röfer
 * @version 02.12.2012
 */
public abstract class Item extends Actor
{
    /**
     * 
     */
    public abstract Item useItem(Robot robot);
    
    /**
     * 
     */
    public abstract boolean matches(Obstacle obstacle);
}

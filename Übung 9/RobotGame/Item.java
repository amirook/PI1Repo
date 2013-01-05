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
     * Abstrakte Methode um das Item zu nutzen
     * @param robot Unser Roboter
     * @return Das Item, welches das im Inventar liegende Item ersetzt
     */
    public abstract Item useItem(Robot robot);
    
    /**
     * Abstrakte Methode, die prüft ob das Item zum Hinderniss passt.
     * @param obstacle Das zu prüfende Hinderniss
     * @return true, wenn das Item zum Hinderniss passt
     */
    public abstract boolean matches(Obstacle obstacle);
}

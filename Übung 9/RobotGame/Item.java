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
     * Standrad Methode um das Item zu nutzen, wenn das Item diese Methode nicht überschreibt
     * @param robot Unser Roboter
     * @return Das Item, welches das im Inventar liegende Item ersetzt
     */
    public Item useItem(Robot robot){
        if (robot.collidesWith(Obstacle.class)){
            Obstacle obstacle = (Obstacle) robot.getCollidingObject(Obstacle.class);
            if (matches(obstacle)){
                robot.getWorld().removeObject(obstacle);
                return null;
            }
        }
        return this;
    }
    
    /**
     * Abstrakte Methode, die prüft ob das Item zum Hinderniss passt.
     * @param obstacle Das zu prüfende Hinderniss
     * @return true, wenn das Item zum Hinderniss passt
     */
    public abstract boolean matches(Obstacle obstacle);
}

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Eine Bombe. Kann benutzt werden, um Wände zu sprengen. (Bonusaufgabe Übungsblatt 3)
 * 
 * @author Thomas Röfer 
 * @version 01.11.2012
 */
public class Bomb extends Item
{
    /**
     * Methode um das Item zu nutzen
     * @param robot Unser Roboter
     * @return Das Item, welches das im Inventar liegende Item ersetzt
     */
    public Item useItem(Robot robot){
        if (robot.collidesWith(Obstacle.class)){
            Obstacle obstacle = (Obstacle) robot.getCollidingObject(Obstacle.class);
            if (matches(obstacle)){
                robot.getWorld().removeObject(obstacle);
                Game.playSound("Bottle.aiff", robot);
                return new BombFire();
            }
        }
        return this;
    }
    
    /**
     * Methode, die prüft ob das Item zum Hinderniss passt.
     * @param obstacle Das zu prüfende Hinderniss
     * @return true, wenn das Item zum Hinderniss passt
     */
    public boolean matches(Obstacle obstacle){   
        return obstacle instanceof Fire;
    }
}

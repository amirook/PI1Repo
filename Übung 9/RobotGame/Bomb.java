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
     * 
     */
    public boolean matches(Obstacle obstacle){   
        return obstacle instanceof Fire;
    }
    
    /**
     * 
     */
    public Item useItem(Robot robot){
        if (robot.collidesWith(Obstacle.class)){
            Obstacle obstacle = (Obstacle) robot.getCollidingObject(Obstacle.class);
            if (matches(obstacle)){
                robot.getWorld().removeObject(obstacle);
                Greenfoot.playSound("Bottle.aiff");
                return new BombFire();
            }
        }
        return this;
    }
}

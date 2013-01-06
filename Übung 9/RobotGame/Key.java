import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ein Schlüssel. Kann benutzt werden, um Türen zu öffnen. (Übungsblatt 3)
 * 
 * @author Thomas Röfer 
 * @version 01.11.2012
 */
public class Key extends Item
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
                robot.getScore().setScore(robot.getScore().getScore() + 100);
                Game.playSound("door-open.wav", robot);
                robot.getWorld().removeObject(obstacle);
                return null;
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
        return obstacle instanceof Door;
    }
}

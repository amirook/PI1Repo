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
     * 
     */
    public Item useItem(Robot robot){
        if (robot.collidesWith(Obstacle.class)){
            Obstacle obstacle = (Obstacle) robot.getCollidingObject(Obstacle.class);
            if (matches(obstacle)){
                robot.getWorld().removeObject(obstacle);
                robot.getScore().setScore(robot.getScore().getScore() + 100);
                Greenfoot.playSound("door-open.wav");
                return null;
            }
        }
        return this;
    }
    
    /**
     * 
     */
    public boolean matches(Obstacle obstacle){   
        return obstacle instanceof Door;
    }
}

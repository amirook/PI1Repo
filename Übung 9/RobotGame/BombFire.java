import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Beschreiben Sie hier die Klasse BombFire.
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class BombFire extends Item
{
    /**
     * 
     */
    public boolean matches(Obstacle obstacle){   
        return obstacle instanceof Wall;
    }
    
    /**
     * 
     */
    public Item useItem(Robot robot){
        if (robot.collidesWith(Obstacle.class)){
            Obstacle obstacle = (Obstacle) robot.getCollidingObject(Obstacle.class);
            if (matches(obstacle)){
                robot.getWorld().removeObject(obstacle);
                robot.getScore().setScore(robot.getScore().getScore() + 200);
                Greenfoot.playSound("Explosion.wav");
                return null;
            }
        }
        return this;
    }
}

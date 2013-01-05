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
     * Methode um das Item zu nutzen
     * @param robot Unser Roboter
     * @return Das Item, welches das im Inventar liegende Item ersetzt
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
    
    /**
     * Methode, die prüft ob das Item zum Hinderniss passt.
     * @param obstacle Das zu prüfende Hinderniss
     * @return true, wenn das Item zum Hinderniss passt
     */
    public boolean matches(Obstacle obstacle){   
        return obstacle instanceof Wall;
    }
}

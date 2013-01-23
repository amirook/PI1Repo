import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Creatures here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Collider
{
    /**
     * gibt an ob die jeweilige instanz von einer Spielerwaffe getroffen wurde
     * wenn player!=null kann dem Spieler ein Punktebonus erteilt werden
     */
    public Submarine hitByPlayer=null;

    /**
     * Act - do whatever the Creatures wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    protected Object getObjectInRange(int range, Class cls)
    {
        List<Actor> actors = getObjectsInRange(range,cls);
        for (Actor actor : actors) {
            if(actor.getClass()== cls) {
                return actor;
            }
        }
        return null;
    }
    
    /**
     * dreht den Gegner in richtung des spezifizierten actors
     * ein spezifizierter Zusatzwinkel kann hier auf die erstellte Rotation addiert werden(z.B.random)
     */
    protected void turnTowardsObject(Actor actor, int zusatzarc){
        turnTowards(actor.getX(),actor.getY());
        int arc=this.getRotation();
        this.setRotation(arc+zusatzarc);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemys wants to do. This method is called whenever
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
     * prüft auf ein Durchbrechen der Wasseroberfläche
     * und reagiert darauf wenn notwendig(
     */
    public void reactToSurface(Actor actor)
    {
        int arc = actor.getRotation();
        if(arc< 270 && arc >=90){
            actor.turn(-1);
            actor.move(3);
        }
        
        else{
            actor.turn(1);
            actor.move(3);
        }

        if(arc == 270)
        {
            actor.move(4);
        }
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

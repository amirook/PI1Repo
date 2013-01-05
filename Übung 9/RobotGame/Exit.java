import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.List;
/**
 * Ein Ausgang zu einer anderen Welt. (Übungsblatt 4)
 * 
 * @author Thomas Röfer 
 * @version 06.11.2012
 */
public class Exit extends Collider
{
    /** Die Klasse der Welt, zu der verzweigt wird. */
    Class worldClass;

    /** Die x-Position des Roboters in der neuen Welt. */
    int x;

    /** Die y-Position des Roboters in der neuen Welt. */
    int y;

    /**
     * Konstruktor.
     * @param worldClass Die Klasse der Welt, zu der verzweigt wird.
     * @param x Die x-Position des Roboters in der neuen Welt.
     * @param y Die y-Position des Roboters in der neuen Welt.
     */
    public Exit(Class worldClass, int x, int y)
    {
        this.worldClass = worldClass;
        this.x = x;
        this.y = y;
    }

    /**
     * Testet auf eine Kollision mit dem Roboter und wechselt die Welt, wenn eine auftritt.
     */
    public void act() 
    {
        if (newCollisionWith(Robot.class)) {
            Greenfoot.playSound("fanfare.wav");
            switchWorld((Robot) getCollidingObject(Robot.class));
        }
    }

    /**
     * Verzweigt zu einer anderen Welt und nimmt den Roboter samt Inventar mit.
     * Es wird angenommen, dass das Inventar in der neuen Welt an derselben
     * Stelle angezeigt wird, wie in der alten.
     * @param robot Der Roboter, der samt seinem Inventar mitgenommen wird.
     */
    private void switchWorld(Robot robot)
    {
        World oldWorld = getWorld();
        World newWorld = Game.getWorld(worldClass);

        // Objekte in die neue Welt verschieben
        Class[] actorClasses = {Robot.class, Inventory.class, Score.class};
        for (Class actorClass : actorClasses) {
            transfer(actorClass, oldWorld, newWorld);
        }
        
        // Den Roboter an die richtige Stelle verschieben
        robot.setLocation(x, y);
        
        // Die Welt wechseln
        Greenfoot.setWorld(newWorld);
    }
    
    /**
     * Verschiebt alle Akteure einer bestimmten Klassen von einer
     * Welt in eine andere.
     * @param actorClass Die Klasse der Akteure, die verschoben werden.
     * @param from Die Welt, aus der die Akteure entfernt werden.
     * @param to Die Welt, in die die Akteure eingefügt werden.
     */
    private void transfer(Class actorClass, World from, World to)
    {
        List<Actor> actors = from.getObjects(actorClass);
        for (Actor actor : actors) {
            int x = actor.getX();
            int y = actor.getY();
            from.removeObject(actor);
            to.addObject(actor, x, y);
        }
    }
}

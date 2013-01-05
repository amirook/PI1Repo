import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Speichert die x- und y-Koordinate sowie die Rotation eine Actors. (Übungsblatt 3)
 * 
 * @author Thomas Röfer 
 * @version 01.11.2012
 */
public class Pose
{
    private int x;
    private int y;
    private int rotation;
    
    /**
     * Der Konstruktor speichert die Position und Rotation des übergebenen
     * Actors ab.
     */
    public Pose(Actor actor)
    {
        x = actor.getX();
        y = actor.getY();
        rotation = actor.getRotation();
    }
    
    /**
     * Setzt die Position und Rotation des übergebenen Actors auf die
     * in diesem Objekt gespeichern Werte.
     */
    public void restore(Actor actor)
    {
        actor.setLocation(x, y);
        actor.setRotation(rotation);
    }
}

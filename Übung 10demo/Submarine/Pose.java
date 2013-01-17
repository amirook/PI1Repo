import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
/**
 * Instanzen dieser Klasse bekommen einen Actor als Paramter übergeben und speichern dessen Position und Rotation. Dies ist nötig um
 * das "durchlaufen" von Hindernissen zu verhindern.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.1
 */
public class Pose
{
    /**
     * x-Postion des Acrors
     */
    private int xPose;
    
    /**
     * y-Position des Acrors
     */
    private int yPose;
    
    /**
     * Rotationswert des Acrors
     */
    private int rotationPose;
    
    /**
     * Referenz auf den Actor
     */
    private Actor actor;

    /**
     * Konstruktor für Objekte der Klasse Pose. Position des Actors wird in xPose und yPose und dessen Rotation
     * in rotationPose hinterlegt.
     * @param actor Actor, dessen Position und Rotation gespeichert werden soll.
     */
    public Pose(Actor actor)
    {
        this.actor = actor;
        xPose = actor.getX();
        yPose = actor.getY();
        rotationPose = actor.getRotation();
    }

    /**
     * Position und Rotation des Actors werden auf seine ursprünglichen Werte zurückgesetzt.
     */
    public void resetPose(){
        actor.setLocation(xPose, yPose);
        actor.setRotation(rotationPose);
    }
}

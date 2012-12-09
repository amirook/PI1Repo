import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Crashable ist die Oberklasse aller sammelbaren Objekte und vererbt ihnen einen Grundstock an
 * Fähigkeiten. Im Wesentlichen kümmert sich diese Klasse darum, wie ein Objekt nach
 * einer Kollision interaggiert.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 */
public class Crashable extends Actor
{
    /**
     * Objekte dieser Klasse können sich in einem Zustand befinden, wo sie gerade "am kollidieren" sind.
     */
    protected boolean isCrashing;
    
    /**
     * Ton-Datei
     */
    protected String soundFile;
    
    /**
     * Wert, um den der Punktestand des Flappers erhöht werden soll.
     */
    protected int scoreValue;    
    
    /**
     * Hilfsklasse für die Repositionierung von Objekten
     */
    protected Utility utility = new Utility();
    
    /**
     * Act - Tue was immer Bug tun möchte. Diese Methode wird aufgerufen,
     * wenn die 'Act'- oder 'Run'-Knöpfe in der Umgebung gedrückt werden.
     */
    public void act() 
    {
        checkCollision();
    }
    
    /**
     * Prüft ob das Objekt mit neo kollidiert. Setzt das Objekt in den "isCrashing" Zustand, damit der Sound nur einmal abgespielt wird. Führt den Crash Handler aus.
     */
    protected void checkCollision()
    {
        Bee bee = (Bee) getOneIntersectingObject(Bee.class);
        if ( (bee != null ) && (!isCrashing) ) {
            isCrashing = true;
            handleCrash(bee);
        }
        else if (bee == null)
        {
            isCrashing = false;
        }
    }
      
    /**
     * Reagiert auf eine eingetretene Kollision.
     * @param bee Bee, der mit diesem Objekt kollidiert.
     */
    public void handleCrash(Bee bee)
    {
        Greenfoot.playSound(soundFile);
        bee.getScoreBoard().updateScore(scoreValue);
        getWorld().removeObject(this);
    }
}

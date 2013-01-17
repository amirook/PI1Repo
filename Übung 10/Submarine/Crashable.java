import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Crashable ist die Oberklasse aller sammelbaren Objekte und vererbt ihnen einen Grundstock an
 * Fähigkeiten. Im Wesentlichen kümmert sich diese Klasse darum, wie ein Objekt nach
 * einer Kollision interaggiert.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 */
public class Crashable extends Scrollable
{
    /**
     * Ton-Datei
     */
    protected String soundFile;
    
    /**
     * Wert, um den der Punktestand des Flappers erhöht werden soll.
     */
    protected int scoreValue;    
      
    /**
     * Reagiert auf eine eingetretene Kollision.
     * @param bee Bee, der mit diesem Objekt kollidiert.
     */
    public void handleCrash(Submarine submarine)
    {
        Greenfoot.playSound(soundFile);
        submarine.getScoreBoard().updateScore(scoreValue);
        getWorld().removeObject(this);
    }
}

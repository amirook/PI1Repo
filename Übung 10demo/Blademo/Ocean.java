import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Beschreiben Sie hier die Klasse Ocean.
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class Ocean extends World
{
    /**
     * Konstruktor für Objekte der Klasse Ocean.
     */
    public Ocean()
    {    
        // Erzeuge eine neue Welt mit 600x400 Zellen und einer Zellgröße von 1x1 Pixeln.
        super(1600, 1200, 1);
        
        //setzt die Koordinate der Oberfläche
        //so wie das noise Setting von erzeugten Blasen
        WorldManager.surfaceY = 460;
        WorldManager.bubbleNoise=false;
        
        CaveShade caveshade = new CaveShade(255);
        addObject(caveshade,500,500);
        
        Submarine sub = new Submarine();
        addObject(sub,424,603);
    }
}        

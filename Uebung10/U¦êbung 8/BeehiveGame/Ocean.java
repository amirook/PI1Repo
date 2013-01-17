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
        super(1600, 700, 1);
        prepare();
    }
    
    /**
     * Bereitet die Welt vor. Benötigte Actors werden instanziert und 
     * in die Welt gesetzt.
     */
    public void prepare()
    {
        this.setBackground("bg700h.png");
       
        // Setzt die Koordinate der Oberfläche
        WorldManager.surfaceY = 0;
        
        // Setzt das noise Setting von erzeugten Blasen
        WorldManager.bubbleNoise = false;

        CaveShade caveshade = new CaveShade(255);
        addObject(caveshade,500,500);
        
        // Gegner werden erzeugt underzeugt und positioniert
        Mine mine = new Mine(8);
        addObject(mine,869,543);
        
        // andere Objecte werden erzeugt underzeugt und positioniert
        Lamp lamp = new Lamp();
        addObject(lamp,348,378);
    }
}        

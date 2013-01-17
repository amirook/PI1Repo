import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die Biene soll Blumen sammeln, um Punkte zu bekommen.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class Flower extends Crashable
{
    /**
     * Konstruktor initialisiert die Anfangswerte für die Sound Datei und dem Punktewert für Flower.
     */
    public Flower()
    {
        soundFile = "back.wav";
        scoreValue = 1;
    }    
}

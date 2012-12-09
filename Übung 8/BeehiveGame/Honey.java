import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Sobald die Biene den Honig erreicht, ist das Spiel zuende.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class Honey extends Crashable
{
    /**
     * Konstruktor initialisiert die Anfangswerte für die Sound Datei und dem Punktewert für Honey.
     */
    public Honey()
    {
        soundFile = "back.wav";
        scoreValue = 10;
    }
    
    /**
     * Überscheibt die checkCollision() Methode von Crashable.
     * Der Honig ist nun das Spielziel. Bei einer Kollision mit der Biene
     * wird das Spiel beendet.
     */
    protected void checkCollision()
    {
        Bee bee = (Bee) getOneIntersectingObject(Bee.class);
        if ( bee != null ) {
            WorldManager.gameOver = true;
        }
    }
}

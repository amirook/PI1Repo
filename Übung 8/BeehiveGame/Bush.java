import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Das Gebüsch ist ein weiteres Hindernis für die Heldin. Es kann mit einer Schere entfernt werden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Bush extends Obstacle
{
    /**
     * Konstruktor von Bush. Die Sounddatei wird gesetzt, die abgespielt wird, wenn
     * Bush überwunden wird.
     */
    public Bush(){
        beatenSound = "Song.wav";
    }
    
    /**
     * Prüft ob das sich im Inventar befindende Objekt eine Instanz von Scissor ist. Falls ja, wird das Gebüsch von der Schere
     * geschlagen und die Heldin kann passieren.
     * 
     * @param collectable Das zu prüfende Objekt.
     * @return true, wenn Bush überwunden ist.
     */
    public boolean isBeaten(Actor collectable)
    {
        if ( collectable instanceof Scissor )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}

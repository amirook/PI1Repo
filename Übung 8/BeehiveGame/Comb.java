import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die Wabe ist ein weiteres Hindernis für die Heldin. Es kann mit einer Schere entfernt werden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Comb extends Obstacle
{
    /**
     * Konstruktor von Comb. Die Sounddatei wird gesetzt, die abgespielt wird, wenn
     * Comb überwunden wird.
     */
    public Comb(){
        beatenSound = "Something.wav";
    }
    
    /**
     * Prüft ob das sich im Inventar befindende Objekt eine Instanz von Schere ist. Falls ja, wird die Wabe von der 
     * Schere
     * geschlagen und die Heldin kann passieren.
     * 
     * @param collectable Das zu prüfende Objekt.
     * @return true, wenn Comb überwunden ist.
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

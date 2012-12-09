import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ein Stein. Ein Hindernis für die Heldin, das sich mit einem Hammer entfernen lässt.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Stone extends Obstacle
{
    /**
     * Konstruktor von Stone. Die Sounddatei wird gesetzt, die abgespielt wird, wenn
     * Stone überwunden wird.
     */
    public Stone(){
        beatenSound = "explosion.wav";
    }
    
    /**
     * Prüft ob das sich im Inventar befindende Objekt eine Instanz von Hammer ist. 
     * Falls ja, wird die Wand vom Hammer geschlagen und die HeldIn kann passieren.
     * 
     * @param collectable Das zu prüfende Objekt
     * @return true, wenn Stone überwunden ist.
     */
    public boolean isBeaten(Actor collectable)
    {
        if ( collectable instanceof Hammer )
        {
            return true;
        }
        else
        {
            return false;
        }
    }  
}

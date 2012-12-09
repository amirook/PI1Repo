import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Oberklasse für alle Hindernisse. Diese Klasse vereint alle Hindernisse,
 * so dass man leichter auf ein Hindernis prüfen kann.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Obstacle extends Actor
{   
    /**
     * Sound Datei, die Abgespielt wird, wenn dieses Hindernisse überwunden wurde.
     */
    public String beatenSound;
    
    /**
     * Diese Methode muss von den Unterklassen überschrieben werden, da sie jeweils aufgerufen wird, ohne zu wissen zu 
     * welcher der Unterklassen das jeweilige Objekt gehört. Liefert standardmäßig false zurück, da alle abgeleiteten
     * Objekte Hindernisse darstellen sollen.
     * 
     * @param collectable Das zu prüfende Objekt.
     * @return Liefert immer false.
     */
    public boolean isBeaten(Actor collectable)
    {
        return false;
    }
}

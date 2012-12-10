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
     * Definiert durch Objekte welcher Klasse das Hindernis überwunden werden kann
     */
    protected Class isBeatenBy;
    
    /**
     * Konstruktor von Obstacle wird von der Subklasse aufgerufen.
     * @param isBeatenBy Die Klasse des Objekts, welches das Hindernis überwinden kann.
     */
    public Obstacle(Class isBeatenBy){
        this.isBeatenBy = isBeatenBy;
    }
    
    /**
     * Prüft ob das sich im Inventar befindende Objekt eine Instanz von isBeatenBy ist. Falls ja, wird das Hindernis von dem Objekt
     * im Inventar geschlagen und die Heldin kann passieren.
     * 
     * @param collectable Das zu prüfende Objekt.
     * @return true, wenn Hindernis überwunden ist.
     */
    public boolean isBeaten(Actor collectable)
    {
        return collectable.getClass() == isBeatenBy ;
    }
}

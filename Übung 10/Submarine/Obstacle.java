import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Oberklasse für alle Hindernisse. Diese Klasse vereint alle Hindernisse,
 * so dass man leichter auf ein Hindernis prüfen kann.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Leopold Schulz-Hanke (Leo) 
 * @version 2.0.0
 * 
 */
public class Obstacle extends Crashable
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

    /**
     * Crash Handler der Hindernisse. Wird von Bee aufgerufen, wenn eine Kollision auftritt.
     * @param bee Die Biene übergibt sich selbst
     */
    public void handleCrash(Submarine submarine){
        if (submarine.myInventory.Contains(isBeatenBy) )
        {
            getWorld().removeObject(this);
            int beatenslot =submarine.myInventory.findSlot(isBeatenBy);
            submarine.myInventory.clearSlot(beatenslot);
            Greenfoot.playSound(beatenSound);
        }
        else
        {
            // Kollision mit Hindernis und kein passendes Inventarobjekt oder leeres Inventar
            submarine.pose.resetPose();
        }
    }
}

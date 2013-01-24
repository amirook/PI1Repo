import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Collectable vereinigt alle Elemente, die die HeldIn in ihr Inventar aufnehmen kann.
 * Sie bestehen jewqeils lediglich aus ihren Klassendefinitionen und den zugehörigen
 * Images, die vom Inventar zur Darstellung genutzt werden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 */
public class Collectable extends Collider
{
    
    
    /**
     * passives oder aktives Item
     * ("usable" Items besitzt munition und können aufgebraucht oder abgefeuert werden)
     */
    public boolean usable = false;
    
    /**
     * setzt ob das Item "abgefeuert wurde"
     * Es dient dazu dass z.B benutzte Geschosse nicht mehr aufgenommen werden können
     * "fired" wird bei Gebrauch durch das jeweilige item gesetzt
     */
    public boolean fired = false;
    
    /**
     * Anzahl der Items die hiermit aufgenommen werden(item wird aus dem Inventar entfernt
     * sollte der stack0 oder weniger betragen
     */
    public int stack = 0;
    
    /**
     * verwender des Items
     */
    public Actor user = null;
    
}
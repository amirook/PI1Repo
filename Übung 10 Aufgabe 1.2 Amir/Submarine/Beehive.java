import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Eine Welt im Inneren eines Bienenstocks. 
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class Beehive extends ServerWorld
{
    /**
     * Konstruktor für Objekte der Klasse Beehive.
     */
    public Beehive()
    {    
        // Erzeuge eine neue Welt mit 600x400 Zellen und einer Zellgröße von 1x1 Pixeln.
        super(1000, 700, 1);
        
        /**
         * [Bildquelle: http://endtimesnourishment.wordpress.com/2011/10/26/the-beehive-of-creation/ 
         * (Stand: 18.11.2012)]
         */
        this.setBackground("beehive.jpg");
        Honey honey = new Honey();
        this.addObject(honey, 500, 50);
    }
}

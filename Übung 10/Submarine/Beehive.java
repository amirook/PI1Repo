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
        
        /**
         * [Bildquelle: http://endtimesnourishment.wordpress.com/2011/10/26/the-beehive-of-creation/ 
         * (Stand: 18.11.2012)]
         */
        this.setBackground("beehive.jpg");
        Honey honey = new Honey();
        this.addObject(honey, 500, 50);
    }
}

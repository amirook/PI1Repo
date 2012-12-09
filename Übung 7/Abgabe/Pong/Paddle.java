import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die Klasse implementiert das linke Paddle und kümmert sich um das Zerquetschen
 * und Neuerzeugen des Balls. Bevor sie benutzt wird, müssen das zweite Paddle
 * und der Tastatur-Manager gesetzt werden.
 * 
 * @author Werner Wirrwarr
 * @version 28.11.2012
 */
public class Paddle extends Actor
{
    /**
    * Steuerung des Paddles für die Aufwärtsbewegung
    */
    String up;
    
    /**
    * Steuerung des Paddles für die Abwärtsbewegung
    */
    String down;
    

    /**
     * Der Konstruktor dreht das Paddle nach oben
     * setzt das Bild des Paddels ein.
     * @param image: Das Bild des Paddles. up: Taste für die Aufwärtsbewegung. down: Taste für die Abwärtsbewegung.
     */
    public Paddle(String image,String up,String down)
    {
        setRotation(-90);
        setImage(image);
        this.up  =up;
        this.down=down;
    }

    /**
     * Diese Methode wird aufgerufen, wenn die 'Act'- oder 'Run'-Knöpfe
     * in der Umgebung gedrückt werden. Sie nutzt den Tastaturmanager,
     * um das Paddle zu bewegen.
     */
    public void act() 
    {
        paddleControl();
    }
    
    /**
     * Je nach Tastendruck werden die Paddles hoch oder runter bewegt
     */
    public void paddleControl() 
    {
        if(Greenfoot.isKeyDown(this.up)) {
            setRotation(-90);
            move(1);
            
            
        } else if ( Greenfoot.isKeyDown(this.down)) {
            setRotation(90);
            move(1);
        }
    }
}
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die Klasse implementiert das linke Paddle und kümmert sich um das Zerquetschen
 * und Neuerzeugen des Balls. Bevor sie benutzt wird, müssen das zweite Paddle
 * und der Tastatur-Manager gesetzt werden.
 * 
 * @author Werner Wirrwarr
 * @version 28.11.2012
 */
public class LeftPaddle extends Actor
{
    /** Das zweite Paddle. */
    private RightPaddle r;

    /** Der Manager für die Tastatursteuerung. */
    private Ball b;

    /**
     * Der Konstruktor dreht das Paddle nach oben.
     */
    public LeftPaddle()
    {
        setRotation(-90);
    }

    /**
     * Setzt das zweite Paddle. Wird benötigt, um den Tastaturmanager
     * automatisch richtig zu setzen.
     * @param r Das andere Paddle.
     */
    public void setOtherPaddle(RightPaddle r)
    {
        this.r = r;
    }
    
    /** 
     * Setzt den den Manager für die Tastatursteuerung.
     * @param b Das Objekt, das ab jetzt die Tastatursteuerung
     *          für dieses und das andere Paddle übernimmt.
     */
    public void setKeyboardManager(Ball b)
    {
        this.b = b;
        r.setKeyboardManager(b);
    }
    
    /**
     * Diese Methode wird aufgerufen, wenn die 'Act'- oder 'Run'-Knöpfe
     * in der Umgebung gedrückt werden. Sie nutzt den Tastaturmanager,
     * um das Paddle zu bewegen.
     */
    public void act() 
    {
        b.handleLeftPaddle(this);
    }

    /**
     * Zerquetsche den Ball und erzeuge einen neuen.
     * Der neue Ball wird zum Tastaturmanager für beide Paddles.
     * @param b Der Ball, der zerquetscht werden soll.
     */
    public void doIt(Ball b)
    {
        // Alten Ball zerquetschen
        int w = b.getImage().getWidth();
        int h = b.getImage().getHeight();
        b.getImage().scale(w / 2, h * 2);
        b.setCrushed(true);
        Greenfoot.playSound("squish.wav");

        // Neuen Ball erzeugen. Er bewegt sich in dieselbe Richtung wie der alte.
        Ball b2 = new Ball();
        b2.setXSpeed(-b.getXSpeed());

        // Zufälliges Bild auswählen 
        String[] s = {
            "apple1.png",
            "apple2.png",
            "bananas.png",
            "bread.png",
            "cherries.png",
            "chips-1.png",
            "chips-2.png",
            "flan.png",
            "grapes.png",
            "hamburger.png",
            "lemon.png",
            "muffin.png",
            "orange.png",
            "pear.png",
            "pizza_cheese.png",
            "plum.png",
            "pumpkin.png",
            "stawberry.png",
            "strawberry2.png"
        };
        b2.setImage(s[Greenfoot.getRandomNumber(s.length)]);
        
        // Dieses Objekt ist immer noch der Crush-Manager
        b2.setCrushManager(this);
        
        // Neuen Ball zur Welt hinzufügen
        getWorld().addObject(b2, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        
        // Als Tastatur-Manager setzen
        setKeyboardManager(b2);
    }        
}
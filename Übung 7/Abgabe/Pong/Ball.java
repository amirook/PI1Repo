import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

public class Ball extends Actor
{
    /** Die Geschwindigkeit in x-Richtung. */ 
    private int xSpeed = 1;

    /** Die Geschwindigkeit in y-Richtung. */ 
    private int ySpeed = 1;

    /** Kollidiert der Ball gerade? */
    private boolean colliding = false; 

    /** Wurde der Ball zerquetscht? */
    private boolean crushed = false;

    /**
     * Konstruktor von Ball. Das Bild des Balles wird zufällig aus dem
     * Array der verfügbaren Bilder gewählt.
     */
    public Ball()
    {
        // Der Ball bekommt ein zufälliges Bild
        String[] images =
            {
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
        setImage(images[Greenfoot.getRandomNumber(images.length)]);

    }

    /**
     * Setze die Geschwindigkeit in y-Richtung.
     * @param xSpeed Die neue Geschwindigkeit in x-Richtung.
     */
    public void setXSpeed(int xSpeed)
    {
        this.xSpeed = xSpeed;

    }

    /**
     * Liefert die Geschwindigkeit in x-Richtung.?
     */
    public int getXSpeed()//warum rückgabe?
    {
        return xSpeed;
    }

    /**
     * Setzt, ob der Ball zerquetscht wurde. Ein zerquetschter Ball
     * bewegt sich nicht mehr.
     * @param crushed Wurde er zerquetscht?
     */
    private void setCrushed(boolean crushed)
    {
        this.crushed = crushed;
    }

    /**
     * Diese Methode wird aufgerufen, wenn die 'Act'- oder 'Run'-Knöpfe
     * in der Umgebung gedrückt werden. Sie implementiert die Bewegung
     * des Balls. Kollidiert er mit einem Paddle oder mit dem oberen oder
     * unteren Spielfeldrand, prallt er in die gespiegelte Richtung ab.
     * Erreicht er den linken oder rechten Spielfeldrand, wird er zerquetscht.
     * Danach bewegt er sich nicht mehr.
     */
    public void act() 
    {
        if (!crushed) {
            boolean collided = colliding;
            colliding = getOneIntersectingObject(Paddle.class ) != null;

            if (colliding&&!collided) {
                xSpeed = -xSpeed;
                Greenfoot.playSound("tock.wav");
            }
            testForBorder();
            setLocation(getX() + xSpeed, getY() + ySpeed);
        }
    }

    /**
     * Zerquetsche den Ball und erzeuge einen neuen.
     * Der neue Ball wird zum Tastaturmanager für beide Paddles.
     * @param b Der Ball, der zerquetscht werden soll.
     */
    private void doIt()
    {
        // Alten Ball zerquetschen
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        getImage().scale(w / 2, h * 2);
        setCrushed(true);
        Greenfoot.playSound("squish.wav");

        // Neuen Ball erzeugen. Er bewegt sich in dieselbe Richtung wie der alte.
        Ball b2 = new Ball();
        b2.setXSpeed(getXSpeed());

        // Neuen Ball zur Welt hinzufügen
        getWorld().addObject(b2, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    }   

    /**
     * Prüft ob der Ball die Bildgrenze Berührt und zerquetscht den Ball falls dem so ist.
     */
    private void testForBorder(){
        int width = getImage().getWidth();  //Ballbreite
        int height = getImage().getHeight();    //Ballhöhe
        // stellt fest ob die Darstellungen des Balls die Bildgrenze berührt
        if (getX() <= width / 2 ||  
        getX() >= getWorld().getWidth() - width / 2) {
            doIt();
        } else if (getY() <= height / 2 ||
        getY() == getWorld().getHeight() - height / 2) {
            ySpeed = -ySpeed;
        }
    }
}
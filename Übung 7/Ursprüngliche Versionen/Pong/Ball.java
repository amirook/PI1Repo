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
    
    /** Der Crush-Manager. */
    private LeftPaddle crushManager;

    /**
     * Setze die Geschwindigkeit in y-Richtung.
     * @param xSpeed Die neue Geschwindigkeit in x-Richtung.
     */
    public void setXSpeed(int xSpeed)
    {
        this.xSpeed = xSpeed;

    }
    
    /**
     * Liefert die Geschwindigkeit in x-Richtung.
     */
    public int getXSpeed()
    {
        return xSpeed;
    }
    
    /**
     * Setzt, ob der Ball zerquetscht wurde. Ein zerquetschter Ball
     * bewegt sich nicht mehr.
     * @param crushed Wurde er zerquetscht?
     */
    public void setCrushed(boolean crushed)
    {
        this.crushed = crushed;
    }

    /**
     * Setzt den Manager, der das Zerquetschen von Bällen übernimmt.
     * @param crushManager Der neue Crush-Manager.
     */
    public void setCrushManager(LeftPaddle crushManager)
    {

        this.crushManager = crushManager;
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
            colliding = getOneIntersectingObject( LeftPaddle.class ) != null || 
                        getOneIntersectingObject (RightPaddle.class) != null;

            if (colliding&&!collided) {
                xSpeed = -xSpeed;
                Greenfoot.playSound("tock.wav");
            }

            
            
            int width = getImage().getWidth();
            int height = getImage().getHeight();

            if (getX() <= width / 2 ||
                    getX() >= getWorld().getWidth() - width / 2) {
                crushManager.doIt(this);
            } else if (getY() <= height / 2 ||
            getY() == getWorld().getHeight() - height / 2) {
                ySpeed = -ySpeed;
            }

            setLocation(getX() + xSpeed, getY() + ySpeed);
        }
    }
    
    /**
     * Tastatursteuerung für das linke Paddle.
     * Ein Druck auf die linke Pfeiltaste bewegt es nach oben, einer auf die 
     * rechte nach unten.
     * @param paddle Das Paddle, das gesteuert wird.
     */
    void handleLeftPaddle(LeftPaddle paddle)
    {
        if ( Greenfoot.isKeyDown("q") ) {
            paddle.setRotation(-90);
            paddle.move(1);
        } else if(Greenfoot.isKeyDown("a") ) {
            paddle.setRotation(90);
            paddle.move(1);
        }
    }

    /**
     * Tastatursteuerung für das rechte Paddle.
     * Ein Druck auf die obere Pfeiltaste bewegt es nach oben, einer auf die 
     * untere nach unten.
     * @param paddle Das Paddle, das gesteuert wird.
     */
    void handleRightPaddle(RightPaddle paddle)
    {
        if(Greenfoot.isKeyDown("up")) {
            paddle.setRotation(-90);
            paddle.move(1);
            
            
        } else if ( Greenfoot.isKeyDown("down")) {
            paddle.setRotation(90);
            paddle.move(1);
        }
    }
}
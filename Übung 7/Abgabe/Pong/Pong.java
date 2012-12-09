import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Das Spiel Pong.
 * 
 * @author Werner Wirrwar 
 * @version 28.11.2012
 */
public class Pong extends World {
    /**
     * Der Konstruktor erzeugt alle Spielobjekte.
     */
    public Pong() {    
        // Erzeuge eine neue Welt mit 200x200 Zellen und einer Zellgröße von 10x10 Pixeln.
        super(600, 400, 1);
        
        // Erzeuge die Spielobjekte
        // und setzt deren Bilder
        Paddle leftPaddle = new Paddle("turtle2.png");
        Paddle rightPaddle = new Paddle("lobster.png");
       Ball ball = new Ball();
       
        // Die Paddle Steuerung setzen (@param oben,unten)
        leftPaddle.setKeyboardControl("w","s");
        rightPaddle.setKeyboardControl("up","down");

          // Objekte hinzufügen und dafür sorgen, dass Bälle immer vor
          // allen anderen Objekten zu sehen sind
        addObject(leftPaddle, 50, getHeight() / 2);
        addObject(rightPaddle, getWidth() - 50, getHeight() / 2);
        addObject(ball, getWidth() / 2, getHeight() / 2);
        setPaintOrder(Paddle.class, Ball.class);
    }
}
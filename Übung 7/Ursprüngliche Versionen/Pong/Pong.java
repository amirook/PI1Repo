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
        LeftPaddle leftPaddle = new LeftPaddle();
        RightPaddle rightPaddle = new RightPaddle();
       Ball ball = new Ball();
        
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
        ball.setImage(images[Greenfoot.getRandomNumber(images.length)]);
        
        // Die Manager setzen
         ball.setCrushManager(leftPaddle);
        leftPaddle.setOtherPaddle(rightPaddle);
        leftPaddle.setKeyboardManager(ball);

          // Objekte hinzufügen und dafür sorgen, dass Bälle immer vor
          // allen anderen Objekten zu sehen sind
        addObject(leftPaddle, 50, getHeight() / 2);
        addObject(rightPaddle, getWidth() - 50, getHeight() / 2);
        addObject(ball, getWidth() / 2, getHeight() / 2);
        setPaintOrder(LeftPaddle.class, RightPaddle.class, Ball.class);
    }
}
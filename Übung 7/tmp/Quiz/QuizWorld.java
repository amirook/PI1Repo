import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

public class QuizWorld extends World
{
    /**
     * Konstruktor für Objekte der Klasse QuizWorld.
     */
    public QuizWorld()
    {    
        // Erzeuge eine neue Welt mit 600x400 Zellen und einer Zellgröße von 1x1 Pixeln.
        super(400, 400, 1);
        Quiz quiz = new Quiz();
        quiz.setImage(new GreenfootImage(" ? ", 400, null, null));
        addObject(quiz, getWidth() / 2, getHeight() / 2);
    }
}

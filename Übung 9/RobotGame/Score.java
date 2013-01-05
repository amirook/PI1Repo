import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.awt.*;

/**
 * Objekte dieser Klasse speichern einen Punktestand und zeigen ihn an. 
 * Andere Objekte können den aktuellen Punktestand abfragen und ihn verändern. (Übungsblatt 5)
 * 
 * @author Thomas Röfer 
 * @version 09.11.2012
 */
public class Score extends Actor
{
    /** Der Punktestand. */
    private int score;
    
    /**
     * Der Konstruktor setzt den Punktestand auf 0.
     */
    public Score()
    {
        setScore(0);
    }
    
    /**
     * Setzen des Punktestandes.
     * Speichert den übergebenen Wert und aktualisiert das Bild, das den
     * Punktestand darstellt. Der Punktestand wird immer fünfstellig angezeigt.
     * @param score Der neue Punktestand.
     */
    public void setScore(int score)
    {
        this.score = score;
        
        setImage("score.png");
        getImage().setColor(Color.WHITE);
        getImage().setFont(new Font("Monospaced", Font.PLAIN, 20));
        getImage().drawString(String.format("%05d", score % 100000), 1, 14);
    }
    
    /**
     * Liefert den aktuellen Punktestand zurück.
     */
    public int getScore()
    {
        return score;
    }
}

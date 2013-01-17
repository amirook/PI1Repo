import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.awt.*;
import java.io.*;
/**
 * Die Klasse ScoreBoard ist unserer Punkteanzeige. Sie zeigt den aktuellen
 * Punktestand in einer Grafik an.
 * 
 * @author Mohamadreza Khostevan (Amir)
 * @version 1.0
 */
public class ScoreBoard extends ServerActor
{
    /**
     * Zähler des Punktestands
     */
    private int score;
    
    /**
     * Der Konstruktor von ScoreBoard setzt das Hintergrundbild, die Schrifteigenschaften
     * der Anzeige und setzt den Anfangswert auf "00"
     */
    public ScoreBoard()
    {
        resetImage();
        score = 0;
        getImage().drawString("00", 13, 42);
    }
    
    
    /**
     * getter Methode um den aktuellen Punktestand zu erhalten. public, damit sie auch aus der Greenfoot Umgebung zu erreichen ist.
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Aktualisiert den Punktestand und die Anzeige. Bei Zahlen < 10 wird eine 0 vorangestellt.
     * 
     * @param scoreValue Wert, um den das ScoreBoard erhöht werden soll
     */
    public void updateScore(int scoreValue)
    {
        score += scoreValue;
        resetImage();
        String preZero = "";
        // Wenn der Punktestand kleiner als 10 ist, wird eine 0 vorangestellt
        if (score < 10){
            preZero = "0";
        }
        getImage().drawString(preZero + new Integer(score).toString() , 13, 42);
    }
    
    /**
     * Leert die Punkteanzeige indem das Hindergrundbild und die Schrifteigenschaften
     * neu gesetzt werden.
     */
    private void resetImage()
    {
        this.setImage("scoreBoard.png");
        // Eigene Font DS-DIGIT.TTF laden und nutzen
        Font font = null;
        try{
            font = Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("DS-DIGIT.TTF") );
            font = font.deriveFont(52f);
        }
        // Fehlerbehandlung: Falls DS-DIGIT nicht korrekt geladen werden kann, wird courier genutzt
        catch(java.awt.FontFormatException ffe){
            System.out.println(ffe + "Using courier instead.");
            font = new Font("courier", Font.PLAIN , 52);
        }
        catch(IOException ioe){
            System.out.println(ioe + "Using courier instead");
            font = new Font("courier", Font.PLAIN , 52);
        }
        getImage().setFont(font);
    }
}

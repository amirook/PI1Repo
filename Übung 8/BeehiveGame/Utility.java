import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;

/**
 * Hilfsklasse für Funktionen, die mehrfach verwendet werden.
 * 
 * @author Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.1
 */
public class Utility
{
    /**
     * Offset, um den ein Objekt außerhalb der Flapperreichweite positioniert werden soll.
     */
    private int positionOffset = 20;
    
    /**
     * Setzt ein Objekt auf eine Position außerhalb der Reichweite des Flappers.  
     * @param flapPosX Position des Flappers auf der X-Achse
     * @param flapPosY Position des Flappers auf der Y-Achse
     * @param flapWidth Breite des Flappers
     * @param flapHeight Höhe des Flappers
     * @param world Referenz auf die aktuelle Welt
     * @param actor Referenz auf den Actor, der neu possitioniert werden soll
     */
    public void setNewPosition(int flapPosX, int flapPosY, int flapWidth, int flapHeight, World world, Actor actor){
        int tmpNewXPos = getNiceXPosition(flapPosX, flapWidth, world);
        int tmpNewYPos = getNiceYPosition(flapPosY, flapHeight, world);
        // erstelle Liste aller Objekte auf der neuen Position
        List objectsOnPosition = world.getObjectsAt(tmpNewXPos, tmpNewYPos, null);
        if(!(objectsOnPosition.size() == 0)){
            // auf der neuen Position befindet sich schon ein Objekt, rufe Funktion rekursiv auf
            setNewPosition(flapPosX, flapPosY, flapWidth, flapHeight, world, actor);
        } else {
            // neue Position ist perfekt,lLege Objekt an dieser Stelle ab
            actor.setLocation(tmpNewXPos, tmpNewYPos);
        }
    }
    
    /**
     * Gibt eine Position auf der X-Achse zurück, die außerhalb des Flappers zzgl. dem definierten Offset liegt. 
     * Der rechte Rand wird nicht verwendet um Platz für das Inventar zu haben.
     * @param flapPosX Position des Flappers auf der X-Achse
     * @param flapWidth Breite des Flappers
     * @param world Referenz auf die aktuelle Welt
     * @return die neue x-Position
     */
    public int getNiceXPosition(int flapPosX, int flapWidth, World world){
        int newPositionX;
        // Positionsvariable muss initial mit realistischen Positionsvariablen vorbelegt werden um Schleifendurchläufe zu ermöglichen
        newPositionX = Greenfoot.getRandomNumber(world.getWidth()-65);
        // Prüfe, ob mögliche neue Position auf der X-Achse innerhalb des Flappers zzgl. dem Offset liegt
        while(newPositionX > (flapPosX - positionOffset) && newPositionX < (flapPosX + flapWidth + positionOffset)){
            // neue Postion auf X-Achse ist nicht akzeptabel, daher wird so lange eine neue Position bestimmt, bis diese akzeptabel ist
            newPositionX = Greenfoot.getRandomNumber(world.getWidth()-65);
        }
        return(newPositionX);
    }
    
    /**
     * Gibt eine Position auf der Y-Achse zurück, die außerhalb des Flappers zzgl. dem definierten Offset liegt.
     * Der rechte Rand wird nicht verwendet um Platz für das Inventar zu haben.
     * @param flapPosY Position des Flappers auf der Y-Achse
     * @param flapHeight Höhe des Flappers
     * @param world Referenz auf die aktuelle Welt
     * @return die neue y-Position
     */
     public int getNiceYPosition(int flapPosY, int flapHeight, World world){
        int newPositionY;
        // Positionsvariable muss initial mit realistischen Positionsvariablen vorbelegt werden um Schleifendurchläufe zu ermöglichen
        newPositionY = Greenfoot.getRandomNumber(world.getHeight()-65);
        // Prüfe, ob mögliche neue Position auf der Y-Achse innerhalb der Fliegenklasche zzgl. dem Offset liegt
        while(newPositionY > (flapPosY - positionOffset) && newPositionY < (flapPosY + flapHeight + positionOffset)){
            // neue Postion auf Y-Achse ist nicht akzeptabel, daher wird so lange eine neue Position bestimmt, bis diese akzeptabel ist
            newPositionY = Greenfoot.getRandomNumber(world.getHeight()-65);
        }
        return(newPositionY);
    }
}

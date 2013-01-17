import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * Das U-Boot lässt sich mittels Kursortasten der Tastatur vor/zurück und 
 * links/rechts steuern.
 * Es verwaltet seinen eigenen Punktestand und bekommt dafür von dem getroffenen
 * Objekt eine Information darüber, wieviele Punkte der Zusammenstoß wert war und aktualisiert
 * seinen Punktestand. Aktuell haben alle getroffenen Objekte den Punktewert 1.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Submarine extends Collider
{    
    /**
     * Instanz der Klasse Pose, in der die Position des U-Bootes hinterlegt wird
     */
    public Pose pose;

    /**
     * Inventar des U-Bootes
     */
    public Inventory myInventory;

    /**
     * Das ScoreBoard des U-Bootes
     */
    private ScoreBoard scoreBoard;

    /**
     * RingBuffer für die X Position
     */
    private RingBuffer bufferX;

    /**
     * RingBuffer für die Y Position
     */
    private RingBuffer bufferY;

    /**
     * RingBuffer für die Rotation
     */
    private RingBuffer bufferRot;

    /**
     * Konstruktor des U-Bootes. Kreiirt jeweils einen RingBuffer für die X und Y Positionen und 
     * für die Roation.
     */
    public Submarine()
    {
        bufferX = new RingBuffer(150);
        bufferY = new RingBuffer(150);
        bufferRot = new RingBuffer(150);
    }

    /**
     * Ordnet dem U-Boot einen Punktezähler zu
     * @param scoreBoard Punktezähler, der dem U-Boot zugeordnet werden soll.
     */
    public void setScoreBoard(ScoreBoard scoreBoard)
    {
        this.scoreBoard = scoreBoard;
    }

    /**
     * Liefert den Punktezähler des U-Bootes zurück
     * @return Das ScoreBoard des U-Bootes.
     */
    public ScoreBoard getScoreBoard()
    {
        return scoreBoard;
    }

    /**
     * Ordnet dem U-Boot ein Inventar zu
     * @param inventory Inventar, das dem U-Boot zugeordnet werden soll.
     */
    public void setInventory(Inventory inventory)
    {
        myInventory = inventory;
    }

    /**
     * Liefert das Inventar des U-Bootes zurück
     * 
     * @return Das Inventar des U-Bootes.
     */
    public Inventory getInventory(){
        return myInventory;
    }

    /**
     * Diese Methode wird aufgerufen, wenn die 'Act'- oder 'Run'-Knöpfe in der Umgebung gedrückt werden.
     * Das U-Boot muss nichts weiter tun, als zu prüfen welche Tasten gedrückt sind und sich dementsprechend verhalten.
     */
    public void act() 
    {
        // Falls das Spielende erreicht ist, wird eine Wiederholung abgespielt
        if(WorldManager.gameOver) {
            if (bufferX.size() != 0 && bufferY.size() != 0 && bufferRot.size() != 0){
                this.setRotation(bufferRot.pop());
                this.setLocation(bufferX.pop(), bufferY.pop());
            } else {
                Greenfoot.stop();
            }
        } else {
            processKeys();
        }
    }    

    /**
     * Prüft, ob Tasten gedrückt werden und reagiert entsprechend.
     */
    private void processKeys()
    {
        // Aktuelle Position merken
        pose = new Pose(this);
        
        // Cursor-Tasten abfragen
        if(Greenfoot.isKeyDown("up")) {
            bufferSubmarine();
            move(3);
        }
        if(Greenfoot.isKeyDown("down")) {
            bufferSubmarine();
            move(-3);
        }
        if(Greenfoot.isKeyDown("left")) {
            bufferSubmarine();
            turn(-5);
        }
        if(Greenfoot.isKeyDown("right")) {
            bufferSubmarine();
            turn(5);
        }
        // getKey() verhindert Timing-Probleme von isKeyDown() in dem Fall, dass mehrere Objekte im Inventar gespeichert sind. (Für spätere Versionen.)
        if (Greenfoot.getKey() == "space") {
            takeOrFreeCollectable();
        }
        
        
        // auf Hindernis prüfen
        checkCollisions();

    }
    
    /**
     * Trägt den aktuellen Zustand des U-Bootes in den RingBuffer ein.
     */
    private void bufferSubmarine()
    {
        bufferX.push(this.getX());
        bufferY.push(this.getY());
        bufferRot.push(this.getRotation());
    }

    /**
     * Prüft, ob das U-Boot mit einem Hindernis kollidiert. Falls eine Kollision existiert, wird
     * der Crash Handler des Objekts aufgerufen.
     */
    private void checkCollisions()
    {
        if (newCollisionWith(Crashable.class))  {
            Crashable crashable = (Crashable) getCollidingObject(Crashable.class);
            crashable.handleCrash(this);
        }
    }

    /**
     * Wenn ein Collectable in der Nähe und das Inventar leer ist, wird das Collectable eingesammelt.
     * Beindet sich ein Actor im Inventar, wird dieser an der aktuellen Position des U-Bootes in die
     * Welt gesetzt. Andernfalls wird der Fehlerton abgespielt.
     */
    private void takeOrFreeCollectable()
    {
        if (newCollisionWith(Collectable.class) && myInventory.isEmpty() ){
            Collectable collectable = (Collectable) getCollidingObject(Collectable.class);
            myInventory.pushToInventory(collectable);
        } else if (!myInventory.isEmpty()){
            myInventory.removeFromInventory(this.getX(), this.getY());
        } else {
            Greenfoot.playSound("out.wav");
        }
    }
    
}

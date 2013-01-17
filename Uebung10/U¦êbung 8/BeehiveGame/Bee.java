import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * Die Bine repräsentiert eine übliche Honigbiene der Realwelt. Die Biene
 * läst sich mittels der Kursortasten der Tastatur vor/zurück und 
 * links/rechts steuern.
 * Da jeder gute Biene ihre eigenen Punktestand verwaltet, bekommt sie von dem getroffenen
 * Objekt eine Information, wieviel Punkte der Zusammenstoß wert war und aktualisiert
 * seinen Punktestand. Aktuell haben alle getroffenen Objekte den Punktewert 1.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Bee extends Collider
{    
    /**
     * Instanz der Klasse Pose, in der die Position der Biene hinterlegt wird
     */
    public Pose pose;

    /**
     * Inventar der Biene
     */
    public Inventory myInventory;

    /**
     * Das ScoreBoard der Biene
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
     * Konstruktor der Biene. Sie kreiirt jeweils einen RingBuffer für die X und Y Positionen und 
     * für die Roation.
     */
    public Bee()
    {
        bufferX = new RingBuffer(150);
        bufferY = new RingBuffer(150);
        bufferRot = new RingBuffer(150);
    }

    /**
     * Ordnet der Biene einen Punktezähler zu
     * @param scoreBoard Punktezähler, das der Biene zugeordnet werden soll.
     */
    public void setScoreBoard(ScoreBoard scoreBoard)
    {
        this.scoreBoard = scoreBoard;
    }

    /**
     * Liefert den Punktezähler der Biene zurück
     * @return Das ScoreBoard der Biene.
     */
    public ScoreBoard getScoreBoard()
    {
        return scoreBoard;
    }

    /**
     * Ordnet der Biene ein Inventar zu
     * @param inventory Inventar, das der Biene zugeordnet werden soll.
     */
    public void setInventory(Inventory inventory)
    {
        myInventory = inventory;
    }

    /**
     * Liefert das Inventar der Biene zurück
     * 
     * @return Das Inventar der Biene.
     */
    public Inventory getInventory(){
        return myInventory;
    }

    /**
     * Diese Methode wird aufgerufen, wenn die 'Act'- oder 'Run'-Knöpfe in der Umgebung gedrückt werden.
     * Die Biene muss nichts weiteres tun, als zu prüfen welche Tasten gedrückt sind und sich dementsprechend zu verhalten.
     * sollte sich diese klasse über der Oberfläche befinden wird stattdessen eine drehung zurück ins Wasser volzogen
     */
    public void act() 
    {
        setImageDependingOnRotation();
        // Falls das Spielende erreicht ist, wird eine Wiederholung abgespielt
        if(WorldManager.gameOver) {
            if (bufferX.size() != 0 && bufferY.size() != 0 && bufferRot.size() != 0){
                this.setRotation(bufferRot.pop());
                this.setLocation(bufferX.pop(), bufferY.pop());
            } else {
                Greenfoot.stop();
            }
        } 
        else {
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
        
        //reaktionauf die Wasseroberfläche (wirkt blockierend auf die Steuerung)
        if(WorldManager.overTheTop(this,10)){
            WorldManager.reactToSurface(this);
        }
    
        else{
            // Cursor-Tasten abfragen
            if(Greenfoot.isKeyDown("w")) {//up
                bufferBee();
                randomlyBlowBubbles();
                move(3);
            }
            if(Greenfoot.isKeyDown("s")) {//down
                bufferBee();
                move(-2);
            }
            if(Greenfoot.isKeyDown("a")) {//left
                bufferBee();
                turn(-2);
            }
            if(Greenfoot.isKeyDown("d")) {//right
                bufferBee();
                turn(2);
            }
        }
        // getKey() verhindert Timing-Probleme von isKeyDown() in dem Fall, dass mehrere Objekte im Inventar gespeichert sind. (Für spätere Versionen.)
        if (Greenfoot.getKey() == "space") {
            takeOrFreeCollectable();
        }
        // auf Hindernis prüfen
        checkCollisions();
    }
    
    /**
     * erfasst den momentanen winkel dieses Aktors und setzt dazu das passende Bild
     */
    public void setImageDependingOnRotation()
    {
        int arc = this.getRotation();
        if (arc >90&& arc <270){
            this.setImage("sub2.png");
        }
        else{
            this.setImage("sub.png");
        }
    }
    
    /**
    * Das Uboot erzeugt in Zufallsintervallen Luftblasen
    */
    public void randomlyBlowBubbles()
    {
        if(Greenfoot.getRandomNumber(80)==1){
            //new bubble with lifespan 40 and a scale between(5-40)pixels
            Bubble bubble = new Bubble(100,Greenfoot.getRandomNumber(35)+5);
            getWorld().addObject(bubble,this.getX(),this.getY());
        }
    }
    
    /**
     * Trägt den aktuellen Zustand der Biene in den RingBuffer ein.
     */
    private void bufferBee()
    {
        bufferX.push(this.getX());
        bufferY.push(this.getY());
        bufferRot.push(this.getRotation());
    }

    /**
     * Prüft, ob die Biene mit einem Hindernis kollidiert. Falls eine Kollision existiert, wird
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
     * Beindet sich ein Actor im Inventar, wird dieser an der aktuellen Position der Biene in die
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

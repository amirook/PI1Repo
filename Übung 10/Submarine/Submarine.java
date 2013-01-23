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
     * erlauben einmaliges Auslösen bestimmter tastenbefehle 
     * z.B.(itemaufnahme, Auswahl, Nutzung)
     */
    private boolean keydown1=false;
    private boolean keydown2=false;
    private boolean keydown3=false;
    private boolean keydown4=false;
    private boolean keydown5=false;
    
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
        } else{
            if(WorldManager.overTheTop(this)) {
               WorldManager.reactToSurface(this,4,2);
               bufferSubmarine();
            }
            else {
                processKeys();
                bufferSubmarine();
            }
        }
    }    

    /**
     * Prüft, ob Tasten gedrückt werden und reagiert entsprechend.
     */
    private void processKeys()
    {
        // Aktuelle Position merken
        setImageDependingOnRotation();
        randomlyBlowBubbles();
        pose = new Pose(this);
        
        // Cursor-Tasten abfragen
        if(Greenfoot.isKeyDown("w")) {//up
            move(3);
        }
        if(Greenfoot.isKeyDown("s")) {//down
            move(-2);
        }
        if(Greenfoot.isKeyDown("a")) {//left
            turn(-2);
        }
        if(Greenfoot.isKeyDown("d")) {//right
            turn(2);
        }
        
        // boolean keydown verhindert Timing-Probleme von isKeyDown() in dem Falls die methode mehr als einmal ausgelöst werden würde
        
        //item aufnehmen
        if (Greenfoot.isKeyDown("e")&& !keydown1) {
            takeCollectable();
            keydown1=true;}
        if(!Greenfoot.isKeyDown("e")){keydown1=false;}
        
        //item ablegen
        if (Greenfoot.isKeyDown("q")&& !keydown2) {
            FreeCollectable();
            keydown2=true;}
        if(!Greenfoot.isKeyDown("q")){keydown2=false;}
        
        //auswahl zwischen Itemslots
        //selection-1
        if (Greenfoot.isKeyDown("1")&& !keydown3) {
            myInventory.setSelection(-1);//slotselection-1
            keydown3=true; }
        if(!Greenfoot.isKeyDown("1")){keydown3=false;}
        
        //selection+1
        if (Greenfoot.isKeyDown("2")&& !keydown4) {
            myInventory.setSelection(1);//slotselection+1
            keydown4=true;}
        if(!Greenfoot.isKeyDown("2")){keydown4=false;}
        
        //verwendung des ausgewählten Items sollte dieses durch parameter "usable" verwendet werden können
        //use Item 
        if (Greenfoot.isKeyDown("space")&& !keydown5) {
            myInventory.useSelection(this); //Versuch das item zu verwenden
            keydown5=true;}
        if(!Greenfoot.isKeyDown("space")){keydown5=false;}
        
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
     * Befindet sich ein Actor im Inventar, wird dieser an der aktuellen Position des U-Bootes in die
     * Welt gesetzt. Andernfalls wird der Fehlerton abgespielt.
     */
    private void takeCollectable()
    {
        Collectable collectable = (Collectable) getCollidingObject(Collectable.class);
        if (newCollisionWith(Collectable.class) && myInventory.hasSpace() && !collectable.fired){
            // testet ob das Object gestackt werden kann
            if(!myInventory.isEmpty() &&
                myInventory.contains(collectable.getClass()) &&
                collectable.usable) {
               myInventory.stackStack(collectable);
               getWorld().removeObject(collectable);
            }
            // wenn nicht wird es neu hinzugefügt
            else {
                myInventory.pushToInventory(collectable);
                getWorld().removeObject(collectable);
            }
        } else {
            Greenfoot.playSound("out.wav");
        }
    }
    
    /**
     * legt das Item aus dem Inventar ab das momentan durch "selectedSlot" ausgewählt ist
     * dies ist der Fall wenn das Inventar nicht leer ist und q gedrückt wurde,
     */
    private void FreeCollectable()
    {
        if (!myInventory.isEmpty()){
            myInventory.removeFromInventory(this.getX(), this.getY());
        } else {
            Greenfoot.playSound("out.wav");
        }
    }
    
    /**
     * erfasst den momentanen winkel dieses Aktors und setzt dazu das passende Bild
     */
    public void setImageDependingOnRotation()
    {
        int arc = this.getRotation();
        if (arc >90&& arc <270){
            this.setImage("2sub2.png");
        }
        else{
            this.setImage("2sub.png");
        }
    }
    
    /**
    * Das Uboot erzeugt in Zufallsintervallen Luftblasen
    */
    public void randomlyBlowBubbles()
    {
        if(Greenfoot.getRandomNumber(78)==1){
            //new bubble with an infinite lifespan and a scale between(5-25)pixels
            Bubble bubble = new Bubble(0,Greenfoot.getRandomNumber(20)+5);
            getWorld().addObject(bubble,this.getX(),this.getY());
        }
    }
}

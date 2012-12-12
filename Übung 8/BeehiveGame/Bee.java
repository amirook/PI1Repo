import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

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
    private Pose pose;

    /**
     * Inventar der Biene
     */
    private Inventory myInventory;

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
            bufferBee();
            move(3);
        }
        if(Greenfoot.isKeyDown("down")) {
            bufferBee();
            move(-3);
        }
        if(Greenfoot.isKeyDown("left")) {
            bufferBee();
            turn(-5);
        }
        if(Greenfoot.isKeyDown("right")) {
            bufferBee();
            turn(5);
        }
        // getKey() verhindert Timing-Probleme von isKeyDown() in dem Fall, dass mehrere Objekte im Inventar gespeichert sind. (Für spätere Versionen.)
        if (Greenfoot.getKey() == "space") {
            takeOrFreeCollectable();
        }
        // auf Hindernis prüfen
        checkForObstacle();
    }

    private void bufferBee()
    {
        bufferX.push(this.getX());
        bufferY.push(this.getY());
        bufferRot.push(this.getRotation());
    }

    /**
     * Prüft, ob die Biene mit einem Hindernis kollidiert. Falls eine Kollision existiert und man kein passendes
     * Objekt im Inventar hat um das Hindernis zu passieren, wird die alte Position der Biene wiederhergestellt.
     * Andernfalls wird das Inventar geleert und das Hindernis entfernt.
     */
    private void checkForObstacle()
    {
        Obstacle obstacle = (Obstacle) getOneIntersectingObject(Obstacle.class);
        boolean isBeaten = false;
        if (obstacle != null) 
        {
            // Kollision mit Hindernis ist eingetreten
            if (!myInventory.isEmpty())
            {
                // Kollision mit Hindernis und nicht leeres Inventar. Hindernis prüfen lassen,
                // ob Inventarobjekt zu Hindernis passt und Hindernis passierbar ist.
                isBeaten = obstacle.isBeaten( myInventory.getInventory());
            }
            if ( isBeaten ) 
            {
                // Kollision mit Hindernis und dazu passendes Inventarobjekt
                getWorld().removeObject(obstacle);
                myInventory.clearInventory();
                Greenfoot.playSound(obstacle.beatenSound);
            }
            else
            {
                // Kollision mit Hindernis und kein passendes Inventarobjekt oder leeres Inventar
                pose.resetPose();
            }
        } 
    }

    /**
     * Wenn ein Collectable in der Nähe und das Inventar leer ist, wird das Collectable eingesammelt.
     * Beindet sich ein Actor im Inventar, wird dieser an der aktuellen Position der Biene in die
     * Welt gesetzt. Andernfalls wird der Fehlerton abgespielt.
     */
    private void takeOrFreeCollectable()
    {
        Actor collectable = (Actor) getOneIntersectingObject(Collectable.class);
        if ( ( collectable != null) && ( myInventory.isEmpty() ) )
        {
            myInventory.pushToInventory(collectable);
        } 
        else if (!myInventory.isEmpty() && myInventory.getInventory() instanceof Actor )
        {
            myInventory.removeFromInventory(this.getX(), this.getY());
        } else
        {
            Greenfoot.playSound("out.wav");
        }
    }

}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.List;
/**
 * Ein Roboter, der per Tastatur gesteuert werden kann.
 * 
 * @author Thomas Röfer 
 * @version 01.11.2012
 */
public class Robot extends Collider
{
    /** Wurde im letzten Aufruf von act() die Leertaste gedrückt? (Übungsblatt 3) */
    private boolean lastSpacePressed;

    /** Das Inventar. (Übungsblatt 3) */
    private Inventory inventory;

    /** Die Punktanzeige. (Übungsblatt 5) */
    private Score score;

    /** Sind wir beim Replay? (Übungsblatt 6) */
    private boolean replaying;
    
    /** Größe des Replay-Puffers. (Übungsblatt 6) */
    private final int BUFFER_SIZE = 20;
    
    /** Die Replay-Puffer für alle drei Koordinaten. (Übungsblatt 6) */
    private RingBuffer xBuffer = new RingBuffer(BUFFER_SIZE);
    private RingBuffer yBuffer = new RingBuffer(BUFFER_SIZE);
    private RingBuffer rotationBuffer = new RingBuffer(BUFFER_SIZE);

    /**
     * Die Methode merkt sich die aktuelle Position, bewegt den Roboter und
     * testet, ob Objekte entfernt werden müssen. Gibt es dann immer noch
     * eine Kollision mit einem Hindernis, wird die alte Position wieder 
     * hergestellt. Danach wird getestet, ob man ein Objekt aufheben oder
     * ablegen möchte und kann.
     */
    public void act() 
    {
        if (replaying) { // Übungsblatt 6
            replay();
        } else {
            Pose oldPose = new Pose(this); // Übungsblatt 3

            keyboardControl(); // Übungsblatt 2
            inventory.useInventory(this); // Übungsblatt 9

            // Übungsblatt 3
            if (collidesWith(Obstacle.class)) {
                oldPose.restore(this);
            }

            pickUpOrDropObject(); // Übungsblatt 3
            countCollisions(); // Übungsblatt 2
            
            // Übungsblatt 6
            xBuffer.push(getX());
            yBuffer.push(getY());
            rotationBuffer.push(getRotation());
        }
    }

    /**
     * Bewegt den Roboter, wenn Pfeiltasten gedrückt werden. (Übungsblatt 2)
     */
    private void keyboardControl()
    {
        if (Greenfoot.isKeyDown("up")) {
            move(5);
        }
        if (Greenfoot.isKeyDown("down")) {
            move(-5);
        }
        if (Greenfoot.isKeyDown("left")) {
            turn(-5);
        }
        if (Greenfoot.isKeyDown("right")) {
            turn(5);
        }
    }

    /**
     * Reagiert auf Kollisionen mit Smileys und Totenköpfen.
     * Der Methodenname ist historisch bedingt.
     */ 
    private void countCollisions()
    {
        if (newCollisionWith(Smiley.class)) {
            score.setScore(score.getScore() + 10);
        } else if (newCollisionWith(Skull.class)) {
            replaying = true;
        }
    }

    /**
     * Setzt das Inventar. (Übungsblatt 3)
     */
    public void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }

    /**
     * Setzt die Punktanzeige. (Übungsblatt 5)
     */
    public void setScore(Score score)
    {
        this.score = score;
    }
    
    /**
     * 
     */
    public Score getScore(){
        return score;
    }

    /**
     * Hebt ein Objekt auf oder legt es ab, wenn die Leertaste gedrückt wird.
     * Aufheben ist möglich, wenn das Inventar leer ist und ein Objekt in der
     * Nähe ist. Ist ein Objekt im Inventar, wird es an der Position des
     * Roboters abgelegt. (Übungsblatt 3)
     */
    private void pickUpOrDropObject()
    {
        boolean spacePressed = Greenfoot.isKeyDown("space");
        if (spacePressed && !lastSpacePressed) {
            if (inventory.isEmpty()) {
                if (collidesWith(Item.class)) {
                    inventory.store((Item) getCollidingObject(Item.class));
                } else {
                    Game.playSound("Bottle.aiff", this);
                }
            } else {
                inventory.dropAt(getX(), getY());
            }
        }
        lastSpacePressed = spacePressed;
    }

    /**
     * Spielt das Replay ab. Wenn es zu Ende ist, wird das Spiel
     * angehalten (bevor Skull den Sound noch einmal abspielt).
     * Für die Zeitlupe wird die Ausführung etwas verzögert. (Übungsblatt 6)
     */
    private void replay()
    {
        if (xBuffer.size() > 0) {
            setLocation(xBuffer.pop(), yBuffer.pop());
            setRotation(rotationBuffer.pop());
        }
        
        // Wenn nun alles abgespielt wurde, beende das Spiel, sonst verzögere es etwas
        if (xBuffer.size() == 0) {
            Greenfoot.stop();
        } else {
            Greenfoot.delay(3);
        }
    }
}
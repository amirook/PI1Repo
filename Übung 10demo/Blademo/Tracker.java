import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tracker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tracker extends Enemy
{
    /**Zeitdauer vor Bildwechseln*/
    private int imagetimer = 6; //relative Zeit die jedes Bild dargestellt wird
    private int bitetimer = 0; //Zähler für imagetimer
    
    /**Jagtmodus und Ziel von Tracker*/
    private boolean hunting = false;
    private Actor target = null;
    
    
    /**
     * @Anfangswinkel mit dem der Tracker in die Welt gesetzt wird
     */
    public Tracker()
    {
    }
    
    /**
     * überprüft das Umfeld auf die Gegenwart eines Spielers
     * stellt schaltet sich bei größerer Distanz aktiv
     * verfolgt den Spieler wenn dieser einen Grenzbereich überschreitet
     * schaltet sich aus und hört auf zu jagen wenn der spieler außer Reichweite ist
     */
    public void act() 
    {
        //reichweite zur visuellen aktivierung des Trackers
        Actor scanresult = (Actor) getObjectInRange(200,Submarine.class);
        if(scanresult!=null && !hunting){
            setImageDependingOnRotation("trackerI");//visuelle aktivierung des Torpedos
        }
        
        //reichweite zur aktivieren des Jagdmodus
        if (scanresult!=null && getObjectInRange(175,Submarine.class)!=null) {
            hunting = true;
            target= scanresult;
        }
        
        //reichweite zur deaktivierung des Trackers)
        if (getObjectInRange(310,Submarine.class)==null) {
            hunting = false;
            target = null;
            setImageDependingOnRotation("trackerO");//visuelle deaktivierung des Torpedos
        }
        
        //verhalten bei Durchbrechen der Oberfläche gilt als override fürs normale Jagdverhalten
        if(WorldManager.overTheTop(this,10)){
            super.reactToSurface(this);
            bite();
        }
        //Verhalten im Jagdmodus unterwasser
        else if(hunting){
            huntMode();
        }
    }  
    
    
    //Jagdverhalten unterwasser
    private void huntMode(){
        //Jagdverhalten unterwasser
        //zufällige Anpeilung bei Chance 1/20
        if(Greenfoot.getRandomNumber(20)==1){
            //@ziel,@varianz im verfolgungswinkel
            this.turnTowardsObject(target,Greenfoot.getRandomNumber(6)-3); 
        }
        move(2);
        bite();//Bisanimation
    }
    
    public void setImageDependingOnRotation(String imagestring)
    {
        //fügt den übergebenen string und den Rotationswinkel zum richtigen filenamen zusammen
        int arc = this.getRotation();
        if (arc >90&& arc <270){
            this.setImage(imagestring+"L"+".png");
        }
        else{
            this.setImage(imagestring+"R"+".png");
        }
    
    }
    
     /**
     * animation des Torpedos bei Verfolgung eines Zieles (öffnen und schließen des piranha mauls)
     */
    private void bite()
    { 
        if(bitetimer >= imagetimer) {
            setImageDependingOnRotation("trackerI1");
            //ausschalten/reseten nach erreichen der doppelten imagetimer länge
            if(bitetimer >= imagetimer + imagetimer){
                bitetimer=0;
                setImageDependingOnRotation("trackerI");
            }
        }
        //erhöhen des Timers pro durchlauf
        bitetimer++;
    }
}

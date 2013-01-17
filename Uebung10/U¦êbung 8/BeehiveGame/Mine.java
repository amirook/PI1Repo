import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

//ist später Unterklasse von obstacle
public class Mine extends Enemy
{
    /**Geschwindigkeit der bei Detonation erzeugten Splitter
     * ist der input 0 so ist die Mine eine finte und detoniert schadenlos mit blasen statt Shrapnels
     */
    private int shrapnelspeed;
    
    /**"Zeitabstand" zwischen aufblinken, leuchtdauer der Lampe und timer*/
    private int blinkSchaltInterval = 80;
    private int leuchtdauer = 5;
    private int blinktimer = 0;
    
    /**
     * Konstruktor speichert die geschwindigkeit der später erzeugten Shrapnel Splitter
     */
    public Mine(int shrapnelspeed) 
    {
        this.shrapnelspeed = shrapnelspeed;
    }    

    /**
     * testet auf kollision mit passenden Aktoren (hier submarine und shrapnels)
     */
    public void act() 
    {
        //ersetze diesen test später durch collidingwith()
        //test auf auslösung
        if (collidesWith(Bee.class) || collidesWith(Shrapnel.class))
        {
            //Test ob die Mine eine Finte ist
            if(shrapnelspeed == 0){finte();}
            else{detonate();}
        }
        blink();
    }    
    
    /**
     * kurze Änderung der Image datei (darstellung einer aufblinkenden Lampe an der Mine)
     */
    private void blink()
    { 
        //aktivieren nach erreichen der Intervalgrenze
        if(blinktimer >= blinkSchaltInterval) {
            this.setImage("mineI.png");
            
            //ausschalten/reseten nach zuzüglichem erreichen der blinkdauer
            if(blinktimer >= leuchtdauer+blinkSchaltInterval){
                blinktimer=0;
                this.setImage("mineO.png");
            }
        }
        //erhöhen des Timers
        blinktimer++;
    }
    
    /**
     * entfernt die Mine und erzeugt 8 Splitter die in alle Richtungen fliegen
     * soll später zusätzlich sound abspielen und explosion darstellen
     */
    public void detonate()
    {
        int shrapnelnumber = 0 ;
        //erstellt 8 Splitter die nach der Detonation in alle Richtungen fliegen;
        while(shrapnelnumber != 8){
            int shrapnelarc = shrapnelnumber*45;
            
            Shrapnel name = new Shrapnel(shrapnelarc,shrapnelspeed);
            getWorld().addObject (name,this.getX(),this.getY());
            
            
            shrapnelnumber++;
        }
        this.setImage("explosion.gif");
        Greenfoot.playSound("explosion.wav");
        Greenfoot.delay(10);
        getWorld().removeObject(this);
    }
    
    /**
     * entfernt die Mine und erzeugt 8 Bubbles statt Shrapnels (kein schaden)
     * dient der Teuchung des spielers
     */
    public void finte()
    {
        int bubblenumber = 0 ;
        //erstellt 8 Blasen die nach der Detonation in alle Richtungen fliegen;
        while(bubblenumber != 8){
            //Bubbles mit zufälliger Lebensdauer(bis100) und Größer (bis59+1 diese Schreibweise verhindert den output 0)
            Bubble name = new Bubble(Greenfoot.getRandomNumber(100),Greenfoot.getRandomNumber(59)+1);
            
            // zufällige Platzierung der Bubbles um die Mitte der Mine
            int nextX= this.getX()+Greenfoot.getRandomNumber(48)-24;
            int nextY= this.getY()+Greenfoot.getRandomNumber(48)-24;
            getWorld().addObject (name,nextX,nextY);
            
            bubblenumber++;
        }
        getWorld().removeObject(this);
    }
}

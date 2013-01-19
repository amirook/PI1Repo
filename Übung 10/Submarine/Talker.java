import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Talker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Talker extends ServerActor
{
    /** index des dialoges bei dem der talker ist*/
    private int index = 0;
    
    /** eine Liste mit Dialogen*/
    private List<String> dialogs;
    private String topic;
    private String startmessage;
    private MessageDialog dia;
    
    private boolean windowStartsOpen=false;
    private boolean dialogOpen=false;
    
    public Talker(String topic,String startmessage,boolean windowStartsOpen)
    {
        this.topic= topic;
        this.startmessage= startmessage;
        this.windowStartsOpen= windowStartsOpen;
        dialogs =new ArrayList<String>();
    }
    
    private void openWindow(){}
    
    public void addDia(String message)
    {
        dialogs.add(message);
    }
    
    /**
     * Act - do whatever the Talker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //creates a dialog window if it doesnt exist yet
        if(nextDia() && index<dialogs.size()){
            //dia.writeDialog(dialogs.get(index));
            index++;}
    }
    
    
    /**
     * überprüft ob ein Wechsel des dialogs möglich ist
     */
    private boolean nextDia(){
        if(getWorld().getObjects(Submarine.class)!=null && Greenfoot.isKeyDown("r"))
        {return true;}
        return false;
    }
    
    private void closeDialog(){
        getWorld().removeObject(dia);
    }
}

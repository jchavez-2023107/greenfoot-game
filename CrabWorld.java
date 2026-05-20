import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(800, 600, 1);

        prepareWorld(); 
    }
    
    private void prepareWorld()
    {
        // Crab principal en el centro
        Crab crab = new Crab();
        addObject(crab, getWidth()/2, getHeight()/2);
    }
}

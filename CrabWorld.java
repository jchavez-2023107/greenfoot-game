import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{
    private GameSettings gameSettings;
    private Counter counter;
    private ArrayList<Lobster> lobsters = new ArrayList<>();

    /**
     * Constructor for objects of class CrabWorld.
     *
     */
    public CrabWorld(GameSettings gameSettings)
    {
        super(gameSettings.getCurrentMapSize().x, gameSettings.getCurrentMapSize().y, 1);
        this.gameSettings = gameSettings;
        prepareWorld();
    }

    private void prepareWorld()
    {
        counter = new Counter();
        int lobsterAmount = gameSettings.getCurrentGameDifficulty().enemyAmount;

        addObject(counter, 100, 30);
        spawnCrabs();
        spawnWorms();
        spawnLobsters(lobsterAmount);
    }

    // Crear cangrejos
    public void spawnCrabs()
    {
        // Crab principal centro
        Crab mainCrab = new Crab();

        addObject(mainCrab, getWidth()/2, getHeight()/2);

        // Otros 4 crabs aleatorios
        /*for(int i = 0; i < 4; i++)
        {
            Crab crab = new Crab();

            int x = Greenfoot.getRandomNumber(getWidth());

            int y = Greenfoot.getRandomNumber(getHeight());

            addObject(crab, x, y);
        }*/
    }

    // Crear gusanos aleatorios
    public void spawnWorms()
    {
        for(int i = 0; i < 100; i++)
        {
            Worm worm = new Worm();

            int x = Greenfoot.getRandomNumber(getWidth());

            int y = Greenfoot.getRandomNumber(getHeight());

            addObject(worm, x, y);
        }
    }

    // Crear Langostas
    public void spawnLobsters(int amount)
    {
        while (lobsters.size() < amount) {
            Lobster lobster = new Lobster();

            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());

            int mainCrabX = getWidth()/2;
            int mainCrabY = getHeight()/2;

            // Nos aseguramos que las langostas no aparezcan demasiado cerca del cangrejo principal.
            if (mainCrabX+10 >= x && x >= mainCrabX-10) continue;
            if (mainCrabY+10 >= x && x >= mainCrabY-10) continue;

            lobsters.add(lobster);
            addObject(lobster, x, y);
        }
    }

    public Counter getCounter()
    {
        return counter;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Counter counter = new Counter();
        addObject(counter,404,201);
        removeObject(counter);
    }
}

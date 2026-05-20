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
    
    private Counter counter;
    
    public CrabWorld()
    {    
        super(800, 600, 1);

        prepareWorld(); 
    }
    
    private void prepareWorld()
    {
        counter = new Counter();

        addObject(counter, 120, 30);
        
        spawnCrabs();

        spawnWorms();

        spawnLobsters();
    }
    
    // Crear cangrejos
    public void spawnCrabs()
    {
        // Crab principal centro
        Crab mainCrab = new Crab();

        addObject(mainCrab, getWidth()/2, getHeight()/2);

        // Otros 4 crabs aleatorios
        for(int i = 0; i < 4; i++)
        {
            Crab crab = new Crab();

            int x = Greenfoot.getRandomNumber(getWidth());

            int y = Greenfoot.getRandomNumber(getHeight());

            addObject(crab, x, y);
        }
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
    public void spawnLobsters()
    {
        // Esquina izquierda superior
        Lobster lobster1 = new Lobster();

        addObject(lobster1, 50, 50);

        // Esquina derecha superior
        Lobster lobster2 = new Lobster();

        addObject(lobster2, getWidth() - 50, 50);

        // Lobster extra aleatoria
        Lobster lobster3 = new Lobster();

        int x = Greenfoot.getRandomNumber(getWidth());

        int y = Greenfoot.getRandomNumber(getHeight());

        addObject(lobster3, x, y);
    }
    
    public Counter getCounter()
    {
        return counter;
    }
}

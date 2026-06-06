import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1World extends GameWorld
{
    /**
     * Constructor for objects of class CrabWorld.
     *
     */
    public Level1World(GameSettings gameSettings)
    {
        super(gameSettings);
    }

    @Override
    protected void nextWorld() {
        Greenfoot.setWorld(new Level2World(gameSettings));
    }

    @Override
    protected void prepareWorld()
    {
        int lobsterAmount = gameSettings.getCurrentGameDifficulty().enemyAmount;

        spawnCounter();
        spawnDoor();
        spawnWalls();
        spawnPlayer();
        spawnKey();
        spawnZombies(lobsterAmount);
    }

    private void spawnWalls() {
        Wall wall1 = new Wall(200, 20, defaultWallTexture);
        addObject(wall1, getHeight()/2, getWidth()/2);
    }

    private void spawnPlayer()
    {
        Player mainPlayer = Player.get();
        addObject(mainPlayer, getWidth()/2, getHeight()-10);
    }

    private void spawnDoor() {
        exitDoor = new ExitDoor();
        addObject(exitDoor, getWidth()/2, getHeight()/8);
    }

    private void spawnCounter() {
        counter = new Counter();
        addObject(counter, 70, 30);
    }

    private void spawnKey()
    {
        for(int i = 0; i < 3; i++)
        {
            Key key = new Key();

            int x = Greenfoot.getRandomNumber(getWidth());

            int y = Greenfoot.getRandomNumber(getHeight());

            addObject(key, x, y);
        }
    }

    // Crear Langostas
    private void spawnZombies(int amount)
    {
        int safeZone = 100;

        while (zombies.size() < amount) {
            Zombie zombie = new Zombie();

            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());

            int mainCrabX = getWidth()/2;
            int mainCrabY = getHeight()/2;

            if (mainCrabX+safeZone >= x && x >= mainCrabX-safeZone) continue;
            if (mainCrabY+safeZone >= x && x >= mainCrabY-safeZone) continue;

            zombies.add(zombie);
            addObject(zombie, x, y);
        }
    }
}

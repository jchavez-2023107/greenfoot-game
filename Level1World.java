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
    protected void setPlayerSpawn() {
        spawnX = getWidth()/2;
        spawnY = getHeight()-10;
    }

    @Override
    protected void nextWorld() {
        Greenfoot.setWorld(new Level2World(gameSettings));
    }

    @Override
    protected void spawnWalls() {
        Wall wall1 = new Wall(400, 50, defaultWallTexture);
        addObject(wall1, getWidth()/2, getHeight()/2);

        Wall wall2 = new Wall(800, 50, defaultWallTexture);
        Wall wall3 = new Wall(800, 50, defaultWallTexture);
        addObject(wall2, getWidth()/3, getHeight()/5);
        addObject(wall3, getWidth()/3*2, getHeight()/5*4);
    }

    @Override
    protected void spawnDoor() {
        exitDoor = new ExitDoor();
        addObject(exitDoor, getWidth()/2, getHeight()/8);
    }

    @Override
    protected void spawnKeys()
    {
        Key key1 = new Key();
        Key key2 = new Key();
        Key key3 = new Key();

        addObject(key1, getWidth()/2, getHeight()/8*7);
        addObject(key2, getWidth()/2, getHeight()/3);
        addObject(key3, getWidth()/2, getHeight()/3*2);
    }
}

import greenfoot.Greenfoot;


/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3World extends GameWorld
{
    /**
     * Constructor for objects of class CrabWorld.
     *
     */
    public Level3World(GameSettings gameSettings)
    {
        super(gameSettings);
    }

    @Override
    protected void setPlayerSpawn() {
        spawnX = getWidth()/8;
        spawnY = getHeight()/2;
    }

    @Override
    protected void nextWorld() {
        Greenfoot.setWorld(new EndingWorld(gameSettings, "¡Gracias por Jugar!"));
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

        addObject(key1, getWidth()/8*7, getHeight()/8*7);
        addObject(key2, getWidth()/2, getHeight()/2);
        addObject(key3, getWidth()/8, getHeight()/8);
    }

    @Override
    protected void spawnWalls() {
        Wall wall1 = new Wall(50, 800, defaultWallTexture);
        addObject(wall1, getWidth()/5, getHeight()/2+140);

        Wall wall2 = new Wall(500, 50, defaultWallTexture);
        addObject(wall2, getWidth()/2, getHeight()/5);

        Wall wall3 = new Wall(25, 400, defaultWallTexture);
        addObject(wall3, getWidth()/5*4, getHeight()/2+100);
    }
}

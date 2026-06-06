import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.ArrayList;
import java.util.List;

public abstract class GameWorld extends World {
    protected GameSettings gameSettings;
    protected Counter counter;
    protected ArrayList<Zombie> zombies = new ArrayList<>();
    protected ExitDoor exitDoor;
    protected String defaultWallTexture = "bricks3.jpg";

    protected int spawnX;
    protected int spawnY;

    public GameWorld(GameSettings gameSettings)
    {
        super(gameSettings.getCurrentMapSize().x, gameSettings.getCurrentMapSize().y, 1);
        this.gameSettings = gameSettings;
        setPlayerSpawn();
        prepareWorld();
    }

    protected abstract void setPlayerSpawn();

    protected abstract void nextWorld();

    protected void prepareWorld() {
        int enemyAmt = gameSettings.getCurrentGameDifficulty().enemyAmount;

        spawnWalls();
        spawnPlayer();
        spawnKeys();
        spawnZombies(enemyAmt);
        spawnCounter();
        spawnDoor();
    }

    protected void unloadWorld() {
        Greenfoot.setWorld(new EndingWorld(gameSettings, "Perdiste"));
    }

    protected void spawnPlayer()
    {
        Player mainPlayer = Player.get();
        addObject(mainPlayer, spawnX, spawnY);
    }

    protected void spawnZombies(int amount)
    {
        int safeZone = 100;

        while (zombies.size() < amount) {
            Zombie zombie = new Zombie();

            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());

            if (isColliding(x, y)) continue;

            if (spawnX+safeZone >= x && x >= spawnX-safeZone) continue;
            if (spawnY+safeZone >= x && x >= spawnY-safeZone) continue;

            zombies.add(zombie);
            addObject(zombie, x, y);
        }
    }

    protected abstract void spawnWalls();

    protected abstract void spawnDoor();

    protected void spawnCounter() {
        counter = new Counter();
        addObject(counter, 70, 30);
    }

    protected abstract void spawnKeys();

    protected boolean isColliding(int x, int y) {
        List<CollisionObject> objects = getObjectsAt(x, y, CollisionObject.class);

        return !objects.isEmpty();
    }

    public Counter getCounter()
    {
        return counter;
    }
}

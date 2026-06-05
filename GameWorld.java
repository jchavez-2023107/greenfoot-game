import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.ArrayList;

public abstract class GameWorld extends World {
    protected GameSettings gameSettings;
    protected Counter counter;
    protected ArrayList<Zombie> zombies = new ArrayList<>();
    protected ExitDoor exitDoor;

    public GameWorld(GameSettings gameSettings)
    {
        super(gameSettings.getCurrentMapSize().x, gameSettings.getCurrentMapSize().y, 1);
        this.gameSettings = gameSettings;
        prepareWorld();
    }

    protected abstract void prepareWorld();

    protected abstract void nextWorld();

    protected void unloadWorld() {
        Greenfoot.setWorld(new MenuWorld(gameSettings));
    }

    public Counter getCounter()
    {
        return counter;
    }
}

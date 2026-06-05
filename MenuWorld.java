import greenfoot.Greenfoot;
import greenfoot.World;  // World class from Greenfoot library

/**
 * Write a description of class MenuWorld here.
 * 
 * @author astxrfr
 * @version 1
 */
public class MenuWorld extends World
{
    private GameSettings gameSettings;

    /**
     * Constructor for objects of class MenuWorld.
     * 
     */
    public MenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 500, 1);
        this.gameSettings = GameSettings.getInstance();
        loadButtons();
    }

    public MenuWorld(GameSettings gameSettings)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 500, 1);
        this.gameSettings = gameSettings;
        loadButtons();
    }

    private void loadButtons() {
        Button playButton = new Button("Jugar", this::play);
        Button settingsButton = new Button("Configuración", this::settings);
        Button quitButton = new Button("Salir", this::quit);

        addObject(playButton, getWidth()/2, getHeight()/3);
        addObject(settingsButton, getWidth()/2, getHeight()/2);
        addObject(quitButton, getWidth()/2, getHeight()/3*2);
    }

    private void play() {
        Greenfoot.setWorld(new Level1World(gameSettings));
    }

    private void settings() {
        Greenfoot.setWorld(new SettingsWorld(gameSettings));
    }

    private void quit() {
        System.exit(0);
    }
}

import greenfoot.Greenfoot;
import greenfoot.World;

public class EndingWorld extends World {
    private final GameSettings gameSettings;
    private final String label;

    public EndingWorld(GameSettings gameSettings, String label) {
        super(500, 500, 1);
        this.gameSettings = gameSettings;
        this.label = label;
        loadButtons();
    }

    private void loadButtons() {
        Label endingLabel = new Label(label);
        Button returnButton = new Button("Regresar al menu principal", this::returnToMainMenu);

        addObject(endingLabel, getWidth()/2, getHeight()/3);
        addObject(returnButton, getWidth()/2, getHeight()/3*2);
    }

    private void returnToMainMenu() {
        Greenfoot.setWorld(new MenuWorld());
    }
}

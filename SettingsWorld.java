import greenfoot.Greenfoot;
import greenfoot.World;

public class SettingsWorld extends World {
    private GameSettings gameSettings;

    public SettingsWorld(GameSettings gameSettings) {
        super(500, 500, 1);
        this.gameSettings = gameSettings;
        loadButtons();
    }

    private void loadButtons() {
        MutableButton mapSizeButton = new MutableButton("Tamaño del mapa: ", this::updateMapSizeRender, this::switchMapSize);
        MutableButton difficultyButton = new MutableButton("Dificultad: ", this::updateDifficultyRender, this::switchDifficulty);
        Button returnButton = new Button("Regresar", this::returnToMainMenu);

        addObject(mapSizeButton, getWidth()/2, getHeight()/3);
        addObject(difficultyButton, getWidth()/2, getHeight()/2);
        addObject(returnButton, getWidth()/2, getHeight()/3*2);
    }

    private String updateMapSizeRender() {
        return switch (gameSettings.getCurrentMapSize()) {
            case SMALL -> "Pequeño";
            case MEDIUM -> "Mediano";
            case LARGE -> "Grande";
        };
    }

    private void switchMapSize() {
        MapSizes newMapSize;

        switch (gameSettings.getCurrentMapSize()) {
            case SMALL -> newMapSize = MapSizes.MEDIUM;
            case MEDIUM -> newMapSize = MapSizes.LARGE;
            case LARGE -> newMapSize = MapSizes.SMALL;

            default -> throw new IllegalStateException("currentMapSize cannot be outside the MapSizes Enum.");
        }

        gameSettings.setCurrentMapSize(newMapSize);
    }

    private String updateDifficultyRender() {
        return switch (gameSettings.getCurrentGameDifficulty()) {
            case EASY -> "Fácil";
            case MEDIUM -> "Media";
            case HARD -> "Difícil";
        };
    }

    private void switchDifficulty() {
        GameDifficulty newDifficulty;

        switch (gameSettings.getCurrentGameDifficulty()) {
            case EASY -> newDifficulty = GameDifficulty.MEDIUM;
            case MEDIUM -> newDifficulty = GameDifficulty.HARD;
            case HARD -> newDifficulty = GameDifficulty.EASY;

            default -> throw new IllegalStateException("currentDifficulty cannot be outside the GameDifficulty Enum.");
        }

        gameSettings.setCurrentGameDifficulty(newDifficulty);
    }

    private void returnToMainMenu() {
        Greenfoot.setWorld(new MenuWorld(gameSettings));
    }
}

public class GameSettings {
    private static GameSettings instance;

    private MapSizes currentMapSize;
    private GameDifficulty currentDiffculty;

    private GameSettings() {
        currentMapSize = MapSizes.LARGE;
        currentDiffculty = GameDifficulty.MEDIUM;
    }

    public static GameSettings getInstance() {
        if (instance == null) instance = new GameSettings();
        return instance;
    }

    public MapSizes getCurrentMapSize() { return currentMapSize; }
    public void setCurrentMapSize(MapSizes mapSize) { currentMapSize = mapSize; }

    public GameDifficulty getCurrentGameDifficulty() { return currentDiffculty; }
    public void setCurrentGameDifficulty(GameDifficulty difficulty) { currentDiffculty = difficulty; }
}

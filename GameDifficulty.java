public enum GameDifficulty {
    EASY(1),
    MEDIUM(3),
    HARD(5);

    public final int enemyAmount;

    GameDifficulty(int enemyAmount) {
        this.enemyAmount = enemyAmount;
    }
}

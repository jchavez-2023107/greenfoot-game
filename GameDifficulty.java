public enum GameDifficulty {
    EASY(5),
    MEDIUM(10),
    HARD(15);

    public final int enemyAmount;

    GameDifficulty(int enemyAmount) {
        this.enemyAmount = enemyAmount;
    }
}

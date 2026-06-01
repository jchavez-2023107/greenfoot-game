public enum MapSizes {
    SMALL(400, 400),
    MEDIUM(600, 600),
    LARGE(800, 800);

    public final int x;
    public final int y;

    MapSizes(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

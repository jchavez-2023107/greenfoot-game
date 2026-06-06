import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor implements CollisionObject
{
    private final String texture;
    private final int width;
    private final int height;

    public Wall(int width, int height, String texture) {
        this.texture = texture;
        this.height = height;
        this.width = width;
        renderSprite();
    }

    public Wall(int width, int height) {
        this.texture = null;
        this.height = height;
        this.width = width;
        renderSprite();
    }

    private void renderSprite() {
        if (texture == null) { renderDefault(); return; }

        GreenfootImage tile = new GreenfootImage(texture);
        GreenfootImage tex = new GreenfootImage(width, height);

        for (int x = 0; x < width; x += tile.getWidth()) {
            for (int y = 0; y < height; y += tile.getHeight()) {
                tex.drawImage(tile, x, y);
            }
        }

        this.setImage(tex);
    }

    private void renderDefault() {
        GreenfootImage tex = new GreenfootImage(width, height);
        tex.setColor(Color.BLACK);
        tex.fill();

        this.setImage(tex);
    }

    public void act()
    {
        // static
    }
}

import greenfoot.*;

public class Button extends Actor {
    private final String label;
    private final Runnable onClick;

    public Button(String label, Runnable onClick) {
        this.label = label;
        this.onClick = onClick;
        render();
    }

    private void render() {
        GreenfootImage img = new GreenfootImage(300, 50);
        img.setColor(Color.BLACK);
        img.fill();
        img.setColor(Color.WHITE);
        img.setFont(new Font("Arial", false, false, 20));
        img.drawString(label, 20, 33);
        setImage(img);
    }

    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            onClick.run();
        }
    }
}

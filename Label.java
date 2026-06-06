import greenfoot.*;

public class Label extends Actor {
    private final String label;
    private final Color bgColor;

    public Label(String label) {
        this.label = label;
        this.bgColor = null;
        render();
    }

    public Label(String label, Color bgColor) {
        this.label = label;
        this.bgColor = bgColor;
        render();
    }

    private void render() {
        GreenfootImage img = new GreenfootImage(300, 50);
        if(bgColor != null) {
            img.setColor(Color.BLACK);
            img.fill();
        }
        img.setColor(Color.WHITE);
        img.setFont(new Font("Arial", false, false, 20));
        img.drawString(label, 20, 33);
        setImage(img);
    }

    public void act() {
    }
}

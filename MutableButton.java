import greenfoot.*;

import java.util.function.Supplier;

public class MutableButton extends Actor {
    private final String staticLabel;
    private final Supplier<String> getLabel;
    private final Runnable onClick;

    public MutableButton(Supplier<String> getLabel, Runnable onClick) {
        this.staticLabel = null;
        this.getLabel = getLabel;
        this.onClick = onClick;
        render();
    }

    public MutableButton(String staticLabel, Supplier<String> getLabel, Runnable onClick) {
        this.staticLabel = staticLabel;
        this.getLabel = getLabel;
        this.onClick = onClick;
        render();
    }

    private String drawLabel() {
        if (staticLabel == null) return getLabel.get();

        return staticLabel + getLabel.get();
    }

    private void render() {
        GreenfootImage img = new GreenfootImage(300, 50);
        img.setColor(Color.BLACK);
        img.fill();
        img.setColor(Color.WHITE);
        img.setFont(new Font("Arial", false, false, 20));
        img.drawString(drawLabel(), 20, 33);
        setImage(img);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            onClick.run();
            render();
        }
    }
}

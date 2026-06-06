import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor {
    private int speed = 1;
    private boolean dumbBehavior = false;

    public Zombie(GameSettings gameSettings) {
        loadSettings(gameSettings);
    }

    private void loadSettings(GameSettings gameSettings) {
        switch (gameSettings.getCurrentGameDifficulty()) {
            case EASY:
                speed = 1;
                dumbBehavior = true;
                break;
            case MEDIUM:
                speed = 1;
                dumbBehavior = false;
                break;
            case HARD:
                speed = 2;
                dumbBehavior = false;
                break;
        }
    }

    public void act()
    {
        updatePosition();
        checkBorder();
        killPlayer();
    }

    // Movimiento automático
    private void updatePosition()
    {
        int behavior = Greenfoot.getRandomNumber(10);
        int playerX = Player.get().getX();
        int playerY = Player.get().getY();

        if (behavior <= 2) this.turn(Greenfoot.getRandomNumber(90) - 45);
        if (behavior == 3) this.turnTowards(playerX, playerY);
        if (behavior == 4 && dumbBehavior) this.turn(180);

        int forwardX = (int)Math.cos(Math.toRadians(getRotation())) * speed;
        int forwardY = (int)Math.sin(Math.toRadians(getRotation())) * speed;

        if(getOneObjectAtOffset(forwardX*4, forwardY*4, CollisionObject.class) == null) {
            move(speed);
            return;
        }

        turn(180);
        move(speed);
    }
    
    // Evitar salir del mapa
    private void checkBorder()
    {
        if(getX() <= 5 || getX() >= getWorld().getWidth() - 5) { turn(180); }
        if(getY() <= 5 || getY() >= getWorld().getHeight() - 5) { turn(180); }
    }

    private void killPlayer()
    {
        Actor player = getOneObjectAtOffset(0, 0, Player.class);

        if(player != null)
        {
            ((Player)player).kill();
            Greenfoot.playSound("gameover.wav");
        }
    }
}

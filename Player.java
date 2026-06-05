import greenfoot.*;

public class Player extends Actor
{
    private static Player PLAYER_INSTANCE;

    // Declarar la velocidad del jugador
    private int speed = 4;

    private Player() {
        PLAYER_INSTANCE = this;
    }

    public static Player get() {
        if (PLAYER_INSTANCE == null) return new Player();
        return PLAYER_INSTANCE;
    }

    // Acciones principales
    public void act() 
    {
        movePlayer();
        collectKey();
        enterDoor();
    }

    public void kill() {
        GameWorld world = (GameWorld)getWorld();
        world.removeObject(this);
        world.unloadWorld();
    }

    //Movimiento principal
    private void movePlayer()
    {
        double dx = 0, dy = 0;

        if (Greenfoot.isKeyDown("a")) { dx -= 1; }
        if (Greenfoot.isKeyDown("d")) { dx += 1; }
        if (Greenfoot.isKeyDown("s")) { dy += 1; }
        if (Greenfoot.isKeyDown("w")) { dy -= 1; }

        double length = Math.sqrt(dx*dx + dy*dy);
        if (length > 0) { dx /= length; dy /= length; }

        int x = this.getX();
        int y = this.getY();

        if (getOneObjectAtOffset((int)dx*speed*2, (int)dy*speed*2, CollisionObject.class) == null) {
            x += (int)(dx * speed);
            y += (int)(dy * speed);
        }

        this.setLocation(x, y);
    }
    
    //Comer gusanos
    private void collectKey()
    {
        Actor key = getOneObjectAtOffset(0, 0, Key.class);

        if(key != null)
        {
            World world = getWorld();
            world.removeObject(key);
            Greenfoot.playSound("eating.wav");
            
            // Sumar los puntos
            GameWorld gameWorld = (GameWorld)world;
            gameWorld.getCounter().addScore(1);
        }
    }

    private void enterDoor() {
        Actor door = getOneObjectAtOffset(0,0, ExitDoor.class);
        if(door == null) return;

        GameWorld world = (GameWorld)getWorld();
        if(world.getCounter().getScore() < 3) return;

        world.nextWorld();
    }
}

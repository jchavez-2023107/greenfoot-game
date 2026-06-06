import greenfoot.*;

public class Player extends Actor
{
    private static Player PLAYER_INSTANCE;

    private int speed = 4;

    private final Gun gun;

    private Player() {
        PLAYER_INSTANCE = this;
        GreenfootImage img = new GreenfootImage("warrior.png");
        img.scale(80, 100); 
        setImage(img);

        this.gun = new Gun();
    }

    public static Player get() {
        if (PLAYER_INSTANCE == null) return new Player();
        return PLAYER_INSTANCE;
    }

    // Acciones principales
    public void act() 
    {
        fireGun();
        movePlayer();
        collectKey();
        enterDoor();
    }

    public void kill() {
        GameWorld world = (GameWorld)getWorld();
        world.removeObject(this);
        world.unloadWorld();
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        world.addObject(gun, this.getX(), this.getY());
    }

    private void fireGun() {
        if (Greenfoot.mouseClicked(getWorld())) {
            gun.shoot();
            Greenfoot.playSound("gunSound.wav");
        }
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

        double x = this.getX();
        double y = this.getY();

        if (getOneObjectAtOffset((int)dx*speed*2, (int)dy*speed*2, CollisionObject.class) == null) {
            x += (int)(dx * speed);
            y += (int)(dy * speed);
        }

        this.setLocation((int)x, (int)y);
    }

    private void collectKey()
    {
        Actor key = getOneObjectAtOffset(0, 0, Key.class);

        if(key != null)
        {
            World world = getWorld();
            world.removeObject(key);
            Greenfoot.playSound("keys.wav");
            
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

    /**
     * Write a description of class Player.Gun here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    public class Gun extends Actor
    {
        private final String gunTexture = "ball.png";

        protected Gun() {
            render();
        }

        protected void shoot() {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse == null) return;

            int targetX = mouse.getX();
            int targetY = mouse.getY();

            Bullet bullet = new Bullet(targetX, targetY);
            getWorld().addObject(bullet, this.getX(), this.getY());
        }

        public void act()
        {
            this.setLocation(PLAYER_INSTANCE.getX(), PLAYER_INSTANCE.getY());
            updateOrientation();
        }

        private void render() {
            this.setImage(gunTexture);
        }

        private void updateOrientation() {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse == null) return;

            int targetX = mouse.getX();
            int targetY = mouse.getY();

            this.turnTowards(targetX, targetY);
        }
    }
}

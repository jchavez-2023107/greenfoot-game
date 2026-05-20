import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Crab extends Actor
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Declarar la velocidad del cangrejo
    private int speed = 4; 
    
    // Acciones principales
    public void act() 
    {
        moveCrab();
        checkBorder();
        eatWorm();
    }    
    
    //Movimiento principal
    public void moveCrab()
    {
        move(speed);

        if(Greenfoot.isKeyDown("left"))
        {
            turn(-4);
        }

        if(Greenfoot.isKeyDown("right"))
        {
            turn(4);
        }
    }
    
    // Evita salir del mapa
    public void checkBorder()
    {
        if(getX() <= 5 || getX() >= getWorld().getWidth() - 5)
        {
            turn(180);
        }

        if(getY() <= 5 || getY() >= getWorld().getHeight() - 5)
        {
            turn(180);
        }
    }
    
    //Comer gusanos
    public void eatWorm()
    {
        Actor worm;

        worm = getOneObjectAtOffset(0, 0, Worm.class);

        if(worm != null)
        {
            World world;

            world = getWorld();

            world.removeObject(worm);

            Greenfoot.playSound("eating.wav");
            
            // Sumar los puntos
            CrabWorld crabWorld = (CrabWorld) world;
            
            crabWorld.getCounter().addScore(1);
        }
    }
}

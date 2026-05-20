import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Velocidad de la langosta
    private int speed = 3;
    
    public void act()
    {
        moveLobster();
        checkBorder();
        eatCrab();
    }
    
    // Movimiento automático
    public void moveLobster()
    {
        move(speed);

        // Movimiento aleatorio
        if(Greenfoot.getRandomNumber(100) < 10)
        {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
    }
    
    // Evitar salir del mapa
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
    
    // Comer crabs
    public void eatCrab()
    {
        Actor crab;

        crab = getOneObjectAtOffset(0, 0, Crab.class);

        if(crab != null)
        {
            World world;

            world = getWorld();

            world.removeObject(crab);

            Greenfoot.playSound("gameover.wav");
        }
    }
}

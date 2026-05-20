import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Puntos del jugador
    private int score = 0;
    
    // Contador de punteo
    public Counter()
    {
        updateImage();
    }

    // Sumar puntos
    public void addScore(int points)
    {
        score = score + points;

        updateImage();
    }

    // Actualizar texto [Mostrar :)]
    public void updateImage()
    {
        setImage(new GreenfootImage("Score: " + score, 30, Color.WHITE, Color.BLACK));
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private final int targetX;
    private final int targetY;

    public Bullet(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public void act()
    {
        move(10);

        if (isAtBorder()) return;
        if (isColliding()) return;
        kill();
    }

    private boolean isAtBorder()
    {
        if(getX() <= 1 || getX() >= getWorld().getWidth()-1) { getWorld().removeObject(this); return true; }
        if(getY() <= 1 || getY() >= getWorld().getHeight()-1) { getWorld().removeObject(this); return true; }

        return false;
    }

    private boolean isColliding() {
        Actor obstacle = this.getOneIntersectingObject(CollisionObject.class);

        if (obstacle != null) {
            getWorld().removeObject(this);
            return true;
        }

        return false;
    }

    private void kill() {
        Actor enemy = this.getOneIntersectingObject(Zombie.class);

        if (enemy != null) {
            getWorld().removeObject(enemy);
            getWorld().removeObject(this);
        }
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        turnTowards(targetX, targetY);
    }
}

package me.max.squared;

import java.awt.*;

/**
 * Created by max on 25-5-2017.
 */
public class RocketEnemy extends GameObject{

    private Handler handler;
    int bulletSpawn = 400;

    public RocketEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 3;
        velY = 1;

    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

        if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

        handler.addObject(new Trial(x, y, ID.Trial, Color.blue, 24, 24, 0.05f, handler));

        bulletSpawn--;
        if (bulletSpawn <= 0){
            bulletSpawn = 400;
            handler.addObject(new RocketEnemyBullet(x, y, ID.RocketEnemyBullet, handler));
        }

    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int) x, (int) y, 24, 24);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 24, 24);
    }
}

package me.max.squared;

import java.awt.*;

/**
 * Created by max on 25-5-2017.
 */
public class BulletEnemy extends GameObject{

    private Handler handler;
    int bulletSpawn = 250;

    public BulletEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 1.75f;
        velY = 2.5f;

    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

        if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

        handler.addObject(new Trial(x, y, ID.Trial, Color.magenta, 20, 20, 0.05f, handler));

        bulletSpawn--;
        if (bulletSpawn <= 0){
            bulletSpawn = 250;
            handler.addObject(new BulletEnemyBullet(x, y, ID.BulletEnemyBullet, handler));
        }

    }

    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) x, (int) y, 20, 20);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 20, 20);
    }
}

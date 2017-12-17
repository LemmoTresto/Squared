package me.max.squared.objects.enemies;

import me.max.squared.Game;
import me.max.squared.enums.ID;
import me.max.squared.handlers.main.Handler;
import me.max.squared.objects.GameObject;
import me.max.squared.objects.trials.Trial;

import java.awt.*;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class BulletEnemy extends GameObject {

    int bulletSpawn = 250;
    private Handler handler;

    public BulletEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 1.75f;
        velY = 2.5f;

    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 50) {
            velY *= -1;
        }

        if (x <= 0 || x >= Game.WIDTH - 20) {
            velX *= -1;
        }

        handler.addObject(new Trial(x, y, ID.Trial, Color.magenta, 20, 20, 0.05f, handler));

        bulletSpawn--;
        if (bulletSpawn <= 0) {
            bulletSpawn = 250;
            if (!(Game.gameState == Game.STATE.Died) && !(Game.gameState == Game.STATE.Died)) {
                handler.addObject(new BulletEnemyBullet(x, y, ID.BulletEnemyBullet, handler));
            }
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

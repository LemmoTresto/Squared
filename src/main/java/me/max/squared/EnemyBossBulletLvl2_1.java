package me.max.squared;

import java.awt.*;
import java.util.Random;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class EnemyBossBulletLvl2_1 extends GameObject{

    private Handler handler;
    private Random r = new Random();
    private int timer = 100;

    public EnemyBossBulletLvl2_1(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = r.nextInt(2 - -2) + -2;
        velY = 4;
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y >= Game.HEIGHT) handler.removeObject(this);

        if (y >= Game.HEIGHT - 268) {
            handler.removeObject(this);
            handler.addObject(new EnemyBossBulletLvl2_2(x, y, ID.EnemyBossBulletLvl2_2, handler));
            GameObject tempObject = handler.object.getLast();
            if (velX < 0) tempObject.velX = velX - 2;
            if (velX > 0) tempObject.velX = velX + 2;
            if (velY < 0) tempObject.velY = velY - 0.3f;
            if (velY > 0) tempObject.velY = velY + 0.3f;
            handler.addObject(new EnemyBossBulletLvl2_2(x, y, ID.EnemyBossBulletLvl2_2, handler));
            GameObject tempObject2 = handler.object.getLast();
            if (velY < 0) tempObject2.velY = velY - 0.3f;
            if (velY > 0) tempObject2.velY = velY + 0.3f;
            handler.addObject(new EnemyBossBulletLvl2_2(x, y, ID.EnemyBossBulletLvl2_2, handler));
            GameObject tempObject3 = handler.object.getLast();
            if (velX < 0) tempObject3.velX = velX + 2;
            if (velX > 0) tempObject3.velX = velX - 2;
            if (velY < 0) tempObject3.velY = velY + 0.3f;
            if (velY > 0) tempObject3.velY = velY - 0.3f;
        }


        //if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

        //if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

        handler.addObject(new Trial(x, y, ID.Trial, Color.orange, 16, 16, 0.07f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}

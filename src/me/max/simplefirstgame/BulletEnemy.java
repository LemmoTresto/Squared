package me.max.simplefirstgame;

import java.awt.*;

/**
 * Created by max on 25-5-2017.
 */
public class BulletEnemy extends GameObject{

    private Handler handler;

    public BulletEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 5;
        velY = 5;

        // TODO: Make a new enemy it shoots a bullet every x amount of seconds.
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

        if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

        handler.addObject(new Trial(x, y, ID.Trial, Color.magenta, 20, 20, 0.05f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) x, (int) y, 20, 20);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 20, 20);
    }
}

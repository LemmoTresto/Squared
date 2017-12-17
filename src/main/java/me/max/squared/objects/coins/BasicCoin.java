package me.max.squared.objects.coins;

import me.max.squared.enums.ID;
import me.max.squared.handlers.main.Handler;
import me.max.squared.objects.GameObject;

import java.awt.*;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class BasicCoin extends GameObject {

    private Handler handler;

    public BasicCoin(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 0;
        velY = 0;
    }

    public void tick() {
        x += velX;
        y += velY;

        //if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

        //if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

    }

    public void render(Graphics g) {

        g.setColor(Color.yellow);
        g.fillOval((int) x, (int) y, 20, 20);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 20, 20);
    }
}

package me.max.squared;

import java.awt.*;
import java.util.Random;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class EnemyBossBulletLvl3_1 extends GameObject{

    private Handler handler;
    private Random r = new Random();
    private int timer = 100;
    private GameObject player;

    public EnemyBossBulletLvl3_1(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        for (int i = 0; i < handler.object.size(); i++){
            if (handler.object.get(i).getId() == ID.Player){
                player = handler.object.get(i);
            }
        }

        if (player.x > Game.WIDTH / 2){
            velX = 5;
        } else if (player.x < Game.WIDTH / 2){
            velX = -5;
        } else {
            velX = 5;
        }
        velY = r.nextInt(10 - -10) + -10;
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y >= Game.HEIGHT) handler.removeObject(this);
        if (y <= 0) handler.removeObject(this);
        if (x >= Game.WIDTH) handler.removeObject(this);
        if (x <= 0) handler.removeObject(this);

        //if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

        //if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

        handler.addObject(new Trial(x, y, ID.Trial, Color.red, 13, 13, 0.07f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 13, 13);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 13, 13);
    }
}

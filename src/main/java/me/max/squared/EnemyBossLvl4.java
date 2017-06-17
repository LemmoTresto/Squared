package me.max.squared;

import java.awt.*;
import java.util.Random;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class EnemyBossLvl4 extends GameObject{

    private Handler handler;
    private int timer = 150;
    private Random random = new Random();
    private GameObject player;

    public EnemyBossLvl4(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 0;
        velY = -2;

        for (int i = 0; i < handler.object.size(); i++){
            if (handler.object.get(i).getId() == ID.Player){
                player = handler.object.get(i);
            }
        }
    }

    public void tick() {
        x += velX;
        y += velY;

        if (timer > 0) {
            timer--;
        }

        if (timer <= 0) {
            velY = 0;
            int spawn = random.nextInt(50);
            if (spawn == 0) {
                handler.addObject(new EnemyBossBulletLvl4_1(x, y, ID.EnemyBossBulletLvl4_1, handler));
            }
        }




        //if (x <= 0 || x >= Game.WIDTH - 92) { velX *= -1; }


        handler.addObject(new Trial(x, y, ID.Trial, Color.pink, 86, 86, 0.07f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect((int) x, (int) y, 86, 86);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 86, 86);
    }
}

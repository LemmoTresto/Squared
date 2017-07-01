package me.max.squared.objects.bosses;

import me.max.squared.Game;
import me.max.squared.objects.GameObject;
import me.max.squared.enums.ID;
import me.max.squared.objects.trials.Trial;
import me.max.squared.handlers.main.Handler;

import java.awt.*;
import java.util.Random;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class EnemyBossBulletLvl2_2 extends GameObject {

    private Handler handler;
    private Random r = new Random();
    private int timer = 100;

    public EnemyBossBulletLvl2_2(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = r.nextInt((5 - -5) + -5);
        velY = 5;
    }

    public void tick() {
        if (!(Game.gameState == Game.STATE.Died) && !(Game.gameState == Game.STATE.WonLevel2)) {
            x += velX;
            y += velY;

            if (y >= Game.HEIGHT) handler.removeObject(this);
            if (y <= 0) handler.removeObject(this);
            if (x <= 0) handler.removeObject(this);
            if (x >= Game.WIDTH) handler.removeObject(this);

            //if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

            //if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

            handler.addObject(new Trial(x, y, ID.Trial, Color.yellow, 12, 12, 0.07f, handler));
        }
    }

    public void render(Graphics g2) {

        float alpha = 0.4f;
        AlphaComposite alcom = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, alpha);
        Graphics2D g = (Graphics2D) g2.create();
        if (Game.gameState == Game.STATE.PauseScreen){
            g.setComposite(alcom);
        }

        g.setColor(Color.yellow);
        g.fillRect((int) x, (int) y, 12, 12);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 12, 12);
    }
}

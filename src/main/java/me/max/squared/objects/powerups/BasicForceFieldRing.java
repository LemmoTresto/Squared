package me.max.squared.objects.powerups;

import me.max.squared.Game;
import me.max.squared.objects.GameObject;
import me.max.squared.handlers.main.Handler;
import me.max.squared.enums.ID;

import java.awt.*;

/**
 * Created by max on 23-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class BasicForceFieldRing extends GameObject {

    private Handler handler;
    private int timer = 30;
    private boolean isFlashed = true;
    private int timesFlashed = 0;

    public BasicForceFieldRing(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 0;
        velY = 0;
    }

    public void tick() {
        x += velX;
        y += velY;

        timer -= timesFlashed;

        timer--;
        if (timer <= 0){
            timesFlashed += 1;
            timer = 30;
            if (timesFlashed >= 2) {
                if (isFlashed) {
                    isFlashed = false;
                } else {
                    isFlashed = true;
                }
            }
        }

        if (timesFlashed >= 20){
            handler.removeObject(this);
        }



        //if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

        //if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

    }

    public void render(Graphics g2) {
        if (isFlashed) {

            float alpha = 0.4f;
            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            Graphics2D g = (Graphics2D) g2.create();
            if (Game.gameState == Game.STATE.PauseScreen){
                g.setComposite(alcom);
            }


            g.setColor(new Color(100, 4, 250));
            int width = 22;
            int height = 23;

            //Making a nice thick ring!
            g.fillOval((int) x, (int) y, width, height);
            g.setColor(Color.black);
            g.fillOval((int) x + 4, (int) y + 4, width - 8, height - 8);

        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 22, 23);
    }
}

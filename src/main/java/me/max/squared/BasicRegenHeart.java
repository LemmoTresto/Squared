package me.max.squared;

import java.awt.*;

/**
 * Created by max on 23-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class BasicRegenHeart extends GameObject{

    private Handler handler;
    private int timer = 30;
    private boolean isFlashed = true;
    private int timesFlashed = 0;

    public BasicRegenHeart(float x, float y, ID id, Handler handler) {
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

            g.setColor(new Color(150, 4, 60));
            int width = 17;
            int height = 23;

            int[] triangleX = {
                    (int) x - 2 * width / 18,
                    (int) x + width + 2 * width / 18,
                    ((int) x - 2 * width / 18 + (int) x + width + 2 * width / 18) / 2};
            int[] triangleY = {
                    (int) y + height - 2 * height / 3,
                    (int) y + height - 2 * height / 3,
                    (int) y + height};
            g.fillOval(
                    (int) x - width / 12,
                    (int) y,
                    width / 2 + width / 6,
                    height / 2);
            g.fillOval(
                    (int) x + width / 2 - width / 12,
                    (int) y,
                    width / 2 + width / 6,
                    height / 2);
            g.fillPolygon(triangleX, triangleY, triangleX.length);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 20, 20);
    }
}

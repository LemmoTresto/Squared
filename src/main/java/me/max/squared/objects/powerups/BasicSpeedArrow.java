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
public class BasicSpeedArrow extends GameObject {

    private Handler handler;
    private int timer = 30;
    private boolean isFlashed = true;
    private int timesFlashed = 0;

    public BasicSpeedArrow(float x, float y, ID id, Handler handler) {
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

            g.setColor(new Color(255, 193, 40));

            //Making a nice lightning strike
            //first row // main row
            g.fillRect((int) x, (int) y, 1, 1);
            g.fillRect((int) x + 1, (int) y, 1, 1);
            g.fillRect((int) x + 2, (int) y, 1, 1);
            g.fillRect((int) x + 3, (int) y, 1, 1);
            g.fillRect((int) x + 4, (int) y, 1, 1);
            g.fillRect((int) x + 5, (int) y, 1, 1);
            g.fillRect((int) x + 6, (int) y, 1, 1);
            g.fillRect((int) x + 7, (int) y, 1, 1);
            g.fillRect((int) x + 8, (int) y, 1, 1);
            g.fillRect((int) x + 9, (int) y, 1, 1);
            g.fillRect((int) x + 10, (int) y, 1, 1);

            //GOING UP!!

            //second row
            g.fillRect((int) x + 1, (int) y - 1, 1, 1);
            g.fillRect((int) x + 2, (int) y - 1, 1, 1);
            g.fillRect((int) x + 3, (int) y - 1, 1, 1);
            g.fillRect((int) x + 4, (int) y - 1, 1, 1);
            g.fillRect((int) x + 5, (int) y - 1, 1, 1);
            g.fillRect((int) x + 6, (int) y - 1, 1, 1);
            g.fillRect((int) x + 7, (int) y - 1, 1, 1);
            g.fillRect((int) x + 8, (int) y - 1, 1, 1);
            g.fillRect((int) x + 9, (int) y - 1, 1, 1);
            g.fillRect((int) x + 10, (int) y - 1, 1, 1);
            g.fillRect((int) x + 11, (int) y - 1, 1, 1);

            //third row
            g.fillRect((int) x + 2, (int) y - 2, 1, 1);
            g.fillRect((int) x + 3, (int) y - 2, 1, 1);
            g.fillRect((int) x + 4, (int) y - 2, 1, 1);
            g.fillRect((int) x + 5, (int) y - 2, 1, 1);

            //fourth row
            g.fillRect((int) x + 3, (int) y - 3, 1, 1);
            g.fillRect((int) x + 4, (int) y - 3, 1, 1);
            g.fillRect((int) x + 5, (int) y - 3, 1, 1);
            g.fillRect((int) x + 6, (int) y - 3, 1, 1);
            g.fillRect((int) x + 7, (int) y - 3, 1, 1);

            //fifth row
            g.fillRect((int) x + 4, (int) y - 4, 1, 1);
            g.fillRect((int) x + 5, (int) y - 4, 1, 1);
            g.fillRect((int) x + 6, (int) y - 4, 1, 1);
            g.fillRect((int) x + 7, (int) y - 4, 1, 1);
            g.fillRect((int) x + 8, (int) y - 4, 1, 1);

            //sixth row
            g.fillRect((int) x + 5, (int) y - 5, 1, 1);
            g.fillRect((int) x + 6, (int) y - 5, 1, 1);
            g.fillRect((int) x + 7, (int) y - 5, 1, 1);
            g.fillRect((int) x + 8, (int) y - 5, 1, 1);

            //seventh row
            g.fillRect((int) x + 6, (int) y - 6, 1, 1);
            g.fillRect((int) x + 7, (int) y - 6, 1, 1);
            g.fillRect((int) x + 8, (int) y - 6, 1, 1);

            //eight row
            g.fillRect((int) x + 7, (int) y - 7, 1, 1);
            g.fillRect((int) x + 8, (int) y - 7, 1, 1);

            //ningth row
            g.fillRect((int) x + 8, (int) y - 8, 1, 1);


            //GOING DOWN NOW

            //second row
            g.fillRect((int) x + 5, (int) y + 1, 1, 1);
            g.fillRect((int) x + 6, (int) y + 1, 1, 1);
            g.fillRect((int) x + 7, (int) y + 1, 1, 1);
            g.fillRect((int) x + 8, (int) y + 1, 1, 1);

            //third row
            g.fillRect((int) x + 4, (int) y + 2, 1, 1);
            g.fillRect((int) x + 5, (int) y + 2, 1, 1);
            g.fillRect((int) x + 6, (int) y + 2, 1, 1);
            g.fillRect((int) x + 7, (int) y + 2, 1, 1);

            //fourth row
            g.fillRect((int) x + 4, (int) y + 3, 1, 1);
            g.fillRect((int) x + 5, (int) y + 3, 1, 1);
            g.fillRect((int) x + 6, (int) y + 3, 1, 1);
            g.fillRect((int) x + 7, (int) y + 3, 1, 1);

            //fifth row
            g.fillRect((int) x + 4, (int) y + 4, 1, 1);
            g.fillRect((int) x + 5, (int) y + 4, 1, 1);
            g.fillRect((int) x + 6, (int) y + 4, 1, 1);

            //sixth row
            g.fillRect((int) x + 3, (int) y + 5, 1, 1);
            g.fillRect((int) x + 4, (int) y + 5, 1, 1);
            g.fillRect((int) x + 5, (int) y + 5, 1, 1);

            //seventh row
            g.fillRect((int) x + 3, (int) y + 6, 1, 1);
            g.fillRect((int) x + 4, (int) y + 6, 1, 1);

            //eight row
            g.fillRect((int) x + 3, (int) y + 7, 1, 1);

        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y - 8, 10, 15);
    }
}

package me.max.squared;

import java.awt.*;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class LaserEnemy extends GameObject{

    private Handler handler;
    int bulletSpawn = 250;
    private float oldVelX;
    private float oldVelY;

    public LaserEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 1.75f;
        velY = 2.5f;

    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

        if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

        handler.addObject(new Trial(x, y, ID.Trial, Color.magenta, 20, 20, 0.05f, handler));

        bulletSpawn--;
        if (bulletSpawn <= 50){
            if (!(velX == 0) && !(velY == 0)) {
                oldVelX = velX;
                oldVelY = velY;
            }
            velX = 0;
            velY = 0;
            bulletSpawn--;
            if (bulletSpawn <= 0) {
                bulletSpawn = 250;
                velX = oldVelX;
                velY = oldVelY;
                handler.addObject(new Trial(x, y, ID.LaserBeam, new Color(250, 250, 250), 14, 14, 0.009f, handler));
            }
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

        g.setColor(new Color(139,0,0));
        //beam will be bright white!
        g.fillRect((int) x, (int) y, 20, 20);

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 20, 20);
    }
}

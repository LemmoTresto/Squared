package me.max.squared;

import java.awt.*;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class BulletEnemyBullet extends GameObject{

    private Handler handler;
    private GameObject player;

    public BulletEnemyBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;
        //velX = 5;
        //velY = 5;

        for (int i = 0; i < handler.object.size(); i++){
            if (handler.object.get(i).getId() == ID.Player){
                player = handler.object.get(i);
            }
        }

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        velX = (float) ((-1.0 / distance) * diffX);
        velY = (float) ((-1.0 / distance) * diffY);
    }

    public void tick() {
        if (!(Game.gameState == Game.STATE.Died)) {
            x += velX;
            y += velY;

            if (y >= Game.HEIGHT) handler.removeObject(this);
            if (x >= Game.WIDTH) handler.removeObject(this);
            if (x <= 0) handler.removeObject(this);
            if (y <= 0) handler.removeObject(this);

            //if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

            //if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

            handler.addObject(new Trial(x, y, ID.Trial, Color.orange, 16, 16, 0.07f, handler));
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

        g.setColor(Color.orange);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}

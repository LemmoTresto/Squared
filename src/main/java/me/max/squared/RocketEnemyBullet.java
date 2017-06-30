package me.max.squared;

import java.awt.*;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class RocketEnemyBullet extends GameObject{

    private Handler handler;
    private GameObject player;
    private int timer = 175;
    private Color rocketEnemyC = new Color(191, 111, 45);

    public RocketEnemyBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;
        //velX = 5;
        //velY = 5;

        for (int i = 0; i < handler.object.size(); i++){
            if (handler.object.get(i).getId() == ID.Player){
                player = handler.object.get(i);
            }
        }
    }

    public void tick() {
        if (!(Game.gameState == Game.STATE.Died)) {
            x += velX;
            y += velY;

            if (!(timer <= 0)) {
                timer--;
            } else if (timer <= 0) {
                handler.removeObject(this);
                handler.addObject(new RocketEnemyExplosion(x, y, ID.RocketEnemyExplosion, Color.darkGray, 24, 24, 0.009f, handler));
            }

            if (y >= Game.HEIGHT) handler.removeObject(this);
            if (x >= Game.WIDTH) handler.removeObject(this);
            if (x <= 0) handler.removeObject(this);
            if (y <= 0) handler.removeObject(this);


            float diffX = x - player.getX() - 8;
            float diffY = y - player.getY() - 8;
            float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
            velX = (float) ((-4.75 / distance) * diffX);
            velY = (float) ((-4.75 / distance) * diffY);

            //if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }

            //if (x <= 0 || x >= Game.WIDTH - 20) { velX *= -1; }

            handler.addObject(new Trial(x, y, ID.Trial, rocketEnemyC, 16, 16, 0.07f, handler));
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

        g.setColor(rocketEnemyC);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}

package me.max.simplefirstgame;

import java.awt.*;
import java.util.Random;

/**
 * Created by max on 25-5-2017.
 */
public class EnemyBoss extends GameObject{

    private Handler handler;
    private int timer = 80;
    private int timer2 = 50;
    private int timer3 = 250;
    private int timer4 = 250;
    private int timer5 = 500;
    private Random random = new Random();

    public EnemyBoss(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 0;
        velY = 2;
    }

    public void tick() {
        x += velX;
        y += velY;


        if (timer <= 0) velY = 0;
        else timer--;

        if (timer <= 0) timer2--;
        if (timer2 <= 0){
            if (velX == 0) velX = 2;
            if (velX > 0) velX += 0.007f;
            else if (velX < 0) velX -= 0.007f;
            int spawn = random.nextInt(10);
            if (spawn == 0) {
                handler.addObject(new EnemyBossBullet(x + 40, y + 80, ID.EnemyBossBullet, handler));
            }

        }

        velX = Game.clamp(velX, -10, 10);



        if (x <= 0 || x >= Game.WIDTH - 92) { velX *= -1; }
        //if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }


        handler.addObject(new Trial(x, y, ID.Trial, Color.red, 86, 86, 0.07f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 86, 86);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 86, 86);
    }
}

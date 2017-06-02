package me.max.simplefirstgame;

import java.awt.*;
import java.util.Random;

/**
 * Created by max on 25-5-2017.
 */
public class EnemyBossLvl2 extends GameObject{

    private Handler handler;
    private int timer = 60;
    private int timer2 = 50;
    private Random random = new Random();

    public EnemyBossLvl2(float x, float y, ID id, Handler handler) {
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
            int spawn = random.nextInt(20);
            if (spawn == 0) {
                handler.addObject(new EnemyBossBulletLvl2_1(x + 40, y + 80, ID.EnemyBossBulletLvl2_1, handler));
            }

        }

        velX = Game.clamp(velX, -10, 10);



        if (x <= 0 || x >= Game.WIDTH - 92) { velX *= -1; }
        //if (y <= 0 || y >= Game.HEIGHT - 50) { velY *= -1; }


        handler.addObject(new Trial(x, y, ID.Trial, Color.blue, 86, 86, 0.07f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int) x, (int) y, 86, 86);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 86, 86);
    }
}

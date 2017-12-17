package me.max.squared.objects.bosses;

import me.max.squared.Game;
import me.max.squared.enums.ID;
import me.max.squared.handlers.main.Handler;
import me.max.squared.objects.GameObject;
import me.max.squared.objects.trials.Trial;

import java.awt.*;
import java.util.Random;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class EnemyBossLvl3 extends GameObject {

    private Handler handler;
    private int timer = 150;
    private Random random = new Random();
    private GameObject player;

    public EnemyBossLvl3(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 0;
        velY = 2;

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) {
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
            if (y <= 0) {
                velY *= -1;
                if (velY < 0) {
                    velY -= 0.02f;
                } else if (velY > 0) {
                    velY += 0.02f;
                }
            } else if (y >= Game.HEIGHT - 110) {
                velY *= -1;
                if (velY < 0) {
                    velY -= 0.02f;
                } else if (velY > 0) {
                    velY += 0.02f;
                }
            }
            int spawn = random.nextInt(10);
            if (spawn == 0) {
                if (player.x < Game.WIDTH / 2) {
                    handler.addObject(new EnemyBossBulletLvl3_1(x - 10, y + 40, ID.EnemyBossBulletLvl3_1, handler));
                } else if (player.x > Game.WIDTH / 2) {
                    handler.addObject(new EnemyBossBulletLvl3_1(x + 75, y + 40, ID.EnemyBossBulletLvl3_1, handler));
                }
            }
        }

        velY = Game.clamp(velY, -7.5f, 7.5f);


        //if (x <= 0 || x >= Game.WIDTH - 92) { velX *= -1; }


        handler.addObject(new Trial(x, y, ID.Trial, Color.lightGray, 86, 86, 0.07f, handler));
    }

    public void render(Graphics g) {

        g.setColor(Color.lightGray);
        g.fillRect((int) x, (int) y, 86, 86);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 86, 86);
    }
}

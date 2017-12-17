package me.max.squared.menus;

import me.max.squared.Game;
import me.max.squared.enums.ID;
import me.max.squared.handlers.main.EffectHandler;
import me.max.squared.handlers.main.Handler;
import me.max.squared.handlers.others.HUD;
import me.max.squared.handlers.others.Spawn;
import me.max.squared.objects.enemies.BasicEnemy;
import me.max.squared.objects.enemies.FastEnemy;
import me.max.squared.objects.players.Player;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by max on 28-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class Died extends MouseAdapter {

    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private EffectHandler effectHandler;
    private Random r = new Random();

    public Died(Handler handler, HUD hud, Spawn spawner, EffectHandler effectHandler) {
        this.handler = handler;
        this.hud = hud;
        this.spawner = spawner;
        this.effectHandler = effectHandler;

    }

    public void mouseClicked(MouseEvent e) {
        if (Game.gameState == Game.STATE.Died) {
            int mx = e.getX();
            int my = e.getY();
            if (mouseOver(mx, my, Game.WIDTH / 2 - 90, 222, 200, 60)) {
                Game.gameState = Game.STATE.Menu;
                handler.object.clear();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                hud.score = 0;
                spawner.scoreKeep = 0;
                hud.setWave(1);
                hud.HEALTH = 100;
            }

        }
    }

    public void tick() {
        if (Game.gameState == Game.STATE.Died) {


        }
    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.Died) {
            Font font1 = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);
            g.setFont(font1);
            g.setColor(Color.red);
            handler.removeObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
            g.drawString("You died...", Game.WIDTH / 2 - 120, 50);
            g.setColor(Color.blue);
            g.drawRect(Game.WIDTH / 2 - 160, 100, 325, 200);
            g.setColor(Color.orange);
            g.setFont(font2);
            g.drawString("You died at wave " + HUD.getWave(), Game.WIDTH / 2 - 140, 200);
            g.drawString("Score: " + hud.getScore(), Game.WIDTH / 2 - 70, 140);
            g.setColor(Color.white);
            g.drawRect(Game.WIDTH / 2 - 90, 222, 200, 60);
            g.setColor(Color.cyan);
            g.drawString("Menu", Game.WIDTH / 2 - 32, 260);

        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            }
        }

        return false;
    }
}

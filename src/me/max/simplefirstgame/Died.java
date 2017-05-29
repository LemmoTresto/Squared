package me.max.simplefirstgame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by max on 28-5-2017.
 */
public class Died extends MouseAdapter{

    Handler handler;
    HUD hud;
    Spawn spawner;
    boolean buttonpressed = false;
    int timer = 150;
    boolean waiter = true;
    Random r = new Random();

    public Died(Handler handler, HUD hud, Spawn spawner){
        this.handler = handler;
        this.hud = hud;
        this.spawner = spawner;

    }

    public void mousePressed(MouseEvent e) {
        if (Game.gameState == Game.STATE.Died) {
            if ((e.getButton() == 1)) {
                int mx = e.getX();
                int my = e.getY();
                if (mouseOver(mx, my, Game.WIDTH / 2 - 90, 222, 200, 60)){
                    buttonpressed = true;
                }
                else {
                    buttonpressed = false;
                }
            }

        }
    }

    public void mouseReleased(MouseEvent e){
        if (Game.gameState == Game.STATE.Died){
            int mx = e.getX();
            int my = e.getY();
            if (mouseOver(mx, my, Game.WIDTH / 2 - 90, 222, 200, 60) && (buttonpressed)) {
                Game.gameState = Game.STATE.Menu;
                handler.object.clear();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                spawner.done2 = true;
                spawner.done3 = true;
                buttonpressed = false;
            }

        }
    }

    public void tick(){
        if (Game.gameState == Game.STATE.Died){


        }
    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.Died) {
            Font font1 = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);
            g.setFont(font1);
            g.setColor(Color.red);
            handler.removeObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
            g.drawString("You died...", Game.WIDTH / 2 - 120, 50);
            g.setColor(Color.blue);
            g.drawRect(Game.WIDTH / 2 - 160, 100, 325, 200);
            g.setColor(Color.orange);
            g.setFont(font2);
            g.drawString("You died at wave " + hud.getLevel(), Game.WIDTH / 2 - 140, 200);
            g.drawString("Score: " + hud.getScore(), Game.WIDTH / 2 - 70, 140);
            g.setColor(Color.white);
            g.drawRect(Game.WIDTH / 2 - 90, 222, 200, 60);
            g.setColor(Color.cyan);
            g.drawString("Menu", Game.WIDTH / 2 - 32, 260);

        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            if (my > y && my < y + height){
                return true;
            }
        }

        return false;
    }
}

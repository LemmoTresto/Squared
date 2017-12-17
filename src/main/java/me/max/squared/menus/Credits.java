package me.max.squared.menus;

import me.max.squared.Game;
import me.max.squared.handlers.main.Handler;
import me.max.squared.handlers.others.Spawn;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by max on 28-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class Credits extends MouseAdapter {

    private Handler handler;
    private Spawn spawner;
    private Random r = new Random();
    private int y = 150;

    public Credits(Handler handler, Spawn spawner) {
        this.handler = handler;
        this.spawner = spawner;
    }

    public void mouseClicked(MouseEvent e) {
        if (Game.gameState == Game.STATE.Credits) {
            int mx = e.getX();
            int my = e.getY();
            if (mouseOver(mx, my, 32, 20, 23, 23)) {
                Game.gameState = Game.STATE.Menu;
            }
        }
    }

    public void tick() {
        if (Game.gameState == Game.STATE.Credits) {
            y--;
            if (y < -400) {
                y = Game.HEIGHT + 100;
            }
        }

    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.Credits) {
            //title
            Font font1 = new Font("arial", 1, 50);
            g.setFont(font1);
            g.setColor(Color.lightGray);
            g.drawString("Squared", Game.WIDTH / 2 - 93, y);

            //Back button
            g.setColor(Color.gray);
            //box
            //g.drawRect(32, 20, 23, 23);
            g.drawString("«", 30, 45);

            //text

            //developer
            Font font = new Font("arial", 1, 21);
            Font font2 = new Font("arial", 1, 13);
            g.setFont(font);
            g.setColor(Color.gray);
            g.drawString("Developer", Game.WIDTH / 2 - 46, y + 50);
            g.setColor(Color.white);
            g.setFont(font2);
            g.drawString("Max Berkelmans", Game.WIDTH / 2 - 49, y + 90);
            //line
            g.setColor(Color.darkGray);
            g.drawLine(Game.WIDTH / 2 - 120, y + 110, Game.WIDTH / 2 + 120, y + 110);

            //testers
            g.setColor(Color.gray);
            g.setFont(font);
            g.drawString("Testers", Game.WIDTH / 2 - 40, y + 140);
            g.setColor(Color.white);
            g.setFont(font2);
            g.drawString("Urix", Game.WIDTH / 2 - 20, y + 180);
            g.drawString("Aaron", Game.WIDTH / 2 - 25, y + 200);
            g.drawString("xTechno", Game.WIDTH / 2 - 35, y + 220);
            g.drawString("Scarsz", Game.WIDTH / 2 - 27, y + 240);
            g.drawString("David", Game.WIDTH / 2 - 24, y + 260);

            //g.drawString("Special credits for youtubers, testers and other people: Aaron, Urix, JJ, Techno, David and Scarsz", Game.WIDTH / 2 - 284, y + 160);
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

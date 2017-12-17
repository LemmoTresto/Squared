package me.max.squared.menus;

import me.max.squared.Game;
import me.max.squared.handlers.main.Handler;
import me.max.squared.handlers.others.HUD;
import me.max.squared.handlers.others.Spawn;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by max on 4-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class InGameShop extends MouseAdapter {

    public static Game.STATE currentLevel;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Color HealthUp;
    private Color HealthMaxed;
    private Color SkipWave;
    private Random r = new Random();

    public InGameShop(Handler handler, HUD hud, Spawn spawner) {
        this.handler = handler;
        this.hud = hud;
        this.spawner = spawner;

    }

    public void mouseClicked(MouseEvent e) {
        if (Game.gameState == Game.STATE.InGameShop) {
            if (e.getButton() == 1) {
                int mx = e.getX();
                int my = e.getY();
                if (mouseOver(mx, my, 100, 125, 135, 60)) {
                    if (HUD.coins >= 1) {
                        if (!(HUD.HEALTH == 100)) {
                            HUD.coins--;
                            HUD.HEALTH += 20;
                        }
                    }
                } else if (mouseOver(mx, my, 100, 250, 135, 60)) {
                    if (HUD.coins >= 3) {
                        if (!(HUD.HEALTH == 100)) {
                            HUD.coins -= 3;
                            HUD.HEALTH = 100;
                        }
                    }
                } else if (mouseOver(mx, my, 350, 125, 135, 60)) {
                    if (HUD.coins >= 4) {
                        if (currentLevel == Game.STATE.HardcoreMode) {
                            spawner.scoreKeep += 250;
                        } else
                            spawner.scoreKeep += 300;
                        HUD.coins -= 4;
                        Game.gameState = currentLevel;
                    }
                } else if (mouseOver(mx, my, 350, 250, 135, 60)) {
                    Game.gameState = currentLevel;
                }
            }
        }
    }

    public void tick() {
        if (Game.gameState == Game.STATE.InGameShop) {
            HUD.HEALTH = Game.clamp(HUD.HEALTH, 0, 100);
            if (HUD.coins >= 1) {
                HealthUp = Color.green;
            } else if (HUD.coins < 1) {
                HealthUp = Color.red;
            }
            if (HUD.coins >= 3) {
                HealthMaxed = Color.green;
            } else if (HUD.coins < 3) {
                HealthMaxed = Color.red;
            }
            if (HUD.coins >= 4) {
                SkipWave = Color.green;
            } else if (HUD.coins < 4) {
                SkipWave = Color.red;
            }
        }
    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.InGameShop) {

            //Title
            Font font = new Font("arial", 1, 50);
            g.setFont(font);
            g.setColor(Color.green);
            g.drawString("Shop", 265, 50);

            //Name font
            Font font2 = new Font("arial", 1, 25);

            //Cost font
            Font font3 = new Font("arial", 1, 15);

            //Health up by 10.
            //Box
            g.setColor(HealthUp);
            g.drawRect(100, 125, 135, 60);
            //Text
            g.setColor(Color.white);
            g.setFont(font2);
            g.drawString("Health +20", 105, 153);
            g.setFont(font3);
            g.drawString("1 Coins", 142, 177);

            //Health maxed out.
            //Box
            g.setColor(HealthMaxed);
            g.drawRect(100, 250, 135, 60);
            //Text
            g.setColor(Color.white);
            g.setFont(font2);
            g.drawString("Max HP", 125, 278);
            g.setFont(font3);
            g.drawString("3 Coins", 142, 302);

            //Skip wave
            //Box
            g.setColor(SkipWave);
            g.drawRect(350, 125, 135, 60);
            //Text
            g.setColor(Color.white);
            g.setFont(font2);
            g.drawString("Skip Wave", 357, 153);
            g.setFont(font3);
            g.drawString("4 Coins", 392, 177);

            //Back button
            //Box
            g.setColor(Color.blue);
            g.drawRect(350, 250, 135, 60);
            //Text
            g.setColor(Color.blue);
            g.setFont(font2);
            g.drawString("Back", 388, 288);

        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            return my > y && my < y + height;
        }

        return false;
    }
}

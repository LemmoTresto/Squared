package me.max.squared;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by max on 4-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class InGameShop extends MouseAdapter {

    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Color HealthUp;
    private Color HealthMaxed;
    private Color SkipWave;
    private boolean hpPlus10Pressed, BackPressed, SkipWavePressed, hpMaxPressed;
    private Random r = new Random();
    public static Game.STATE currentLevel;

    public InGameShop(Handler handler, HUD hud, Spawn spawner){
        this.handler = handler;
        this.hud = hud;
        this.spawner = spawner;

    }

    public void mousePressed(MouseEvent e) {
        if (Game.gameState == Game.STATE.InGameShop) {
            if (e.getButton() == 1) {
                int mx = e.getX();
                int my = e.getY();
                if (mouseOver(mx, my, 100, 125, 135, 60)){
                    hpPlus10Pressed = true;
                    hpMaxPressed = false;
                    BackPressed = false;
                    SkipWavePressed = false;
                } else if (mouseOver(mx, my, 100, 250, 135, 60)){
                    hpPlus10Pressed = false;
                    hpMaxPressed = true;
                    BackPressed = false;
                    SkipWavePressed = false;
                } else if (mouseOver(mx, my, 350, 125, 135, 60)){
                    hpPlus10Pressed = false;
                    hpMaxPressed = false;
                    BackPressed = false;
                    SkipWavePressed = true;
                } else if (mouseOver(mx, my, 350, 250, 135, 60)){
                    hpPlus10Pressed = false;
                    hpMaxPressed = false;
                    BackPressed = true;
                    SkipWavePressed = false;
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (Game.gameState == Game.STATE.InGameShop) {
            if (e.getButton() == 1) {
                int mx = e.getX();
                int my = e.getY();
                if ((mouseOver(mx, my, 100, 125, 135, 60)) && (hpPlus10Pressed)){
                    if (hud.coins >= 1){
                        if (!(hud.HEALTH == 100)) {
                            hud.coins--;
                            hud.HEALTH += 20;
                        }
                    }
                } else if ((mouseOver(mx, my, 100, 250, 135, 60)) && (hpMaxPressed)){
                    if (hud.coins >= 3){
                        if (!(hud.HEALTH == 100)){
                            hud.coins -= 3;
                            hud.HEALTH = 100;
                        }
                    }
                } else if ((mouseOver(mx, my, 350, 125, 135, 60)) && (SkipWavePressed)){
                    if (hud.coins >= 4) {
                        if (currentLevel == Game.STATE.HardcoreMode){
                            spawner.scoreKeep += 250;
                        } else
                            spawner.scoreKeep += 300;
                        hud.coins -= 4;
                        Game.gameState = currentLevel;
                    }
                } else if ((mouseOver(mx, my, 350, 250, 135, 60)) && (BackPressed)){
                    Game.gameState = currentLevel;
                }
            }
        }
    }

    public void tick(){
        if (Game.gameState == Game.STATE.InGameShop) {
            HUD.HEALTH = Game.clamp(HUD.HEALTH, 0, 100);
            if (hud.coins >= 1){
                HealthUp = Color.green;
            } else if (hud.coins < 1){
                HealthUp = Color.red;
            }
            if (hud.coins >= 3){
                HealthMaxed = Color.green;
            } else if (hud.coins < 3){
                HealthMaxed = Color.red;
            }
            if (hud.coins >= 4){
                SkipWave = Color.green;
            } else if (hud.coins < 4){
                SkipWave = Color.red;
            }
        }
    }

    public void render(Graphics g){
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

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            if (my > y && my < y + height){
                return true;
            }
        }

        return false;
    }
}

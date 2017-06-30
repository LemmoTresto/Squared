package me.max.squared;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class HUD extends MouseAdapter {

    public static float HEALTH = 100;
    public static int lives = 1;

    private float greenValue = 255;
    public int score = 0;
    public static int highScore;
    private int level = 1;
    public static int coins;
    private Handler handler;
    private boolean inGameShopPressed, pausePressed;
    public LinkedList<GameObject> object2 = new LinkedList<GameObject>();
    public static boolean shopEnabled = true;
    public static boolean immortal = false;

    public HUD(Handler handler){
        this.handler = handler;
    }


    public void mousePressed(MouseEvent e) {
        if (!(Game.gameState == Game.STATE.Menu) && !(Game.gameState == Game.STATE.InGameShop) && !(Game.gameState == Game.STATE.Help) && !(Game.gameState == Game.STATE.LevelChooser) && !(Game.gameState == Game.STATE.Died) && !(Game.gameState == Game.STATE.MenuShop) && !(Game.gameState == Game.STATE.WonLevel10) && !(Game.gameState == Game.STATE.WonLevel9) && !(Game.gameState == Game.STATE.WonLevel8) && !(Game.gameState == Game.STATE.WonLevel7) && !(Game.gameState == Game.STATE.WonLevel6) && !(Game.gameState == Game.STATE.WonLevel5) && !(Game.gameState == Game.STATE.WonLevel4) && !(Game.gameState == Game.STATE.WonLevel3) && !(Game.gameState == Game.STATE.WonLevel2) && !(Game.gameState == Game.STATE.WonLevel1) ) {
            if (e.getButton() == 1) {
                int mx = e.getX();
                int my = e.getY();
                if (mouseOver(mx, my, Game.WIDTH - 150, Game.HEIGHT - 90, 135, 50)) {
                    inGameShopPressed = true;
                    pausePressed = false;
                }
                if (mouseOver(mx, my, 540, 12 , 23, 25)){
                    inGameShopPressed = false;
                    pausePressed = true;
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (!(Game.gameState == Game.STATE.Menu) && !(Game.gameState == Game.STATE.PauseScreen) && !(Game.gameState == Game.STATE.InGameShop) && !(Game.gameState == Game.STATE.Help) && !(Game.gameState == Game.STATE.LevelChooser) && !(Game.gameState == Game.STATE.Died) && !(Game.gameState == Game.STATE.MenuShop) && !(Game.gameState == Game.STATE.WonLevel10) && !(Game.gameState == Game.STATE.WonLevel9) && !(Game.gameState == Game.STATE.WonLevel8) && !(Game.gameState == Game.STATE.WonLevel7) && !(Game.gameState == Game.STATE.WonLevel6) && !(Game.gameState == Game.STATE.WonLevel5) && !(Game.gameState == Game.STATE.WonLevel4) && !(Game.gameState == Game.STATE.WonLevel3) && !(Game.gameState == Game.STATE.WonLevel2) && !(Game.gameState == Game.STATE.WonLevel1) ) {
            if (e.getButton() == 1) {
                int mx = e.getX();
                int my = e.getY();
                if ((mouseOver(mx, my, Game.WIDTH - 150, Game.HEIGHT - 90, 135, 50)) && (inGameShopPressed)) {
                    Game.gameState = Game.STATE.InGameShop;
                    inGameShopPressed = false;
                }
                if ((mouseOver(mx, my, 540, 12 , 23, 25)) && (pausePressed)){
                    Game.gameState = Game.STATE.PauseScreen;
                    pausePressed = false;
                }
            }
        }
    }

    public void tick() {

        if (!(Game.gameState == Game.STATE.Menu) && !(Game.gameState == Game.STATE.InGameShop) && !(Game.gameState == Game.STATE.PauseScreen) && !(Game.gameState == Game.STATE.Help) && !(Game.gameState == Game.STATE.MenuShop) && !(Game.gameState == Game.STATE.LevelChooser) && !(Game.gameState == Game.STATE.Died) && !(Game.gameState == Game.STATE.WonLevel1) && !(Game.gameState == Game.STATE.WonLevel2) && !(Game.gameState == Game.STATE.WonLevel3) && !(Game.gameState == Game.STATE.WonLevel4) && !(Game.gameState == Game.STATE.WonLevel5) && !(Game.gameState == Game.STATE.WonLevel6) && !(Game.gameState == Game.STATE.WonLevel7) && !(Game.gameState == Game.STATE.WonLevel8) && !(Game.gameState == Game.STATE.WonLevel9) && !(Game.gameState == Game.STATE.WonLevel10)) {
            HEALTH = Game.clamp((int) HEALTH, 0, 100);
            greenValue = Game.clamp(greenValue, 0, 255);

            greenValue = (int) HEALTH * 2;
            score++;
            if (HEALTH <= 0) {
                if (lives <= 1) {
                    if (MenuShop.purchasedUpgrades.contains(MenuShop.StoreUpgrades.ExtraLife_1)){
                        lives = 2;
                    } else {
                        lives = 1;
                    }
                    if (Game.gameState == Game.STATE.HardcoreMode) {
                        if (highScore < score) {
                            highScore = score;
                        }
                    }
                    Game.gameState = Game.STATE.Died;
                    EffectHandler.object.clear();
                    for (int i = 0; i < handler.object.size(); i++) {
                        GameObject tempObject = handler.object.get(i);
                        if (tempObject.getId() == ID.Player) {
                            handler.object.remove(i);
                            HEALTH = 100;
                            break;
                        }
                    }
                    shopEnabled = true;
                } else {
                    lives --;
                    HEALTH = 100;
                }
            }
        }
        if (Game.gameState == Game.STATE.Level1 || Game.gameState == Game.STATE.Level2 || Game.gameState == Game.STATE.Level3 || Game.gameState == Game.STATE.Level4 || Game.gameState == Game.STATE.Level5 || Game.gameState == Game.STATE.Level6 || Game.gameState == Game.STATE.Level7 || Game.gameState == Game.STATE.Level8 || Game.gameState == Game.STATE.Level9 || Game.gameState == Game.STATE.Level10 || Game.gameState == Game.STATE.InGameShop){
            if (EffectHandler.object.isEmpty()) {
                if (EffectHandler.object.contains(EffectHandler.EFFECT.ForceField)) {
                    immortal = true;
                } else {
                    immortal = false;
                }
            }
        }
    }

    public void render(Graphics g2){
        if (!(Game.gameState == Game.STATE.Menu) && !(Game.gameState == Game.STATE.MenuShop) && !(Game.gameState == Game.STATE.Help) && !(Game.gameState == Game.STATE.LevelChooser) && !(Game.gameState == Game.STATE.Died) && !(Game.gameState == Game.STATE.WonLevel1) && !(Game.gameState == Game.STATE.WonLevel2) && !(Game.gameState == Game.STATE.WonLevel3) && !(Game.gameState == Game.STATE.WonLevel4) && !(Game.gameState == Game.STATE.WonLevel5) && !(Game.gameState == Game.STATE.WonLevel6) && !(Game.gameState == Game.STATE.WonLevel7) && !(Game.gameState == Game.STATE.WonLevel8) && !(Game.gameState == Game.STATE.WonLevel9) && !(Game.gameState == Game.STATE.WonLevel10)) {

            float alpha = 0.4f;
            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            Graphics2D g = (Graphics2D) g2.create();
            if (Game.gameState == Game.STATE.PauseScreen){
                g.setComposite(alcom);
            }

            g.setColor(Color.gray);
            g.fillRect(15, 15, 200, 32);
            g.setColor(new Color(75, (int) greenValue, 0));
            g.fillRect(15, 15, (int) HEALTH * 2, 32);
            g.setColor(Color.white);
            g.drawRect(15, 15, 200, 32);

            g.drawString("Score: " + score, 15, 64);
            g.drawString("Wave: " + level, 15, 78);
            g.drawString("Coins: " + coins, 15, 92);
            g.drawString("Lives: " + lives, 15, 106);

            if (!(Game.gameState == Game.STATE.Menu) && !(Game.gameState == Game.STATE.InGameShop) && !(Game.gameState == Game.STATE.Help) && !(Game.gameState == Game.STATE.MenuShop) && !(Game.gameState == Game.STATE.LevelChooser) && !(Game.gameState == Game.STATE.Died) && !(Game.gameState == Game.STATE.WonLevel1) && !(Game.gameState == Game.STATE.WonLevel2) && !(Game.gameState == Game.STATE.WonLevel3) && !(Game.gameState == Game.STATE.WonLevel4) && !(Game.gameState == Game.STATE.WonLevel5) && !(Game.gameState == Game.STATE.WonLevel6) && !(Game.gameState == Game.STATE.WonLevel7) && !(Game.gameState == Game.STATE.WonLevel8) && !(Game.gameState == Game.STATE.WonLevel9) && !(Game.gameState == Game.STATE.WonLevel10)) {
                if (shopEnabled) {
                    g.setColor(Color.white);
                    g.drawRect(Game.WIDTH - 150, Game.HEIGHT - 90, 135, 50);
                    g.setColor(Color.green);
                    Font font = new Font("arial", 1, 35);
                    g.setFont(font);
                    g.drawString("Shop", Game.WIDTH - 123, Game.HEIGHT - 55);
                }
            }
            //PAUSE BUTTON!
            g.setColor(Color.gray);
            g.fillRect(540, 12, 5, 25);
            g.fillRect(553, 12, 5, 25);
            //Button box.
            //g.fillRect(540, 12 , 23, 25);

            if (Game.gameState == Game.STATE.PauseScreen) {
            }

        }
    }

    public void score(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
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

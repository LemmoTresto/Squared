package me.max.simplefirstgame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by max on 28-5-2017.
 */
public class onWin extends MouseAdapter{

    private Handler handler;
    private HUD hud;
    private boolean nextLevelPressed = false;
    private boolean menuPressed = false;

    public onWin(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void mousePressed(MouseEvent e) {
        if ((Game.gameState == Game.STATE.WonLevel1) || (Game.gameState == Game.STATE.WonLevel2) || (Game.gameState == Game.STATE.WonLevel3) || (Game.gameState == Game.STATE.WonLevel4) || (Game.gameState == Game.STATE.WonLevel5) || (Game.gameState == Game.STATE.WonLevel6) || (Game.gameState == Game.STATE.WonLevel7) || (Game.gameState == Game.STATE.WonLevel8) || (Game.gameState == Game.STATE.WonLevel9)) {
            int mx = e.getX();
            int my = e.getY();
            if (e.getButton() == 1){
                //Next level button
                if (mouseOver(mx, my, Game.WIDTH / 2 - 90, 152, 200, 60)){
                    nextLevelPressed = true;
                    menuPressed = false;
                }
                //Menu button
                else if (mouseOver(mx, my, Game.WIDTH / 2 - 90, 222, 200, 60)){
                    menuPressed = true;
                    nextLevelPressed = false;
                }
            }

        } else if (!(Game.gameState == Game.STATE.WonLevel1) && !(Game.gameState == Game.STATE.WonLevel2) && !(Game.gameState == Game.STATE.WonLevel3) && !(Game.gameState == Game.STATE.WonLevel4) && !(Game.gameState == Game.STATE.WonLevel5) && !(Game.gameState == Game.STATE.WonLevel6) && !(Game.gameState == Game.STATE.WonLevel7) && !(Game.gameState == Game.STATE.WonLevel8) && !(Game.gameState == Game.STATE.WonLevel9)) {
            int mx = e.getX();
            int my = e.getY();
            if (e.getButton() == 1){
                //Next level button
                //if (mouseOver(mx, my, Game.WIDTH / 2 - 90, 152, 200, 60)){
                //    nextLevelPressed = true;
                //    menuPressed = false;
                //}
                //Menu button
                //else if (mouseOver(mx, my, Game.WIDTH / 2 - 90, 222, 200, 60)){
                //    menuPressed = true;
                //    nextLevelPressed = false;
                //}
            }

        }
    }

    public void mouseReleased(MouseEvent e) {
        if ((Game.gameState == Game.STATE.WonLevel1) || (Game.gameState == Game.STATE.WonLevel2) || (Game.gameState == Game.STATE.WonLevel3) || (Game.gameState == Game.STATE.WonLevel4) || (Game.gameState == Game.STATE.WonLevel5) || (Game.gameState == Game.STATE.WonLevel6) || (Game.gameState == Game.STATE.WonLevel7) || (Game.gameState == Game.STATE.WonLevel8) || (Game.gameState == Game.STATE.WonLevel9)) {
            if (e.getButton() == 1) {
                int mx = e.getX();
                int my = e.getY();
                if ((mouseOver(mx, my, Game.WIDTH / 2 - 90, 152, 200, 60)) && (nextLevelPressed)) {
                    nextLevelPressed = false;
                    menuPressed = false;
                    if (Game.gameState == Game.STATE.WonLevel1){
                        Game.gameState = Game.STATE.Level2;
                    } else if (Game.gameState == Game.STATE.WonLevel2){
                        Game.gameState = Game.STATE.Level3;
                    } else if (Game.gameState == Game.STATE.WonLevel3){
                        Game.gameState = Game.STATE.Level4;
                    } else if (Game.gameState == Game.STATE.WonLevel4){
                        Game.gameState = Game.STATE.Level5;
                    } else if (Game.gameState == Game.STATE.WonLevel5){
                        Game.gameState = Game.STATE.Level6;
                    } else if (Game.gameState == Game.STATE.WonLevel6){
                        Game.gameState = Game.STATE.Level7;
                    } else if (Game.gameState == Game.STATE.WonLevel7){
                        Game.gameState = Game.STATE.Level8;
                    } else if (Game.gameState == Game.STATE.WonLevel8){
                        Game.gameState = Game.STATE.Level9;
                    } else if (Game.gameState == Game.STATE.WonLevel9) {
                        Game.gameState = Game.STATE.Level10;
                    }

                } else if ((mouseOver(mx, my, Game.WIDTH / 2 - 90, 222, 200, 60)) && (menuPressed)) {
                    menuPressed = false;
                    nextLevelPressed = false;
                    Game.gameState = Game.STATE.Menu;
                }
            }
        } else if (!(Game.gameState == Game.STATE.WonLevel1) && !(Game.gameState == Game.STATE.WonLevel2) && !(Game.gameState == Game.STATE.WonLevel3) && !(Game.gameState == Game.STATE.WonLevel4) && !(Game.gameState == Game.STATE.WonLevel5) && !(Game.gameState == Game.STATE.WonLevel6) && !(Game.gameState == Game.STATE.WonLevel7) && !(Game.gameState == Game.STATE.WonLevel8) && !(Game.gameState == Game.STATE.WonLevel9)) {

        }
    }

    public void tick(){
        if ((Game.gameState == Game.STATE.WonLevel1) || (Game.gameState == Game.STATE.WonLevel2) || (Game.gameState == Game.STATE.WonLevel3) || (Game.gameState == Game.STATE.WonLevel4) || (Game.gameState == Game.STATE.WonLevel5) || (Game.gameState == Game.STATE.WonLevel6) || (Game.gameState == Game.STATE.WonLevel7) || (Game.gameState == Game.STATE.WonLevel8) || (Game.gameState == Game.STATE.WonLevel9)) {


        }
    }

    public void render(Graphics g) {
            if ((Game.gameState == Game.STATE.WonLevel1) || (Game.gameState == Game.STATE.WonLevel2) || (Game.gameState == Game.STATE.WonLevel3) || (Game.gameState == Game.STATE.WonLevel4) || (Game.gameState == Game.STATE.WonLevel5) || (Game.gameState == Game.STATE.WonLevel6) || (Game.gameState == Game.STATE.WonLevel7) || (Game.gameState == Game.STATE.WonLevel8) || (Game.gameState == Game.STATE.WonLevel9)) {
                Font font1 = new Font("arial", 1, 50);
                Font font2 = new Font("arial", 1, 30);
                g.setFont(font1);
                g.setColor(Color.green);
                g.drawString("You've Won!", Game.WIDTH / 2 - 140, 50);
                g.setColor(Color.blue);
                g.drawRect(Game.WIDTH / 2 - 160, 100, 325, 200);
                g.setColor(Color.orange);
                g.setFont(font2);
                g.drawString("You completed level " + getLevel(), Game.WIDTH / 2 - 147, 135);
                g.setColor(Color.white);
                g.drawRect(Game.WIDTH / 2 - 90, 222, 200, 60);
                g.drawRect(Game.WIDTH / 2 - 90, 152, 200, 60);
                g.setColor(Color.cyan);
                g.drawString("Menu", Game.WIDTH / 2 - 28, 260);
                g.drawString("Next Level", Game.WIDTH / 2 - 60, 190);
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

    private int getLevel() {
        if (Game.gameState == Game.STATE.WonLevel1) {
            return 1;
        } else if (Game.gameState == Game.STATE.WonLevel2) {
            return 2;
        } else if (Game.gameState == Game.STATE.WonLevel3) {
            return 3;
        } else if (Game.gameState == Game.STATE.WonLevel4) {
            return 4;
        } else if (Game.gameState == Game.STATE.WonLevel5) {
            return 5;
        } else if (Game.gameState == Game.STATE.WonLevel6) {
            return 6;
        } else if (Game.gameState == Game.STATE.WonLevel7) {
            return 7;
        } else if (Game.gameState == Game.STATE.WonLevel8) {
            return 8;
        } else if (Game.gameState == Game.STATE.WonLevel9) {
            return 9;
        } else if (Game.gameState == Game.STATE.WonLevel10) {
            return 10;
        }

        return 101;

    }
}

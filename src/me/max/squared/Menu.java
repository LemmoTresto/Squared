package me.max.squared;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by max on 28-5-2017.
 */
public class Menu extends MouseAdapter{

    private boolean mouseHasBeenPressed, mouse2HasBeenPressed, storePressed, helpPressed;
    private int highscoreX;

    public void mousePressed(MouseEvent e) {
        if (Game.gameState == Game.STATE.Menu) {
            if ((e.getButton() == 1)) {
                int mx = e.getX();
                int my = e.getY();
                if (mouseOver(mx, my, Game.WIDTH / 2 - 75, 85, 150, 70)) {
                    mouseHasBeenPressed = true;
                    mouse2HasBeenPressed = false;
                    storePressed = false;
                    helpPressed = false;
                }
                if (mouseOver(mx, my, Game.WIDTH / 2 - 75, 285, 150, 70)) {
                    mouseHasBeenPressed = false;
                    mouse2HasBeenPressed = true;
                    storePressed = false;
                    helpPressed = false;
                }
                if (mouseOver(mx, my, Game.WIDTH / 2 - 307, 195, 150, 70)){
                    mouse2HasBeenPressed = false;
                    mouse2HasBeenPressed = false;
                    storePressed = true;
                    helpPressed = false;
                }
                if (mouseOver(mx, my, Game.WIDTH - 168, 195, 150, 70)){
                    mouse2HasBeenPressed = false;
                    mouse2HasBeenPressed = false;
                    storePressed = false;
                    helpPressed = true;
                }
            }

        }
    }

    public void mouseReleased(MouseEvent e){
        if (Game.gameState == Game.STATE.Menu){
            int mx =e.getX();
            int my =e.getY();
            if ((mouseOver(mx, my, Game.WIDTH / 2 - 75, 85, 150, 70)) && (mouseHasBeenPressed)) {
                mouseHasBeenPressed = false;
                mouse2HasBeenPressed = false;
                helpPressed = false;
                storePressed = false;
                Game.gameState = Game.STATE.LevelChooser;
            }
            if ((mouseOver(mx, my, Game.WIDTH / 2 - 75, 285, 150, 70))  && (mouse2HasBeenPressed)) {
                mouse2HasBeenPressed = false;
                mouseHasBeenPressed = false;
                helpPressed = false;
                storePressed = false;
                System.exit(1);
            }

            if ((mouseOver(mx, my, Game.WIDTH / 2 - 307, 195, 150, 70)) && (storePressed)){
                mouse2HasBeenPressed = false;
                mouseHasBeenPressed = false;
                storePressed = false;
                helpPressed = false;
                Game.gameState = Game.STATE.MenuShop;
            }
            if ((mouseOver(mx, my, Game.WIDTH - 168, 195, 150, 70)) && (helpPressed)){
                mouse2HasBeenPressed = false;
                mouseHasBeenPressed = false;
                storePressed = false;
                helpPressed = false;
                Game.gameState = Game.STATE.Help;
            }

        }
    }

    public void tick(){
        if (Game.gameState == Game.STATE.Menu){

        }
    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.Menu) {
            Font font = new Font("arial", 1, 50);
            g.setFont(font);
            g.setColor(Color.darkGray);
            g.drawString("Squared!", Game.WIDTH / 2 - 109, 60);
            g.setColor(Color.white);
            Font font2 = new Font("arial", 1, 15);
            g.setFont(font2);
            g.drawString("Hardcore highscore: " + HUD.highScore, Game.WIDTH / 2 - 100, 85);
            g.setColor(Color.blue);
            g.setFont(font);
            g.drawRect(Game.WIDTH / 2 - 75, 105, 150, 70);
            g.drawString("Start", Game.WIDTH / 2 - 57, 154);
            g.setColor(Color.cyan);
            g.drawRect(Game.WIDTH / 2 - 110, 195, 220, 70);
            g.drawString("Options", Game.WIDTH / 2 - 95, 244);
            g.setColor(Color.red);
            g.drawRect(Game.WIDTH / 2 - 75, 285, 150, 70);
            g.drawString("Quit", Game.WIDTH / 2 - 55, 339);
            g.setColor(Color.white);
            g.drawRect(Game.WIDTH / 2 - 307, 195, 150, 70);
            g.setColor(Color.green);
            g.drawString("Store", Game.WIDTH / 2 - 295, 246);
            g.setColor(Color.white);
            g.drawRect(Game.WIDTH - 168, 195, 150, 70);
            g.setColor(Color.blue);
            g.drawString("Help", Game.WIDTH - 150, 246);
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

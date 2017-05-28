package me.max.simplefirstgame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by max on 28-5-2017.
 */
public class Menu extends MouseAdapter{

    private boolean mouseHasBeenPressed;
    private boolean mouse2HasBeenPressed;

    public void mousePressed(MouseEvent e) {
        if (Game.gameState == Game.STATE.Menu) {
            if ((e.getButton() == 1)) {
                int mx = e.getX();
                int my = e.getY();
                if (mouseOver(mx, my, Game.WIDTH / 2 - 75, 85, 150, 70)) {
                    mouseHasBeenPressed = true;
                    mouse2HasBeenPressed = false;
                }
                if (mouseOver(mx, my, Game.WIDTH / 2 - 75, 285, 150, 70)) {
                    mouseHasBeenPressed = false;
                    mouse2HasBeenPressed = true;
                }
            }

        }
    }

    public void mouseReleased(MouseEvent e){
        if (Game.gameState == Game.STATE.Menu){
            int mx =e.getX();
            int my =e.getY();
            if ((mouseOver(mx, my, Game.WIDTH / 2 - 75, 85, 150, 70)) && (mouseHasBeenPressed)) {
                Game.gameState = Game.STATE.LevelChooser;
                mouseHasBeenPressed = false;
                mouse2HasBeenPressed = false;
            }
            if ((mouseOver(mx, my, Game.WIDTH / 2 - 75, 285, 150, 70))  && (mouse2HasBeenPressed)) {
                mouse2HasBeenPressed = false;
                mouseHasBeenPressed = false;
                System.exit(1);
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
            g.drawString("RectDodge!", Game.WIDTH / 2 - 135, 60);
            g.setColor(Color.blue);
            g.drawRect(Game.WIDTH / 2 - 75, 105, 150, 70);
            g.drawString("Start", Game.WIDTH / 2 - 57, 154);
            g.setColor(Color.cyan);
            g.drawRect(Game.WIDTH / 2 - 110, 195, 220, 70);
            g.drawString("Options", Game.WIDTH / 2 - 95, 244);
            g.setColor(Color.red);
            g.drawRect(Game.WIDTH / 2 - 75, 285, 150, 70);
            g.drawString("Quit", Game.WIDTH / 2 - 55, 339);
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

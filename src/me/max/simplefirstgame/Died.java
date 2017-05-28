package me.max.simplefirstgame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by max on 28-5-2017.
 */
public class Died extends MouseAdapter{

    Handler handler;

    public Died(Handler handler){
        this.handler = handler;

    }

    public void mousePressed(MouseEvent e) {
        if (Game.gameState == Game.STATE.Died) {
            if ((e.getButton() == 1)) {

            }

        }
    }

    public void mouseReleased(MouseEvent e){
        if (Game.gameState == Game.STATE.Died){

        }
    }

    public void tick(){
        if (Game.gameState == Game.STATE.Died){


        }
    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.Died) {
            Font font1 = new Font("arial", 1, 50);
            g.setFont(font1);
            g.setColor(Color.red);
            handler.removeObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
            g.drawString("You died...", Game.WIDTH / 2 - 120, 50);

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

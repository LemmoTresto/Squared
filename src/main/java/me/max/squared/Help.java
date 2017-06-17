package me.max.squared;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by max on 28-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class Help extends MouseAdapter{

    private Handler handler;
    private Spawn spawner;
    private boolean isBackPressed, level1pressed, level2pressed, level3pressed, level4pressed, level5pressed, level6pressed, level7pressed, level8pressed, level9pressed, level10pressed, hardcorePressed;
    private Random r = new Random();

    public Help(Handler handler, Spawn spawner){
        this.handler = handler;
        this.spawner = spawner;
    }

    public void mousePressed(MouseEvent e){
        if (Game.gameState == Game.STATE.Help) {
            if ((e.getButton() == 1)) {
                int mx = e.getX();
                int my = e.getY();

                //back button
                if (mouseOver(mx, my, 32, 20, 23, 23)) {
                    isBackPressed = true;
                    hardcorePressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level1pressed = false;
                }

            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (Game.gameState == Game.STATE.Help) {
            int mx = e.getX();
            int my = e.getY();

            if ((mouseOver(mx, my, 32, 20, 23, 23)) && (isBackPressed)){
                Game.gameState = Game.STATE.Menu;
                isBackPressed = false;
                level1pressed = false;
                level2pressed = false;
                level3pressed = false;
                level4pressed = false;
                level5pressed = false;
                level6pressed = false;
                level7pressed = false;
                level8pressed = false;
                level9pressed = false;
                level10pressed = false;


            }
        }
    }

    public void tick(){
        if (Game.gameState == Game.STATE.Help) {
            //nothing to tick
        }

    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.Help) {
            //title
            Font font1 = new Font("arial", 1, 50);
            g.setFont(font1);
            g.setColor(Color.lightGray);
            g.drawString("Help", Game.WIDTH / 2 - 65, 60);

            //Back button
            g.setColor(Color.gray);
            //box
            //g.drawRect(32, 20, 23, 23);
            g.drawString("«", 30, 45);

            //text
            Font font = new Font("arial", 1, 12);
            g.setFont(font);
            g.setColor(Color.white);
            g.drawString("Welcome to Squared!", Game.WIDTH / 2 - 75, 100);
            g.drawString("This game was made by:", Game.WIDTH / 2 - 85, 120);
            g.drawString("Max Berkelmans | LemmoTresto | NiCe1GuN | Hobo | Elmo | MaxiMiniJaniJos", Game.WIDTH / 2 - 230, 140);
            g.drawString("Special credits for youtubers, testers and other people: Aaron, Urix and JJ", Game.WIDTH / 2 - 225, 160);

            g.setFont(font1);
            g.setColor(Color.gray);
            g.drawString("Goal", Game.WIDTH / 2 - 65, 225);
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString("The aim/goal of this game is to complete all levels,", Game.WIDTH / 2 - 150, 265);
            g.drawString("in all worlds, you do this by dodging enemies in each level.", Game.WIDTH / 2 - 172, 285);
            g.drawString("You can unlock new skins and upgrades by picking up coins which randomly spawn in each level.", Game.WIDTH / 2 - 275, 305);
            g.drawString("There is also hardcore mode. This mode has no ending try to get the highest score in the world!", Game.WIDTH / 2 - 275, 325);

            //Copyright stuff
            Font font3 = new Font("arial", 1, 15);
            g.setFont(font3);
            g.setColor(Color.white);
            g.drawString("© Copyright 2017 Max Berkelmans", 10, Game.HEIGHT - 40);

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

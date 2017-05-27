package me.max.simplefirstgame;

import java.awt.*;


/**
 * Created by max on 25-5-2017.
 */
public class HUD {

    public static float HEALTH = 100;

    private float greenValue = 255;
    private int score = 0;
    private int level = 1;

    public void tick(){
        HEALTH = Game.clamp((int) HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);

        greenValue = (int) HEALTH * 2;
        score ++;
    }

    public void render(Graphics g, boolean ComesFromFPS, int FPS){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75, (int) greenValue, 0));
        g.fillRect(15, 15, (int) HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 78);
        g.drawString("FPS: " + FPS, 15, 120);
        if (ComesFromFPS){
            System.out.println("RECEIVED!");
            g.drawString("FPS: " + FPS, 15, 92);

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
}

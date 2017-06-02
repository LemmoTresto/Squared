package me.max.simplefirstgame;

import java.awt.*;


/**
 * Created by max on 25-5-2017.
 */
public class HUD {

    public static float HEALTH = 100;

    private float greenValue = 255;
    public int score = 0;
    private int level = 1;
    private Handler handler;

    public HUD(Handler handler){
        this.handler = handler;
    }

    public void tick() {
        if (!(Game.gameState == Game.STATE.Menu) && !(Game.gameState == Game.STATE.LevelChooser) && !(Game.gameState == Game.STATE.Died) && !(Game.gameState == Game.STATE.WonLevel1) && !(Game.gameState == Game.STATE.WonLevel2) && !(Game.gameState == Game.STATE.WonLevel3) && !(Game.gameState == Game.STATE.WonLevel4) && !(Game.gameState == Game.STATE.WonLevel5) && !(Game.gameState == Game.STATE.WonLevel6) && !(Game.gameState == Game.STATE.WonLevel7) && !(Game.gameState == Game.STATE.WonLevel8) && !(Game.gameState == Game.STATE.WonLevel9) && !(Game.gameState == Game.STATE.WonLevel10)) {
            HEALTH = Game.clamp((int) HEALTH, 0, 100);
            greenValue = Game.clamp(greenValue, 0, 255);

            greenValue = (int) HEALTH * 2;
            score++;
            if (HEALTH <= 0){
                Game.gameState = Game.STATE.Died;
                for (int i = 0; i < handler.object.size(); i++){
                    GameObject tempObject = handler.object.get(i);
                    HEALTH = 100;
                    if (tempObject.getId() == ID.Player){
                        handler.object.remove(i);
                        break;
                    }
                }
            }
        }
    }

    public void render(Graphics g){
        if (!(Game.gameState == Game.STATE.Menu) && !(Game.gameState == Game.STATE.LevelChooser) && !(Game.gameState == Game.STATE.Died) && !(Game.gameState == Game.STATE.WonLevel1) && !(Game.gameState == Game.STATE.WonLevel2) && !(Game.gameState == Game.STATE.WonLevel3) && !(Game.gameState == Game.STATE.WonLevel4) && !(Game.gameState == Game.STATE.WonLevel5) && !(Game.gameState == Game.STATE.WonLevel6) && !(Game.gameState == Game.STATE.WonLevel7) && !(Game.gameState == Game.STATE.WonLevel8) && !(Game.gameState == Game.STATE.WonLevel9) && !(Game.gameState == Game.STATE.WonLevel10)) {
            g.setColor(Color.gray);
            g.fillRect(15, 15, 200, 32);
            g.setColor(new Color(75, (int) greenValue, 0));
            g.fillRect(15, 15, (int) HEALTH * 2, 32);
            g.setColor(Color.white);
            g.drawRect(15, 15, 200, 32);

            g.drawString("Score: " + score, 15, 64);
            g.drawString("Wave: " + level, 15, 78);
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

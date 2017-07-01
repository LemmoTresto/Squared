package me.max.squared.effects;

import me.max.squared.Game;
import me.max.squared.handlers.others.HUD;
import me.max.squared.enums.ID;
import me.max.squared.handlers.main.EffectHandler;

import java.awt.*;

/**
 * Created by max on 23-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class SpeedEffect extends GameEffect {


    private int timer = 10;
    private int maxTimed = 0;
    private boolean isFlashed = false;
    private int timer2 = 15;

    private float x2;
    private EffectHandler effectHandler;

    public SpeedEffect(float x, HUD hud, ID id, EffectHandler effectHandler) {
        super(x, hud, id);

        this.effectHandler = effectHandler;
    }

    public void tick(){
        if (Game.gameState == Game.STATE.Level1 || Game.gameState == Game.STATE.Level2 || Game.gameState == Game.STATE.Level3 || Game.gameState == Game.STATE.Level4 || Game.gameState == Game.STATE.Level5 || Game.gameState == Game.STATE.Level6 || Game.gameState == Game.STATE.Level7 || Game.gameState == Game.STATE.Level8 || Game.gameState == Game.STATE.Level9 || Game.gameState == Game.STATE.Level10) {
            if (maxTimed >= 20){
                timer2--;
                if (timer2 <= 0){
                    timer2 = 15;
                    if (isFlashed){
                        isFlashed = false;
                    } else {
                        isFlashed = true;
                    }
                }
            }

            if (timer <= 0) {
                if (maxTimed != 25) {
                    if (hud.HEALTH < 100) {
                        HUD.HEALTH += 2;
                    }
                    maxTimed++;
                    timer = 30;
                }
                if (maxTimed >= 25){
                    effectHandler.removeEffect(this);
                }
            } else {
                timer--;
            }
        } else if (Game.gameState == Game.STATE.InGameShop) {
            //Do nothing ;)
        } else {
            effectHandler.removeEffect(this);
            // remove myself because I don't wanna be loaded in menu...
        }
        x = x2 + 5;
    }

    public void render(Graphics g2) {
        //The eh heart and more as HUD and more...!
        //use a static number * length of the currenteffect array. to make a easy way of adding these icons!
        if (!isFlashed) {
            if (Game.gameState == Game.STATE.Level1 || Game.gameState == Game.STATE.Level2 || Game.gameState == Game.STATE.Level3 || Game.gameState == Game.STATE.Level4 || Game.gameState == Game.STATE.Level5 || Game.gameState == Game.STATE.Level6 || Game.gameState == Game.STATE.Level7 || Game.gameState == Game.STATE.Level8 || Game.gameState == Game.STATE.Level9 || Game.gameState == Game.STATE.Level10) {

                float alpha = 0.4f;
                AlphaComposite alcom = AlphaComposite.getInstance(
                        AlphaComposite.SRC_OVER, alpha);
                Graphics2D g = (Graphics2D) g2.create();
                if (Game.gameState == Game.STATE.PauseScreen){
                    g.setComposite(alcom);
                }

                //Outside of icon
                x2 = x - 5;
                g.setColor(Color.darkGray);
                g.drawRect((int) x2, Game.HEIGHT - 76, 30, 30);

                //The heart in the icon.
                float y = Game.HEIGHT - 62;
                g.setColor(new Color(255, 193, 40));
                x += 5;

                //Making a nice lightning strike
                //first row // main row
                g.fillRect((int) x, (int) y, 1, 1);
                g.fillRect((int) x + 1, (int) y, 1, 1);
                g.fillRect((int) x + 2, (int) y, 1, 1);
                g.fillRect((int) x + 3, (int) y, 1, 1);
                g.fillRect((int) x + 4, (int) y, 1, 1);
                g.fillRect((int) x + 5, (int) y, 1, 1);
                g.fillRect((int) x + 6, (int) y, 1, 1);
                g.fillRect((int) x + 7, (int) y, 1, 1);
                g.fillRect((int) x + 8, (int) y, 1, 1);
                g.fillRect((int) x + 9, (int) y, 1, 1);
                g.fillRect((int) x + 10, (int) y, 1, 1);

                //GOING UP!!

                //second row
                g.fillRect((int) x + 1, (int) y - 1, 1, 1);
                g.fillRect((int) x + 2, (int) y - 1, 1, 1);
                g.fillRect((int) x + 3, (int) y - 1, 1, 1);
                g.fillRect((int) x + 4, (int) y - 1, 1, 1);
                g.fillRect((int) x + 5, (int) y - 1, 1, 1);
                g.fillRect((int) x + 6, (int) y - 1, 1, 1);
                g.fillRect((int) x + 7, (int) y - 1, 1, 1);
                g.fillRect((int) x + 8, (int) y - 1, 1, 1);
                g.fillRect((int) x + 9, (int) y - 1, 1, 1);
                g.fillRect((int) x + 10, (int) y - 1, 1, 1);
                g.fillRect((int) x + 11, (int) y - 1, 1, 1);

                //third row
                g.fillRect((int) x + 2, (int) y - 2, 1, 1);
                g.fillRect((int) x + 3, (int) y - 2, 1, 1);
                g.fillRect((int) x + 4, (int) y - 2, 1, 1);
                g.fillRect((int) x + 5, (int) y - 2, 1, 1);

                //fourth row
                g.fillRect((int) x + 3, (int) y - 3, 1, 1);
                g.fillRect((int) x + 4, (int) y - 3, 1, 1);
                g.fillRect((int) x + 5, (int) y - 3, 1, 1);
                g.fillRect((int) x + 6, (int) y - 3, 1, 1);
                g.fillRect((int) x + 7, (int) y - 3, 1, 1);

                //fifth row
                g.fillRect((int) x + 4, (int) y - 4, 1, 1);
                g.fillRect((int) x + 5, (int) y - 4, 1, 1);
                g.fillRect((int) x + 6, (int) y - 4, 1, 1);
                g.fillRect((int) x + 7, (int) y - 4, 1, 1);
                g.fillRect((int) x + 8, (int) y - 4, 1, 1);

                //sixth row
                g.fillRect((int) x + 5, (int) y - 5, 1, 1);
                g.fillRect((int) x + 6, (int) y - 5, 1, 1);
                g.fillRect((int) x + 7, (int) y - 5, 1, 1);
                g.fillRect((int) x + 8, (int) y - 5, 1, 1);

                //seventh row
                g.fillRect((int) x + 6, (int) y - 6, 1, 1);
                g.fillRect((int) x + 7, (int) y - 6, 1, 1);
                g.fillRect((int) x + 8, (int) y - 6, 1, 1);

                //eight row
                g.fillRect((int) x + 7, (int) y - 7, 1, 1);
                g.fillRect((int) x + 8, (int) y - 7, 1, 1);

                //ningth row
                g.fillRect((int) x + 8, (int) y - 8, 1, 1);


                //GOING DOWN NOW

                //second row
                g.fillRect((int) x + 5, (int) y + 1, 1, 1);
                g.fillRect((int) x + 6, (int) y + 1, 1, 1);
                g.fillRect((int) x + 7, (int) y + 1, 1, 1);
                g.fillRect((int) x + 8, (int) y + 1, 1, 1);

                //third row
                g.fillRect((int) x + 4, (int) y + 2, 1, 1);
                g.fillRect((int) x + 5, (int) y + 2, 1, 1);
                g.fillRect((int) x + 6, (int) y + 2, 1, 1);
                g.fillRect((int) x + 7, (int) y + 2, 1, 1);

                //fourth row
                g.fillRect((int) x + 4, (int) y + 3, 1, 1);
                g.fillRect((int) x + 5, (int) y + 3, 1, 1);
                g.fillRect((int) x + 6, (int) y + 3, 1, 1);
                g.fillRect((int) x + 7, (int) y + 3, 1, 1);

                //fifth row
                g.fillRect((int) x + 4, (int) y + 4, 1, 1);
                g.fillRect((int) x + 5, (int) y + 4, 1, 1);
                g.fillRect((int) x + 6, (int) y + 4, 1, 1);

                //sixth row
                g.fillRect((int) x + 3, (int) y + 5, 1, 1);
                g.fillRect((int) x + 4, (int) y + 5, 1, 1);
                g.fillRect((int) x + 5, (int) y + 5, 1, 1);

                //seventh row
                g.fillRect((int) x + 3, (int) y + 6, 1, 1);
                g.fillRect((int) x + 4, (int) y + 6, 1, 1);

                //eight row
                g.fillRect((int) x + 3, (int) y + 7, 1, 1);


            }
        }
    }
}

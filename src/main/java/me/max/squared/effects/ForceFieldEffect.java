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
public class ForceFieldEffect extends GameEffect {

    private int timer = 10;
    private int maxTimed = 0;
    private boolean isFlashed = false;
    private int timer2 = 15;

    private float x2;

    private EffectHandler effectHandler;

    public ForceFieldEffect(float x, HUD hud, ID id, EffectHandler effectHandler) {
        super(x, hud, id);

        this.effectHandler = effectHandler;

        HUD.immortal = true;
    }

    public void tick(){
        if (Game.gameState == Game.STATE.Level1 || Game.gameState == Game.STATE.Level2 || Game.gameState == Game.STATE.Level3 || Game.gameState == Game.STATE.Level4 || Game.gameState == Game.STATE.Level5 || Game.gameState == Game.STATE.Level6 || Game.gameState == Game.STATE.Level7 || Game.gameState == Game.STATE.Level8 || Game.gameState == Game.STATE.Level9 || Game.gameState == Game.STATE.Level10) {

            if (maxTimed >= 12){
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
                if (maxTimed != 17) {

                    maxTimed++;
                    timer = 30;
                }
                if (maxTimed >= 17){
                    effectHandler.removeEffect(this);
                    HUD.immortal = false;
                }
            } else {
                timer--;
            }
        } else if (Game.gameState == Game.STATE.InGameShop) {
            //Do nothing ;)
        } else {
            effectHandler.removeEffect(this);
            HUD.immortal = false;
        }

    }

    public void render(Graphics g2) {

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
                x2 = x - 4;
                g.setColor(Color.darkGray);
                g.drawRect((int) x2, Game.HEIGHT - 76, 30, 30);


                //The forcefield in the icon.
                float y = Game.HEIGHT - 72;
                g.setColor(new Color(100, 4, 250));
                int width = 22;
                int height = 23;
                g.fillOval((int) x, (int) y, width, height);
                g.setColor(Color.black);
                g.fillOval((int) x + 4, (int) y + 4, width - 8, height - 8);
            }
        }
    }
}

package me.max.squared;

import java.awt.*;

/**
 * Created by max on 23-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class RegenEffect extends GameEffect {


    private int timer = 10;
    private int maxTimed = 0;
    private boolean isFlashed = false;
    private int timer2 = 15;

    private GameEffect forceFieldEffect;
    private GameEffect regenEffect;
    private GameEffect speedEffect;

    public static int oldObjectSize;

    private float x2;

    private ID id;
    private EffectHandler effectHandler;

    public RegenEffect(float x, HUD hud, ID id, EffectHandler effectHandler) {
        super(x, hud, id);

        this.effectHandler = effectHandler;
        oldObjectSize = effectHandler.object.size();
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

    public void render(Graphics g) {
        //The eh heart and more as HUD and more...!
        //use a static number * length of the currenteffect array. to make a easy way of adding these icons!
        if (!isFlashed) {
            if (Game.gameState == Game.STATE.Level1 || Game.gameState == Game.STATE.Level2 || Game.gameState == Game.STATE.Level3 || Game.gameState == Game.STATE.Level4 || Game.gameState == Game.STATE.Level5 || Game.gameState == Game.STATE.Level6 || Game.gameState == Game.STATE.Level7 || Game.gameState == Game.STATE.Level8 || Game.gameState == Game.STATE.Level9 || Game.gameState == Game.STATE.Level10) {
                //Outside of icon
                x2 = x - 5;
                g.setColor(Color.darkGray);
                g.drawRect((int) x2, Game.HEIGHT - 76, 30, 30);

                //The heart in the icon.
                float y = Game.HEIGHT - 72;
                g.setColor(new Color(150, 4, 60));
                int width = 20;
                int height = 25;
                int[] triangleX = {
                        (int) x - 2 * width / 18,
                        (int) x + width + 2 * width / 18,
                        ((int) x - 2 * width / 18 + (int) x + width + 2 * width / 18) / 2};
                int[] triangleY = {
                        (int) y + height - 2 * height / 3,
                        (int) y + height - 2 * height / 3,
                        (int) y + height};
                g.fillOval(
                        (int) x - width / 12,
                        (int) y,
                        width / 2 + width / 6,
                        height / 2);
                g.fillOval(
                        (int) x + width / 2 - width / 12,
                        (int) y,
                        width / 2 + width / 6,
                        height / 2);

                g.fillPolygon(triangleX, triangleY, triangleX.length);
            }
        }
    }
}

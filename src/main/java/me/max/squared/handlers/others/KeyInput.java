package me.max.squared.handlers.others;

import me.max.squared.enums.ID;
import me.max.squared.handlers.main.Handler;
import me.max.squared.objects.GameObject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class KeyInput extends KeyAdapter {

    public static float playerSpeed;
    private Handler handler;
    private float xp, xm, yp, ym;

    public KeyInput(Handler handler) {
        this.handler = handler;

        playerSpeed = 5;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {

                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) ym = playerSpeed;
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) xm = playerSpeed;
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) yp = playerSpeed;
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) xp = playerSpeed;

                tempObject.setVelX(xp - xm);
                tempObject.setVelY(yp - ym);

            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();


        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {

                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) ym = 0;
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) xm = 0;
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) yp = 0;
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) xp = 0;

                tempObject.setVelX(xp - xm);
                tempObject.setVelY(yp - ym);

            }
        }

    }

}

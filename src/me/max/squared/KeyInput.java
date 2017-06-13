package me.max.squared;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by max on 25-5-2017.
 */
public class KeyInput extends KeyAdapter{

    private Handler handler;
    private float xp, xm, yp, ym;
    public static float playerSpeed = 5;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player){

                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) ym = playerSpeed;
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) xm = playerSpeed;
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) yp = playerSpeed;
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) xp = playerSpeed;

                tempObject.setVelX(xp - xm);
                tempObject.setVelY(yp - ym);

            }
        }
        if (key == KeyEvent.VK_ESCAPE) { System.exit(1); }

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

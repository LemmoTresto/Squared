package me.max.simplefirstgame;

import java.awt.*;
import java.util.Random;

/**
 * Created by max on 25-5-2017.
 */
public class Player extends GameObject{

    Random r = new Random();
    Handler handler;

    public Player (float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public void tick() {
        x += velX;
        y += velY;


        x = Game.clamp((int) x, 0, Game.WIDTH - 39);
        y = Game.clamp((int) y, 0, Game.HEIGHT - 62);

        //collision();

        handler.addObject(new Trial(x, y, ID.Trial, Color.white, 32, 32, 0.09f, handler));

    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 1;
                }

            }
            else if (tempObject.getId() == ID.FastEnemy){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 3;
                }

            }
            else if (tempObject.getId() == ID.SmartEnemy){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 6;
                }

            }
            else if (tempObject.getId() == ID.EnemyBoss){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 10;
                }

            }
            else if (tempObject.getId() == ID.EnemyBossBullet){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 3;
                }

            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle( (int) x, (int) y, 32, 32);
    }
}

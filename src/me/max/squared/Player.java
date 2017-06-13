package me.max.squared;

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

        collision();

        handler.addObject(new Trial(x, y, ID.Trial, MenuShop.PlayerColor, 32, 32, 0.09f, handler));

    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 1;
                }

            }
            if (tempObject.getId() == ID.FastEnemy){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 3;
                }

            }
            if (tempObject.getId() == ID.SmartEnemy){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 6;
                }

            }
            if (tempObject.getId() == ID.EnemyBossLvl1){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 10;
                }

            }
            if (tempObject.getId() == ID.EnemyBossBulletLvl1_1){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 3;
                }

            }
            if (tempObject.getId() == ID.EnemyBossBulletLvl2_1){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 3;
                }
            }
            if (tempObject.getId() == ID.EnemyBossBulletLvl2_2){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }

            if (tempObject.getId() == ID.BasicCoin){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.coins += 1;
                    HUD.HEALTH += 5;
                    handler.removeObject(tempObject);
                    Spawn.currentInGameCoins--;
                }
            }

            if (tempObject.getId() == ID.RocketEnemyBullet){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 10;
                    handler.removeObject(tempObject);
                    handler.addObject(new RocketEnemyExplosion(x, y, ID.RocketEnemyExplosion, Color.darkGray, 24, 24, 0.009f, handler));
                }
            }

            if (tempObject.getId() == ID.RocketEnemy){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }

            if (tempObject.getId() == ID.BulletEnemy){
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }

            if (tempObject.getId() == ID.BulletEnemyBullet){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 6;
                    handler.removeObject(tempObject);
                }
            }
            if (tempObject.getId() == ID.EnemyBossBulletLvl4_1){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                    handler.removeObject(tempObject);
                }
            }
            if (tempObject.getId() == ID.EnemyBossBulletLvl4_2){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 1;
                }
            }
            if (tempObject.getId() == ID.EnemyBossLvl4){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 4;
                }
            }
            if (tempObject.getId() == ID.EnemyBossLvl3){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 5;
                }
            }
            if (tempObject.getId() == ID.EnemyBossBulletLvl3_1){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 3;
                }
            }
            if (tempObject.getId() == ID.EnemyBossLvl2){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 10;
                }
            }

        }
    }

    public void render(Graphics g) {
        g.setColor(MenuShop.PlayerColor);
        g.fillRect((int) x, (int) y, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle( (int) x, (int) y, 32, 32);
    }
}

package me.max.simplefirstgame;

import java.util.Random;

/**
 * Created by max on 25-5-2017.
 */
public class Spawn {

    private Handler handler;
    private HUD hud;
    public boolean done2 = false;
    public boolean done3 = false;

    private Random r = new Random();

    public float scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {

        if (Game.gameState == Game.STATE.Menu) {
            if (!(done2)) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                done2 = true;
            }
        }

        else if (Game.gameState == Game.STATE.LevelChooser) {
            if (!(done3)) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                done3 = true;
            }
        }

        else if (Game.gameState == Game.STATE.HardcoreMode){
            scoreKeep++;

            if (scoreKeep >= 250){
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);

                if (hud.getLevel() == 2){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 5){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 6){
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 7){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 8){
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    for (int i = 0; i < handler.object.size(); i++){
                        GameObject tempObject = handler.object.get(i);

                        if (tempObject.getId() == ID.BasicEnemy){
                            handler.object.remove(i);
                            break;
                        }
                    }
                } else if (hud.getLevel() == 9){
                    for (int i = 0; i < handler.object.size(); i++){
                        GameObject tempObject = handler.object.get(i);

                        if (tempObject.getId() == ID.BasicEnemy){
                            handler.object.remove(i);
                            break;
                        }
                    }
                } else if (hud.getLevel() == 10){
                    for (int i = 0; i < handler.object.size(); i++){
                        GameObject tempObject = handler.object.get(i);

                        if (tempObject.getId() == ID.BasicEnemy){
                            handler.object.remove(i);
                            break;
                        }
                    }
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 11){
                    for (int i = 0; i < handler.object.size(); i++){
                        GameObject tempObject = handler.object.get(i);

                        if (tempObject.getId() == ID.BasicEnemy){
                            handler.object.remove(i);
                            break;
                        }
                    }
                    for (int i = 0; i < handler.object.size(); i++){
                        GameObject tempObject = handler.object.get(i);

                        if (tempObject.getId() == ID.BasicEnemy){
                            handler.object.remove(i);
                            break;
                        }
                    }
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 12){
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() > 12){
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                }
            }
        }


        else if (Game.gameState == Game.STATE.Level1) {
            scoreKeep++;

            if (scoreKeep >= 300) {
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);

                if (hud.getLevel() == 2) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4) {
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 5) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 6) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 7) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 8) {
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 9) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 10) {
                    handler.clearEnemies();
                    hud.HEALTH = 100;
                    handler.addObject(new EnemyBossLvl1((Game.WIDTH / 2) - 48, -120, ID.EnemyBossLvl1, handler));
                } else if (hud.getLevel() == 15) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.WonLevel1;
                    hud.HEALTH = 100;
                }
            }
        }

        else if (Game.gameState == Game.STATE.Level2) {
            scoreKeep++;

            if (scoreKeep >= 300) {
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);

                if (hud.getLevel() == 2) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4) {
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 5) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 6) {
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 7) {
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 8) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 9) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 10) {
                    handler.clearEnemies();
                    hud.HEALTH = 100;
                    handler.addObject(new EnemyBossLvl2((Game.WIDTH / 2) - 48, -120, ID.EnemyBossLvl2, handler));
                } else if (hud.getLevel() == 15) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.WonLevel2;
                    hud.HEALTH = 100;
                }

            }
        }

        else if (Game.gameState == Game.STATE.Level3){
            scoreKeep++;

            if (scoreKeep >= 300){
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);

                if (hud.getLevel() == 2){
                    // TODO: Make level 3 with the new Bullet Enemy.
                }
            }
        }

    }
}

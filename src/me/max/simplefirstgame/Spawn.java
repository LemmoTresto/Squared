package me.max.simplefirstgame;

import java.util.Random;

/**
 * Created by max on 25-5-2017.
 */
public class Spawn {

    private Handler handler;
    private HUD hud;
    private boolean done = false;
    private boolean done2 = false;
    private boolean done3 = false;
    private boolean waiter = false;
    private int timer = 1000;

    private Random r = new Random();

    private float scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        if (waiter){
            timer--;
        }

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

        if (Game.gameState == Game.STATE.LevelChooser) {
            if (!(done3)) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                done3 = true;
            }
        }


        if (Game.gameState == Game.STATE.Level1) {
            scoreKeep++;

            if (!(done)) {
                handler.clearEnemies();
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                done = true;
            }

            if (scoreKeep >= 350) {
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);

                if (hud.getLevel() == 2) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4) {
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 5) {
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 6) {
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 7) {
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 8) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 9) {
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 10) {
                    handler.clearEnemies();
                    handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
                } else if (hud.getLevel() == 12) {
                    handler.clearEnemies();
                    Game.gameState = Game.STATE.Menu;

                }
            }
        }

        if (Game.gameState == Game.STATE.Level2) {
            scoreKeep++;

            if (!(done)) {
                handler.clearEnemies();
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                done = true;
            }

            if (scoreKeep >= 100) {
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);

                if (hud.getLevel() == 2){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 4){
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 5){
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 6){
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                    //a new enemy!!!
                }

            }
        }

    }
}

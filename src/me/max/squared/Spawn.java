package me.max.squared;

import java.util.Random;

/**
 * Created by max on 25-5-2017.
 */
public class Spawn {

    private Handler handler;
    private HUD hud;
    private static Random r = new Random();
    private static int coinChanceMethod = 500;
    public static int coinChance;
    public static int maxCoin = 3;
    public static int currentInGameCoins = 0;
    public boolean done2 = false;
    public boolean done3 = false;
    private GameObject player;


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
            coinChance = r.nextInt(getCoinChance());

            if (scoreKeep >= 250){
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);

                if (currentInGameCoins <= maxCoin) {
                    if (coinChance == 1) {
                        handler.addObject(new BasicCoin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicCoin, handler));
                        currentInGameCoins++;
                    }
                }

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
            coinChance = r.nextInt(getCoinChance());

            if (currentInGameCoins <= maxCoin) {
                if (coinChance == 1) {
                    handler.addObject(new BasicCoin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicCoin, handler));
                    currentInGameCoins++;
                }
            }

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
                    hud.shopEnabled = false;
                } else if (hud.getLevel() == 15) {
                    handler.object.clear();
                    hud.HEALTH = 100;
                    hud.shopEnabled = true;
                    Game.gameState = Game.STATE.WonLevel1;
                }
            }
        }

        else if (Game.gameState == Game.STATE.Level2) {
            scoreKeep++;
            coinChance = r.nextInt(getCoinChance());

            if (currentInGameCoins <= maxCoin) {
                if (coinChance == 1) {
                    handler.addObject(new BasicCoin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicCoin, handler));
                    currentInGameCoins++;
                }
            }

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
                    hud.shopEnabled = false;
                } else if (hud.getLevel() == 15) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.WonLevel2;
                    hud.HEALTH = 100;
                    hud.shopEnabled = true;
                }

            }
        }

        else if (Game.gameState == Game.STATE.Level3){

            for (int i = 0; i < handler.object.size(); i++){
                if (handler.object.get(i).getId() == ID.Player){
                    player = handler.object.get(i);
                }
            }

            scoreKeep++;
            coinChance = r.nextInt(getCoinChance());

            if (currentInGameCoins <= maxCoin) {
                if (coinChance == 1) {
                    if (hud.getLevel() >= 10){
                        if (player.x <= Game.WIDTH / 2) {
                            int Low = Game.WIDTH / 2;
                            int High = Game.WIDTH - 50;
                            int CoinX = r.nextInt(High-Low) + Low;
                            handler.addObject(new BasicCoin(CoinX, r.nextInt(Game.HEIGHT - 50), ID.BasicCoin, handler));
                            currentInGameCoins++;
                        } else if (player.x > Game.WIDTH / 2){
                            int Low = 50;
                            int High = Game.WIDTH / 2;
                            int CoinX = r.nextInt(High-Low) + Low;
                            handler.addObject(new BasicCoin(CoinX, r.nextInt(Game.HEIGHT - 50), ID.BasicCoin, handler));
                            currentInGameCoins++;
                        } else {
                            handler.addObject(new BasicCoin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicCoin, handler));
                            currentInGameCoins++;
                        }
                    } else {
                        handler.addObject(new BasicCoin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicCoin, handler));
                        currentInGameCoins++;
                    }
                }
            }

            if (scoreKeep >= 300){
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);


                if (hud.getLevel() == 2){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new BulletEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BulletEnemy, handler));
                } else if (hud.getLevel() == 3){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4){
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 5){
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));

                    for (int i = 0; i < handler.object.size(); i++){
                        GameObject tempObject = handler.object.get(i);

                        if (tempObject.getId() == ID.BasicEnemy){
                            handler.object.remove(i);
                            break;
                        }
                    }

                } else if (hud.getLevel() == 6){
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 7){
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
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
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 10){
                    handler.clearEnemies();
                    hud.HEALTH = 100;
                    handler.addObject(new EnemyBossLvl3((Game.WIDTH / 2) - 48, -120, ID.EnemyBossLvl3, handler));
                    hud.shopEnabled = false;
                } else if (hud.getLevel() == 17){
                    handler.object.clear();
                    Game.gameState = Game.STATE.WonLevel3;
                    hud.HEALTH = 100;
                    hud.shopEnabled = true;
                }
            }
        } else if (Game.gameState == Game.STATE.Level4){
            scoreKeep++;
            coinChance = r.nextInt(getCoinChance());

            if (currentInGameCoins <= maxCoin) {
                if (coinChance == 1) {
                    handler.addObject(new BasicCoin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicCoin, handler));
                    currentInGameCoins++;
                }
            }

            if (scoreKeep >= 300){
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);

                if (hud.getLevel() == 2){
                    handler.addObject(new RocketEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.RocketEnemy, handler));
                } else if (hud.getLevel() == 3){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new BulletEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BulletEnemy, handler));
                } else if (hud.getLevel() == 4){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 5){
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 6){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new BulletEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BulletEnemy, handler));
                } else if (hud.getLevel() == 7){
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));

                    for (int i = 0; i < handler.object.size(); i++){
                        GameObject tempObject = handler.object.get(i);

                        if (tempObject.getId() == ID.BasicEnemy){
                            handler.object.remove(i);
                            break;
                        }
                    }

                } else if (hud.getLevel() == 8){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 9){
                    handler.addObject(new BulletEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BulletEnemy, handler));
                } else if (hud.getLevel() == 10){
                    handler.clearEnemies();
                    hud.HEALTH = 100;
                    handler.addObject(new EnemyBossLvl4((Game.WIDTH / 2) - 48,  Game.HEIGHT + 120, ID.EnemyBossLvl4, handler));
                    hud.shopEnabled = false;
                } else if (hud.getLevel() == 15){
                    handler.object.clear();
                    Game.gameState = Game.STATE.WonLevel4;
                    hud.HEALTH = 100;
                    hud.shopEnabled = true;
                }
            }
        }

    }


    public static int getCoinChance(){
        return coinChanceMethod;
    }
    public void setCoinChance(int coinChanceMethod){
        this.coinChanceMethod = coinChanceMethod;
    }
}

//TODO: Idea for level 5. A laser enemy shoots a whopping laser!!
//TODO: Idea for new level. A enemy which is always high up and drops x.
//TODO: Add JJ in your beta testers list
//TODO: Get sounds...
//TODO: Finish menushop...
//TODO: Finish pause screen (learn how to make things a bit more black)..
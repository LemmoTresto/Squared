package me.max.squared.menus;

import me.max.squared.*;
import me.max.squared.enums.ID;
import me.max.squared.handlers.main.EffectHandler;
import me.max.squared.handlers.main.Handler;
import me.max.squared.handlers.others.HUD;
import me.max.squared.handlers.others.Spawn;
import me.max.squared.objects.enemies.BasicEnemy;
import me.max.squared.objects.enemies.FastEnemy;
import me.max.squared.objects.enemies.LaserEnemy;
import me.max.squared.objects.players.Player;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by max on 28-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class LevelChooser extends MouseAdapter{

    private Handler handler;
    private Spawn spawner;
    private HUD hud;
    private EffectHandler effectHandler;
    private boolean isBackPressed, level1pressed, level2pressed, level3pressed, level4pressed, level5pressed, level6pressed, level7pressed, level8pressed, level9pressed, level10pressed, hardcorePressed;
    private Random r = new Random();

    public LevelChooser(Handler handler, Spawn spawner, HUD hud, EffectHandler effectHandler){
        this.handler = handler;
        this.spawner = spawner;
        this.hud = hud;
        this.effectHandler = effectHandler;
    }

    public void mousePressed(MouseEvent e){
        if (Game.gameState == Game.STATE.LevelChooser) {
            if ((e.getButton() == 1)) {
                int mx = e.getX();
                int my = e.getY();

                //back button
                if (mouseOver(mx, my, 32, 20, 23, 23)) {
                    isBackPressed = true;
                    hardcorePressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level1pressed = false;
                }

                //level1
                else if (mouseOver(mx, my, 50, 100, 45, 45)) {
                    hardcorePressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level1pressed = true;
                }

                //level2
                else if (mouseOver(mx, my, 100, 100, 45, 45)) {
                    hardcorePressed = false;
                    level1pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level2pressed = true;
                }

                //level3
                else if (mouseOver(mx, my, 150, 100, 45, 45)) {
                    hardcorePressed = false;
                    level1pressed = false;
                    level2pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level3pressed = true;
                }

                //level4
                else if (mouseOver(mx, my, 200, 100, 45, 45)) {
                    hardcorePressed = false;
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level4pressed = true;
                }

                //level5
                else if (mouseOver(mx, my, 250, 100, 45, 45)) {
                    hardcorePressed = false;
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level5pressed = true;
                }

                //level6
                else if (mouseOver(mx, my, 300, 100, 45, 45)) {
                    hardcorePressed = false;
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level6pressed = true;
                }

                //level7
                else if (mouseOver(mx, my, 350, 100, 45, 45)) {
                    hardcorePressed = false;
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level7pressed = true;
                }

                //level8
                else if (mouseOver(mx, my, 400, 100, 45, 45)) {
                    hardcorePressed = false;
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level8pressed = true;
                }

                //level9
                else if (mouseOver(mx, my, 450, 100, 45, 45)) {
                    hardcorePressed = false;
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level10pressed = false;
                    level9pressed = true;
                }

                //level10
                else if (mouseOver(mx, my, 500, 100, 45, 45)) {
                    hardcorePressed = false;
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = true;
                }
                else if (mouseOver(mx, my, 195, 300, 250, 70)){
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    hardcorePressed = true;
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (Game.gameState == Game.STATE.LevelChooser) {
            int mx = e.getX();
            int my = e.getY();

            if ((mouseOver(mx, my, 32, 20, 23, 23)) && (isBackPressed)){
                Game.gameState = Game.STATE.Menu;
                isBackPressed = false;
                level1pressed = false;
                level2pressed = false;
                level3pressed = false;
                level4pressed = false;
                level5pressed = false;
                level6pressed = false;
                level7pressed = false;
                level8pressed = false;
                level9pressed = false;
                level10pressed = false;


            }
            //level1
            else if ((mouseOver(mx, my, 50, 100, 45, 45)) && (level1pressed)) {
                handler.object.clear();
                InGameShop.currentLevel = Game.STATE.Level1;
                Game.gameState = Game.STATE.Level1;
                level1pressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
            }

            //level2
            else if ((mouseOver(mx, my, 100, 100, 45, 45)) && (level2pressed)) {
                handler.object.clear();
                Game.gameState = Game.STATE.Level2;
                InGameShop.currentLevel = Game.STATE.Level2;
                level2pressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
            }

             else if ((mouseOver(mx, my, 195, 300, 250, 70)) && (hardcorePressed)){
                handler.object.clear();
                Game.gameState = Game.STATE.HardcoreMode;
                InGameShop.currentLevel = Game.STATE.HardcoreMode;
                hardcorePressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
            }

            //level3
            else if ((mouseOver(mx, my, 150, 100, 45, 45)) && (level3pressed)) {
                handler.object.clear();
                Game.gameState = Game.STATE.Level3;
                InGameShop.currentLevel = Game.STATE.Level3;
                level3pressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
            }

            //level4
            else if ((mouseOver(mx, my, 200, 100, 45, 45)) && (level4pressed)) {
                handler.object.clear();
                Game.gameState = Game.STATE.Level4;
                InGameShop.currentLevel = Game.STATE.Level4;
                level4pressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.FastEnemy, handler));
            }

            //level5
            else if ((mouseOver(mx, my, 250, 100, 45, 45)) && (level5pressed)) {
                handler.object.clear();
                Game.gameState = Game.STATE.Level5;
                InGameShop.currentLevel = Game.STATE.Level5;
                level5pressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
            }

            //level6
            else if ((mouseOver(mx, my, 300, 100, 45, 45)) && (level6pressed)) {
                handler.object.clear();
                Game.gameState = Game.STATE.Level6;
                InGameShop.currentLevel = Game.STATE.Level6;
                level6pressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
            }

            //level7
            else if ((mouseOver(mx, my, 350, 100, 45, 45)) && (level7pressed)) {
                handler.object.clear();
                Game.gameState = Game.STATE.Level7;
                InGameShop.currentLevel = Game.STATE.Level7;
                level7pressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                handler.addObject(new LaserEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.LaserEnemy, handler));
            }

            //level8
            else if ((mouseOver(mx, my, 400, 100, 45, 45)) && (level8pressed)) {
                handler.object.clear();
                Game.gameState = Game.STATE.Level8;
                InGameShop.currentLevel = Game.STATE.Level8;
                level8pressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
            }

            //level9
            else if ((mouseOver(mx, my, 450, 100, 45, 45)) && (level9pressed)) {
                handler.object.clear();
                Game.gameState = Game.STATE.Level9;
                InGameShop.currentLevel = Game.STATE.Level9;
                level9pressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
            }

            //level10
            else if ((mouseOver(mx, my, 500, 100, 45, 45)) && (level10pressed)) {
                handler.object.clear();
                Game.gameState = Game.STATE.Level10;
                InGameShop.currentLevel = Game.STATE.Level10;
                level10pressed = false;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
            }
        }
    }

    public void tick(){
        if (Game.gameState == Game.STATE.LevelChooser) {
            //nothing to tick
        }

    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.LevelChooser) {
            //title
            Font font1 = new Font("arial", 1, 50);
            g.setFont(font1);
            g.setColor(Color.gray);
            g.drawString("World 1", Game.WIDTH / 2 - 90, 60);

            //Back button
            //box
            g.setColor(Color.gray);
            //g.drawRect(32, 20, 23, 23);
            g.drawString("«", 30, 45);

            //level font
            Font font2 = new Font("arial", 1, 25);
            g.setFont(font2);

            //Copyright stuff
            Font fontCopyRight = new Font("arial", 1, 15);
            g.setFont(fontCopyRight);
            g.setColor(Color.white);
            g.drawString("© Copyright 2017 Max Berkelmans", 10, Game.HEIGHT - 40);

            //level font set
            g.setFont(font2);

            //level1
            g.setColor(Color.white);
            g.drawRect(50, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("1", 67, 132);

            //level2
            g.setColor(Color.white);
            g.drawRect(100, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("2", 117, 132);

            //level3
            g.setColor(Color.white);
            g.drawRect(150, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("3", 167, 132);

            //level4
            g.setColor(Color.white);
            g.drawRect(200, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("4", 217, 132);

            //level5
            g.setColor(Color.white);
            g.drawRect(250, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("5", 267, 132);

            //insane/hardcore mode
            g.setColor(Color.white);
            Font font3 = new Font("arial", 1, 43);
            g.setFont(font3);
            g.drawRect(195, 300, 250, 70);
            g.setColor(Color.red);
            g.drawString("Hardcore", 225, 348);
            g.setFont(font2);

            //level6
            g.setColor(Color.white);
            g.drawRect(300, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("6", 317, 132);

            //level7
            g.setColor(Color.white);
            g.drawRect(350, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("7", 367, 132);

            //level8
            g.setColor(Color.white);
            g.drawRect(400, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("8", 417, 132);

            //level9
            g.setColor(Color.white);
            g.drawRect(450, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("9", 467, 132);

            //level10
            g.setColor(Color.white);
            g.drawRect(500, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("10", 508, 132);


        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            if (my > y && my < y + height){
                return true;
            }
        }

        return false;
    }


}

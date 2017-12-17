package me.max.squared.menus;

import me.max.squared.Game;
import me.max.squared.enums.ID;
import me.max.squared.handlers.main.EffectHandler;
import me.max.squared.handlers.main.Handler;
import me.max.squared.handlers.others.HUD;
import me.max.squared.handlers.others.Spawn;
import me.max.squared.objects.enemies.BasicEnemy;
import me.max.squared.objects.enemies.FastEnemy;
import me.max.squared.objects.enemies.LaserEnemy;
import me.max.squared.objects.players.Player;
import me.max.squared.utils.DiscordRPCUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by max on 28-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class LevelChooser extends MouseAdapter {

    private Handler handler;
    private Spawn spawner;
    private HUD hud;
    private EffectHandler effectHandler;
    private Random r = new Random();
    private BufferedImage level1, background, level2, level3, level4, level5, level6, level7, level8, level9, level10, hardcore;

    public LevelChooser(Handler handler, Spawn spawner, HUD hud, EffectHandler effectHandler) {
        this.handler = handler;
        this.spawner = spawner;
        this.hud = hud;
        this.effectHandler = effectHandler;

        try {
            background = ImageIO.read(getClass().getResource("/images/squared_frame.png"));
            level1 = ImageIO.read(getClass().getResource("/images/squared_level1.png"));
            level2 = ImageIO.read(getClass().getResource("/images/squared_level2.png"));
            level3 = ImageIO.read(getClass().getResource("/images/squared_level3.png"));
            level4 = ImageIO.read(getClass().getResource("/images/squared_level4.png"));
            level5 = ImageIO.read(getClass().getResource("/images/squared_level5.png"));
            level6 = ImageIO.read(getClass().getResource("/images/squared_level6.png"));
            level7 = ImageIO.read(getClass().getResource("/images/squared_level7.png"));
            level8 = ImageIO.read(getClass().getResource("/images/squared_level8.png"));
            level9 = ImageIO.read(getClass().getResource("/images/squared_level9.png"));
            level10 = ImageIO.read(getClass().getResource("/images/squared_level10.png"));
            hardcore = ImageIO.read(getClass().getResource("/images/squared_hardcore.png"));
        } catch (IOException e) {
            System.out.println("Level image couldn't be loaded!");

        }
    }


    public void mouseClicked(MouseEvent e) {
        if (Game.gameState == Game.STATE.LevelChooser) {
            if (e.getButton() == 1) {
                int mx = e.getX();
                int my = e.getY();

                //back button
                if (mouseOver(mx, my, 48, 35, 23, 23)) {
                    Game.gameState = Game.STATE.Menu;
                }
                //hardcore mode
                else if (mouseOver(mx, my, 205, 300, 231, 70)) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.HardcoreMode;
                    InGameShop.currentLevel = Game.STATE.HardcoreMode;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                    DiscordRPCUtil.updatePresence();
                }
                //level 1
                else if (mouseOver(mx, my, 70, 100, 45, 45)) {
                    handler.object.clear();
                    InGameShop.currentLevel = Game.STATE.Level1;
                    Game.gameState = Game.STATE.Level1;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                    DiscordRPCUtil.updatePresence();
                }
                //level 2
                else if (mouseOver(mx, my, 120, 100, 45, 45)) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.Level2;
                    InGameShop.currentLevel = Game.STATE.Level2;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                    DiscordRPCUtil.updatePresence();
                }
                //level 3
                else if (mouseOver(mx, my, 170, 100, 45, 45)) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.Level3;
                    InGameShop.currentLevel = Game.STATE.Level3;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                    DiscordRPCUtil.updatePresence();
                }
                //level 4
                else if (mouseOver(mx, my, 220, 100, 45, 45)) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.Level4;
                    InGameShop.currentLevel = Game.STATE.Level4;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.FastEnemy, handler));
                    DiscordRPCUtil.updatePresence();
                }
                //level 5
                else if (mouseOver(mx, my, 270, 100, 45, 45)) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.Level5;
                    InGameShop.currentLevel = Game.STATE.Level5;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    DiscordRPCUtil.updatePresence();
                }
                //level 6
                else if (mouseOver(mx, my, 320, 100, 45, 45)) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.Level6;
                    InGameShop.currentLevel = Game.STATE.Level6;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    DiscordRPCUtil.updatePresence();
                }
                //level 7
                else if (mouseOver(mx, my, 370, 100, 45, 45)) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.Level7;
                    InGameShop.currentLevel = Game.STATE.Level7;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    handler.addObject(new LaserEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.LaserEnemy, handler));
                    DiscordRPCUtil.updatePresence();
                }
                //level 8
                else if (mouseOver(mx, my, 420, 100, 45, 45)) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.Level8;
                    InGameShop.currentLevel = Game.STATE.Level8;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    DiscordRPCUtil.updatePresence();
                }
                //level 9
                else if (mouseOver(mx, my, 470, 100, 45, 45)) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.Level9;
                    InGameShop.currentLevel = Game.STATE.Level9;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    DiscordRPCUtil.updatePresence();
                }
                //level 10
                else if (mouseOver(mx, my, 520, 100, 45, 45)) {
                    handler.object.clear();
                    Game.gameState = Game.STATE.Level10;
                    InGameShop.currentLevel = Game.STATE.Level10;
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, hud, handler, effectHandler));
                    DiscordRPCUtil.updatePresence();
                }
            }
        }
    }

    public void tick() {
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
            g.drawString("World 1", Game.WIDTH / 2 - 90, 80);

            //Back button
            //box
            g.setColor(Color.gray);
            g.drawString("«", 45, 60);
            //level font
            Font font2 = new Font("arial", 1, 25);
            g.setFont(font2);

            //Copyright stuff
            Font fontCopyRight = new Font("arial", 1, 15);
            g.setFont(fontCopyRight);
            g.setColor(Color.white);
            g.drawString("© Copyright 2017 Max Berkelmans", 35, Game.HEIGHT - 55);

            //level font set
            g.setFont(font2);

            //background
            g.drawImage(background, -11, -15, Game.WIDTH + 30, Game.HEIGHT, null);

            //level1
            g.drawImage(level1, 70, 100, 45, 45, null);

            //level2
            g.drawImage(level2, 120, 100, 45, 45, null);

            //level3
            g.drawImage(level3, 170, 100, 45, 45, null);

            //level4
            g.drawImage(level4, 220, 100, 45, 45, null);

            //level5
            g.drawImage(level5, 270, 100, 45, 45, null);

            //level6
            g.drawImage(level6, 320, 100, 45, 45, null);

            //level7
            g.drawImage(level7, 370, 100, 45, 45, null);

            //level8
            g.drawImage(level8, 420, 100, 45, 45, null);

            //level9
            g.drawImage(level9, 470, 100, 45, 45, null);

            //level10
            g.drawImage(level10, 520, 100, 45, 45, null);

            //levelhardcore
            g.drawImage(hardcore, 195, 300, 250, 70, null);

        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            }
        }

        return false;
    }


}

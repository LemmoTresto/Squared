package me.max.squared.menus;

import me.max.squared.Game;
import me.max.squared.handlers.others.HUD;
import me.max.squared.utils.DiscordRPCUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static me.max.squared.handlers.others.Window.frame;

/**
 * Created by max on 28-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class Menu extends MouseAdapter {

    private int highscoreX;
    private BufferedImage background, help_button, start_button, quit_button, store_button, options_button;

    public Menu() {
        try {
            background = ImageIO.read(getClass().getResource("/images/squared_menu_main.png"));
            help_button = ImageIO.read(getClass().getResource("/images/squared_button_help.png"));
            start_button = ImageIO.read(getClass().getResource("/images/squared_button_start.png"));
            quit_button = ImageIO.read(getClass().getResource("/images/squared_button_quit.png"));
            store_button = ImageIO.read(getClass().getResource("/images/squared_button_store.png"));
            options_button = ImageIO.read(getClass().getResource("/images/squared_button_options.png"));
        } catch (IOException e) {
            System.out.println("Menu Image couldn't be loaded!");
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (Game.gameState == Game.STATE.Menu) {
            int mx = e.getX();
            int my = e.getY();
            if (mouseOver(mx, my, Game.WIDTH / 2 - 77, 120, 121, 50)) {
                Game.gameState = Game.STATE.LevelChooser;
            }
            if (mouseOver(mx, my, Game.WIDTH / 2 - 78, 295, 122, 50)) {
                int confirm = JOptionPane.showOptionDialog(
                        frame, "Are you sure you want to close Squared?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    DiscordRPCUtil.shutdownDiscord();
                    System.exit(1);
                }
            }
            if (mouseOver(mx, my, Game.WIDTH / 2 - 243, 205, 122, 52)) {
                Game.gameState = Game.STATE.MenuShop;
            }
            if (mouseOver(mx, my, 422, 204, 122, 52)) {
                Game.gameState = Game.STATE.Help;
            }

        }
    }

    public void tick() {
        if (Game.gameState == Game.STATE.Menu) {
            if (HUD.highScore >= 100000) {
                highscoreX = Game.WIDTH / 2 - 67;
            } else if (HUD.highScore >= 10000) {
                highscoreX = Game.WIDTH / 2 - 62;
            } else if (HUD.highScore >= 1000) {
                highscoreX = Game.WIDTH / 2 - 57;
            } else if (HUD.highScore >= 100) {
                highscoreX = Game.WIDTH / 2 - 52;
            } else if (HUD.highScore >= 10) {
                highscoreX = Game.WIDTH / 2 - 47;
            } else {
                highscoreX = Game.WIDTH / 2 - 42;
            }
        }
    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.Menu) {
            //background
            g.drawImage(background, -11, -15, Game.WIDTH + 30, Game.HEIGHT, null);

            //highscore counter
            g.setColor(Color.white);
            Font font2 = new Font("arial", 1, 15);
            g.setFont(font2);
            g.drawString("Score: " + HUD.highScore, highscoreX, 110);

            //everything -15 in x pls
            //start button
            g.drawImage(start_button, Game.WIDTH / 2 - 90, 110, 150, 70, null);

            //options button
            g.drawImage(options_button, Game.WIDTH / 2 - 90, 195, 150, 70, null);
            //For clicking : g.drawRect(Game.WIDTH / 2 - 78, 204, 122, 52);

            //quit button
            g.drawImage(quit_button, Game.WIDTH / 2 - 90, 285, 150, 70, null);

            //store button
            g.drawImage(store_button, Game.WIDTH / 2 - 255, 195, 150, 70, null);

            //help button
            g.drawImage(help_button, 410, 195, 150, 70, null);

            //Copyright stuff
            Font font3 = new Font("arial", 1, 15);
            g.setFont(font3);
            g.setColor(Color.white);
            g.drawString("© Copyright 2017 Max Berkelmans", 35, Game.HEIGHT - 55);
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

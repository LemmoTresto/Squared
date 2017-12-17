package me.max.squared.handlers.others;

import me.max.squared.Game;
import me.max.squared.utils.DiscordRPCUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by max on 24-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class Window extends Canvas {

    public static JFrame frame;

    public Window(int width, int height, String title, Game game) {
        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        frame, "Are you sure you want to close Squared?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    DiscordRPCUtil.shutdownDiscord();
                    System.exit(1);
                }
            }
        });
        game.start();
    }
}

package me.max.squared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.max.squared.data.DataSaving;
import me.max.squared.data.Datas;
import me.max.squared.handlers.main.EffectHandler;
import me.max.squared.handlers.main.Handler;
import me.max.squared.handlers.others.HUD;
import me.max.squared.handlers.others.KeyInput;
import me.max.squared.handlers.others.Spawn;
import me.max.squared.handlers.others.Window;
import me.max.squared.menus.*;
import me.max.squared.utils.DiscordRPCUtil;
import me.max.squared.utils.UpdateChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Created by max on 24-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    public static STATE gameState = STATE.Menu;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Map<String, String> attributes = new HashMap<>();
    private static String OS = System.getProperty("os.name").toLowerCase();
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private HUD hud;
    private EffectHandler effectHandler;
    private Spawn spawner;
    private me.max.squared.menus.Menu menu;
    private LevelChooser lvlchooser;
    private Died died;
    private Won Won;
    private InGameShop inGameShop;
    private MenuShop menuShop;
    private Help help;
    private DataSaving dataSaving;
    private int fps;
    private Credits credits;


    public Game() {

        handler = new Handler();

        menu = new me.max.squared.menus.Menu();
        hud = new HUD(handler);
        effectHandler = new EffectHandler();
        spawner = new Spawn(handler, hud);
        lvlchooser = new LevelChooser(handler, spawner, hud, effectHandler);
        died = new Died(handler, hud, spawner, effectHandler);
        Won = new Won(handler, hud, spawner, effectHandler);
        inGameShop = new InGameShop(handler, hud, spawner);
        menuShop = new MenuShop(handler, hud, spawner);
        help = new Help(handler, spawner);
        dataSaving = new DataSaving();
        UpdateChecker updateChecker = new UpdateChecker();
        credits = new Credits(handler, spawner);

        try {
            getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HUD.lives = 1;
        if (MenuShop.purchasedUpgrades != null && !MenuShop.purchasedUpgrades.isEmpty()) {
            if (MenuShop.purchasedUpgrades.contains(MenuShop.StoreUpgrades.ExtraLife_1)) {
                HUD.lives = 2;
            } else {
                HUD.lives = 1;
            }
        }

        new Window(WIDTH, HEIGHT, "Squared - (BETA)", this);

        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new me.max.squared.menus.Menu());
        this.addMouseListener(new LevelChooser(handler, spawner, hud, effectHandler));
        this.addMouseListener(new Died(handler, hud, spawner, effectHandler));
        this.addMouseListener(new Won(handler, hud, spawner, effectHandler));
        this.addMouseListener(new HUD(handler));
        this.addMouseListener(new InGameShop(handler, hud, spawner));
        this.addMouseListener(new MenuShop(handler, hud, spawner));
        this.addMouseListener(new Help(handler, spawner));
        this.addMouseListener(new Credits(handler, spawner));

        try {
            Enumeration<URL> resources = this.getClass().getClassLoader().getResources(JarFile.MANIFEST_NAME);

            while (resources.hasMoreElements()) {
                InputStream inputStream = resources.nextElement().openStream();
                Manifest manifest = new Manifest(inputStream);
                manifest.getMainAttributes().forEach((key, value) -> attributes.put(key.toString(), (String) value));
                inputStream.close();
            }
        } catch (IOException ignored) {
        }


        boolean update = updateChecker.checkForUpdates();
        System.out.println(update);
        if (update) {
            JOptionPane.showMessageDialog(this,
                    "An update is available, get it at Github or Jenkins!\nhttps://www.github.com/MaxiMiniJaniJos/Squared\nhttps://ci.scarsz.me/job/squared",
                    "Squared - Update",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        DiscordRPCUtil.initDiscord();
    }

    public static float clamp(float var, float min, float max) {
        if (var >= max) {
            return max;
        } else if (var <= min) {
            return min;
        } else {
            return var;
        }
    }

    public static Gson getGson() {
        return gson;
    }

    public static boolean isWindows() {

        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }

    public static String getManifestValue(String key) {
        return attributes.get(key);
    }

    public static void main(String args[]) {
        new Game();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;


            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                fps = frames;
                try {
                    dataSaving.tick();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                frames = 0;
            }

        }
        stop();
    }

    private void tick() {
        handler.tick();
        spawner.tick();
        hud.tick();
        effectHandler.tick();
        menu.tick();
        lvlchooser.tick();
        died.tick();
        Won.tick();
        inGameShop.tick();
        menuShop.tick();
        help.tick();
        credits.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        Font oldFont = g.getFont();

        handler.render(g);

        hud.render(g);

        effectHandler.render(g);

        menu.render(g);
        lvlchooser.render(g);
        died.render(g);
        Won.render(g);
        inGameShop.render(g);
        menuShop.render(g);
        help.render(g);
        credits.render(g);


        g.setFont(oldFont);
        g.setColor(Color.yellow);
        g.drawString("FPS: " + fps, Game.WIDTH - 65, 15);

        g.dispose();
        bs.show();
    }

    private void getData() throws IOException {

        if (isWindows()) {
            File f = new File(System.getenv("APPDATA") + "\\.squared\\data.dat");
            if (f.exists()) {

                Datas data2;

                data2 = new Datas();
                try {

                    FileInputStream fin = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fin);
                    data2 = (Datas) ois.readObject();
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                HUD.coins = data2.coins;
                HUD.highScore = data2.highscore;
                if (data2.skinstate == 1) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.White;
                } else if (data2.skinstate == 2) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Red;
                } else if (data2.skinstate == 3) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Blue;
                } else if (data2.skinstate == 4) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Green;
                } else if (data2.skinstate == 5) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Yellow;
                } else if (data2.skinstate == 6) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Orange;
                } else if (data2.skinstate == 7) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Pink;
                } else if (data2.skinstate == 8) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Gray;
                }
                MenuShop.currentSkin = data2.currentSkin;
                MenuShop.purchasedSkins = data2.purchasedSkins;
                MenuShop.purchasedUpgrades = data2.purchasedUpgrades;
                HUD.lives = data2.lives;

            } else {
                if (!(MenuShop.purchasedSkins.contains(MenuShop.SkinSTATE.White))) {
                    MenuShop.purchasedSkins.add(MenuShop.SkinSTATE.White);
                }
                dataSaving.tick();
            }
        } else if (isUnix()) {
            File f = new File(System.getProperty("user.home") + "/.squared/data.dat");
            if (f.exists()) {

                Datas data2;

                data2 = new Datas();
                try {

                    FileInputStream fin = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fin);
                    data2 = (Datas) ois.readObject();
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                HUD.coins = data2.coins;
                HUD.highScore = data2.highscore;
                if (data2.skinstate == 1) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.White;
                } else if (data2.skinstate == 2) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Red;
                } else if (data2.skinstate == 3) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Blue;
                } else if (data2.skinstate == 4) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Green;
                } else if (data2.skinstate == 5) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Yellow;
                } else if (data2.skinstate == 6) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Orange;
                } else if (data2.skinstate == 7) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Pink;
                } else if (data2.skinstate == 8) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Gray;
                }
                MenuShop.currentSkin = data2.currentSkin;
                MenuShop.purchasedSkins = data2.purchasedSkins;
                MenuShop.purchasedUpgrades = data2.purchasedUpgrades;
                HUD.lives = data2.lives;

            } else {
                dataSaving.tick();
            }
        } else if (isMac()) {
            File f = new File(System.getProperty("user.home") + "/Library/Application Support/.squared/data.dat");
            if (f.exists()) {

                Datas data2;

                data2 = new Datas();
                try {

                    FileInputStream fin = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fin);
                    data2 = (Datas) ois.readObject();
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                HUD.coins = data2.coins;
                HUD.highScore = data2.highscore;
                if (data2.skinstate == 1) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.White;
                } else if (data2.skinstate == 2) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Red;
                } else if (data2.skinstate == 3) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Blue;
                } else if (data2.skinstate == 4) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Green;
                } else if (data2.skinstate == 5) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Yellow;
                } else if (data2.skinstate == 6) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Orange;
                } else if (data2.skinstate == 7) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Pink;
                } else if (data2.skinstate == 8) {
                    MenuShop.skinSTATE = MenuShop.SkinSTATE.Gray;
                }
                MenuShop.currentSkin = data2.currentSkin;
                MenuShop.purchasedSkins = data2.purchasedSkins;
                MenuShop.purchasedUpgrades = data2.purchasedUpgrades;
                HUD.lives = data2.lives;

            } else {
                dataSaving.tick();
            }
        }


    }


    public enum STATE {
        Menu,
        Help,
        Credits,
        LevelChooser,
        InGameShop,
        MenuShop,
        PauseScreen,
        Died,
        HardcoreMode,
        Level1,
        Level2,
        Level3,
        Level4,
        Level5,
        Level6,
        Level7,
        Level8,
        Level9,
        Level10,
        WonLevel1,
        WonLevel2,
        WonLevel3,
        WonLevel4,
        WonLevel5,
        WonLevel6,
        WonLevel7,
        WonLevel8,
        WonLevel9,
        WonLevel10
    }
}

package me.max.squared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Random;
import java.io.InputStream;
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

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random r;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    private LevelChooser lvlchooser;
    private Died died;
    private onWin onWin;
    private InGameShop inGameShop;
    private MenuShop menuShop;
    private Help help;
    private DataSaving dataSaving;
    private int fps;
    private UpdateChecker updateChecker;

    private static Map<String, String> attributes = new HashMap<>();

    private static String OS = System.getProperty("os.name").toLowerCase();
    private File f;

    public enum STATE {
        Menu,
        Help,
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


    public static STATE gameState = STATE.Menu;


    public Game() {

        handler = new Handler();

        menu = new Menu();
        hud = new HUD(handler);
        spawner = new Spawn(handler, hud);
        lvlchooser = new LevelChooser(handler, spawner);
        died = new Died(handler, hud, spawner);
        onWin = new onWin(handler, hud, spawner);
        inGameShop = new InGameShop(handler, hud, spawner);
        menuShop = new MenuShop(handler, hud, spawner);
        help = new Help(handler, spawner);
        dataSaving = new DataSaving();
        updateChecker = new UpdateChecker();

        try {
            getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        r = new Random();

        new Window(WIDTH, HEIGHT, "Squared - (BETA)", this);

        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new Menu());
        this.addMouseListener(new LevelChooser(handler, spawner));
        this.addMouseListener(new Died(handler, hud, spawner));
        this.addMouseListener(new onWin(handler, hud, spawner));
        this.addMouseListener(new HUD(handler));
        this.addMouseListener(new InGameShop(handler, hud, spawner));
        this.addMouseListener(new MenuShop(handler, hud, spawner));
        this.addMouseListener(new Help(handler, spawner));

        try {
            Enumeration<URL> resources = this.getClass().getClassLoader().getResources(JarFile.MANIFEST_NAME);

            while (resources.hasMoreElements()) {
                InputStream inputStream = resources.nextElement().openStream();
                Manifest manifest = new Manifest(inputStream);
                manifest.getMainAttributes().forEach((key, value) -> attributes.put(key.toString(), (String) value));
                inputStream.close();
            }
        } catch (IOException ignored) {}

        boolean update = updateChecker.checkForUpdates();
        System.out.println(update);
        if (update){
            JOptionPane.showMessageDialog(this,
                    "An update is available, get it at Github or Jenkins!\nhttps://www.github.com/MaxiMiniJaniJos/Squared\nhttps://www.ci.scarsz.me/job/squared",
                    "Squared - Update",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
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
        hud.tick();
        spawner.tick();
        menu.tick();
        lvlchooser.tick();
        died.tick();
        onWin.tick();
        inGameShop.tick();
        menuShop.tick();
        help.tick();
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

        handler.render(g);

        g.setColor(Color.yellow);
        g.drawString("FPS: " + fps, Game.WIDTH - 65, 15);
        hud.render(g);

        menu.render(g);
        lvlchooser.render(g);
        died.render(g);
        onWin.render(g);
        inGameShop.render(g);
        menuShop.render(g);
        help.render(g);


        g.dispose();
        bs.show();
    }


    public static float clamp(float var, float min, float max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static Gson getGson(){
        return gson;
    }


    public void getData() throws IOException {

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
                hud.coins = data2.coins;
                hud.highScore = data2.highscore;
                if (data2.skinstate == 1) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.White;
                } else if (data2.skinstate == 2) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Red;
                } else if (data2.skinstate == 3) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Blue;
                } else if (data2.skinstate == 4) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Green;
                } else if (data2.skinstate == 5) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Yellow;
                } else if (data2.skinstate == 6) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Orange;
                } else if (data2.skinstate == 7) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Pink;
                } else if (data2.skinstate == 8) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Gray;
                }
                menuShop.currentSkin = data2.currentSkin;
                menuShop.purchasedSkins = data2.purchasedSkins;
                menuShop.purchasedUpgrades = data2.purchasedUpgrades;
                hud.lives = data2.lives;

            } else {
                if (!(menuShop.purchasedSkins.contains(MenuShop.SkinSTATE.White))) {
                    menuShop.purchasedSkins.add(MenuShop.SkinSTATE.White);
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
                hud.coins = data2.coins;
                hud.highScore = data2.highscore;
                if (data2.skinstate == 1) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.White;
                } else if (data2.skinstate == 2) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Red;
                } else if (data2.skinstate == 3) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Blue;
                } else if (data2.skinstate == 4) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Green;
                } else if (data2.skinstate == 5) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Yellow;
                } else if (data2.skinstate == 6) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Orange;
                } else if (data2.skinstate == 7) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Pink;
                } else if (data2.skinstate == 8) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Gray;
                }
                menuShop.currentSkin = data2.currentSkin;
                menuShop.purchasedSkins = data2.purchasedSkins;
                menuShop.purchasedUpgrades = data2.purchasedUpgrades;
                hud.lives = data2.lives;

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
                hud.coins = data2.coins;
                hud.highScore = data2.highscore;
                if (data2.skinstate == 1) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.White;
                } else if (data2.skinstate == 2) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Red;
                } else if (data2.skinstate == 3) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Blue;
                } else if (data2.skinstate == 4) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Green;
                } else if (data2.skinstate == 5) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Yellow;
                } else if (data2.skinstate == 6) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Orange;
                } else if (data2.skinstate == 7) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Pink;
                } else if (data2.skinstate == 8) {
                    menuShop.skinSTATE = MenuShop.SkinSTATE.Gray;
                }
                menuShop.currentSkin = data2.currentSkin;
                menuShop.purchasedSkins = data2.purchasedSkins;
                menuShop.purchasedUpgrades = data2.purchasedUpgrades;
                hud.lives = data2.lives;

            } else {
                dataSaving.tick();
            }
        }


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

    public static String getManifestValue(String key){
        return attributes.get(key);
    }



    public static void main(String args[]){
        new Game();
    }
}

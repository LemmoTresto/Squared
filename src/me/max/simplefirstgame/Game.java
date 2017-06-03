package me.max.simplefirstgame;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Created by max on 24-5-2017.
 */
public class Game extends Canvas implements Runnable{

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
    private int fps;

    public enum STATE {
        Menu,
        LevelChooser,
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

        r = new Random();

        new Window(WIDTH, HEIGHT, "Simple first game!", this);

        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new Menu());
        this.addMouseListener(new LevelChooser(handler, spawner));
        this.addMouseListener(new Died(handler, hud, spawner));
        this.addMouseListener(new onWin(handler, hud, spawner));

    }



    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if(running) {
                render();
            }
            frames++;


            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                fps = frames;
                frames = 0;
            }

        }
        stop();
    }

    private void tick(){
        handler.tick();
        hud.tick();
        spawner.tick();
        menu.tick();
        lvlchooser.tick();
        died.tick();
        onWin.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(g);

        g.setColor(Color.yellow);
        g.drawString("FPS: " + fps, Game.WIDTH - 65, 15);
        hud.render(g);

        menu.render(g);
        lvlchooser.render(g);
        died.render(g);
        onWin.render(g);


        g.dispose();
        bs.show();
    }





    public static float clamp(float var, float min, float max){
        if (var >= max){
            return var = max;
        }
        else if (var <= min){
            return var = min;
        }
        else {
            return var;
        }
    }

    public static void main(String args[]){
        new Game();
    }
}

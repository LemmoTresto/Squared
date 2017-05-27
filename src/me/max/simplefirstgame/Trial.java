package me.max.simplefirstgame;

import java.awt.*;

/**
 * Created by max on 25-5-2017.
 */
public class Trial extends GameObject{

    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int width, height;
    private float life;

    public Trial(float x, float y, ID id, Color color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;

    }

    public void tick() {
        if (alpha > life){
            alpha -= life - 0.001f;
        }else{
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTranspaant(alpha));

        g.setColor(color);
        g.fillRect((int) x, (int) y, width, height);

        g2d.setComposite(makeTranspaant(1));
    }

    private AlphaComposite makeTranspaant(float alpha){
        float type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance((int) type, alpha));
    }

    public Rectangle getBounds() {
        return null;
    }
}

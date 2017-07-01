package me.max.squared.effects;

import me.max.squared.handlers.others.HUD;
import me.max.squared.enums.ID;

import java.awt.*;

/**
 * Created by max on 23-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public abstract class GameEffect {

    protected ID id;
    protected HUD hud;
    protected float x;

    public GameEffect(float x, HUD hud, ID id){
        this.id = id;
        this.hud = hud;
        this.x = x;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setId(){
        this.id = id;
    }

    public ID getId(){
        return id;
    }

    public HUD getHud() { return hud; }

    public void setHud() { this.hud = hud; }

    public void setX(float x) { this.x = x; }

    public float getX() { return x; }
}

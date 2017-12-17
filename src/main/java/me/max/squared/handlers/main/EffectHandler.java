package me.max.squared.handlers.main;

import me.max.squared.effects.GameEffect;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by max on 23-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class EffectHandler {

    public static LinkedList<GameEffect> object = new LinkedList<GameEffect>();
    private float x;

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameEffect tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        x = -25;
        for (int i = 0; i < object.size(); i++) {
            GameEffect tempObject = object.get(i);
            x += 40;
            tempObject.setX(x);
            tempObject.render(g);
        }
    }

    public void addEffect(GameEffect object) {
        this.object.add(object);
    }

    public void removeEffect(GameEffect object) {
        this.object.remove(object);
    }

    public enum EFFECT {
        Regen(),
        ForceField(),
        Speed()
    }
}

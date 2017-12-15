package me.max.squared.handlers.main;

import me.max.squared.Game;
import me.max.squared.objects.GameObject;
import me.max.squared.enums.ID;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by max on 25-5-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class Handler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        if (!(Game.gameState == Game.STATE.InGameShop) && !(Game.gameState == Game.STATE.PauseScreen)) {
            for (int i = 0; i < object.size(); i++) {
                GameObject tempObject = object.get(i);
                tempObject.tick();
            }
        }
    }

    public void render(Graphics g) {
        if (!(Game.gameState == Game.STATE.InGameShop)) {
            GameObject tempObject;
            for (int i = 0; i < object.size(); i++) {
                try {
                    tempObject = object.get(i);
                    tempObject.render(g);
                } catch (NullPointerException e){
                    //Do nothing cuz nothing to worry about
                    System.out.println("Another unnecessary nullpointer from handler in render... Ignore it ;).");
                }
            }
        }
    }

    public void clearEnemies(){
        Iterator<GameObject> i = object.iterator();
        while (i.hasNext()){
            GameObject tempObject = i.next();
            if (tempObject.getId() != ID.Player && tempObject.getId() != ID.BasicCoin){
                i.remove();
            }
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

}

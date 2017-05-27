package me.max.simplefirstgame;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by max on 25-5-2017.
 */
public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void clearEnemies(){
        Iterator<GameObject> i = object.iterator();
        while (i.hasNext()){
            GameObject tempObject = i.next();
            if (tempObject.getId() != ID.Player){
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

package me.max.squared.data;

import me.max.squared.menus.MenuShop;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by max on 4-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class Datas implements Serializable{

    public int highscore;
    public int coins;
    public int skinstate;
    public int lives;
    public ArrayList purchasedSkins;
    public ArrayList purchasedUpgrades;
    public MenuShop.SkinSTATE currentSkin;


}

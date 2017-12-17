package me.max.squared.data;

import me.max.squared.menus.MenuShop;

import java.io.Serializable;
import java.util.List;

/**
 * Created by max on 4-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class Datas implements Serializable {

    public int highscore;
    public int coins;
    public int skinstate;
    public int lives;
    public List<MenuShop.SkinSTATE> purchasedSkins;
    public List<MenuShop.StoreUpgrades> purchasedUpgrades;
    public MenuShop.SkinSTATE currentSkin;


}

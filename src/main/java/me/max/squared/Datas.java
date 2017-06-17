package me.max.squared;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by max on 4-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class Datas implements Serializable{

    int highscore;
    int coins;
    int skinstate;
    int lives;
    ArrayList purchasedSkins;
    ArrayList purchasedUpgrades;
    MenuShop.SkinSTATE currentSkin;


}

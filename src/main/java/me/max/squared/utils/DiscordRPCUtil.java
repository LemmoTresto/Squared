package me.max.squared.utils;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.Callback;
import com.jagrosh.discordipc.entities.RichPresence;
import com.jagrosh.discordipc.exceptions.NoDiscordClientException;
import jdk.nashorn.internal.codegen.CompilerConstants;
import me.max.squared.Game;
import me.max.squared.handlers.others.HUD;

import java.time.OffsetDateTime;
import java.util.function.Consumer;

/**
 * Created by max on 15-12-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class DiscordRPCUtil {

    private static IPCClient client;

    public static void initDiscord() {
        client = new IPCClient(391356322316288011L);
        client.setListener(new IPCListener() {
            @Override
            public void onReady(IPCClient client) {
                RichPresence.Builder builder = new RichPresence.Builder();
                builder.setState("Main menu")
                        .setDetails("Highscore: " + HUD.highScore)
                        .setStartTimestamp(OffsetDateTime.now())
                        .setLargeImage("main-large")
                        .setSmallImage("main-small");
                client.sendRichPresence(builder.build(), new Callback((Consumer<String>) System.out::println));
            }
        });
        try {
            client.connect();
        } catch (NoDiscordClientException e) {
            System.out.println("No discord client so not using discord rich presence!");
        }
    }

    private static boolean isDiscordReady() {
        return client.getStatus().equals(IPCClient.Status.CONNECTED);
    }

    public static void shutdownDiscord() {
        try {
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Shutdown Discord RPC");
    }

    public static void updatePresence() {
        if (isDiscordReady()) {
            Game.STATE state = Game.gameState;
            if (state.toString().startsWith("Level")) {
                RichPresence.Builder builder = new RichPresence.Builder();
                builder.setState("Playing level " + state.toString().replace("Level", ""))
                        .setDetails("On wave " + HUD.getWave())
                        .setStartTimestamp(OffsetDateTime.now())
                        .setLargeImage("main-large")
                        .setSmallImage("main-small");
                client.sendRichPresence(builder.build());

            } else if (state.equals(Game.STATE.HardcoreMode)) {
                RichPresence.Builder builder = new RichPresence.Builder();
                builder.setState("Playing hardcore mode!")
                        .setDetails("On wave " + HUD.getWave())
                        .setStartTimestamp(OffsetDateTime.now())
                        .setLargeImage("main-large")
                        .setSmallImage("main-small");
                client.sendRichPresence(builder.build());
            } else {
                RichPresence.Builder builder = new RichPresence.Builder();
                builder.setState("Main menu")
                        .setDetails("Highscore: " + HUD.highScore)
                        .setStartTimestamp(OffsetDateTime.now())
                        .setLargeImage("main-large")
                        .setSmallImage("main-small");
                client.sendRichPresence(builder.build());
            }
        }
    }
}

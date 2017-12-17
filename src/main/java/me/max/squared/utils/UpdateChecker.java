package me.max.squared.utils;

import com.google.gson.JsonObject;
import me.max.squared.Game;

import static me.max.squared.Game.getGson;

/**
 * Created by max on 19-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class UpdateChecker {


    /**
     * Check the build hash of Squared against the latest hashes from GitHub
     *
     * @return boolean indicating if an update to Squared is available
     */
    public boolean checkForUpdates() {
        try {
            String buildHash = Game.getManifestValue("Git-Revision");

            if (buildHash == null || buildHash.equalsIgnoreCase("unknown")) {
                System.out.println("Git-Revision wasn't available, Squared is a dev build");
                return false;
            }

            String masterHash = getGson().fromJson(HttpUtil.requestHttp("https://api.github.com/repos/MaxiMiniJaniJos/Squared/git/refs/heads/master"), JsonObject.class).getAsJsonObject("object").get("sha").getAsString();
            JsonObject masterComparisonResult = getGson().fromJson(HttpUtil.requestHttp("https://api.github.com/repos/MaxiMiniJaniJos/Squared/compare/" + masterHash + "..." + buildHash), JsonObject.class);
            String masterStatus = masterComparisonResult.get("status").getAsString();
            switch (masterStatus.toLowerCase()) {
                case "ahead":
                    String developHash = getGson().fromJson(HttpUtil.requestHttp("https://api.github.com/repos/MaxiMiniJaniJos/Squared/git/refs/heads/develop"), JsonObject.class).getAsJsonObject("object").get("sha").getAsString();
                    JsonObject developComparisonResult = getGson().fromJson(HttpUtil.requestHttp("https://api.github.com/repos/MaxiMiniJaniJos/Squared/compare/" + developHash + "..." + buildHash), JsonObject.class);
                    String developStatus = developComparisonResult.get("status").getAsString();
                    switch (developStatus.toLowerCase()) {
                        case "ahead":
                            System.out.println("This build of Squared is ahead of master and develop. [latest private dev build]");
                            return false;
                        case "identical":
                            System.out.println("This build of Squared is identical to develop. [latest public dev build]");
                            return false;
                        case "behind":
                            System.out.println("This build of Squared is ahead of master but behind develop. Update your development build!");
                            return true;
                    }
                    return false;
                case "behind":
                    System.out.println("The current build of Squared is outdated by " + masterComparisonResult.get("behind_by").getAsInt() + " versions!");
                    return true;
                case "identical":
                    System.out.println("Squared is up-to-date. (" + buildHash + ")");
                    return false;
                default:
                    System.out.println("Got weird build comparison status from GitHub: " + masterStatus + ". Assuming Squared is up-to-date.");
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Update check failed: " + e.getMessage());
            return false;
        }
    }


}

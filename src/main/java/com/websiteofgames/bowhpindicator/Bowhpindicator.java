package com.websiteofgames.bowhpindicator;

import com.websiteofgames.bowhpindicator.events.BowHitEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bowhpindicator extends JavaPlugin {
private static Bowhpindicator plugin;

    public static Bowhpindicator getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        this.saveDefaultConfig();
getServer().getPluginManager().registerEvents(new BowHitEvent(), this);
        try {
            boolean a = (boolean) Bowhpindicator.getPlugin().getConfig().get("Arrow.Sound");
            boolean b = (boolean) Bowhpindicator.getPlugin().getConfig().get("Arrow.ActionBar");
            boolean c = (boolean) Bowhpindicator.getPlugin().getConfig().get("Arrow.ChatMessage");
            boolean d = (boolean) Bowhpindicator.getPlugin().getConfig().get("Melee.ChatMessage");
            boolean e = (boolean) Bowhpindicator.getPlugin().getConfig().get("Melee.ActionBar");
        }catch (Exception e){
            for (Player player1: Bowhpindicator.getPlugin().getServer().getOnlinePlayers()){
                if (player1.isOp()){
                    player1.sendMessage("§c[BowHPIndicator] Something is wrong with the config! If you cannot fix this error, just delete the config.yml file! BowHPIndicator will restore the file!");
                    Bowhpindicator.getPlugin().getServer().getConsoleSender().sendMessage("§c[BowHPIndicator] Something is wrong with the config! If you cannot fix this error, just delete the config.yml file! BowHPIndicator will restore it!");
                }
            }
        }
    }





}

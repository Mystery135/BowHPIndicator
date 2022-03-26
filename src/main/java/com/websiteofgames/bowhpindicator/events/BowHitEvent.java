package com.websiteofgames.bowhpindicator.events;

import com.websiteofgames.bowhpindicator.Bowhpindicator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Objects;

public class BowHitEvent implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event){




        Bukkit.getScheduler().runTaskLater(Bowhpindicator.getPlugin(), () -> {
        if (!(event.getDamager() instanceof  Player)){
            return;
        }
        if (!(event.getEntity() instanceof LivingEntity)){
            return;
        }
        StringBuilder hp = new StringBuilder("§4");


        Player player = (Player) event.getDamager();
            double roundhp = Math.round(((LivingEntity) event.getEntity()).getHealth() * 100.0) / 100.0;
            double inthp = Math.round(((LivingEntity) event.getEntity()).getHealth());
        if (inthp%2 == 1){

            for (int i = 0; i<inthp/2-1; i++){
                hp.append("❤");

            }
            hp.append("§c❤");

        }else{
            for (int i = 0; i<inthp/2; i++){
                hp.append("❤");

            }

        }
            while (StringUtils.countMatches(hp.toString(), "❤") < Objects.requireNonNull(((LivingEntity) event.getEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH)).getBaseValue()/2){
                hp.append("§0❤");
            }
            try {
            boolean a = (boolean) Bowhpindicator.getPlugin().getConfig().get("Melee.ActionBar");
            boolean b = (boolean) Bowhpindicator.getPlugin().getConfig().get("Melee.ChatMessage");
            boolean c = (boolean) Bowhpindicator.getPlugin().getConfig().get("Arrow.ActionBar");
            boolean d = (boolean) Bowhpindicator.getPlugin().getConfig().get("Arrow.Sound");
            boolean e = (boolean) Bowhpindicator.getPlugin().getConfig().get("Arrow.ChatMessage");
            if (b){
                player.sendMessage("§a§l(!) §e" + (event.getEntity()).getName() + " §7is on §c" + roundhp + " §7HP!");
            }
if (a){
    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§4" +  hp));
}



        }catch (Exception e){
            for (Player player1: Bowhpindicator.getPlugin().getServer().getOnlinePlayers()){
                if (player1.isOp()){
                    player1.sendMessage("§c[BowHPIndicator] Something is wrong with the config! If you cannot fix this error, just delete the config.yml file! BowHPIndicator will restore the file!");
                    Bowhpindicator.getPlugin().getServer().getConsoleSender().sendMessage("§c[BowHPIndicator] Something is wrong with the config! If you cannot fix this error, just delete the config.yml file! BowHPIndicator will restore it!");
                }
            }
        }

        }, 1);
    }    @EventHandler
    public void onBowHit(ProjectileHitEvent event){


        Bukkit.getScheduler().runTaskLater(Bowhpindicator.getPlugin(), () -> {
        if (!(event.getEntity().getShooter() instanceof  Player)){
            return;
        }
        if (!(event.getHitEntity() instanceof LivingEntity)){
            return;
        }
        StringBuilder hp = new StringBuilder("§4");


        Player player = (Player) event.getEntity().getShooter();
            double roundhp = Math.round(((LivingEntity) event.getHitEntity()).getHealth() * 100.0) / 100.0;
            double inthp = Math.round(((LivingEntity) event.getHitEntity()).getHealth());
        if (inthp%2 == 1){

            for (int i = 0; i<inthp/2-1; i++){
                hp.append("❤");

            }
            hp.append("§c❤");

        }else{
            for (int i = 0; i<inthp/2; i++){
                hp.append("❤");

            }

        }
            while (StringUtils.countMatches(hp.toString(), "❤") < Objects.requireNonNull(((LivingEntity) event.getHitEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH)).getBaseValue()/2){
                hp.append("§0❤");
            }

            try {
                boolean a = (boolean) Bowhpindicator.getPlugin().getConfig().get("Arrow.Sound");
                boolean b = (boolean) Bowhpindicator.getPlugin().getConfig().get("Arrow.ActionBar");
                boolean c = (boolean) Bowhpindicator.getPlugin().getConfig().get("Arrow.ChatMessage");
                boolean d = (boolean) Bowhpindicator.getPlugin().getConfig().get("Melee.ChatMessage");
                boolean e = (boolean) Bowhpindicator.getPlugin().getConfig().get("Melee.ActionBar");
                if (a){
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0.5f);

                }

                if (c){
                    player.sendMessage("§a§l(!) §e" + (event.getHitEntity()).getName() + " §7is on §c" + roundhp + " §7HP!");
                }
                if (b){
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§4" +  hp));
                }




            }catch (Exception e){
                for (Player player1: Bowhpindicator.getPlugin().getServer().getOnlinePlayers()){
                    if (player1.isOp()){
                        player1.sendMessage("§c[BowHPIndicator] Something is wrong with the config! If you cannot fix this error, just delete the config.yml file! BowHPIndicator will restore the file!");
                        Bowhpindicator.getPlugin().getServer().getConsoleSender().sendMessage("§c[BowHPIndicator] Something is wrong with the config! If you cannot fix this error, just delete the config.yml file! BowHPIndicator will restore it!");
                    }
                }
            }        }, 1);
    }



}

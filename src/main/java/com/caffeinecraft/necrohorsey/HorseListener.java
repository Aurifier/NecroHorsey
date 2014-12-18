package com.caffeinecraft.necrohorsey;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * Created by drew on 6/21/14.
 */
public class HorseListener implements Listener {

    @EventHandler
    public void onHorseDamage(EntityDamageEvent event) {
        if (event.getEntity().getType() == EntityType.HORSE) {
            Horse horse = (Horse) event.getEntity();
            Horse.Variant variant;
            //If the horse is about to die
            if (horse.getHealth() <= event.getDamage()) {
                switch (event.getCause()) {
                    case FIRE:
                    case FIRE_TICK:
                        variant = Horse.Variant.SKELETON_HORSE;
                        horse.setFireTicks(0);
                        break;
                    default:
                        variant = Horse.Variant.UNDEAD_HORSE;
                }
                horse.setVariant(variant);
                horse.setMaxHealth(52f);
                horse.setHealth(horse.getMaxHealth());
                event.setCancelled(true);
            }
        }
    }
}

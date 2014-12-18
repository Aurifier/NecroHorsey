package com.caffeinecraft.necrohorsey;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by drew on 6/21/14.
 */
public final class NecroHorsey extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new HorseListener(), this);
    }
}

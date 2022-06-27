package me.roinujnosde.protectionprovider;

import me.roinujnosde.protectionprovider.provider.PS6Provider;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class SimpleClansPlotSquared6 extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTask(this, this::registerProvider);
    }

    private void registerProvider() {
        PluginManager pluginManager = getServer().getPluginManager();
        if (pluginManager.getPlugin("PlotSquared") == null) {
            getLogger().severe("PlotSquared not found! Disabling...");
            pluginManager.disablePlugin(this);
            return;
        }
        Plugin scPl = pluginManager.getPlugin("SimpleClans");
        if (scPl == null) {
            getLogger().severe("SimpleClans not found! Disabling...");
            pluginManager.disablePlugin(this);
            return;
        }
        getLogger().info("Registering provider...");
        new PS6Provider().register();
    }
}

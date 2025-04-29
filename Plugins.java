package Plugintest.plugins;

import org.bukkit.plugin.java.JavaPlugin;

public final class Plugins extends JavaPlugin {

    private static Plugins instance;


    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new SheepColor(),this);
        getServer().getPluginManager().registerEvents(new EggPlosion(), this);
        getServer().getPluginManager().registerEvents(new Trail(), this);
        getServer().getPluginManager().registerEvents(new Fireworks(), this);
        getCommand("gravswitch").setExecutor(new GravSwitch());
    }

    @Override
    public void onDisable() {
        System.out.println("Disabled SheepColor Plugin");
        System.out.println("Disabled Egg Plugin");
        System.out.println("Disabled Trail Plugin");
    }

    public static Plugins getInstance() {
        return instance;
    }

}

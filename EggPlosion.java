package Plugintest.plugins;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.util.Vector;

public class EggPlosion implements Listener {

    @EventHandler

    public void onEntityExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof TNTPrimed) {
            Location location = event.getLocation();

            event.setCancelled(true);

            location.getWorld().createExplosion(
                    location,
                    125,// power
                    false,//fire
                    true//blocks
            );
        }
    }

    @EventHandler
    //egg throwing
    public void onPlayerEggThrow(PlayerEggThrowEvent event) {
        org.bukkit.entity.Egg egg = event.getEgg();
        Player player = event.getPlayer();

        //velocity altering
        Bukkit.getScheduler().runTaskLater(Plugins.getPlugin(Plugins.class), () -> {
            Vector customVelocity = new Vector(200, 200, 200); // (X, Y, Z)
            egg.setVelocity(customVelocity);
        }, 1L);

        //makes egg hatch a prime tnt on impact
        Bukkit.getScheduler().runTaskLater(Plugins.getPlugin(Plugins.class), () -> {
            TNTPrimed tnt = egg.getWorld().spawn(egg.getLocation(), TNTPrimed.class);
            tnt.setFuseTicks(1);
        }, 1L);
    }
}





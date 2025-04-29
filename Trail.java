package Plugintest.plugins;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Trail implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        Player player = (Player) event.getPlayer();
        if (player.isSprinting()) {
            Location location = event.getPlayer().getLocation();
            location.setY(location.getY() - 1);

            if (location.getBlock().getType() != Material.AIR) {
                player.getWorld().getBlockAt(location).setType(Material.PURPLE_CONCRETE);
            }
        }
    }
}

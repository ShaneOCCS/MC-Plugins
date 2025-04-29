package Plugintest.plugins;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;


public class GravSwitch implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase("gravswitch")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                player.setGlowing(true);
                player.setInvulnerable(true);
                player.setGravity(false);
                player.setVelocity(new Vector(0, 2, 0));

                List<Entity> nearbyEntities = player.getNearbyEntities(10, 10, 10);

                for (Entity entity : nearbyEntities) {
                    if (entity instanceof Animals) {
                        entity.setGlowing(true);
                        entity.setInvulnerable(true);
                        entity.setGravity(false);
                        entity.setVelocity(new Vector(0, 2, 0));
                    }
                    entity.setGlowing(false);
                }

                player.sendMessage("Gravity has been flipped");

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.setGravity(true);
                        player.sendMessage("Gravity returned to normal! ");

                        for (Entity entity : nearbyEntities) {
                            if (entity instanceof Animals) {
                                entity.setGravity(true);
                            }
                        }
                    }
                }.runTaskLater(Plugins.getInstance(), 20L);

            } else {
                commandSender.sendMessage("Only players can use this command LOL");
            }
            return true; //flip
        }
        return false; //no flip
    }
}



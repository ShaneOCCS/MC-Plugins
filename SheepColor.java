package Plugintest.plugins;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class SheepColor implements Listener {

    @EventHandler
    public void onSheepSpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.SHEEP) {
            Sheep sheep = (Sheep) event.getEntity();
            sheep.setColor(DyeColor.BLACK);
            sheep.setCustomName("Dinnerbone");
        }
    }

    @EventHandler
    public void onSheepDeath(EntityDeathEvent event) {
        if (event.getEntityType() == EntityType.SHEEP) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.BLACK_DYE, 1));
        }
    }
}


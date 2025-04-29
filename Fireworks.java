package Plugintest.plugins;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.Material;
import org.bukkit.util.Vector;
import org.bukkit.entity.Firework;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FireworkExplodeEvent;

public class Fireworks implements Listener {
    @EventHandler
    public void onFireworkExplode(FireworkExplodeEvent event) {

        Firework firework = event.getEntity();
        Location loc = firework.getLocation();
        World world = loc.getWorld();

        int r = 10;
        for (int dx = -r; dx < r; dx++) {
            for (int dy = -r; dy < r; dy++) {
                for (int dz = -r; dz < r; dz++) {

                    Location spawnLoc = loc.clone().add(dx, dy, dz);
                    FallingBlock fallingSand = world.spawnFallingBlock(
                            spawnLoc, Material.DIAMOND_BLOCK.createBlockData()
                    );

                    fallingSand.setDropItem(false);

                    double vx = (Math.random() - 0.5) * 0.4;
                    double vy = Math.random() * 0.5;
                    double vz = (Math.random() - 0.5) * 0.4;
                    fallingSand.setVelocity(new Vector(vx, vy, vz));
                }
            }
        }
    }
}

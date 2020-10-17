package masa3mc.masa3lobby.Listener;

import masa3mc.masa3lobby.Masa3Lobby;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GateListener implements Listener {

    private final ArrayList<Player> ingate = new ArrayList<>();
    private final Masa3Lobby instance = Masa3Lobby.instance;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerMoveGate(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (ingate.contains(player)) {
            return;
        }
        Location loc = player.getLocation();
        YamlConfiguration yml = Masa3Lobby.portal_yml;
        int x = (int) loc.getX();
        int y = (int) loc.getY();
        int z = (int) loc.getZ();
        for (String server : Arrays.asList("Creative","Survival","Athletic","PvP")) {
            if (x >= yml.getInt("Gate."+server+".min.X") && x <= yml.getInt("Gate."+server+".max.X") &&
                    y >= yml.getInt("Gate."+server+".min.Y") && y <= yml.getInt("Gate."+server+".max.Y") &&
                    z >= yml.getInt("Gate."+server+".min.Z") && z <= yml.getInt("Gate."+server+".max.Z")) {
                try {
                    ingate.add(player);
                    Masa3Lobby.bungeecord().Connect(player, server);
                    new BukkitRunnable() {
                        public void run() {
                            ingate.remove(player);
                        }

                    }.runTaskLater(instance, 20*5);
                } catch (IOException e) {
                    ingate.remove(player);
                }
            }
        }
    }


}

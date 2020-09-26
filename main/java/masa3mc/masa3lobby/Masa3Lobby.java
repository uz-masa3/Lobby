package masa3mc.masa3lobby;

import masa3mc.masa3lobby.Listener.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public final class Masa3Lobby extends JavaPlugin {

    public static Masa3Lobby instance = null;
    private static BungeeCord bungeecord = null;

    @Override
    public void onEnable() {
        instance = this;
        bungeecord = new BungeeCord();
        Bukkit.getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(this,"BungeeCord", (PluginMessageListener) bungeecord);
        Bukkit.getPluginManager().registerEvents(new Listeners(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

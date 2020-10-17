package masa3mc.masa3lobby;

import masa3mc.masa3lobby.Listener.GateListener;
import masa3mc.masa3lobby.Listener.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.File;
import java.io.IOException;

public final class Masa3Lobby extends JavaPlugin {

    public static Masa3Lobby instance = null;
    private static BungeeCord bungeecord = null;
    public static YamlConfiguration portal_yml = null;

    @Override
    public void onEnable() {
        instance = this;
        bungeecord = new BungeeCord();
        saveDefaultConfig();
        createyml();
        portal_yml = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "portals.yml"));
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        Bukkit.getPluginManager().registerEvents(new GateListener(), this);

    }

    private void createyml() {
        File file = new File(getDataFolder(), "portals.yml");
        portal_yml = YamlConfiguration.loadConfiguration(file);

        if (file.exists()) {
            return;
        }

        portal_yml.set("Gate.Athletic.min.X", 84);
        portal_yml.set("Gate.Athletic.min.Y", 35);
        portal_yml.set("Gate.Athletic.min.Z", -90);
        portal_yml.set("Gate.Athletic.max.X", 104);
        portal_yml.set("Gate.Athletic.max.Y", 60);
        portal_yml.set("Gate.Athletic.max.Z", -90);
        //
        portal_yml.set("Gate.Creative.min.X", 49);
        portal_yml.set("Gate.Creative.min.Y", 35);
        portal_yml.set("Gate.Creative.min.Z", -144);
        portal_yml.set("Gate.Creative.max.X", 49);
        portal_yml.set("Gate.Creative.max.Y", 60);
        portal_yml.set("Gate.Creative.max.Z", -124);
        //
        portal_yml.set("Gate.Survival.min.X", 84);
        portal_yml.set("Gate.Survival.min.Y", 35);
        portal_yml.set("Gate.Survival.min.Z", -177);
        portal_yml.set("Gate.Survival.max.X", 104);
        portal_yml.set("Gate.Survival.max.Y", 60);
        portal_yml.set("Gate.Survival.max.Z", -177);
        //
        portal_yml.set("Gate.PvP.min.X", 138);
        portal_yml.set("Gate.PvP.min.Y", 35);
        portal_yml.set("Gate.PvP.min.Z", -144);
        portal_yml.set("Gate.PvP.max.X", 138);
        portal_yml.set("Gate.PvP.max.Y", 60);
        portal_yml.set("Gate.PvP.max.Z", -124);

        try {
            portal_yml.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BungeeCord bungeecord() {
        return bungeecord;
    }

}

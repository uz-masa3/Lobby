package masa3mc.masa3lobby.Listener;

import masa3mc.masa3lobby.Masa3Lobby;
import masa3mc.masa3lobby.Other.setItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

import java.io.IOException;

public class Listeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        player.teleport(player.getWorld().getSpawnLocation());
        setItems.setInv(player);
        player.sendTitle("§7§l-=§6Masa3MCNetwork§7§l=-", "§bGen2", 20, 100, 20);
        for (Player player1 : Bukkit.getOnlinePlayers()) {
            player1.getWorld().playSound(player1.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 2);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 2);
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 2);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE) {
            event.setCancelled(true);
        } else {
            return;
        }
    }

    @EventHandler
    public void onClickServerSelect(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "-ServerSelect-")) {
                setItems.openMenu(player);
            }
        }
    }

    @EventHandler
    public void onServerSelect(InventoryClickEvent event){
        Inventory inv = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(setItems.serverselect_string)){
            event.setCancelled(true);
            int raw = event.getRawSlot();
            try {
                switch (raw) {
                    case 1:
                        Masa3Lobby.bungeecord().Connect(player, "Creative");
                        player.closeInventory();
                        break;
                    case 3:
                        Masa3Lobby.bungeecord().Connect(player, "Survival");
                        player.closeInventory();
                        break;
                    case 5:
                        Masa3Lobby.bungeecord().Connect(player, "Athletic");
                        player.closeInventory();
                        break;
                    case 7:
                        Masa3Lobby.bungeecord().Connect(player, "PvP");
                        player.closeInventory();
                        break;
                    default:
                        break;
                }
            } catch (IOException e) {
            }
        }
    }

}

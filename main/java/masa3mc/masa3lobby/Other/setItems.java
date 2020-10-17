package masa3mc.masa3lobby.Other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class setItems {

    private static ItemStack creative = null;
    private static ItemStack survival = null;
    private static ItemStack pvp = null;
    private static ItemStack athletic = null;

    public static String serverselect_string = ChatColor.GOLD + "-ServerSelect-";

    public static void setInv(Player player) {
        player.getInventory().clear();

        ItemStack item1 = new ItemStack(Material.CLOCK);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName(serverselect_string);
        item1.setItemMeta(meta1);

        ItemStack item2 = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(ChatColor.AQUA + "-FishingRod-");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        player.getInventory().setItem(1, item1);
        player.getInventory().setItem(7, item2);
    }

    public static void openMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9, serverselect_string);
        creative = new ItemStack(Material.OAK_LOG);
        ItemMeta creative_meta = creative.getItemMeta();
        creative_meta.setDisplayName(ChatColor.YELLOW + "Creative");
        ArrayList<String> creative_lore = new ArrayList<String>();
        creative_lore.add(ChatColor.RED + "ver 1.16.*");
        //lore1.add("§fメンテナンス中...");
        creative_meta.setLore(creative_lore);
        creative.setItemMeta(creative_meta);

        survival = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta survival_meta = survival.getItemMeta();
        survival_meta.setDisplayName(ChatColor.GREEN + "Survival");
        ArrayList<String> survival_lore = new ArrayList<String>();
        survival_lore.add(ChatColor.RED + "ver 1.16.3");
        survival_meta.setLore(survival_lore);
        survival.setItemMeta(survival_meta);

        athletic = new ItemStack(Material.FEATHER);
        ItemMeta athletic_meta = athletic.getItemMeta();
        athletic_meta.setDisplayName(ChatColor.AQUA + "Athletic");
        ArrayList<String> athletic_lore = new ArrayList<String>();
        athletic_lore.add(ChatColor.RED + "ver 1.12.2");
        athletic_meta.setLore(athletic_lore);
        athletic.setItemMeta(athletic_meta);

        pvp = new ItemStack(Material.IRON_SWORD);
        ItemMeta pvp_meta = pvp.getItemMeta();
        pvp_meta.setDisplayName(ChatColor.DARK_RED + "PvP");
        ArrayList<String> pvp_lore = new ArrayList<String>();
        pvp_lore.add(ChatColor.RED + "ver 1.8~1.16.3");
        pvp_lore.add("§f1.8.8で入ることを推奨します。");
        pvp_meta.setLore(pvp_lore);
        pvp.setItemMeta(pvp_meta);


        inv.setItem(1, creative);
        inv.setItem(3, survival);
        inv.setItem(5, athletic);
        inv.setItem(7, pvp);
        player.openInventory(inv);
    }
}

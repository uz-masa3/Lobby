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
    public void setInv(Player player){
        player.getInventory().clear();

        ItemStack item1 = new ItemStack(Material.CLOCK);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName(ChatColor.GOLD + "-ServerSelect-");
        item1.setItemMeta(meta1);

        ItemStack item2 = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(ChatColor.AQUA + "-FishingRod-");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        player.getInventory().setItem(1,item1);
        player.getInventory().setItem(7,item2);
    }
    public void openMenu(Player player){
        Inventory inv = Bukkit.createInventory(null,9,ChatColor.GOLD + "-Server Select-");


        ItemStack item1 = new ItemStack(Material.OAK_LOG);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName(ChatColor.YELLOW + "Creative");
        ArrayList<String> lore1 = new ArrayList<String>();
        lore1.add(ChatColor.RED + "ver 1.16.*");
        //lore1.add("§fメンテナンス中...");
        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        inv.setItem(1, item1);


        ItemStack item2 = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(ChatColor.GREEN + "Survival");
        ArrayList<String> lore2 = new ArrayList<String>();
        lore2.add(ChatColor.RED + "ver 1.16.3");
        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        inv.setItem(3, item2);


        ItemStack item3 = new ItemStack(Material.FEATHER);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName(ChatColor.AQUA + "Athletic");
        ArrayList<String> lore3 = new ArrayList<String>();
        lore3.add(ChatColor.RED + "ver 1.12.2");
        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        inv.setItem(5, item3);


        ItemStack item4 = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName(ChatColor.DARK_RED + "PvP");
        ArrayList<String> lore4 = new ArrayList<String>();
        lore4.add(ChatColor.RED + "ver 1.8~1.16.3");
        lore4.add("§f1.8.8で入ることを推奨します。");
        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        inv.setItem(7, item4);

        player.openInventory(inv);
    }
}

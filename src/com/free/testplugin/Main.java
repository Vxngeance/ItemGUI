package com.free.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Test plugin is enabled!");

        getCommand("menu").setExecutor(new MenuCommand(this));
    }

    /* ELYTRA UI */

    public void applyElytraUI(Player player) {

        // BEGINNING
        Inventory gui = Bukkit.createInventory(null, 44, ChatColor.GREEN + "Elytra menu!");
        // LORES
        List<String> enableLore = new ArrayList<>();
        enableLore.add(ChatColor.GRAY + "Click me for the");
        enableLore.add(ChatColor.GRAY + "best time of your life!");

        List<String> disableLore = new ArrayList<>();
        disableLore.add(ChatColor.GRAY + "Click me for the");
        disableLore.add(ChatColor.GRAY + "worst time of your life");

        List<String> launchLore = new ArrayList<>();
        launchLore.add(ChatColor.GRAY + "Click to be launched!");
        launchLore.add(ChatColor.GRAY + "up by 200 blocks! :D");

        // ITEMSTACKS
        ItemStack toggle;
        ItemMeta toggleMeta;
        if (player.getInventory().getChestplate().getType() != null
                && player.getInventory().getChestplate().equals(Material.ELYTRA)) {
            toggle = new ItemStack(Material.REDSTONE_BLOCK);

            toggleMeta = toggle.getItemMeta();
            toggleMeta.setDisplayName(ChatColor.RED + "Disable Elytra!");
            toggleMeta.setLore(disableLore);

        } else {
            toggle = new ItemStack(Material.EMERALD_BLOCK);

            toggleMeta = toggle.getItemMeta();
            toggleMeta.setDisplayName(ChatColor.GREEN + "Enable Elytra!");
            toggleMeta.setLore(enableLore);
        }
        toggle.setItemMeta(toggleMeta);

        ItemStack launch = new ItemStack(Material.WEB);
        ItemMeta launchMeta = launch.getItemMeta();
        launchMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Launch into the air!");
        launchMeta.setLore(launchLore);
        launch.setItemMeta(launchMeta);

        // ITEM SETTING
        gui.setItem(34, toggle);
        gui.setItem(4, launch);


        // FINAL

        player.openInventory(gui);


    }

}
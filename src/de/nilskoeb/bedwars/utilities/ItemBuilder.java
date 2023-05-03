package de.nilskoeb.bedwars.utilities;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemBuilder {

    private final ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemBuilder (Material material) {
        itemStack = new ItemStack(material, 1);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder (Material material, int amount) {
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder (Material material, int amount, short data) {
        itemStack = new ItemStack(material, amount, data);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder displayName (String displayName) {
        itemMeta.setDisplayName(displayName);
        return this;
    }

    public ItemBuilder lore (ArrayList<String> lore) {
        itemMeta.setLore(lore);
        return this;
    }

    public ItemBuilder enchant (Enchantment enchantment, int level, boolean skipMaxLevelRestriction) {
        itemMeta.addEnchant(enchantment, level, skipMaxLevelRestriction);
        return this;
    }

    public ItemBuilder flag (ItemFlag... itemFlags) {
        itemMeta.addItemFlags(itemFlags);
        return this;
    }

    public ItemBuilder unbreakable () {
        itemMeta.spigot().setUnbreakable(true);
        return this;
    }

    public ItemStack toItemStack () {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}

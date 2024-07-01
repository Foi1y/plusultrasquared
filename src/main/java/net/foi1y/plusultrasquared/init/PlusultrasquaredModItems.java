/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.foi1y.plusultrasquared.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;

import net.foi1y.plusultrasquared.item.AItem;
import net.foi1y.plusultrasquared.PlusultrasquaredMod;

public class PlusultrasquaredModItems {
	public static Item A;

	public static void load() {
		A = register("a", new AItem());
	}

	public static void clientLoad() {
	}

	private static Item register(String registryName, Item item) {
		return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PlusultrasquaredMod.MODID, registryName), item);
	}

	private static void registerBlockingProperty(Item item) {
		ItemProperties.register(item, new ResourceLocation("blocking"), (ClampedItemPropertyFunction) ItemProperties.getProperty(Items.SHIELD, new ResourceLocation("blocking")));
	}
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.foi1y.plusultrasquared.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.foi1y.plusultrasquared.item.TestrunsItem;
import net.foi1y.plusultrasquared.PlusultrasquaredMod;

public class PlusultrasquaredModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PlusultrasquaredMod.MODID);
	public static final RegistryObject<Item> TESTRUNS = REGISTRY.register("testruns", () -> new TestrunsItem());
	public static final RegistryObject<Item> BLACKHOLE_SPAWN_EGG = REGISTRY.register("blackhole_spawn_egg", () -> new ForgeSpawnEggItem(PlusultrasquaredModEntities.BLACKHOLE, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> BLACK_HOLE_2_SPAWN_EGG = REGISTRY.register("black_hole_2_spawn_egg", () -> new ForgeSpawnEggItem(PlusultrasquaredModEntities.BLACK_HOLE_2, -1, -1, new Item.Properties()));
}

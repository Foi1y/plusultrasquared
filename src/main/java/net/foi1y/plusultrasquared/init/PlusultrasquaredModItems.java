
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.foi1y.plusultrasquared.init;

import org.checkerframework.checker.units.qual.A;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.foi1y.plusultrasquared.item.AItem;
import net.foi1y.plusultrasquared.PlusultrasquaredMod;

public class PlusultrasquaredModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PlusultrasquaredMod.MODID);
	public static final RegistryObject<Item> A = REGISTRY.register("a", () -> new AItem());
}


/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.foi1y.plusultrasquared.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.foi1y.plusultrasquared.potion.ReverseHealMobEffect;
import net.foi1y.plusultrasquared.PlusultrasquaredMod;

public class PlusultrasquaredModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PlusultrasquaredMod.MODID);
	public static final RegistryObject<MobEffect> REVERSE_HEAL = REGISTRY.register("reverse_heal", () -> new ReverseHealMobEffect());
}

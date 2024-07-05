
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.foi1y.plusultrasquared.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.foi1y.plusultrasquared.PlusultrasquaredMod;

public class PlusultrasquaredModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, PlusultrasquaredMod.MODID);
	public static final RegistryObject<SimpleParticleType> HEALPARTICLE = REGISTRY.register("healparticle", () -> new SimpleParticleType(false));
}

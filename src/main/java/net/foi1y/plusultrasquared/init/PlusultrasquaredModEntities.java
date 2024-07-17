
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.foi1y.plusultrasquared.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.foi1y.plusultrasquared.entity.BlackholeEntity;
import net.foi1y.plusultrasquared.entity.BlackHole2Entity;
import net.foi1y.plusultrasquared.PlusultrasquaredMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlusultrasquaredModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PlusultrasquaredMod.MODID);
	public static final RegistryObject<EntityType<BlackholeEntity>> BLACKHOLE = register("blackhole",
			EntityType.Builder.<BlackholeEntity>of(BlackholeEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(BlackholeEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BlackHole2Entity>> BLACK_HOLE_2 = register("black_hole_2",
			EntityType.Builder.<BlackHole2Entity>of(BlackHole2Entity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(BlackHole2Entity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BlackholeEntity.init();
			BlackHole2Entity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BLACKHOLE.get(), BlackholeEntity.createAttributes().build());
		event.put(BLACK_HOLE_2.get(), BlackHole2Entity.createAttributes().build());
	}
}

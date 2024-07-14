package net.foi1y.plusultrasquared.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;
import net.foi1y.plusultrasquared.PlusultrasquaredMod;

import java.util.List;
import java.util.Comparator;

public class ExplosivespeedorflightProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(PlusultrasquaredModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlusultrasquaredModVariables.PlayerVariables())).quirk).equals("Explosion")) {
			if (entity.onGround()) {
				entity.getPersistentData().putBoolean("speed", true);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, (entity.getLookAngle().x * 2), 0, (entity.getLookAngle().z * 1), 3, Level.ExplosionInteraction.NONE);
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 2), 0, (entity.getLookAngle().z * 1)));
				PlusultrasquaredMod.queueServerWork(20, () -> {
					entity.getPersistentData().putBoolean("speed", true);
				});
			} else {
				if (entity.getPersistentData().getBoolean("speed") == true) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity) && entity instanceof LivingEntity && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION)), 8);
							}
						}
					}
				}
			}
			entity.getPersistentData().putBoolean("flight", true);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getLookAngle().x * 2), 0, (entity.getLookAngle().z * 1), 3, Level.ExplosionInteraction.NONE);
			entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 2), 0.6, (entity.getLookAngle().z * 1)));
			PlusultrasquaredMod.queueServerWork(20, () -> {
				entity.getPersistentData().putBoolean("flight", true);
			});
		} else {
			if (entity.getPersistentData().getBoolean("flight") == true) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity) && entity instanceof LivingEntity && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION)), 8);
						}
					}
				}
			}
		}
	}
}

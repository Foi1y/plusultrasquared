package net.foi1y.plusultrasquared.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;

public class SuicideBombtrigger1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(PlusultrasquaredModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlusultrasquaredModVariables.PlayerVariables())).quirk).equals("Self Detonation")
				|| entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("plusultrasquared:mhaentity")))) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 6, Level.ExplosionInteraction.TNT);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
		}
	}
}

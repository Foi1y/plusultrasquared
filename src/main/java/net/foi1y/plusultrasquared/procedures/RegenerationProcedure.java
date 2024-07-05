package net.foi1y.plusultrasquared.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;

public class RegenerationProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(PlusultrasquaredModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlusultrasquaredModVariables.PlayerVariables())).quirk).equals("Hyper Regeneration")) {
			if (entity.getPersistentData().getBoolean("Regen") == false) {
				entity.getPersistentData().putBoolean("Regen", true);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100000, 2, false, false));
			} else {
				entity.getPersistentData().putBoolean("Regen", false);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.REGENERATION);
			}
		}
	}
}

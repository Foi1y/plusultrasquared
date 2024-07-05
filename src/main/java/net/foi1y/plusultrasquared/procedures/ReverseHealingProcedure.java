package net.foi1y.plusultrasquared.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;
import net.foi1y.plusultrasquared.init.PlusultrasquaredModMobEffects;

public class ReverseHealingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(PlusultrasquaredModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlusultrasquaredModVariables.PlayerVariables())).quirk).equals("Hyper Regeneration")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PlusultrasquaredModMobEffects.REVERSE_HEAL.get(), 60, 1, false, false));
		}
	}
}

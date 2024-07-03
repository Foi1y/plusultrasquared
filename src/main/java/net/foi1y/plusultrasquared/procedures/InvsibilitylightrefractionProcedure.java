package net.foi1y.plusultrasquared.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class InvsibilitylightrefractionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(PlusultrasquaredModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlusultrasquaredModVariables.PlayerVariables())).quirk).equals("Invisibility")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 1, false, false));
		}
	}
}

package net.foi1y.plusultrasquared.procedures;

import net.minecraft.world.entity.Entity;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;

public class DefineScroll3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(PlusultrasquaredModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlusultrasquaredModVariables.PlayerVariables())).ScrollSelection <= 4;
	}
}

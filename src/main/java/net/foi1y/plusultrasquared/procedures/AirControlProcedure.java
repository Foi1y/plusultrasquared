package net.foi1y.plusultrasquared.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;
import net.foi1y.plusultrasquared.PlusultrasquaredMod;

public class AirControlProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(PlusultrasquaredModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlusultrasquaredModVariables.PlayerVariables())).quirk).equals("Air Walk")
				|| entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("plusultrasquared:mhaentity")))) {
			if (entity.getPersistentData().getBoolean("levitate") == false) {
				entity.getPersistentData().putBoolean("levitate", true);
				while (entity.getPersistentData().getBoolean("levitate") == true) {
					entity.setNoGravity(true);
					if (new Object() {
						public int getScore(String score, Entity _ent) {
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective(score);
							if (_so != null)
								return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
							return 0;
						}
					}.getScore("Stamina", entity) <= 5) {
						entity.getPersistentData().putBoolean("levitate", false);
						entity.setNoGravity(false);
					} else {
						PlusultrasquaredMod.queueServerWork(200, () -> {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Stamina");
								if (_so == null)
									_so = _sc.addObjective("Stamina", ObjectiveCriteria.DUMMY, Component.literal("Stamina"), ObjectiveCriteria.RenderType.INTEGER);
								_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
									public int getScore(String score, Entity _ent) {
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective(score);
										if (_so != null)
											return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
										return 0;
									}
								}.getScore("Stamina", entity) - 5));
							}
						});
					}
				}
			} else {
				entity.getPersistentData().putBoolean("levitate", false);
				entity.setNoGravity(false);
			}
		}
	}
}

package net.foi1y.plusultrasquared.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;
import net.foi1y.plusultrasquared.init.PlusultrasquaredModParticleTypes;
import net.foi1y.plusultrasquared.PlusultrasquaredMod;

public class RegenerationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(PlusultrasquaredModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlusultrasquaredModVariables.PlayerVariables())).quirk).equals("Hyper Regeneration")) {
			if (entity.getPersistentData().getBoolean("Regen") == false) {
				entity.getPersistentData().putBoolean("Regen", true);
				while (entity.getPersistentData().getBoolean("Regen") == true) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 10, (int) 0.5, false, false));
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (PlusultrasquaredModParticleTypes.HEALPARTICLE.get()), x, y, z, 5, 0.5, 0.5, 0.5, 0.1);
					if (new Object() {
						public int getScore(String score, Entity _ent) {
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective(score);
							if (_so != null)
								return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
							return 0;
						}
					}.getScore("Stamina", entity) <= 5) {
						entity.getPersistentData().putBoolean("Regen", false);
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
				entity.getPersistentData().putBoolean("Regen", false);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.REGENERATION);
			}
		}
	}
}

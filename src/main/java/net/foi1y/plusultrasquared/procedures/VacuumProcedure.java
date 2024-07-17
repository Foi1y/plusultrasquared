package net.foi1y.plusultrasquared.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;
import net.foi1y.plusultrasquared.init.PlusultrasquaredModEntities;
import net.foi1y.plusultrasquared.entity.BlackHole2Entity;
import net.foi1y.plusultrasquared.PlusultrasquaredMod;

import java.util.Comparator;

public class VacuumProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(PlusultrasquaredModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlusultrasquaredModVariables.PlayerVariables())).quirk).equals("Black Hole")) {
			if (entity.getPersistentData().getBoolean("Singularity") == false) {
				entity.getPersistentData().putBoolean("Singularity", true);
				while (entity.getPersistentData().getBoolean("Singularity") == true) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PlusultrasquaredModEntities.BLACK_HOLE_2.get().spawn(_level, new BlockPos(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					if (new Object() {
						public int getScore(String score, Entity _ent) {
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective(score);
							if (_so != null)
								return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
							return 0;
						}
					}.getScore("Stamina", entity) <= 5) {
						entity.getPersistentData().putBoolean("Singularity", false);
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
				entity.getPersistentData().putBoolean("Singularity", false);
				if (!((Entity) world.getEntitiesOfClass(BlackHole2Entity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
					((Entity) world.getEntitiesOfClass(BlackHole2Entity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
			}
		}
	}
}

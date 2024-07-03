package net.foi1y.plusultrasquared.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WorldCreatedProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (PlusultrasquaredModVariables.MapVariables.get(world).WorldCreated == false) {
			PlusultrasquaredModVariables.MapVariables.get(world).WorldCreated = true;
			PlusultrasquaredModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"scoreboard objectives add Stamina dummy \"Stamina\"");
		}
	}
}

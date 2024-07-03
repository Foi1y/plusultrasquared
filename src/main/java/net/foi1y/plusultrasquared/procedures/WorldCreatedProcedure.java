package net.foi1y.plusultrasquared.procedures;

import net.minecraftforge.eventbus.api.Event;

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

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z
) {
if (==false) {if (world instanceof ServerLevel _level)
_level.getServer().getCommands().performPrefixedCommand(
new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO,
_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "scoreboard objectives add Stamina dummy \"Stamina\"");}
}
}

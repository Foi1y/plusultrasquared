package net.foi1y.plusultrasquared.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;

public class FlightvariableProcedure {
@Mod.EventBusSubscriber public class FlightvariableProcedure {
@SubscribeEvent public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
if (event.phase == TickEvent.Phase.END) {
execute(event,event.player.level(),event.player);
}
}
public static void execute(
LevelAccessor world,
Entity entity
) {
if(
entity == null
) return ;
if ((PlusultrasquaredModVariables.MapVariables.get(world).power).equals("Flight")) {if (PlusultrasquaredModVariables.MapVariables.get(world).flight_variable==true) {entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getXRot()+180))*0.5), (entity.getXRot()*(-0.025)), (Math.cos(Math.toRadians(entity.getXRot()))*0.5)));}}
}
}

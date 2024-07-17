
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.foi1y.plusultrasquared.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.foi1y.plusultrasquared.client.renderer.BlackholeRenderer;
import net.foi1y.plusultrasquared.client.renderer.BlackHole2Renderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PlusultrasquaredModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PlusultrasquaredModEntities.BLACKHOLE.get(), BlackholeRenderer::new);
		event.registerEntityRenderer(PlusultrasquaredModEntities.BLACK_HOLE_2.get(), BlackHole2Renderer::new);
	}
}

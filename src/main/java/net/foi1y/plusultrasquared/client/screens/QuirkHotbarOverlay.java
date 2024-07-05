
package net.foi1y.plusultrasquared.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.foi1y.plusultrasquared.procedures.DefineScroll5Procedure;
import net.foi1y.plusultrasquared.procedures.DefineScroll4Procedure;
import net.foi1y.plusultrasquared.procedures.DefineScroll3Procedure;
import net.foi1y.plusultrasquared.procedures.DefineScroll2Procedure;
import net.foi1y.plusultrasquared.procedures.DefineScroll1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class QuirkHotbarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			event.getGuiGraphics().blit(new ResourceLocation("plusultrasquared:textures/screens/quirkhotbar.png"), w / 2 + 95, h - 22, 0, 0, 102, 22, 102, 22);

			if (DefineScroll1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("plusultrasquared:textures/screens/hotbar_selection.png"), w / 2 + 94, h - 23, 0, 0, 24, 23, 24, 23);
			}
			if (DefineScroll2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("plusultrasquared:textures/screens/hotbar_selection.png"), w / 2 + 114, h - 23, 0, 0, 24, 23, 24, 23);
			}
			if (DefineScroll3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("plusultrasquared:textures/screens/hotbar_selection.png"), w / 2 + 134, h - 23, 0, 0, 24, 23, 24, 23);
			}
			if (DefineScroll4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("plusultrasquared:textures/screens/hotbar_selection.png"), w / 2 + 154, h - 23, 0, 0, 24, 23, 24, 23);
			}
			if (DefineScroll5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("plusultrasquared:textures/screens/hotbar_selection.png"), w / 2 + 174, h - 23, 0, 0, 24, 23, 24, 23);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}

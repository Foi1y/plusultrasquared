
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.foi1y.plusultrasquared.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.foi1y.plusultrasquared.network.ScrollMenuMessage;
import net.foi1y.plusultrasquared.network.ExplosiontestMessage;
import net.foi1y.plusultrasquared.PlusultrasquaredMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PlusultrasquaredModKeyMappings {
	public static final KeyMapping USE_ABILITY = new KeyMapping("key.plusultrasquared.use_ability", GLFW.GLFW_KEY_Z, "key.categories.plusultra");
	public static final KeyMapping SCROLL_MENU = new KeyMapping("key.plusultrasquared.scroll_menu", GLFW.GLFW_KEY_X, "key.categories.plusultra") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PlusultrasquaredMod.PACKET_HANDLER.sendToServer(new ScrollMenuMessage(0, 0));
				ScrollMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping EXPLOSIONTEST = new KeyMapping("key.plusultrasquared.explosiontest", GLFW.GLFW_KEY_Z, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PlusultrasquaredMod.PACKET_HANDLER.sendToServer(new ExplosiontestMessage(0, 0));
				ExplosiontestMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(USE_ABILITY);
		event.register(SCROLL_MENU);
		event.register(EXPLOSIONTEST);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SCROLL_MENU.consumeClick();
				EXPLOSIONTEST.consumeClick();
			}
		}
	}
}

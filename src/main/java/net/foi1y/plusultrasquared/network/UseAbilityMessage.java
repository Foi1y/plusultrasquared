
package net.foi1y.plusultrasquared.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.network.FriendlyByteBuf;

import net.foi1y.plusultrasquared.PlusultrasquaredMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UseAbilityMessage {
	int type, pressedms;

	public UseAbilityMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public UseAbilityMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(UseAbilityMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(UseAbilityMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
		});
		context.setPacketHandled(true);
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PlusultrasquaredMod.addNetworkMessage(UseAbilityMessage.class, UseAbilityMessage::buffer, UseAbilityMessage::new, UseAbilityMessage::handler);
	}
}

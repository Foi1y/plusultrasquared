package net.foi1y.plusultrasquared.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;

public class SelfdetonationProcedure {
public SelfdetonationProcedure() {
UseEntityCallback.EVENT.register((player, level, hand, entity, hitResult) -> {
if (hand != player).getUsedItemHand())
return;
execute(level,entity.getX(),entity.getY(),entity.getZ(),entity);
return InteractionResult.PASS;
});
}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Items.FLINT_AND_STEEL == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if ((PlusultrasquaredModVariables.MapVariables.get(world).power).equals("Self Detonation") || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mha:entity")))) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, y, z, 6, Level.ExplosionInteraction.TNT);
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(0);
			}
		}
	}
}

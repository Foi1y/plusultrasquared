
package net.foi1y.plusultrasquared.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.foi1y.plusultrasquared.entity.BlackholeEntity;
import net.foi1y.plusultrasquared.client.model.ModelBlack_Hole;

public class BlackholeRenderer extends MobRenderer<BlackholeEntity, ModelBlack_Hole<BlackholeEntity>> {
	public BlackholeRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBlack_Hole(context.bakeLayer(ModelBlack_Hole.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlackholeEntity entity) {
		return new ResourceLocation("plusultrasquared:textures/entities/black_hole.png");
	}
}

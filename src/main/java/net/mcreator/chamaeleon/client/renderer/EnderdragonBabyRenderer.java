
package net.mcreator.chamaeleon.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.BatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.ambient.Bat;

public class EnderdragonBabyRenderer extends BatRenderer {
	public EnderdragonBabyRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(Bat entity) {
		return new ResourceLocation("chamaeleon:textures/entities/enderdragon-baby.png");
	}
}

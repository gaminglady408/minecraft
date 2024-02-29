
package net.mcreator.chamaeleon.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

import net.mcreator.chamaeleon.entity.HerzliKuhEntity;

public class HerzliKuhRenderer extends MobRenderer<HerzliKuhEntity, CowModel<HerzliKuhEntity>> {
	public HerzliKuhRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel(context.bakeLayer(ModelLayers.COW)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HerzliKuhEntity entity) {
		return new ResourceLocation("chamaeleon:textures/entities/heart-cow.png");
	}
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.chamaeleon.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.chamaeleon.client.renderer.HerzliKuhRenderer;
import net.mcreator.chamaeleon.client.renderer.EnderdragonBabyRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ChamaeleonModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ChamaeleonModEntities.HERZLI_KUH.get(), HerzliKuhRenderer::new);
		event.registerEntityRenderer(ChamaeleonModEntities.ENDERDRAGON_BABY.get(), EnderdragonBabyRenderer::new);
	}
}

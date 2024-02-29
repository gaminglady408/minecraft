
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.chamaeleon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.chamaeleon.entity.HerzliKuhEntity;
import net.mcreator.chamaeleon.entity.EnderdragonBabyEntity;
import net.mcreator.chamaeleon.ChamaeleonMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChamaeleonModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ChamaeleonMod.MODID);
	public static final RegistryObject<EntityType<HerzliKuhEntity>> HERZLI_KUH = register("herzli_kuh",
			EntityType.Builder.<HerzliKuhEntity>of(HerzliKuhEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HerzliKuhEntity::new)

					.sized(0.9f, 1.4f));
	public static final RegistryObject<EntityType<EnderdragonBabyEntity>> ENDERDRAGON_BABY = register("enderdragon_baby",
			EntityType.Builder.<EnderdragonBabyEntity>of(EnderdragonBabyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EnderdragonBabyEntity::new)

					.sized(0.9f, 1.4f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			HerzliKuhEntity.init();
			EnderdragonBabyEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(HERZLI_KUH.get(), HerzliKuhEntity.createAttributes().build());
		event.put(ENDERDRAGON_BABY.get(), EnderdragonBabyEntity.createAttributes().build());
	}
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.chamaeleon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.chamaeleon.ChamaeleonMod;

public class ChamaeleonModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ChamaeleonMod.MODID);
	public static final RegistryObject<Item> HERZLI_KUH_SPAWN_EGG = REGISTRY.register("herzli_kuh_spawn_egg", () -> new ForgeSpawnEggItem(ChamaeleonModEntities.HERZLI_KUH, -13108, -65485, new Item.Properties()));
	public static final RegistryObject<Item> ENDERDRAGON_BABY_SPAWN_EGG = REGISTRY.register("enderdragon_baby_spawn_egg", () -> new ForgeSpawnEggItem(ChamaeleonModEntities.ENDERDRAGON_BABY, -16777216, -1, new Item.Properties()));
}

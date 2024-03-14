package net.mcreator.chamaeleon.init;

import net.mcreator.chamaeleon.ChamaeleonMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChamaeleonModSounds 
{
	public static final DeferredRegister<SoundEvent> REGISTRY =
			DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ChamaeleonMod.MODID);
	
	public static final RegistryObject<SoundEvent> COW_DEATH_SOUND = registerSoundEvent("herzlikuh_death");
	
	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
		ResourceLocation id = new ResourceLocation(ChamaeleonMod.MODID, name);
		return REGISTRY.register(name, () -> SoundEvent.createVariableRangeEvent(id));
	}
}

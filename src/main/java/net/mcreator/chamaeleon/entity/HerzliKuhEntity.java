
package net.mcreator.chamaeleon.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mcreator.chamaeleon.ChamaeleonMod;
import net.mcreator.chamaeleon.init.ChamaeleonModEntities;
import net.mcreator.chamaeleon.init.ChamaeleonModSounds;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.animal.Cow;
//import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

//public class HerzliKuhEntity extends Animal {
public class HerzliKuhEntity extends Cow {
	
	public static final Logger LOGGER = LogManager.getLogger(ChamaeleonMod.class);
	public static final String MODID = "chamaeleon";

	public HerzliKuhEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(ChamaeleonModEntities.HERZLI_KUH.get(), world);
	}

	public HerzliKuhEntity(EntityType<HerzliKuhEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(1.2f);
		xpReward = 3;
		setNoAi(false);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new PanicGoal(this, 1.2));
		this.goalSelector.addGoal(4, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}
	
	/**
	 *
	 */
	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean hurtbyplayer) {
		super.dropCustomDeathLoot(source, looting, hurtbyplayer);
		LOGGER.info("CHECKPOINT::dropCustomDeathLoot:dropping RED_CANDLE_CAKE, GOLD_BLOCK, PINK_CANDLE");
		
		List<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(Blocks.RED_CANDLE_CAKE));
		drops.add(new ItemStack(Blocks.GOLD_BLOCK));
		drops.add(new ItemStack(Blocks.PINK_CANDLE));
		drops.forEach(this::spawnAtLocation);
	}

	
	/**
	* Returns the sound this mob makes when it is dead.
	*/
	@Override
	protected SoundEvent getDeathSound()
	{
		LOGGER.info("CHECKPOINT::getDeathSound:calling COW_DEATH sound");
		return ChamaeleonModSounds.COW_DEATH_SOUND.get();
	}	
	
	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		LOGGER.info("CHECKPOINT::getDeathSound:calling COW_HURT sound, " + ds);
		return ChamaeleonModSounds.COW_DEATH_SOUND.get();

//		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
		builder = builder.add(Attributes.MAX_HEALTH, 12);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}

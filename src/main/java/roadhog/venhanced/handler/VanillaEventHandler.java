package roadhog.venhanced.handler;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.oredict.OreDictionary;
import roadhog.venhanced.VanillaEnhanced;
import roadhog.venhanced.block.BlockCauldronLava;
import roadhog.venhanced.block.BlockMyceliumPath;
import roadhog.venhanced.block.BlockNewFlower;
import roadhog.venhanced.block.BlockScaffolding;
import roadhog.venhanced.block.BlockStrippedLog;
import roadhog.venhanced.block.BlockStrippedLogNew;

public class VanillaEventHandler {
	
	@SuppressWarnings("unlikely-arg-type")
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onLivingDrop(LivingDropsEvent event) {
		if(event.entity instanceof EntityPlayer) {
			//Roadhog360's UUID
			if(event.entity.getUniqueID().toString().equals("390d0a39-5541-4e8e-8f07-115bb41684c4")) {
			ItemStack itemDrop = new ItemStack(VanillaEnhanced.itemChocolateCookie, 1);
			//If he dies, drop a chocolate cookie, why not?
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemDrop));
			}
			}
		if(event.entity instanceof EntityVillager) {
			Random random = new Random();
			ItemStack itemDrop = new ItemStack(Items.emerald, 1);
			if(random.nextInt(100) <= 75) {
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemDrop));
			}
			}
		if(event.entity instanceof EntitySkeleton) {
			
			Random random = new Random();
			int j = random.nextInt(4) + 1 + event.lootingLevel;
		    int wild = OreDictionary.WILDCARD_VALUE;
			
			ItemStack itemDrop = new ItemStack(VanillaEnhanced.itemWitheredBone, j);

			if (((EntitySkeleton)event.entityLiving).getSkeletonType() == 1){
				event.drops.remove(Items.bone); // LINE THAT WON'T WORK
			}
			
			if (((EntitySkeleton)event.entityLiving).getSkeletonType() == 1 && random.nextInt(100) <= 75){
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemDrop));
			}
			
			}
		}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Block block = event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z);
		
		if (block == Blocks.log || block == Blocks.log2 || block == Blocks.cauldron || block == Blocks.mycelium || block == Blocks.flower_pot) {
			BlockCauldronLava.onPlayerInteract(event);
			BlockStrippedLog.onPlayerInteract(event);
			BlockStrippedLogNew.onPlayerInteract(event);
			BlockMyceliumPath.onPlayerInteract(event);
			BlockNewFlower.onPlayerInteract(event);
		}
	}
	
	public static void overrideDefaultSettings() {
		Items.arrow.setFull3D();
    	Items.golden_pickaxe.setMaxDamage(46).setHarvestLevel("pickaxe", 2);
    	Items.golden_sword.setMaxDamage(46).setHarvestLevel("sword", 2);
		Items.golden_axe.setMaxDamage(46).setHarvestLevel("axe", 2);
    	Items.golden_shovel.setMaxDamage(46).setHarvestLevel("spade", 2);
    	Items.golden_hoe.setMaxDamage(46).setHarvestLevel("hoe", 2);
    	Items.wooden_door.setMaxStackSize(64);
    	Items.iron_door.setMaxStackSize(64);
    	Items.sign.setMaxStackSize(64);
    	Items.egg.setMaxStackSize(64);
    	Items.snowball.setMaxStackSize(64);
    	Items.iron_door.setMaxStackSize(64);
    	Items.wooden_door.setMaxStackSize(64);
    	Blocks.piston.setHarvestLevel("pickaxe", 0);
    	Blocks.piston_extension.setHarvestLevel("pickaxe", 0);
    	Blocks.piston_head.setHarvestLevel("pickaxe", 0);
    	Blocks.sticky_piston.setHarvestLevel("pickaxe", 0);
    	Blocks.packed_ice.setHarvestLevel("pickaxe", 0);
    	Blocks.glowstone.setHarvestLevel("pickaxe", 0);
    	Blocks.redstone_lamp.setHarvestLevel("pickaxe", 0);
    	Blocks.lit_redstone_lamp.setHarvestLevel("pickaxe", 0);
    	Blocks.beacon.setCreativeTab(CreativeTabs.tabDecorations).setHarvestLevel("pickaxe", 0);
    	Blocks.cactus.setStepSound(Block.soundTypeWood).setHarvestLevel("axe", 0);
    	Blocks.bed.setStepSound(Block.soundTypeWood).setHarvestLevel("axe", 0);
    	Blocks.lever.setStepSound(Block.soundTypeStone).setHarvestLevel("pickaxe", 0);
    	Blocks.end_portal_frame.setStepSound(Block.soundTypeStone);
    	Blocks.fire.setStepSound(Block.soundTypeCloth);
    	Blocks.hopper.setStepSound(Block.soundTypeMetal);
    	Blocks.cauldron.setStepSound(Block.soundTypeMetal);
    	Blocks.jukebox.setStepSound(Block.soundTypeWood);
    	Blocks.noteblock.setStepSound(Block.soundTypeWood);
    	Blocks.nether_wart.setStepSound(Block.soundTypeWood);
    	Blocks.redstone_wire.setStepSound(Block.soundTypeSand);
    	Blocks.unpowered_repeater.setStepSound(Block.soundTypeStone);
    	Blocks.powered_repeater.setStepSound(Block.soundTypeStone);
    	Blocks.unpowered_comparator.setStepSound(Block.soundTypeStone);
    	Blocks.powered_comparator.setStepSound(Block.soundTypeStone);
    	Blocks.light_weighted_pressure_plate.setStepSound(Block.soundTypeMetal);
    	Blocks.heavy_weighted_pressure_plate.setStepSound(Block.soundTypeMetal);
    	Blocks.end_portal_frame.setStepSound(Block.soundTypeStone);
    	Blocks.mycelium.setStepSound(Block.soundTypeGravel);
    	Blocks.command_block.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.water.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.lava.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.dragon_egg.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.lit_furnace.setCreativeTab(VanillaEnhanced.tabHidden).setBlockName("BlockLitFurnace");
    	Blocks.lit_redstone_ore.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.cocoa.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.portal.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.end_portal.setCreativeTab(VanillaEnhanced.tabHidden).setBlockName("BlockEndPortal");
    	Blocks.farmland.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.fire.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.mob_spawner.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.sponge.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.brown_mushroom_block.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.red_mushroom_block.setCreativeTab(VanillaEnhanced.tabHidden);
    	Blocks.double_stone_slab.setCreativeTab(CreativeTabs.tabBlock);
    	Blocks.monster_egg.setCreativeTab(VanillaEnhanced.tabHidden);
    	Items.command_block_minecart.setCreativeTab(VanillaEnhanced.tabHidden);
    	Items.fireworks.setCreativeTab(VanillaEnhanced.tabHidden);
	}
	
}

package roadhog.venhanced.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;
import scala.Int;

public class ItemBlazicitePickaxe extends ItemPickaxe {
	
	public ItemBlazicitePickaxe(ToolMaterial material) {
		super(material);
	}

		public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack){
		if(par1ItemStack.getItem() == VanillaEnhanced.itemBlazicitePickaxe) {
		return VanillaEnhanced.itemIngotBlazicite == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		}
		return false;
	}
		
    @Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase targetEntity, EntityLivingBase entity) {
		boolean result = super.hitEntity(itemstack, targetEntity, entity);
		NBTTagList ench = itemstack.getEnchantmentTagList();
		short level = 0;
		if(ench != null)
		{
			for (int x = 0; x < ench.tagCount(); x++)
			{
				NBTTagCompound nbt = ench.getCompoundTagAt(x);
				short id = nbt.getShort("id");
				if (id == Enchantment.fireAspect.effectId)
				{
					level = nbt.getShort("lvl");
				}
			}
		}
		
		int burnTime = level * 5;
		
    	if(targetEntity.isImmuneToFire() == false)
    	targetEntity.setFire(10 + burnTime);
    	return result;
    }


	//AleXnderTheGr8st
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int i, int j, int k, EntityPlayer player)
	{
		int fxplay = 0;
		Random random = new Random();
		if(this == VanillaEnhanced.itemBlazicitePickaxe && !player.capabilities.isCreativeMode)
		{
			World world = player.worldObj;
			Block block = world.getBlock(i, j, k);
			int meta = world.getBlockMetadata(i, j, k);

			NBTTagList ench = itemstack.getEnchantmentTagList();
			short level = 0;
			if(ench != null)
			{
				for (int x = 0; x < ench.tagCount(); x++)
				{
					NBTTagCompound nbt = ench.getCompoundTagAt(x);
					short id = nbt.getShort("id");
					if (id == Enchantment.fortune.effectId)
					{
						level = nbt.getShort("lvl");
					}
				}
			}
			
			ArrayList<ItemStack> items = block.getDrops(world, i, j, k, meta, level);
			if(items == null || items.size() == 0)
			{
				return false;
			}
			if(block != null && this.getDigSpeed(itemstack, block, meta) > 1.0F)
			{
				for (ItemStack item : items)
				{
					if (FurnaceRecipes.smelting().getSmeltingResult(item) == null)
					{
						return false;
					}
					
		            int var3 = random.nextInt(level + 2) - 1;

		            if (var3 < 0)
		            {
		                var3 = 0;
		            }
		            
		            int quantity;
		            
		            if(block == Blocks.stone || block == Blocks.cobblestone || block == Blocks.netherrack) {
		            	quantity = 1;
		            }else{
		            	quantity = block.quantityDropped(random) * (var3 + 1);
		            }
					
		            float pitchSound = random.nextFloat() + .6F;
//		            if (pitchSound > 1) pitchSound = 1;
					ItemStack drop = new ItemStack(FurnaceRecipes.smelting().getSmeltingResult(item).copy().getItem(), quantity, FurnaceRecipes.smelting().getSmeltingResult(item).copy().getItemDamage());

					if (fxplay == 0) {

						if (!world.isRemote) {
							itemstack.damageItem(1, player);
							world.setBlockToAir(i, j, k);
						}
						
						world.playSoundEffect(i + 0.5F, j + 0.5F, k + 0.5F, "fire.ignite", (block.stepSound.getVolume() + 1.0F) / 1.5F, pitchSound);
						world.spawnParticle("flame", random.nextFloat() + i, random.nextFloat() + j, random.nextFloat() + k, 0.0D, 0.0D, 0.0D);
						world.spawnParticle("flame", random.nextFloat() + i, random.nextFloat() + j, random.nextFloat() + k, 0.0D, 0.0D, 0.0D);
						world.spawnParticle("flame", random.nextFloat() + i, random.nextFloat() + j, random.nextFloat() + k, 0.0D, 0.0D, 0.0D);
						world.spawnParticle("flame", random.nextFloat() + i, random.nextFloat() + j, random.nextFloat() + k, 0.0D, 0.0D, 0.0D);
						world.spawnParticle("flame", random.nextFloat() + i, random.nextFloat() + j, random.nextFloat() + k, 0.0D, 0.0D, 0.0D);
						world.spawnParticle("flame", random.nextFloat() + i, random.nextFloat() + j, random.nextFloat() + k, 0.0D, 0.0D, 0.0D);
						world.spawnParticle("smoke", random.nextFloat() + i, random.nextFloat() + j, random.nextFloat() + k, 0.0D, 0.0D, 0.0D);
						world.spawnParticle("smoke", random.nextFloat() + i, random.nextFloat() + j, random.nextFloat() + k, 0.0D, 0.0D, 0.0D);
						world.spawnParticle("smoke", random.nextFloat() + i, random.nextFloat() + j, random.nextFloat() + k, 0.0D, 0.0D, 0.0D);
						world.spawnParticle("smoke", random.nextFloat() + i, random.nextFloat() + j, random.nextFloat() + k, 0.0D, 0.0D, 0.0D);
						
						fxplay = 1;
					} else {}
					if(!world.isRemote)
					{
						EntityItem entityitem = new EntityItem(world, i + 0.5, j + 0.5, k + 0.5, drop);
						entityitem.delayBeforeCanPickup = 10;
						world.spawnEntityInWorld(entityitem);
						
						try {
							int exp = drop.stackSize;
							float expFloat = FurnaceRecipes.smelting().func_151398_b(FurnaceRecipes.smelting().getSmeltingResult(item).copy());
							int expAmount;
							if(expFloat == 0.0F)
								exp = 0;
							else if(expFloat < 1.0F) {
								expAmount = MathHelper.floor_float(exp * expFloat);
								if(expAmount < MathHelper.ceiling_float_int(exp * expFloat) && (float)Math.random() < exp * expFloat - expAmount) {
									++expAmount;
								}
								exp = expAmount;
							}
							while(exp > 0) {
								expAmount = EntityXPOrb.getXPSplit(exp);
								exp -= expAmount;
								 if(block == Blocks.stone || block == Blocks.cobblestone || block == Blocks.netherrack) {} else {
									 world.spawnEntityInWorld(new EntityXPOrb(world, i + 0.5, j + 0.5, k + 0.5, expAmount));
									 }
							}
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			return false;
		}
		else return false;
	}
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.uncommon;
    }
	
}

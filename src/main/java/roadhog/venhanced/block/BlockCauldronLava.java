package roadhog.venhanced.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import roadhog.venhanced.VanillaEnhanced;

public class BlockCauldronLava extends BlockCauldron {

    @SideOnly(Side.CLIENT)
    public IIcon field_150029_a;
    @SideOnly(Side.CLIENT)
    public IIcon field_150028_b;
    @SideOnly(Side.CLIENT)
    public IIcon field_150030_M;
    @SideOnly(Side.CLIENT)
    public IIcon lavaIcon;
    
	public BlockCauldronLava() {
		this.setStepSound(Block.soundTypeMetal);
		this.setHardness(2.0F);
        this.setTickRandomly(true);
		this.setLightLevel(1.0F);
	}
    
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	ItemStack item;
    	if (p_149727_5_.getCurrentEquippedItem() != null) {
    		 item = p_149727_5_.getCurrentEquippedItem();
    		 if (item.getItem() == Items.lava_bucket) {
    			 return true;
    		}
    	}
		return false;
    }
    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
    	if (!world.isRemote) {
        	if(entity.isImmuneToFire() == true || (world.canBlockSeeTheSky(x, y + 1, z) && world.isRaining())) {
                entity.attackEntityFrom(DamageSource.lava, 4.0F);
        	}
        	else
        	{
                entity.setFire(11);
                entity.attackEntityFrom(DamageSource.lava, 4.0F);
        	}
    	}
    	
        if (entity instanceof EntityItem) {
        	world.playSound(x, y, z, "random.fizz", .5F, 6, false);
        }

    }
    
    public void onEntityWalking(World world, int x, int y, int z, Entity entity)
    {
    	if(!entity.isImmuneToFire() && !(entity instanceof EntityItem)) {
            entity.attackEntityFrom(DamageSource.inFire, 2.0F);
    		
    	}
    }
    
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icons)
    {
        this.field_150029_a = icons.registerIcon(this.getTextureName() + "_" + "inner");
        this.field_150028_b = icons.registerIcon(this.getTextureName() + "_top");
        this.field_150030_M = icons.registerIcon(this.getTextureName() + "_" + "bottom");
        this.blockIcon = icons.registerIcon(this.getTextureName() + "_side");
        this.lavaIcon = icons.registerIcon("lava_still");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.field_150028_b : (side == 0 ? this.field_150030_M : this.blockIcon);
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Items.cauldron;
    }

    @SideOnly(Side.CLIENT)
    public String getItemIconName()
    {
        return "venh:itemCauldronLava";
    }
    
    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.3125F, 1F);
        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        float f = 0.125F;
        float g = 0.005F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    

    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    
    public int tickRate(World world)
    {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
		float p0 = 0.875F;
		float p1 = 0.125F;

        double d0 = (double)((float)x + random.nextFloat());
        double d1 = (double)((float)z + random.nextFloat());
		
        if(d0 > (p0 + x)) {
        	d0 = x + p0;
        } else if(d0 < (p1 + x))
        	d0 = x + p1;
        if(d1 > (p0 + z)) {
        	d1 = z + p0;
        } else if(d1 < (p1 + z))
        	d1 = z + p1;
        
        if (world.canBlockSeeTheSky(x, y + 1, z) && world.isRaining()) {
            world.spawnParticle("smoke", d0, y + 1, d1, 0.0D, 0.0D, 0.0D);
        } if (random.nextInt(100) == 0) {
            world.spawnParticle("lava", d0, y + 1, d1, 0.0D, 0.0D, 0.0D);
            world.playSound(x + .5, y + 1, z + 0.5, "liquid.lavapop", 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
        } if (random.nextInt(200) == 0) {
            world.playSound(x + .5, y + 1, z + 0.5, "liquid.lava", 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
        }
	}
    
	public static void onPlayerInteract(PlayerInteractEvent event) {
		EntityPlayer player = event.entityPlayer;
			if (event.entityPlayer != null && !player.isSneaking()) {
				World world = event.entityPlayer.worldObj;
				if (event.action == Action.RIGHT_CLICK_BLOCK && event.getResult() == event.useItem)
					if (world.getBlock(event.x, event.y, event.z) == Blocks.cauldron && world.getBlockMetadata(event.x, event.y, event.z) == 0) {
						ItemStack stack = event.entityPlayer.getCurrentEquippedItem();
						if (stack != null && (stack.getItem() == Items.lava_bucket)) {
							event.setResult(event.useItem.DENY);
							world.setBlock(event.x, event.y, event.z, VanillaEnhanced.blockCauldronLava);
							event.entityPlayer.swingItem();
							if (!event.entityPlayer.capabilities.isCreativeMode)
								if (stack.stackSize <= 1) {
		                            player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.bucket));
								} else {
									--stack.stackSize;
								}
						}
					}
			}
	}
	
	@Override
    public int getRenderType()
    {
        return VanillaEnhanced.renderID_CauldronLava;
    }
}

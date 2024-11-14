package roadhog.venhanced.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockMycelium;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import roadhog.venhanced.VanillaEnhanced;

public class BlockMyceliumPath extends BlockMycelium {

	public IIcon mycelSide;
	public IIcon mycelTop;
	public IIcon mycelSideSnow;
	
    public BlockMyceliumPath()
    {
        super();
        this.setTickRandomly(false);
        this.setHardness(0.6F);
        this.setStepSound(soundTypeGravel);
        this.setHarvestLevel("shovel", 0);
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	ItemStack item;
    	Boolean active = false;
    	
    	if (player.getCurrentEquippedItem() != null) {
    		 item = player.getCurrentEquippedItem();
    		 if (item.getItem() instanceof ItemHoe) {
    			 Block block = Blocks.farmland;
    			 world.setBlock(x, y, z, block, 0, 2);
    			 world.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, block.stepSound.getStepResourcePath(), (block.stepSound.getVolume()+ 1.0F) / 2.0F, (block.stepSound.getPitch() * .8F));
    			 active = true;
    			 if (!player.capabilities.isCreativeMode) {
    				 item.damageItem(1, player);
    			 }
    		}
    	}
    	
		return active;
    }

	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
		return Blocks.dirt.canSustainPlant(world, x, y, z, direction, plant);
	}

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.mycelSide = icon.registerIcon("minecraft:mycelium" + "_side");
        this.mycelTop = icon.registerIcon(this.getTextureName() + "Top");
        this.mycelSideSnow = icon.registerIcon("minecraft:grass" + "_side_snowed");
    }
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        if (p_149673_5_ == 1)
        {
            return this.mycelTop;
        }
        else if (p_149673_5_ == 0)
        {
            return Blocks.dirt.getBlockTextureFromSide(p_149673_5_);
        }
        else
        {
            Material material = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.mycelSide : this.mycelSideSnow;
        }
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Blocks.dirt.getItemDropped(0, p_149650_2_, p_149650_3_);
    }
    
    protected boolean canSilkHarvest()
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.mycelTop : (p_149691_1_ == 0 ? Blocks.dirt.getBlockTextureFromSide(p_149691_1_) : this.mycelSide);
    }
    
    public static void onPlayerInteract(PlayerInteractEvent event) {
		World world = event.entityPlayer.worldObj;
		EntityPlayer player = event.entityPlayer;
		Random random = new Random();
			if (event.entityPlayer != null && !player.isSneaking()) {
				if (event.action == Action.RIGHT_CLICK_BLOCK)
					if (world.getBlock(event.x, event.y, event.z) == Blocks.mycelium) {
						ItemStack stack = event.entityPlayer.getCurrentEquippedItem();
						if (stack != null && (stack.getItem() instanceof ItemSpade)) {
							world.setBlock(event.x, event.y, event.z, VanillaEnhanced.blockMyceliumSupport, 0, 2);
							float soundPitch = random.nextFloat();
							world.playSoundEffect(event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, "venh:item.spade.scrape", random.nextFloat() + 1.5F, random.nextFloat() + 2F / 2);
							event.entityPlayer.swingItem();
							if (!event.entityPlayer.capabilities.isCreativeMode)
								stack.damageItem(1, player);
						}
					}
			}
	}

}

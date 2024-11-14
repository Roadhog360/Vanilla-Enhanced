package roadhog.venhanced.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import roadhog.venhanced.VanillaEnhanced;

public class BlockStrippedLog extends BlockLog {

	public static final String[] icons = new String[] {"Oak", "Spruce", "Birch", "Jungle"};
	
	@SideOnly(Side.CLIENT)
	protected IIcon[] iconTop;

	@SideOnly(Side.CLIENT)
	protected IIcon[] iconSide;
	
	public BlockStrippedLog() {
		super();
		this.setHarvestLevel("axe", 0);
		this.setStepSound(soundTypeWood);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getSideIcon(int meta) {
		return this.iconSide[meta % iconSide.length];
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int meta) {
		return this.iconTop[meta % iconTop.length];
	}

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconTop)
    {
        this.iconTop = new IIcon[icons.length];
        this.iconSide = new IIcon[icons.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
			this.iconTop[i] = iconTop.registerIcon(VanillaEnhanced.modid + ":" + "blockStripped" + icons[i] + "LogTop");
			this.iconSide[i] = iconTop.registerIcon(VanillaEnhanced.modid + ":" + "blockStripped" + icons[i] + "Log");
        }
    }
	
	public int damageDropped(int meta) {
		return meta & 3;
	}
	
    public int quantityDropped(Random random)
    {
        return 1;
    }

    public Item getItemDropped(int unk1, Random random, int unk2)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
    
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		
		for (int i = 0; i < icons.length; i++) {
			list.add(new ItemStack(block, 1, i));
		}
	}

	public static void onPlayerInteract(PlayerInteractEvent event) {
		World world = event.entityPlayer.worldObj;
		EntityPlayer player = event.entityPlayer;
		int logMeta = world.getBlockMetadata(event.x, event.y, event.z);
		ItemStack drop = new ItemStack(VanillaEnhanced.blockBark, 1, logMeta & 3);
		EntityItem entityitem = new EntityItem(world, event.x + 0.5, event.y + 0.5, event.z + 0.5, drop);
		
			if (event.entityPlayer != null && !player.isSneaking()) {
				if (event.action == Action.RIGHT_CLICK_BLOCK)
					if (world.getBlock(event.x, event.y, event.z) == Blocks.log) {
						ItemStack stack = event.entityPlayer.getCurrentEquippedItem();
						if (stack != null && (stack.getItem() instanceof ItemAxe)) {
							world.setBlock(event.x, event.y, event.z, VanillaEnhanced.blockStrippedLog, logMeta, 2);
							world.playSoundEffect(event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, "venh:item.axe.strip", (Blocks.log.stepSound.getVolume() + 1.0F) / 1.5F, (Blocks.log.stepSound.getPitch() + 1.0F));
							if (!world.isRemote) {
								entityitem.delayBeforeCanPickup = 10;
								world.spawnEntityInWorld(entityitem);
							}
							event.entityPlayer.swingItem();
							if (!event.entityPlayer.capabilities.isCreativeMode)
								stack.damageItem(1, player);
						}
					}
			}
	}
}
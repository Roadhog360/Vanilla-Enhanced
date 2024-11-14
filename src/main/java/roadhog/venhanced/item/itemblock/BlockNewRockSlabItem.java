package roadhog.venhanced.item.itemblock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;

public class BlockNewRockSlabItem extends ItemSlab {
	
	final static String[] metaBlocks = new String[] {"RedNetherBrick", "BlackNetherBrick", "RedSandstone"};

	public BlockNewRockSlabItem(Block block) {
		super(block, (BlockSlab)VanillaEnhanced.blockNewRockSlab, (BlockSlab)VanillaEnhanced.blockNewRockDoubleSlab, block == VanillaEnhanced.blockNewRockDoubleSlab);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= metaBlocks.length) {
			i = 0;
		}
		
		return VanillaEnhanced.blockNewRockSlab.getUnlocalizedName() + "." + metaBlocks[i];
	}
	
	public int getMetadata(int meta) {
		return meta & 15;
	}
}

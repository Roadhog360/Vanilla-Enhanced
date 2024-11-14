package roadhog.venhanced.item.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockRedSandstoneItem extends ItemBlock {
	
	final static String[] metaBlocks = new String[] {"Normal", "Carved", "Cut", "Smooth", "Coarse"};

	public BlockRedSandstoneItem(Block p_i45328_1_) {
		super(p_i45328_1_);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemStack) {
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= metaBlocks.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + metaBlocks[i];
	}
	
	public int getMetadata(int meta) {
		if(meta < metaBlocks.length)
		return meta;
		else;
		return 0;
	}
	

}

package roadhog.venhanced.item.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockStrippedLogItem extends ItemBlock {
	
	public static final String[] metaBlocks = new String[] {"Oak", "Spruce", "Birch", "Jungle"};

	public BlockStrippedLogItem(Block block) {
		super(block);
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
		if(meta < metaBlocks.length * 4) {
		return meta;
		} else {
		return 0;
		}
	}
}

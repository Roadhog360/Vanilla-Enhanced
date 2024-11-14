package roadhog.venhanced.item.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockOreMetalItem extends ItemBlock {
	
	final static String[] metaBlocks = new String[] {"Tin", "Copper", "Osmium", "Iridium"};

	public BlockOreMetalItem(Block block) {
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
		if(meta < metaBlocks.length)
		return meta;
		else if(meta > metaBlocks.length);
		return 0;
	}
	
}
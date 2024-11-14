package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMissing extends Block {

	public BlockMissing(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(2.4F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeStone);
	}

}

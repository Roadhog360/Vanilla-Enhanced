package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPolishedStone extends Block {

	public BlockPolishedStone(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(soundTypeStone);
		this.setHardness(1.5F);
		this.setResistance(30.0F);
	}

}

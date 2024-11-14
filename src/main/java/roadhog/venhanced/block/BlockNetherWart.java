package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNetherWart extends Block {

	public BlockNetherWart(Material material) {
		super(material);
		this.setHarvestLevel("axe", 0);
		this.setStepSound(soundTypeWood);
		this.setHardness(1F);
		this.setResistance(5F);
		
	}

}

package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCharcoal extends Block {

	private boolean canBurn;

	public BlockCharcoal(Material material) {
		super(material);
		this.setHarvestLevel("axe", 0);
		this.setStepSound(soundTypeGrass);
		this.setHardness(1.0F);
		this.setResistance(8.0F);
	}

	
}

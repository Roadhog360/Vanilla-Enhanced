package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBlaze extends Block {

	public BlockBlaze(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeMetal);
		this.setHardness(2.0F);
		this.setResistance(20.0F);
		this.setLightLevel(1.0F);
	}

}

package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAnthracite extends Block {

	public BlockAnthracite(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeStone);
		this.setHardness(4.0F);
		this.setResistance(20.0F);
	}

}

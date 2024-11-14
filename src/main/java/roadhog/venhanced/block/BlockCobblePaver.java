package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCobblePaver extends Block {

	public BlockCobblePaver(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(soundTypeStone);
		this.setHardness(2.0F);
		this.setResistance(30.0F);
	}

}

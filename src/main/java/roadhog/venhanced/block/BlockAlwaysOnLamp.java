package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAlwaysOnLamp extends Block {

	public BlockAlwaysOnLamp(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(soundTypeGlass);
		this.setHardness(0.3F);
		this.setResistance(1.5F);
		this.setLightLevel(1.0F);
	}

}

package roadhog.venhanced.block;

import net.minecraft.block.material.Material;
import roadhog.venhanced.VanillaEnhanced;

public class BlockSteelScaffolding extends BlockScaffolding {

	public BlockSteelScaffolding(Material material) {
		super(material);
		this.setStepSound(soundTypeMetal);
		this.setResistance(8000F);
		this.setHardness(0.65F);
		this.setHarvestLevel("pickaxe", 0);
		scaffoldType = VanillaEnhanced.blockSteelScaffolding;
		bridgeLimit = 11;
	}
	
	public boolean isSteel() {
		return true;
	}
}

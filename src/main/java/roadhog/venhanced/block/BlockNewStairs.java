package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;

public class BlockNewStairs extends BlockStairs {

	public BlockNewStairs(Block block, int var2) {
		super(block, var2);
        this.useNeighborBrightness = true;
        this.setLightOpacity(255);
	}

}

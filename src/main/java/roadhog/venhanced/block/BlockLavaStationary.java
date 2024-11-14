package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockLavaStationary extends BlockLiquid {

	public BlockLavaStationary(Material material) {
		super(material);
        this.setTickRandomly(true);
	}

    public void onBlockAdded(World world, int x, int y, int z) {}      	
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {}
	
}

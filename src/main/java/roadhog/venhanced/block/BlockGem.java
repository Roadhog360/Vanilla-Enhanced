package roadhog.venhanced.block;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

public class BlockGem extends Block {

	public BlockGem(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeMetal);
		this.setHardness(5.0F);
		this.setResistance(15.0F);
	}
	
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
    {
        return this == VanillaEnhanced.blockRuby || this == VanillaEnhanced.blockSapphire;
    }

}

package roadhog.venhanced.block;

import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;
import roadhog.venhanced.block.replace.BlockFenceNether;

public class BlockNewNetherBrickFence extends BlockFence {

	Block fenceType = Blocks.nether_brick_fence;
	
	public BlockNewNetherBrickFence(String texture, Material material) {
		super(texture, material);
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
	}

	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        return true;
    }
	
    public boolean canConnectFenceTo(IBlockAccess p_149826_1_, int p_149826_2_, int p_149826_3_, int p_149826_4_)
    {
        Block block = p_149826_1_.getBlock(p_149826_2_, p_149826_3_, p_149826_4_);
        return block != this && !(block instanceof BlockNewNetherBrickFence) && !(block instanceof BlockFenceNether) && !(block instanceof BlockNewFenceGateWood) && !(block instanceof BlockNewFenceGateRock) && block != Blocks.nether_brick_fence && block != Blocks.fence_gate ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
    }
}

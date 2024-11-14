package roadhog.venhanced.block.replace;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;
import roadhog.venhanced.block.BlockNewFenceGateRock;
import roadhog.venhanced.block.BlockNewFenceGateWood;
import roadhog.venhanced.block.BlockNewFenceWood;

public class BlockWallRock extends BlockWall {
	
	private Block fenceType = Blocks.cobblestone_wall;

    public BlockWallRock(Block p_i45435_1_)
    {
        super(p_i45435_1_);
        this.setHardness(2F);
        this.setResistance(10F / 3.0F);
        this.setStepSound(p_i45435_1_.stepSound);
		this.setCreativeTab(CreativeTabs.tabDecorations);
    }

	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        return true;
    }
    
    public boolean canConnectWallTo(IBlockAccess p_150091_1_, int p_150091_2_, int p_150091_3_, int p_150091_4_)
    {
        Block block = p_150091_1_.getBlock(p_150091_2_, p_150091_3_, p_150091_4_);
        return block != this && block != Blocks.fence_gate && !(block instanceof BlockNewFenceGateWood) && !(block instanceof BlockNewFenceGateRock) ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
    }
}

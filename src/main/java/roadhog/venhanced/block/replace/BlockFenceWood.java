package roadhog.venhanced.block.replace;

import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;
import roadhog.venhanced.block.BlockNewFenceGateRock;
import roadhog.venhanced.block.BlockNewFenceGateWood;
import roadhog.venhanced.block.BlockNewFenceWood;

public class BlockFenceWood extends BlockFence {

	private Block fenceType = Blocks.fence;
	
	public BlockFenceWood(String p_i45406_1_, Material p_i45406_2_) {
		super(p_i45406_1_, p_i45406_2_);
		this.setHardness(2F);
		this.setResistance(10F);
		this.setStepSound(fenceType.stepSound);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        return true;
    }
	
    public boolean canConnectFenceTo(IBlockAccess p_149826_1_, int p_149826_2_, int p_149826_3_, int p_149826_4_)
    {
        Block block = p_149826_1_.getBlock(p_149826_2_, p_149826_3_, p_149826_4_);
        return block != this && !(block instanceof BlockNewFenceWood) && !(block instanceof BlockFenceWood) && !(block instanceof BlockNewFenceGateWood) && !(block instanceof BlockNewFenceGateRock)   && block != Blocks.fence && block != Blocks.fence_gate ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
    }
}

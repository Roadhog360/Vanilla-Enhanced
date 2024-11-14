package roadhog.venhanced.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import roadhog.venhanced.VanillaEnhanced;

public class BlockLantern extends BlockFalling {

	public BlockLantern(Material material) {
		super(material);
    	float r = 0.0625F;
        float f = 0.375F;
        float f1 = f / 2.0F;
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(soundTypeMetal);
		this.setHardness(0.85F);
		this.setLightLevel(1.0F);
		this.setLightOpacity(500);
    	this.setBlockBounds(0.5F - f1, r * 1, 0.5F - f1, 0.5F + f1, r * 7, 0.5F + f1);
	}
	
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
    	float r = 0.0625F;
        float f = 0.375F;
        float f1 = f / 2.0F;
        if (p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_) == 0)
        	this.setBlockBounds(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, r * 7, 0.5F + f1);
        else
        	this.setBlockBounds(0.5F - f1, r * 1, 0.5F - f1, 0.5F + f1, r * 8, 0.5F + f1);
    }
    
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
    	int i1 = world.getBlockMetadata(x, y + 1, z);
    	int stairMeta = world.getBlockMetadata(x, y + 1, z) & 7;
        return	world.getBlock(x, y - 1, z).canPlaceTorchOnTop(world, x, y, z) ||
        		world.doesBlockHaveSolidTopSurface(world, x, y - 1, z) ||
        		world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN) ||
        		world.getBlock(x, y + 1, z) instanceof BlockWall ||
        		world.getBlock(x, y + 1, z) instanceof BlockFence ||
        		((world.getBlock(x, y + 1, z) instanceof BlockStairs) && stairMeta <= 3) ||
        		((world.getBlock(x, y + 1, z) instanceof BlockSlab) && i1 <= 7);
    }
    
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
    {
        int i = 0;
        if (side == 0) {
        	i = 1;
        } else if (side > 0){
        	if (world.getBlock(x, y - 1, z).canPlaceTorchOnTop(world, x, y, z) || world.doesBlockHaveSolidTopSurface(world, x, y - 1, z)) {
        		i = 0;
        	} else {
        		i = 1;
        	}
        }
        return i;
    }
    public void onBlockAdded(World world, int x, int y, int z)
    {
    	Block block = world.getBlock(x, y, z);
    	this.onNeighborBlockChange(world, x, y, z, block);
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
    	int i = world.getBlockMetadata(x, y, z);
    	int i2 = world.getBlockMetadata(x, y + 1, z);
    	int stairMeta1 = i2 & 7;
    	
    	if (i == 0 && !world.getBlock(x, y - 1, z).canPlaceTorchOnTop(world, x, y, z) &&
    			!world.doesBlockHaveSolidTopSurface(world, x, y - 1, z)) {
    		this.setLanternToAir(world, x, y, z);
    	} else if (i == 1 && !world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN) &&
    			!(world.getBlock(x, y + 1, z) instanceof BlockWall) &&
    			!(world.getBlock(x, y + 1, z) instanceof BlockFence) &&
    			!((world.getBlock(x, y + 1, z) instanceof BlockStairs) && stairMeta1 <= 3) && 
    			!((world.getBlock(x, y + 1, z) instanceof BlockSlab) && i2 <= 7)) {
    		this.setLanternToAir(world, x, y, z);
    	}
    }
    
    public void updateTick(World world, int x, int y, int z, Random random)
    {
    }
    
    public void setLanternToAir(World world, int x, int y, int z) {
    	Random random = new Random();

    	if (!world.isRemote) {
            this.dropBlockAsItem(world, x, y, z, 0, 0);
            world.setBlockToAir(x, y, z);
    	}
    }

    @SideOnly(Side.CLIENT)
    public String getItemIconName()
    {
        return "venh:itemLantern";
    }
	
    public int getRenderType()
    {
		return VanillaEnhanced.renderID_Lantern;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
}

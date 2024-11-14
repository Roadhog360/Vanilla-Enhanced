package roadhog.venhanced.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;

public class BlockNewTrapDoorWood extends BlockTrapDoor {

	public BlockNewTrapDoorWood(Material material) {
		super(material);
        float f = 0.0F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, -0.5F, 0.5F - f, 0.5F + f, f1 + 0.5F, 0.5F + f);
        this.disableStats();
        this.setHardness(3F);
        this.setStepSound(soundTypeWood);
	}
	
	@Override
    public int getRenderType()
    {
        return VanillaEnhanced.renderID_VenhTrapdoor;
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
    	
    	int l = world.getBlockMetadata(x, y, z);
    	Block b = world.getBlock(x, y, z);
    	
    	if (((l >= 4 && l <= 7) || (l >= 12 && l <= 15)) && b == VanillaEnhanced.blockTrapDoorLadder)
            return true;
    	else
    		return false;
    }
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
    {
        this.setBlockBoundsBasedOnState(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
        return super.getSelectedBoundingBoxFromPool(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
        return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        this.func_150117_b(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));
    }

    public void setBlockBoundsForItemRender()
    {
    	float f;
    	if (this == VanillaEnhanced.blockTrapDoorLadder)
    		f = 0.125F;
    	else
            f = 0.1875F;
    	
        this.setBlockBounds(0.0F, 0.5F - f / 2.0F, 0.0F, 1.0F, 0.5F + f / 2.0F, 1.0F);
    }

    public void func_150117_b(int p_150117_1_)
    {
    	float f;
    	if (this == VanillaEnhanced.blockTrapDoorLadder)
    		f = 0.125F;
    	else
            f = 0.1875F;

        if ((p_150117_1_ & 8) != 0)
        {
            this.setBlockBounds(0.0F, 1.0F - f, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
        }

        if (func_150118_d(p_150117_1_))
        {
            if ((p_150117_1_ & 3) == 0)
            {
                this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
            }

            if ((p_150117_1_ & 3) == 1)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
            }

            if ((p_150117_1_ & 3) == 2)
            {
                this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }

            if ((p_150117_1_ & 3) == 3)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
            }
        }
    }

    
}

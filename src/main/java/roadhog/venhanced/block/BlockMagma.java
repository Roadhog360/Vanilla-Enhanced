package roadhog.venhanced.block;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.Random;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.block.BlockNetherrack;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockMagma extends BlockNetherrack {

	public BlockMagma(Material material) {
		super();
		this.setHardness(0.5F);
		this.setHarvestLevel("pickaxe", 0);
		this.setResistance(2.5F);
		this.setLightLevel(0.3F);
		this.setTickRandomly(true);
	}
    
    public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
    {
        if (this == VanillaEnhanced.blockMagma && side == UP)
        {
            return true;
        }
        return false;
    }
    

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)(y + 1) - f), (double)(z + 1));
    }
    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
    	if (!world.isRemote) {
        	if(!entity.isImmuneToFire() && !entity.isSneaking()) {
                entity.attackEntityFrom(DamageSource.inFire, 1.0F);
        	}
    	}

    }

}

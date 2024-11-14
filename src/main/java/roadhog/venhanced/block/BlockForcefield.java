package roadhog.venhanced.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockForcefield extends Block {

	public BlockForcefield(Material material) {
		super(material);
		this.setHardness(-1F);
		this.setResistance(8000F);
	}
	
    public int getRenderType()
    {
        return -1;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }
    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
    	{
    		entity.setVelocity(0, -5F, 0);
            entity.attackEntityFrom(DamageSource.generic, 1.0F);
    	}
    	if(entity.isCollidedVertically){
    		entity.setPosition(x + .5F, y - 2F, z + .5F);
    	}
    	if(world.getEntityByID(14) != null){
    		entity.setDead();
    		entity.attackEntityFrom(DamageSource.inFire, 20.0f);
    		entity.setPosition(x + .5F, y - 2F, z + .5F);
    	}
    	
    }
    
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return null;
    }

}

package roadhog.venhanced.block;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class BlockCrate extends Block {

	public BlockCrate(Material material) {
		super(material);
		this.setHarvestLevel("axe", 0);
		this.setStepSound(soundTypeWood);
		this.setHardness(2.5F);
		this.setResistance(12.0F);
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
    	float f = 0.025F;
		if(world.getBlock(x, y, z) == VanillaEnhanced.blockStickyCrate)
        	return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)(y + 1) - f ), (double)(z + 1));
    	else return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)(y + 1)), (double)(z + 1));
    }
    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
		if(world.getBlock(x, y, z) == VanillaEnhanced.blockStickyCrate) {
			entity.motionX *= 0.535D;
        	entity.motionZ *= 0.535D;
		}
    }
    
}

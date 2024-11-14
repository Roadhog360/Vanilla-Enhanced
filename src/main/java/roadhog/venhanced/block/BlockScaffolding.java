package roadhog.venhanced.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;

public class BlockScaffolding extends BlockFalling {

	final static String[] metaBlocks = new String[] {"Spruce", "Birch", "Jungle", "Acacia", "BigOak"};
	final static String[] vanillaPlanks = new String[] {"spruce", "birch", "jungle", "acacia", "big_oak"};
	
	public IIcon Side0;
	public IIcon Side1;
	public IIcon Side2;
	
	public int bridgeLimit;
	public Block scaffoldType;

	public BlockScaffolding(Material material) {
		super(material);
		this.setStepSound(soundTypeWood);
		this.setResistance(0.5F);
		this.setHardness(0.15F);
		this.setHarvestLevel("axe", 0);
		scaffoldType = this;
		bridgeLimit = 5;
	}

	public boolean isSteel() {
		return this instanceof BlockSteelScaffolding;
	}
	
    public void onBlockAdded(World world, int x, int y, int z)
    {
    	
    	int scaffoldDamage;
    	
    	if(world.getBlockMetadata(x, y, z) >= bridgeLimit) {
    		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
    	}
    	if(world.getBlock(x, y - 1, z) == scaffoldType && world.getBlockMetadata(x, y - 1, z) == 0){
    		world.setBlockMetadataWithNotify(x, y, z, 0, 1);
    	} else if(world.getBlock(x, y - 1, z) != scaffoldType && world.getBlock(x, y - 1, z) != Blocks.air && world.getBlock(x, y - 1, z).getMaterial() != Material.fire && world.getBlock(x, y - 1, z).getMaterial() != Material.water && world.getBlock(x, y - 1, z).getMaterial() != Material.lava){
    		world.setBlockMetadataWithNotify(x, y, z, 0, 1);
			
   	 	} else if(world.getBlock(x, y - 1, z) == scaffoldType){
         	scaffoldDamage = world.getBlockMetadata(x, y - 1, z);
 			world.setBlockMetadataWithNotify(x, y, z, scaffoldDamage + 1, 1);
 			
     	} else if(world.getBlock(x - 1, y, z) == scaffoldType){
    		scaffoldDamage = world.getBlockMetadata(x - 1, y, z);
    		world.setBlockMetadataWithNotify(x, y, z, scaffoldDamage + 1, 1);
    		
    	} else if(world.getBlock(x, y, z - 1) == scaffoldType){
    		scaffoldDamage = world.getBlockMetadata(x, y, z - 1);
    		world.setBlockMetadataWithNotify(x, y, z, scaffoldDamage + 1, 1);
    		
    	} else if(world.getBlock(x + 1, y, z) == scaffoldType){
    		scaffoldDamage = world.getBlockMetadata(x + 1, y, z);
    		world.setBlockMetadataWithNotify(x, y, z, scaffoldDamage + 1, 1);
    		
    	} else if(world.getBlock(x, y, z + 1) == scaffoldType){
    		scaffoldDamage = world.getBlockMetadata(x, y, z + 1);
    		world.setBlockMetadataWithNotify(x, y, z, scaffoldDamage + 1, 1);
    		
    	}
        if (!this.isScaffoldSupported(world, x, y, z) && (world.getBlock(x, y - 1, z) == Blocks.air || world.getBlock(x, y - 1, z).getMaterial() == Material.fire || world.getBlock(x, y - 1, z).getMaterial() == Material.water || world.getBlock(x, y - 1, z).getMaterial() == Material.lava))
        {
    		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
        }else if(!this.isScaffoldSupported(world, x, y, z) && world.getBlock(x, y - 1, z).getMaterial() != Material.fire){
            this.setScaffoldToAir(world, x, y, z);
        }
    }
        	
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {

    	int scaffoldDamage;
    	
        boolean flag = false;
    	scaffoldDamage = world.getBlockMetadata(x, y, z);
    	
        if(world.getBlock(x, y - 1, z) != scaffoldType && world.getBlock(x, y - 1, z) != Blocks.air && world.getBlock(x, y - 1, z) != Blocks.fire){
			world.setBlockMetadataWithNotify(x, y, z, 0, 0);
        } else if(world.getBlock(x, y - 1, z) != scaffoldType && world.getBlockMetadata(x, y, z) == 0){
        	flag = true;
        } else if(!(world.getBlock(x + 1, y, z) == scaffoldType && world.getBlockMetadata(x + 1, y, z) < scaffoldDamage) && !(world.getBlock(x - 1, y, z) == scaffoldType && world.getBlockMetadata(x - 1, y, z) < scaffoldDamage) && !(world.getBlock(x, y, z + 1) == scaffoldType && world.getBlockMetadata(x, y, z + 1) < scaffoldDamage) && !(world.getBlock(x, y, z - 1) == scaffoldType && world.getBlockMetadata(x, y, z - 1) < scaffoldDamage) && (world.getBlock(x, y - 1, z) == Blocks.air || world.getBlock(x, y - 1, z).getMaterial() == Material.fire)){
            if(scaffoldDamage != 0)
            	flag = true;
    	} else if (!this.isScaffoldSupported(world, x, y, z) && world.getBlock(x, y - 1, z) == Blocks.air && world.getBlockMetadata(x, y, z) < bridgeLimit)
        {
            flag = true;
        }/* else if (world.getBlock(x, y - 1, z) == scaffoldType && world.getBlockMetadata(x, y - 1, z) <= 0 && isScaffoldSupported(world, x, y - 1, z)) {
    		world.setBlockMetadataWithNotify(x, y, z, 0, 1);
        }*/
        if (flag)
        {
            this.setScaffoldToAir(world, x, y, z);
        }
    }
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityLivingBase) {
			float setSpeed = 0.22F;
			if (entity.motionX < (double)(- setSpeed))
			{
				entity.motionX = (double)(- setSpeed);
			}
				
			if (entity.motionX > (double) setSpeed)
			{
				entity.motionX = (double) setSpeed;
			}
				
			if (entity.motionZ < (double)(- setSpeed))
			{
				entity.motionZ = (double)(- setSpeed);
			}
			
			if (entity.motionZ > (double) setSpeed)
			{
				entity.motionZ = (double) setSpeed;
			}
				
			entity.fallDistance = 0.0F;

			if(entity.isSneaking())
			{
				entity.motionY = .075;
			} else if (entity.motionY < -0.1D)
				entity.motionY = -0.1D;
			
			if(entity.isCollidedHorizontally)
				entity.motionY = .2;
		}
			
	}

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        return true;
    }
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        float f = 0.005F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + f), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)((float)(y + 1)), (double)((float)(z + 1) - f));
    }
    
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		
		isSteel();
		String typeWood1 = "oak";
		String typeWood2 = "Oak";
		
		if (this == VanillaEnhanced.blockOakScaffolding) {
			typeWood1 = "oak";
			typeWood2 = "Oak";
		} else if (this == VanillaEnhanced.blockSpruceScaffolding) {
			typeWood1 = "spruce";
			typeWood2 = "Spruce";
		} else if (this == VanillaEnhanced.blockBirchScaffolding) {
			typeWood1 = "birch";
			typeWood2 = "Birch";
		} else if (this == VanillaEnhanced.blockJungleScaffolding) {
			typeWood1 = "jungle";
			typeWood2 = "Jungle";
		} else if (this == VanillaEnhanced.blockAcaciaScaffolding) {
			typeWood1 = "acacia";
			typeWood2 = "Acacia";
		} else if (this == VanillaEnhanced.blockBigOakScaffolding) {
			typeWood1 = "big_oak";
			typeWood2 = "BigOak";
		}
		
		if (!isSteel()) {
			Side0 = icon.registerIcon("minecraft:planks_" + typeWood1);
			Side1 = icon.registerIcon("venh:block" + typeWood2 + "ScaffoldTop");
			Side2 = icon.registerIcon("venh:block" + typeWood2 + "ScaffoldSide");
		} else {
			Side0 = icon.registerIcon("venh:blockSteel");
			Side1 = icon.registerIcon("venh:blockSteelScaffoldTop");
			Side2 = icon.registerIcon("venh:blockSteelScaffoldSide");
		}
	}
	
	public IIcon getIcon(int side, int meta){
		if(side == 0){
			return Side0;
		}else if(side == 1){
			return Side1;
		}else if(side > 1){
			return Side2;
		}
		return null;
	}
	
	protected boolean isScaffoldSupported(World world, int x, int y, int z)
    {
		
    	isSteel();
		boolean supported;
		
    	if(world.getBlock(x, y, z).getDamageValue(world, x, y, z) >= bridgeLimit)
    		supported = false;
    	else if(((world.getBlock(x + 1, y, z) == scaffoldType && world.getBlockMetadata(x + 1, y, z) <= bridgeLimit) || (world.getBlock(x - 1, y, z) == scaffoldType && world.getBlockMetadata(x - 1, y, z) <= bridgeLimit) || (world.getBlock(x, y, z + 1) == scaffoldType && world.getBlockMetadata(x, y, z + 1) <= bridgeLimit) || (world.getBlock(x, y, z - 1) == scaffoldType && world.getBlockMetadata(x, y, z - 1) <= bridgeLimit) || (world.getBlock(x, y - 1, z) == scaffoldType && world.getBlockMetadata(x, y - 1, z) <= bridgeLimit))){
    		supported = true;
    	}
    	else if(world.getBlock(x, y - 1, z) == Blocks.air || !world.getBlock(x, y - 1, z).isOpaqueCube()){
    		supported = false;
    	}
        else{
    	supported = true;
        }
		return supported;
		
    }
	
	public int damageDropped(int meta) {
		return 0;
	}
	
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
    	
    	isSteel();
    	
    	if(world.getBlock(x, y - 1, z) == scaffoldType && world.getBlockMetadata(x, y - 1, z) >= (bridgeLimit - 1)){
    		return false;
    	} else if (!this.isScaffoldSupported(world, x, y, z) && world.getBlock(x, y - 1, z) != Blocks.air && world.getBlock(x, y - 1, z).getMaterial() != Material.water && world.getBlock(x, y - 1, z).getMaterial() != Material.lava && world.getBlock(x, y - 1, z).getMaterial() != Material.fire) {
    		return false;
    	}
		else
        return true;
    }
    
    public int tickRate(World world) {
		return 1;
    }
    
    public void setScaffoldToAir(World world, int x, int y, int z) {
    	
    	if (!world.isRemote) {
            this.dropBlockAsItem(world, x, y, z, 0, 0);
            world.setBlockToAir(x, y, z);
//    		world.playSoundEffect((double)x, (double)y, (double)z, this.stepSound.toString(), this.stepSound.getVolume(), this.stepSound.getPitch());
    	}
    }
	
}
package roadhog.venhanced.block;

import java.util.Random;

import roadhog.venhanced.VanillaEnhanced;
import scala.Int;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBarrier extends Block {
	
	public BlockBarrier(Material material) {
		super(material);
		this.setBlockUnbreakable();
		this.setResistance(2000000F);
		this.setTickRandomly(true);
        this.setLightOpacity(0);
        this.canBlockGrass = false;
	}

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        
    	EntityPlayer player = Minecraft.getMinecraft().thePlayer;
    	Item heldItem;
    	
    	if (player.inventory.getCurrentItem() != null) {
    		heldItem = player.inventory.getCurrentItem().getItem();
        	Item barrier = Item.getItemFromBlock(this);

            double d0 = (double)((float)x + rand.nextFloat());
            double d1 = (double)((float)y + rand.nextFloat());
            double d2 = (double)((float)z + rand.nextFloat());
            
            String particle = "reddust";
    		float p0 = 0.625F;
    		float p1 = 0.375F;
            
            if(d0 > (p0 + x)) {
            	d0 = x + p0;
            } else if(d0 < (p1 + x))
            	d0 = x + p1;
            if(d1 > (p0 + y)) {
            	d1 = y + p0;
            } else if(d1 < (p1 + y))
            	d1 = y + p1;
            if(d2 > (p0 + z)) {
            	d2 = z + p0;
            } else if(d2 < (p1 + z)) {
            	d2 = z + p1;
            }
            
        	if(player.capabilities.isCreativeMode && heldItem == barrier) {
                world.spawnParticle(particle, d0, d1, d2, 255.0D, -255D, 0.0D);
                world.spawnParticle(particle, d0, d1, d2, 255.0D, -255D, 0.0D);
        	}
    	} 
    }
    
    public int getRenderType()
    {
        return -1;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public String getItemIconName()
    {
        return "venh:itemBarrier";
    }
    
}

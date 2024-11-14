package roadhog.venhanced.block;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCake;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import roadhog.venhanced.VanillaEnhanced;
import scala.Int;

public class BlockNewCake extends BlockCake {
	
    @SideOnly(Side.CLIENT)
    private IIcon field_150038_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_150037_b;
    @SideOnly(Side.CLIENT)
    private IIcon field_150039_M;
    
	public BlockNewCake() {
		super();		
        this.setTickRandomly(true);
        this.setStepSound(soundTypeCloth);
        this.setHardness(0.5F);
        this.disableStats();
	}

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_150038_a : (p_149691_1_ == 0 ? this.field_150037_b : (p_149691_2_ > 0 && p_149691_1_ == 4 ? this.field_150039_M : this.blockIcon));
    }
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "Side");
        this.field_150039_M = p_149651_1_.registerIcon(this.getTextureName() + "Inner");
        this.field_150038_a = p_149651_1_.registerIcon(this.getTextureName() + "Top");
        this.field_150037_b = p_149651_1_.registerIcon(this.getTextureName() + "Bottom");
    }
/*
    @SideOnly(Side.CLIENT)
    public String getItemIconName()
    {
        return "venh:itemCakeCarrot";
    } */

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
    	if (this == VanillaEnhanced.blockCakeCarrot) {
    		return VanillaEnhanced.itemCakeCarrot;
    	} else if (this == VanillaEnhanced.blockCakeChocolate) {
    		return VanillaEnhanced.itemCakeChocolate;
    	} else if (this == VanillaEnhanced.blockCakeVelvet) {
    		return VanillaEnhanced.itemCakeVelvet;
    	} else if (this == VanillaEnhanced.blockCakeIceCream) {
    		return VanillaEnhanced.itemCakeIceCream;
    	}
    	else return VanillaEnhanced.itemCakeCarrot;
    }
    
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        this.func_150036_b(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_);
        return true;
    }

    public void onBlockClicked(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_)
    {
        this.func_150036_b(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_, p_149699_5_);
    }
    
    private void func_150036_b(World p_150036_1_, int p_150036_2_, int p_150036_3_, int p_150036_4_, EntityPlayer p_150036_5_)
    {
    	
    	int healAmount = p_150036_1_.getBlock(p_150036_2_, p_150036_3_, p_150036_4_) == VanillaEnhanced.blockCakeIceCream ? 1 : 2;
    	
        if (p_150036_5_.canEat(false))
        {
            p_150036_5_.getFoodStats().addStats(healAmount, 0.1F);
            int l = p_150036_1_.getBlockMetadata(p_150036_2_, p_150036_3_, p_150036_4_) + 1;

            if (l >= 6)
            {
                p_150036_1_.setBlockToAir(p_150036_2_, p_150036_3_, p_150036_4_);
            }
            else
            {
                p_150036_1_.setBlockMetadataWithNotify(p_150036_2_, p_150036_3_, p_150036_4_, l, 2);
            }
        }
    }
    
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
    	
    	if (p_149674_1_.getBlock(p_149674_2_, p_149674_3_, p_149674_4_) == VanillaEnhanced.blockCakeIceCream) {
            if (p_149674_1_.getSavedLightValue(EnumSkyBlock.Block, p_149674_2_, p_149674_3_, p_149674_4_) > 11 - this.getLightOpacity() || p_149674_1_.provider.isHellWorld)
            {

            	int random = new Random().nextInt(2) + 1;
            	int cakeMeta = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);
            	
            	if (random + cakeMeta >= 6)
                    p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_, p_149674_4_);
            	else
            		p_149674_1_.setBlockMetadataWithNotify(p_149674_2_, p_149674_3_, p_149674_4_, random + cakeMeta, 3);
                return;
            }
        }
    }
}

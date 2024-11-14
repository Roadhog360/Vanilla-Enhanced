package roadhog.venhanced.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;
import roadhog.venhanced.tileentity.TileEntityNewSign;

public class ItemNewSign extends Item {
	
	public Block wallSignType;
	public Block standingSignType;

    public ItemNewSign()
    {
        this.maxStackSize = Items.sign.getItemStackLimit();
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	wallSignType = VanillaEnhanced.blockWallSignSpruce;
    	standingSignType = VanillaEnhanced.blockStandingSignSpruce;
    	if (this == VanillaEnhanced.itemSignBirch) {
        	wallSignType = VanillaEnhanced.blockWallSignBirch;
        	standingSignType = VanillaEnhanced.blockStandingSignBirch;
    	} else if (this == VanillaEnhanced.itemSignJungle) {
        	wallSignType = VanillaEnhanced.blockWallSignJungle;
        	standingSignType = VanillaEnhanced.blockStandingSignJungle;
    	} else if (this == VanillaEnhanced.itemSignAcacia) {
        	wallSignType = VanillaEnhanced.blockWallSignAcacia;
        	standingSignType = VanillaEnhanced.blockStandingSignAcacia;
    	} else if (this == VanillaEnhanced.itemSignBigOak) {
        	wallSignType = VanillaEnhanced.blockWallSignBigOak;
        	standingSignType = VanillaEnhanced.blockStandingSignBigOak;
    	}
    	
        if (p_77648_7_ == 0)
        {
            return false;
        }
        else if (!p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).getMaterial().isSolid())
        {
            return false;
        }
        else
        {
            if (p_77648_7_ == 1)
            {
                ++p_77648_5_;
            }

            if (p_77648_7_ == 2)
            {
                --p_77648_6_;
            }

            if (p_77648_7_ == 3)
            {
                ++p_77648_6_;
            }

            if (p_77648_7_ == 4)
            {
                --p_77648_4_;
            }

            if (p_77648_7_ == 5)
            {
                ++p_77648_4_;
            }

            if (!player.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, itemStack))
            {
                return false;
            }
            else if (!Blocks.standing_sign.canPlaceBlockAt(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_))
            {
                return false;
            }
            else if (p_77648_3_.isRemote)
            {
                return true;
            }
            else
            {
                if (p_77648_7_ == 1)
                {
                    int i1 = MathHelper.floor_double((double)((player.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
                    p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, standingSignType, i1, 3);
                }
                else
                {
                    p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, wallSignType, p_77648_7_, 3);
                }

                --itemStack.stackSize;
                TileEntityNewSign tileentitysign = (TileEntityNewSign)p_77648_3_.getTileEntity(p_77648_4_, p_77648_5_, p_77648_6_);

                if (tileentitysign != null)
                {
                    player.func_146100_a(tileentitysign);
                }

                return true;
            }
        }
    }
}

package roadhog.venhanced.block;

import roadhog.venhanced.VanillaEnhanced;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class BlockVenhPot extends BlockFlowerPot {
	
    public BlockVenhPot()
    {
        super();
    }
    
    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        ItemStack itemstack = p_149727_5_.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() instanceof ItemBlock)
        {
            TileEntityFlowerPot tileentityflowerpot = this.tileEntity(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);

            if (tileentityflowerpot != null)
            {
                if (tileentityflowerpot.getFlowerPotItem() != null)
                {
                    return false;
                }
                else
                {
                    Block block = Block.getBlockFromItem(itemstack.getItem());

                    if (!this.flowers(block, itemstack.getItemDamage()))
                    {
                        return false;
                    }
                    else
                    {
                        tileentityflowerpot.func_145964_a(itemstack.getItem(), itemstack.getItemDamage());
                        tileentityflowerpot.markDirty();

                        if (!p_149727_1_.setBlockMetadataWithNotify(p_149727_2_, p_149727_3_, p_149727_4_, itemstack.getItemDamage(), 2))
                        {
                            p_149727_1_.markBlockForUpdate(p_149727_2_, p_149727_3_, p_149727_4_);
                        }

                        if (!p_149727_5_.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                        {
                            p_149727_5_.inventory.setInventorySlotContents(p_149727_5_.inventory.currentItem, (ItemStack)null);
                        }

                        return true;
                    }
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    public boolean flowers(Block p_149928_1_, int p_149928_2_)
    {
        return p_149928_1_ != VanillaEnhanced.blockRose && p_149928_1_ != VanillaEnhanced.blockPaeonia ? p_149928_1_ == Blocks.tallgrass && p_149928_2_ == 2 : true;
    }
    
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        Object object = null;
        byte meta = 0;

        switch (p_149915_2_)
        {
            case 1:
                object = VanillaEnhanced.blockRose;
                break;
            case 2:
                object = VanillaEnhanced.blockPaeonia;
                break;
        }

        return new TileEntityFlowerPot(Item.getItemFromBlock((Block)object), meta);
    }

    private TileEntityFlowerPot tileEntity(World p_149929_1_, int p_149929_2_, int p_149929_3_, int p_149929_4_)
    {
        TileEntity tileentity = p_149929_1_.getTileEntity(p_149929_2_, p_149929_3_, p_149929_4_);
        return tileentity != null && tileentity instanceof TileEntityFlowerPot ? (TileEntityFlowerPot)tileentity : null;
    }

    
}

package roadhog.venhanced.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;

public class ContainerNewWorkbench extends ContainerWorkbench {
	
	private int posX, posY, posZ;
	private World worldObj;
	
    public ContainerNewWorkbench(InventoryPlayer p_i1808_1_, World p_i1808_2_, int p_i1808_3_, int p_i1808_4_,
			int p_i1808_5_) {
		super(p_i1808_1_, p_i1808_2_, p_i1808_3_, p_i1808_4_, p_i1808_5_);
		worldObj = p_i1808_2_;
		posX = p_i1808_3_;
		posY = p_i1808_4_;
		posZ = p_i1808_5_;
	}

	public boolean canInteractWith(EntityPlayer player)
    {
        return worldObj.getBlock(posX, posY, posZ) != VanillaEnhanced.blockNewWorkbench ? false : player.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
    }
}
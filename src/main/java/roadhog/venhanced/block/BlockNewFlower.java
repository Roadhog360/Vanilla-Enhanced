package roadhog.venhanced.block;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class BlockNewFlower extends BlockBush {
	
	public BlockNewFlower(Material material) {
		super(material);
		this.setStepSound(soundTypeGrass);

	}
	
	public static void onPlayerInteract(PlayerInteractEvent event) {
		EntityPlayer player = event.entityPlayer;
		
			if (event.entityPlayer != null && !player.isSneaking()) {
				World world = event.entityPlayer.worldObj;
				if (event.action == Action.RIGHT_CLICK_BLOCK)
					if (world.getBlock(event.x, event.y, event.z) == Blocks.flower_pot && world.getBlockMetadata(event.x, event.y, event.z) == 0) {
						ItemStack item = event.entityPlayer.getCurrentEquippedItem();
						if (item != null && (item.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockRose) ||
								item.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockPaeonia))) {

							world.setBlock(event.x, event.y, event.z, VanillaEnhanced.blockVenhPot, 0, 2);
							event.entityPlayer.swingItem();
					}
			}
	}
	}
	
}
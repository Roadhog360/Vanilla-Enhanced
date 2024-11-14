package roadhog.venhanced.handler;

import roadhog.venhanced.VanillaEnhanced;
import roadhog.venhanced.gui.ContainerMacerator;
import roadhog.venhanced.gui.ContainerNewWorkbench;
import roadhog.venhanced.gui.GuiMacerator;
import roadhog.venhanced.gui.GuiNewWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (ID) {

			}
		}

		if (ID == VanillaEnhanced.guiID_BlockNewWorkbench) {
			return ID == VanillaEnhanced.guiID_BlockNewWorkbench
					&& world.getBlock(x, y, z) == VanillaEnhanced.blockNewWorkbench ? new ContainerNewWorkbench(
					player.inventory, world, x, y, z) : null;
		}else if (ID == VanillaEnhanced.guiID_BlockMacerator) {
			return ID == VanillaEnhanced.guiID_BlockMacerator
					&& world.getBlock(x, y, z) == VanillaEnhanced.blockMacerator ? new ContainerMacerator(
					player.inventory, world, x, y, z) : null;
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (ID) {

			}
		}

		if (ID == VanillaEnhanced.guiID_BlockNewWorkbench) {
			return ID == VanillaEnhanced.guiID_BlockNewWorkbench
					&& world.getBlock(x, y, z) == VanillaEnhanced.blockNewWorkbench ? new GuiNewWorkbench(
					player.inventory, world, x, y, z) : null;
		}else if (ID == VanillaEnhanced.guiID_BlockMacerator) {
			return ID == VanillaEnhanced.guiID_BlockMacerator
					&& world.getBlock(x, y, z) == VanillaEnhanced.blockMacerator ? new GuiMacerator(
					player.inventory, world, x, y, z) : null;
		}

		return null;
	}

}

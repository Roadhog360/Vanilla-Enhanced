package roadhog.venhanced.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import roadhog.venhanced.VanillaEnhanced;

public class BlockStrippedWoodNew extends BlockStrippedLogNew {

	public BlockStrippedWoodNew() {
		super();
		this.setHarvestLevel("axe", 0);
		this.setStepSound(soundTypeWood);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int meta) {
		return this.iconSide[meta % iconSide.length];
	}

}

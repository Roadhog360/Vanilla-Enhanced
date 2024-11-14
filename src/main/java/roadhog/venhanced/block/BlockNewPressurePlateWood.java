package roadhog.venhanced.block;

import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlockNewPressurePlateWood extends BlockPressurePlate {

	public BlockNewPressurePlateWood(String p_i45418_1_, Material p_i45418_2_, Sensitivity p_i45418_3_) {
		super(p_i45418_1_, p_i45418_2_, p_i45418_3_);
		this.setHardness(0.5F);
		this.setStepSound(soundTypeWood);
	}

}

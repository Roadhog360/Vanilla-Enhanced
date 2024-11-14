package roadhog.venhanced.block;

import static net.minecraftforge.common.util.ForgeDirection.UP;
import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockOreBlazicite extends Block {

	public BlockOreBlazicite(Material material) {
		super(material);
		this.setStepSound(soundTypeStone);
		this.setHardness(1.0F);
		this.setResistance(15.0F);
		this.setLightLevel(0.4F);
		this.setHarvestLevel("pickaxe", 2);
	}
	
    public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
    {
        if (this == VanillaEnhanced.blockOreBlazicite && side == UP)
        {
            return true;
        }
        return false;
    }

}

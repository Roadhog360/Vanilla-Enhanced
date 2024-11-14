package roadhog.venhanced.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockGlowingObsidian extends Block {

	public BlockGlowingObsidian(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 3);
		this.setHardness(50.0F);
		this.setResistance(6000.0F);
		this.setLightLevel(1.0F);
		this.setTickRandomly(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		renderParticle(world, x, y, z);
	}
	
    public int tickRate(World world)
    {
        return 50;
    }
	
    private void renderParticle(World world, int x, int y, int z)
    {
        Random random = world.rand;
        double d0 = 0.0625D;

        for (int l = 0; l < 6; ++l)
        {
            double d1 = (double)((float)x + random.nextFloat());
            double d2 = (double)((float)y + random.nextFloat());
            double d3 = (double)((float)z + random.nextFloat());

            if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube())
            {
                d2 = (double)(y + 1) + d0;
            }

            if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube())
            {
                d2 = (double)(y + 0) - d0;
            }

            if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube())
            {
                d3 = (double)(z + 1) + d0;
            }

            if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube())
            {
                d3 = (double)(z + 0) - d0;
            }

            if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube())
            {
                d1 = (double)(x + 1) + d0;
            }

            if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube())
            {
                d1 = (double)(x + 0) - d0;
            }

            if (d1 < (double)x || d1 > (double)(x + 1) || d2 < 0.0D || d2 > (double)(y + 1) || d3 < (double)z || d3 > (double)(z + 1))
            {
                world.spawnParticle("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
            }
        }
    }
	
}

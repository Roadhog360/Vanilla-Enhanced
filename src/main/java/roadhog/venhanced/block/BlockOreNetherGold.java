package roadhog.venhanced.block;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import roadhog.venhanced.VanillaEnhanced;

public class BlockOreNetherGold extends Block {

	public BlockOreNetherGold(Material material) {
		super(material);
		this.setStepSound(soundTypeStone);
		this.setHardness(0.95F);
		this.setResistance(14.2F);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	int drops;
	int amplifylevel;
	
    public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
    {
        if (this == VanillaEnhanced.blockOreBlazicite && side == UP)
        {
            return true;
        }
        return false;
    }

		public Item getItemDropped(int metadata, Random rand, int fortune){
    		return Items.gold_nugget;
    		}

        public int quantityDropped(Random rand)
        {
        	drops = rand.nextInt(4) + 2;
        	
            return drops;
        }

        public int quantityDroppedWithBonus(int fortune, Random rand)
        {
            if (fortune > 0)
            {
            	drops = rand.nextInt(4);
            	int flevel = (fortune * rand.nextInt(3) + 1) + drops;
            	
                int bonusdrops = rand.nextInt(flevel) + 3;

                if (bonusdrops < 3)
                {
                    bonusdrops = 3;
                }

                return quantityDropped(rand) + (bonusdrops);
            }
            else
            {
            	drops = rand.nextInt(4) + 2;
                return drops;
            }
        }
    	
    	@Override
    	public int getExpDrop(IBlockAccess world, int metadata, int fortune){
    		
    	    Random rand = world instanceof World ? ((World)world).rand : new Random();
    		return rand.nextInt(3)+3; 
        }

}

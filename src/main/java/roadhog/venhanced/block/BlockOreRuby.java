package roadhog.venhanced.block;

import java.util.Random;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOreRuby extends Block {

	public BlockOreRuby(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeStone);
		this.setHardness(3.0F);
		this.setResistance(30.0F);
	}

	public Item getItemDropped(int metadata, Random rand, int fortune){
		return VanillaEnhanced.itemRuby;
		}

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0)
        {
            int bonusdrops = random.nextInt(fortune + 2) - 1;

            if (bonusdrops < 0)
            {
                bonusdrops = 0;
            }

            return quantityDropped(random) * (bonusdrops + 1);
        }
        else
        {
            return quantityDropped(random);
        }
    }
	
	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune){
		
	    Random rand = world instanceof World ? ((World)world).rand : new Random();
		return rand.nextInt(5)+3; 
    }
}

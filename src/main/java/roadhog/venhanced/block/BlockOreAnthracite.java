package roadhog.venhanced.block;

import java.util.Random;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOreAnthracite extends Block {

	public BlockOreAnthracite(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeStone);
		this.setHardness(2.5F);
		this.setResistance(30.0F);
	}

	public Item getItemDropped(int metadata, Random rand, int fortune){
		return VanillaEnhanced.itemAnthracite;
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
		
        //THE RETURN VALUE IS HOW MANY XP ORBS IT WILL DROP WHEN THE BLOCK IS BROKEN.
	    Random rand = world instanceof World ? ((World)world).rand : new Random();
		return rand.nextInt(4)+1; 
    }
}

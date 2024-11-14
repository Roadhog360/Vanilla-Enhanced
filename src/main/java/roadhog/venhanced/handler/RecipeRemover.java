package roadhog.venhanced.handler;

import java.util.Iterator;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemover {
	
	public static void removeRecipe() {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		
		Iterator<IRecipe> remover = recipes.iterator();
		
			while(remover.hasNext()) {
				ItemStack input = remover.next().getRecipeOutput();
			if(input != null && input.getItem() == Item.getItemFromBlock(Blocks.sandstone)) {
				remover.remove();
			} else if(input != null && input.getItem() == Item.getItemFromBlock(Blocks.nether_brick_fence)){
				remover.remove();
			} else if(input != null && input.getItem() == Item.getItemFromBlock(Blocks.fence)){
				remover.remove();
			} else if(input != null && input.getItem() == Items.sign){
				remover.remove();
			} else if(input != null && input.getItem() == Item.getItemFromBlock(Blocks.fence_gate)){
				remover.remove();
			} else if(input != null && input.getItem() == Items.wooden_door){
				remover.remove();
			} else if(input != null && input.getItem() == Items.iron_door){
				remover.remove();
			} else if(input != null && input.getItem() == Items.brewing_stand){
				remover.remove();
			} else if(input != null && input.getItem() == Items.flint_and_steel){
				remover.remove();
			} else if(input != null && input.getItem() == Item.getItemFromBlock(Blocks.stone_button)){
				remover.remove();
			} else if(input != null && input.getItem() == Item.getItemFromBlock(Blocks.wooden_button)){
				remover.remove();
			} else if(input != null && input.getItem() == Item.getItemFromBlock(Blocks.stone_pressure_plate)){
				remover.remove();
			} else if(input != null && input.getItem() == Item.getItemFromBlock(Blocks.wooden_pressure_plate)){
				remover.remove();
			} else if(input != null && input.getItem() == Item.getItemFromBlock(Blocks.trapdoor)){
				remover.remove();
			}
		}
	
	}

}

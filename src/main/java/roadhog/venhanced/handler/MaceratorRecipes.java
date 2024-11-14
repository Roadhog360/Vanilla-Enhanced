package roadhog.venhanced.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import roadhog.venhanced.VanillaEnhanced;

public class MaceratorRecipes {
    /** The static instance of this class */
    private static final MaceratorRecipes instance = new MaceratorRecipes();
    /** A list of all the recipes added */
    private List recipes = new ArrayList();
    
    int wild = OreDictionary.WILDCARD_VALUE;

    /**
     * Returns the static instance of this class
     */
    public static final MaceratorRecipes getInstance()
    {
/** The static instance of this class */
return instance;
    }

    private MaceratorRecipes()
    {
recipes = new ArrayList();

this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemNuggetBlazicite), new Object[] {new ItemStack(VanillaEnhanced.itemBlaziciteAxe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemNuggetBlazicite), new Object[] {new ItemStack(VanillaEnhanced.itemBlazicitePickaxe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemNuggetBlazicite), new Object[] {new ItemStack(VanillaEnhanced.itemBlaziciteHoe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemNuggetBlazicite), new Object[] {new ItemStack(VanillaEnhanced.itemBlaziciteSword, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemNuggetBlazicite), new Object[] {new ItemStack(VanillaEnhanced.itemBlaziciteSpade, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemNuggetBlazicite), new Object[] {new ItemStack(VanillaEnhanced.itemBlaziciteHelmet, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemNuggetBlazicite), new Object[] {new ItemStack(VanillaEnhanced.itemBlaziciteChestplate, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemNuggetBlazicite), new Object[] {new ItemStack(VanillaEnhanced.itemBlaziciteLeggings, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemNuggetBlazicite), new Object[] {new ItemStack(VanillaEnhanced.itemBlaziciteBoots, 1, wild)});

this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 3), new Object[] {new ItemStack(Items.diamond_axe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 3), new Object[] {new ItemStack(Items.diamond_pickaxe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 3), new Object[] {new ItemStack(Items.diamond_hoe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 3), new Object[] {new ItemStack(Items.diamond_sword, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 3), new Object[] {new ItemStack(Items.diamond_shovel, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 3), new Object[] {new ItemStack(Items.diamond_helmet, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 3), new Object[] {new ItemStack(Items.diamond_chestplate, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 3), new Object[] {new ItemStack(Items.diamond_leggings, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 3), new Object[] {new ItemStack(Items.diamond_boots, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 6, 3), new Object[] {new ItemStack(Items.diamond_horse_armor, 1, wild)});

this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 4), new Object[] {new ItemStack(VanillaEnhanced.itemEmeraldAxe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 4), new Object[] {new ItemStack(VanillaEnhanced.itemEmeraldPickaxe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 4), new Object[] {new ItemStack(VanillaEnhanced.itemEmeraldHoe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 4), new Object[] {new ItemStack(VanillaEnhanced.itemEmeraldSword, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 4), new Object[] {new ItemStack(VanillaEnhanced.itemEmeraldSpade, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 4), new Object[] {new ItemStack(VanillaEnhanced.itemEmeraldHelmet, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 4), new Object[] {new ItemStack(VanillaEnhanced.itemEmeraldChestplate, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 4), new Object[] {new ItemStack(VanillaEnhanced.itemEmeraldLeggings, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 4), new Object[] {new ItemStack(VanillaEnhanced.itemEmeraldBoots, 1, wild)});

this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 5), new Object[] {new ItemStack(VanillaEnhanced.itemRubyAxe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 5), new Object[] {new ItemStack(VanillaEnhanced.itemRubyPickaxe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 5), new Object[] {new ItemStack(VanillaEnhanced.itemRubyHoe, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 5), new Object[] {new ItemStack(VanillaEnhanced.itemRubySword, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 5), new Object[] {new ItemStack(VanillaEnhanced.itemRubySpade, 1, wild)});

this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 6), new Object[] {new ItemStack(VanillaEnhanced.itemSapphireHelmet, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 6), new Object[] {new ItemStack(VanillaEnhanced.itemSapphireChestplate, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 6), new Object[] {new ItemStack(VanillaEnhanced.itemSapphireLeggings, 1, wild)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemShard, 1, 6), new Object[] {new ItemStack(VanillaEnhanced.itemSapphireBoots, 1, wild)});

this.addShapelessRecipe(new ItemStack(Blocks.planks), new Object[] {new ItemStack(Items.wooden_axe, 1, wild)});
this.addShapelessRecipe(new ItemStack(Blocks.planks), new Object[] {new ItemStack(Items.wooden_pickaxe, 1, wild)});
this.addShapelessRecipe(new ItemStack(Blocks.planks), new Object[] {new ItemStack(Items.wooden_hoe, 1, wild)});
this.addShapelessRecipe(new ItemStack(Blocks.planks), new Object[] {new ItemStack(Items.wooden_sword, 1, wild)});
this.addShapelessRecipe(new ItemStack(Blocks.planks), new Object[] {new ItemStack(Items.wooden_shovel, 1, wild)});

this.addShapelessRecipe(new ItemStack(Blocks.cobblestone), new Object[] {new ItemStack(Items.stone_axe, 1, wild)});
this.addShapelessRecipe(new ItemStack(Blocks.cobblestone), new Object[] {new ItemStack(Items.stone_pickaxe, 1, wild)});
this.addShapelessRecipe(new ItemStack(Blocks.cobblestone), new Object[] {new ItemStack(Items.stone_hoe, 1, wild)});
this.addShapelessRecipe(new ItemStack(Blocks.cobblestone), new Object[] {new ItemStack(Items.stone_sword, 1, wild)});
this.addShapelessRecipe(new ItemStack(Blocks.cobblestone), new Object[] {new ItemStack(Items.stone_shovel, 1, wild)});

this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 0), new Object[] {new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 0)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 1), new Object[] {new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 1)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 2), new Object[] {new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 2)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 3), new Object[] {new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 3)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 4), new Object[] {new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 4)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 5), new Object[] {new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 5)});

this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDust, 1, 0), new Object[] {new ItemStack(Items.coal, 1, 0)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDust, 1, 1), new Object[] {new ItemStack(Items.coal, 1, 1)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDust, 1, 2), new Object[] {new ItemStack(VanillaEnhanced.itemAnthracite)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDust, 1, 3), new Object[] {new ItemStack(Items.iron_ingot)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDust, 1, 4), new Object[] {new ItemStack(Items.gold_ingot)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDust, 1, 5), new Object[] {new ItemStack(VanillaEnhanced.itemIngotBlazicite)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDust, 1, 6), new Object[] {new ItemStack(Items.diamond)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDust, 1, 7), new Object[] {new ItemStack(Items.emerald)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDust, 1, 8), new Object[] {new ItemStack(VanillaEnhanced.itemRuby)});
this.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemDust, 1, 9), new Object[] {new ItemStack(VanillaEnhanced.itemSapphire)});
       
Collections.sort(this.recipes, new MaceratorRecipeSorter(this));
    }

    public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
    	ArrayList arraylist = new ArrayList();
    	Object[] aobject = par2ArrayOfObj;
    	int i = par2ArrayOfObj.length;

    	for (int j = 0; j < i; ++j)
{
    	    Object object1 = aobject[j];

    	    if (object1 instanceof ItemStack)
    	    {
    	    	arraylist.add(((ItemStack)object1).copy());
    	    }
    	    else if (object1 instanceof Item)
    	    {
    	    	arraylist.add(new ItemStack((Item)object1));
    	    }
    	    else
    	    {
    	if (!(object1 instanceof Block))
    	{
    	    throw new RuntimeException("Invalid shapeless recipe!");
    	}

    	arraylist.add(new ItemStack((Block)object1));
    }
}

this.recipes.add(new ShapelessRecipes(par1ItemStack, arraylist));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
int i = 0;
ItemStack itemstack = null;
ItemStack itemstack1 = null;
int j;

for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
{
    ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

    if (itemstack2 != null)
    {
if (i == 0)
{
    itemstack = itemstack2;
}

if (i == 1)
{
    itemstack1 = itemstack2;
}

++i;
    }
}

if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
{
    Item item = itemstack.getItem();
    int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
    int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
    int l = j1 + k + item.getMaxDamage() * 5 / 100;
    int i1 = item.getMaxDamage() - l;

    if (i1 < 0)
    {
i1 = 0;
    }

    return new ItemStack(itemstack.getItem(), 1, i1);
}
else
{
    for (j = 0; j < this.recipes.size(); ++j)
    {
IRecipe irecipe = (IRecipe)this.recipes.get(j);

if (irecipe.matches(par1InventoryCrafting, par2World))
{
    return irecipe.getCraftingResult(par1InventoryCrafting);
}
    }

    return null;
}
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
return this.recipes;
    }
}
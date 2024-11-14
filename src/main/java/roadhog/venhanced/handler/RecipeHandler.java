package roadhog.venhanced.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.RecipesTools;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import roadhog.venhanced.VanillaEnhanced;

public class RecipeHandler {
	
	public static void addRecipes() {
		
		int any = OreDictionary.WILDCARD_VALUE;
		
		//Recipe strands
		
		//Bricks and Concrete
		final ItemStack[] dyesI = new ItemStack[15];
		for (int i = 0; i < 15; i++) {
			dyesI[i] = new ItemStack(Items.dye, 1, i);
		}
		
		final String[] dyesOD = new String[] {"dyeWhite", "dyeOrange", "dyeMagenta", "dyeLightBlue", "dyeYellow", "dyeLime", "dyePink", "dyeGray", "dyeLightGray", "dyeCyan", "dyePurple", "dyeBlue", "dyeBrown", "dyeGreen", "dyeRed", "dyeBlack"};

		for (int i = 0; i < dyesOD.length; i++) {
			CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.blockConcretePowder, 8, i), new Object[]{dyesOD[i], new ItemStack(Blocks.sand, 1, 0), new ItemStack(Blocks.sand, 1, 0), new ItemStack(Blocks.sand, 1, 0), new ItemStack(Blocks.sand, 1, 0), Blocks.gravel, Blocks.gravel, Blocks.gravel, Blocks.gravel}));
			CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.blockBrickDyed, 8, i), new Object[]{dyesOD[i], "blockBrick", "blockBrick", "blockBrick", "blockBrick", "blockBrick", "blockBrick", "blockBrick", "blockBrick"}));
		}

		//Tools
	    String[][] toolPatterns = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}, {"X", "X", "#"}};
	    Object[][] toolItems;
	    
	    toolItems = new Object[][] {
	    	{"gemRuby", "gemEmerald", "ingotTin", "ingotCopper", "ingotOsmium", "ingotIridium", "ingotBronze", "ingotSteel", VanillaEnhanced.blockBone, "ingotBlazicite"},
	    	{VanillaEnhanced.itemRubyPickaxe, VanillaEnhanced.itemEmeraldPickaxe, VanillaEnhanced.itemTinPickaxe, VanillaEnhanced.itemCopperPickaxe, VanillaEnhanced.itemOsmiumPickaxe, VanillaEnhanced.itemIridiumPickaxe, VanillaEnhanced.itemBronzePickaxe, VanillaEnhanced.itemSteelPickaxe, VanillaEnhanced.itemBonePickaxe, VanillaEnhanced.itemBlazicitePickaxe},
	    	{VanillaEnhanced.itemRubySpade, VanillaEnhanced.itemEmeraldSpade, VanillaEnhanced.itemTinSpade, VanillaEnhanced.itemCopperSpade, VanillaEnhanced.itemOsmiumSpade, VanillaEnhanced.itemIridiumSpade, VanillaEnhanced.itemBronzeSpade, VanillaEnhanced.itemSteelSpade, VanillaEnhanced.itemBoneSpade, VanillaEnhanced.itemBlaziciteSpade},
	    	{VanillaEnhanced.itemRubyAxe, VanillaEnhanced.itemEmeraldAxe, VanillaEnhanced.itemTinAxe, VanillaEnhanced.itemCopperAxe, VanillaEnhanced.itemOsmiumAxe, VanillaEnhanced.itemIridiumAxe, VanillaEnhanced.itemBronzeAxe, VanillaEnhanced.itemSteelAxe, VanillaEnhanced.itemBoneAxe, VanillaEnhanced.itemBlaziciteAxe},
	    	{VanillaEnhanced.itemRubyHoe, VanillaEnhanced.itemEmeraldHoe, VanillaEnhanced.itemTinHoe, VanillaEnhanced.itemCopperHoe, VanillaEnhanced.itemOsmiumHoe, VanillaEnhanced.itemIridiumHoe, VanillaEnhanced.itemBronzeHoe, VanillaEnhanced.itemSteelHoe, VanillaEnhanced.itemBoneHoe, VanillaEnhanced.itemBlaziciteHoe},
	    	{VanillaEnhanced.itemRubySword, VanillaEnhanced.itemEmeraldSword, VanillaEnhanced.itemTinSword, VanillaEnhanced.itemCopperSword, VanillaEnhanced.itemOsmiumSword, VanillaEnhanced.itemIridiumSword, VanillaEnhanced.itemBronzeSword, VanillaEnhanced.itemSteelSword, VanillaEnhanced.itemBoneSword, VanillaEnhanced.itemBlaziciteSword}};

	    	for (int i = 0; i < toolItems[0].length; ++i) {
	            Object object = toolItems[0][i];

	            for (int j = 0; j < toolItems.length - 1; ++j) {
	            	Object stick = "stickWood";
	                Item item = (Item)toolItems[j + 1][i];
	                
	                if (object == "ingotBlazicite")
	                	stick = Items.blaze_rod;
	                
	    			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(item), new Object[]{toolPatterns[j], '#', stick, 'X', object}));
	    		}
			}

			//Armour
		    String[][] armourPatterns = new String[][] {{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
		    Object[][] armourItems;
		    
		    armourItems = new Object[][] {
		    	{"gemEmerald", "gemSapphire", "ingotTin", "ingotCopper", "ingotOsmium", "ingotIridium", "ingotBronze", "ingotSteel", "ingotBlazicite"},
		    	{VanillaEnhanced.itemEmeraldHelmet, VanillaEnhanced.itemSapphireHelmet, VanillaEnhanced.itemTinHelmet, VanillaEnhanced.itemCopperHelmet, VanillaEnhanced.itemOsmiumHelmet, VanillaEnhanced.itemIridiumHelmet, VanillaEnhanced.itemBronzeHelmet, VanillaEnhanced.itemSteelHelmet, VanillaEnhanced.itemBlaziciteHelmet},
		    	{VanillaEnhanced.itemEmeraldChestplate, VanillaEnhanced.itemSapphireChestplate, VanillaEnhanced.itemTinChestplate, VanillaEnhanced.itemCopperChestplate, VanillaEnhanced.itemOsmiumChestplate, VanillaEnhanced.itemIridiumChestplate, VanillaEnhanced.itemBronzeChestplate, VanillaEnhanced.itemSteelChestplate, VanillaEnhanced.itemBlaziciteChestplate},
		    	{VanillaEnhanced.itemEmeraldLeggings, VanillaEnhanced.itemSapphireLeggings, VanillaEnhanced.itemTinLeggings, VanillaEnhanced.itemCopperLeggings, VanillaEnhanced.itemOsmiumLeggings, VanillaEnhanced.itemIridiumLeggings, VanillaEnhanced.itemBronzeLeggings, VanillaEnhanced.itemSteelLeggings, VanillaEnhanced.itemBlaziciteLeggings},
		    	{VanillaEnhanced.itemEmeraldBoots, VanillaEnhanced.itemSapphireBoots, VanillaEnhanced.itemTinBoots, VanillaEnhanced.itemCopperBoots, VanillaEnhanced.itemOsmiumBoots, VanillaEnhanced.itemIridiumBoots, VanillaEnhanced.itemBronzeBoots, VanillaEnhanced.itemSteelBoots, VanillaEnhanced.itemBlaziciteBoots}};

	    	for (int i = 0; i < armourItems[0].length; ++i) {
	            Object object = armourItems[0][i];
	            
		            for (int j = 0; j < armourItems.length - 1; ++j) {
	                Item item = (Item)armourItems[j + 1][i];
	                
	    			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(item), new Object[]{armourPatterns[j], 'X', object}));
	    		}
			}

			//Blocks, Ingots, Nuggets etc
		    String[][] loopPatterns = new String[][] {{"XXX", "XXX", "XXX"}, {"XX", "XX"}};
		    Object[][] loopItems;
		    
		    loopItems = new Object[][] {
		    	{new ItemStack(Items.coal, 1, 1), "gemRuby", "gemSapphire", "ingotTin", "ingotCopper", "ingotIridium", "ingotOsmium", Items.nether_wart, VanillaEnhanced.itemAnthracite, Items.blaze_rod, Items.bone},
		    	{VanillaEnhanced.blockCharcoal, VanillaEnhanced.blockRuby, VanillaEnhanced.blockSapphire, VanillaEnhanced.blockMetal, VanillaEnhanced.blockMetal, VanillaEnhanced.blockMetal, VanillaEnhanced.blockMetal, VanillaEnhanced.blockNetherWart, VanillaEnhanced.blockAnthracite, VanillaEnhanced.blockBlaze, VanillaEnhanced.blockBone},
		    	{VanillaEnhanced.blockCharcoal, "blockRuby", "blockSapphire"},
		    	{new ItemStack(Items.coal, 1, 1), VanillaEnhanced.itemRuby, VanillaEnhanced.itemSapphire}};
	                
	    	    	for (int i = 0; i < loopItems[0].length; ++i) {
		    	            Object object = loopItems[0][i];
		                    Block item = (Block)loopItems[1][i];
//		    	            Object object2 = loopItems[2][i];
//		                    Item item2 = (Item)loopItems[3][i];
		                    
		                    int rPat = 0;
		                    int rOut = 9;
		                    int iDamage = 0;
		                    if (object == "ingotCopper")
		                    	iDamage = 1;
		                    else if (object == "ingotOsmium")
		                    	iDamage = 2;
		                    else if (object == "ingotIridium")
		                    	iDamage = 3;
		                    else if (object == "ingotBronze")
		                    	iDamage = 4;
		                    else if (object == "ingotSteel")
		                    	iDamage = 5;
		                    
		                    if (object == Items.blaze_rod || object == Items.bone) {
		                    	rPat = 1;
		                    	rOut = 4;
		                    }
			    			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(item, 1, iDamage), new Object[]{loopPatterns[rPat], 'X', object}));
			    			CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.blockBark), new Object[]{item}));
	    			}

		GameRegistry.addRecipe(new ItemStack(Blocks.sandstone), new Object[]{"SS","SS",'S', Blocks.sand});
		GameRegistry.addRecipe(new ItemStack(Blocks.sandstone, 4, 2), new Object[]{"SS","SS", 'S', new ItemStack(Blocks.sandstone, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Blocks.sandstone, 1, 1), new Object[]{"S","S", 'S', new ItemStack(Blocks.stone_slab, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Blocks.nether_brick_fence, 6), new Object[]{"BbB","BbB", 'B', Blocks.nether_brick, 'b', Items.netherbrick});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.iron_door, 3), new Object[]{"II","II","II", 'I', "ingotIron"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.wooden_door, 3), new Object[]{"PP","PP","PP", 'P', "plankWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(Items.flint_and_steel), new Object[]{Items.flint, "ingotSteel"}));
		GameRegistry.addRecipe(new ItemStack(Items.brewing_stand), new Object[]{"B","S", 'S', new ItemStack(Blocks.stone_slab, 1, 3), 'B', Items.blaze_rod});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockLantern, 1), new Object[]{"iii","ici","iii", 'i', "nuggetIron", 'c', new ItemStack(Items.coal, 1, any)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockLantern, 3), new Object[]{"iii","igi","iii", 'i', "nuggetIron", 'g', Items.glowstone_dust}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockLantern, 4), new Object[]{"iii","igi","iii", 'i', "nuggetIron", 'g', VanillaEnhanced.itemAnthracite}));
		
		//Material Loops
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 0), new Object[]{"RRR","RRR","RRR", 'R', "nuggetTin"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemNuggetMetal, 9, 0), new Object[]{"ingotTin"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 1), new Object[]{"RRR","RRR","RRR", 'R', "nuggetCopper"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemNuggetMetal, 9, 1), new Object[]{"ingotCopper"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 2), new Object[]{"RRR","RRR","RRR", 'R', "nuggetOsmium"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemNuggetMetal, 9, 2), new Object[]{"ingotOsmium"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 3), new Object[]{"RRR","RRR","RRR", 'R', "nuggetIridium"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemNuggetMetal, 9, 3), new Object[]{"ingotIridium"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemIngotBlazicite), new Object[]{"RRR","RRR","RRR", 'R', "nuggetBlazicite"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemNuggetBlazicite, 9), new Object[]{"ingotBlazicite"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.iron_ingot), new Object[]{"RRR","RRR","RRR", 'R', "nuggetIron"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemNuggetIron, 9), new Object[]{"ingotIron"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.coal), new Object[]{"RRR","RRR","RRR", 'R', "nuggetCoal"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemShard, 9, 0), new Object[]{Items.coal}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.coal, 1, 1), new Object[]{"RRR","RRR","RRR", 'R', "nuggetCharcoal"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemShard, 9, 1), new Object[]{new ItemStack(Items.coal, 1, 1)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemAnthracite), new Object[]{"RRR","RRR","RRR", 'R', "nuggetAnthracite"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemShard, 9, 2), new Object[]{"itemAnthracite"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.diamond), new Object[]{"RRR","RRR","RRR", 'R', "nuggetDiamond"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemShard, 9, 3), new Object[]{"gemDiamond"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.emerald), new Object[]{"RRR","RRR","RRR", 'R', "nuggetEmerald"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemShard, 9, 4), new Object[]{"gemEmerald"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemRuby), new Object[]{"RRR","RRR","RRR", 'R', "nuggetRuby"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemShard, 9, 5), new Object[]{"gemRuby"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemSapphire), new Object[]{"RRR","RRR","RRR", 'R', "nuggetSapphire"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemShard, 9, 6), new Object[]{"gemSapphire"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockMetal, 1, 4), new Object[]{"RRR","RRR","RRR", 'R', "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemIngotMetal, 9, 4), new Object[]{"blockBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockMetal, 1, 5), new Object[]{"RRR","RRR","RRR", 'R', "ingotSteel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemIngotMetal, 9, 5), new Object[]{"blockSteel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 4), new Object[]{"RRR","RRR","RRR", 'R', "nuggetBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemNuggetMetal, 9, 4), new Object[]{"ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 5), new Object[]{"RRR","RRR","RRR", 'R', "nuggetSteel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemNuggetMetal, 9, 5), new Object[]{"ingotSteel"}));
		
		//Normal Crafting
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 2), new Object[]{"CB","BC", 'C', "nuggetCoal", 'B', Items.netherbrick}));
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 5), new Object[]{"NB","BN", 'N', Items.nether_wart, 'B', Items.netherbrick});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockMissing), new Object[] {"BM","MB", 'M', new ItemStack(VanillaEnhanced.blockConcrete, 1, 2), 'B', new ItemStack(VanillaEnhanced.blockConcrete, 1, 15)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockCobblePaver, 4), new Object[]{"CC","CC", 'C', Blocks.cobblestone});
		GameRegistry.addRecipe(new ItemStack(Blocks.double_stone_slab, 1), new Object[]{"S","S", 'S', new ItemStack(Blocks.stone_slab, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockPolishedStone, 4), new Object[]{"SS","SS", 'S', new ItemStack(Blocks.double_stone_slab, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockNewSandstone, 4), new Object[]{"SS","SS", 'S', new ItemStack(Blocks.sandstone, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockNewSandstone, 5, 1), new Object[]{"S S"," S ","S S", 'S', new ItemStack(Blocks.sandstone, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockRedSandstone, 4, 2), new Object[]{"SS","SS", 'S', new ItemStack(VanillaEnhanced.blockRedSandstone, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockRedSandstone), new Object[]{"SS","SS", 'S', new ItemStack(Blocks.sand, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockRedSandstone, 2, 1), new Object[]{"S","S", 'S', new ItemStack(VanillaEnhanced.blockRedSandstone, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockRedSandstone, 4, 3), new Object[]{"SS","SS", 'S', new ItemStack(VanillaEnhanced.blockRedSandstone, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockRedSandstone, 5, 4), new Object[]{"S S"," S ","S S", 'S', new ItemStack(VanillaEnhanced.blockRedSandstone, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockRose, 4), new Object[]{"R", 'R', new ItemStack(Blocks.double_plant, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockPaeonia, 4), new Object[]{"P", 'P', new ItemStack(Blocks.double_plant, 1, 5)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 1), new Object[]{VanillaEnhanced.blockRose});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 9), new Object[]{VanillaEnhanced.blockPaeonia});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.flint), new Object[]{Blocks.gravel, Blocks.gravel, Blocks.gravel});
//		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 2), new Object[]{"SS","SS", 'S', Items.stick});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.torch, 12), new Object[]{"A","S", 'S', "stickWood", 'A', VanillaEnhanced.itemAnthracite}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockGlowingObsidian), new Object[]{"RGR","GOG","RGR", 'O', Blocks.obsidian, 'R', "dustRedstone", 'G', Blocks.glowstone}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockGlowingObsidian), new Object[]{"GRG","ROR","GRG", 'O', Blocks.obsidian, 'R', "dustRedstone", 'G', Blocks.glowstone}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockCrate, 6), new Object[]{"WPW","P P","WPW", 'P', "plankWood", 'W', Blocks.wool}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockStickyCrate, 6), new Object[]{"WPW","PSP","WPW", 'P', "plankWood", 'W', Blocks.wool, 'S', "slimeball"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.blockStickyCrate), new Object[]{"slimeball", VanillaEnhanced.blockCrate}));
//		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.blaze_rod, 2), new Object[]{"B","B", 'B', "ingotBlazicite"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockMacerator), new Object[]{"T T","RIR","CCC", 'C', "cobblestone", 'I', "ingotIron", 'R', "dustRedstone", 'T', "ingotTin"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemDustMetal, 4, 4), new Object[]{"dustTin", "dustCopper", "dustCopper", "dustCopper"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemDustMetal, 9, 5), new Object[]{"dustCoal", "dustIron", "dustIron", "dustIron", "dustIron", "dustIron", "dustIron", "dustIron", "dustIron"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(VanillaEnhanced.itemDustMetal, 9, 5), new Object[]{"dustAnthracite", "dustIron", "dustIron", "dustIron", "dustIron"}));
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockNewWorkbench, 1, 0), new Object[]{"SS","SS", 'S', new ItemStack(Blocks.planks, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockNewWorkbench, 1, 1), new Object[]{"BB","BB", 'B', new ItemStack(Blocks.planks, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockNewWorkbench, 1, 2), new Object[]{"JJ","JJ", 'J', new ItemStack(Blocks.planks, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockNewWorkbench, 1, 3), new Object[]{"AA","AA", 'A', new ItemStack(Blocks.planks, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockNewWorkbench, 1, 4), new Object[]{"DD","DD", 'D', new ItemStack(Blocks.planks, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 4, 0), new Object[]{"L", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 4, 1), new Object[]{"L", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 4, 2), new Object[]{"L", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 4, 3), new Object[]{"L", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 4, 4), new Object[]{"L", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog2, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 4, 5), new Object[]{"L", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog2, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockStrippedWood, 4, 0), new Object[]{"LL", "LL", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockStrippedWood, 4, 1), new Object[]{"LL", "LL", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockStrippedWood, 4, 2), new Object[]{"LL", "LL", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockStrippedWood, 4, 3), new Object[]{"LL", "LL", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockStrippedWood2, 4, 0), new Object[]{"LL", "LL", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog2, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockStrippedWood2, 4, 1), new Object[]{"LL", "LL", 'L', new ItemStack(VanillaEnhanced.blockStrippedLog2, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.itemWitheredBonemeal, 3), new Object[]{"W", 'W', VanillaEnhanced.itemWitheredBone});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockSpruceScaffolding, 10), new Object[]{"PPP","SSS","SSS",'P', new ItemStack(Blocks.planks, 1, 1), 'S', "stickWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockBirchScaffolding, 10), new Object[]{"PPP","SSS","SSS",'P', new ItemStack(Blocks.planks, 1, 2), 'S', "stickWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockJungleScaffolding, 10), new Object[]{"PPP","SSS","SSS",'P', new ItemStack(Blocks.planks, 1, 3), 'S', "stickWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockAcaciaScaffolding, 10), new Object[]{"PPP","SSS","SSS",'P', new ItemStack(Blocks.planks, 1, 4), 'S', "stickWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockBigOakScaffolding, 10), new Object[]{"PPP","SSS","SSS",'P', new ItemStack(Blocks.planks, 1, 5), 'S', "stickWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockOakScaffolding, 10), new Object[]{"PPP","SSS","SSS",'P', "plankWood", 'S', "stickWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceSpruce, 6), new Object[]{"PsP","PsP",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 1)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceBirch, 6), new Object[]{"PsP","PsP",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 2)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceJungle, 6), new Object[]{"PsP","PsP",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 3)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceAcacia, 6), new Object[]{"PsP","PsP",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 4)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceBigOak, 6), new Object[]{"PsP","PsP",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 5)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.fence, 6), new Object[]{"PsP","PsP",'s', "stickWood", 'P', "plankWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceGateSpruce, 3), new Object[]{"sPs","sPs",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 1)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceGateBirch, 3), new Object[]{"sPs","sPs",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 2)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceGateJungle, 3), new Object[]{"sPs","sPs",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 3)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceGateAcacia, 3), new Object[]{"sPs","sPs",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 4)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceGateBigOak, 3), new Object[]{"sPs","sPs",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 5)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceGateNetherBrick, 3), new Object[]{"bPb","bPb",'b', "ingotBrickNether", 'P', new ItemStack(Blocks.nether_brick, 1, 0)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceGateRedNetherBrick, 3), new Object[]{"bPb","bPb",'b', "ingotBrickNether", 'P', new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 5)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockFenceGateBlackNetherBrick, 3), new Object[]{"bPb","bPb",'b', "ingotBrickNether", 'P', new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 2)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.fence_gate, 3), new Object[]{"sPs","sPs",'s', "stickWood", 'P', "plankWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.wooden_button, 12), new Object[]{"P", 'P', new ItemStack(Blocks.planks, 1, 0)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockButtonSpruce, 12), new Object[]{"P", 'P', new ItemStack(Blocks.planks, 1, 1)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockButtonBirch, 12), new Object[]{"P", 'P', new ItemStack(Blocks.planks, 1, 2)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockButtonJungle, 12), new Object[]{"P", 'P', new ItemStack(Blocks.planks, 1, 3)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockButtonAcacia, 12), new Object[]{"P", 'P', new ItemStack(Blocks.planks, 1, 4)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockButtonBigOak, 12), new Object[]{"P", 'P', new ItemStack(Blocks.planks, 1, 5)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockPressurePlateSpruce, 8), new Object[]{"PP", 'P',  new ItemStack(Blocks.planks, 1, 1)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockPressurePlateBirch, 8), new Object[]{"PP", 'P',  new ItemStack(Blocks.planks, 1, 2)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockPressurePlateJungle, 8), new Object[]{"PP", 'P',  new ItemStack(Blocks.planks, 1, 3)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockPressurePlateAcacia, 8), new Object[]{"PP", 'P',  new ItemStack(Blocks.planks, 1, 4)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockPressurePlateBigOak, 8), new Object[]{"PP", 'P',  new ItemStack(Blocks.planks, 1, 5)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockTrapDoorSpruce, 2), new Object[]{"PPP", "PPP", 'P',  new ItemStack(Blocks.planks, 1, 1)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockTrapDoorBirch, 2), new Object[]{"PPP", "PPP", 'P',  new ItemStack(Blocks.planks, 1, 2)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockTrapDoorJungle, 2), new Object[]{"PPP", "PPP", 'P',  new ItemStack(Blocks.planks, 1, 3)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockTrapDoorAcacia, 2), new Object[]{"PPP", "PPP", 'P',  new ItemStack(Blocks.planks, 1, 4)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockTrapDoorBigOak, 2), new Object[]{"PPP", "PPP", 'P',  new ItemStack(Blocks.planks, 1, 5)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.blockTrapDoorLadder, 1), new Object[]{"PLP", "PLP", 'P',  "plankWood", 'L', Blocks.ladder}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.trapdoor, 2), new Object[]{"PPP", "PPP", 'P',  "plankWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemSignSpruce, 3), new Object[]{"PPP","PPP"," s ",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 1)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemSignBirch, 3), new Object[]{"PPP","PPP"," s ",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 2)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemSignJungle, 3), new Object[]{"PPP","PPP"," s ",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 3)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemSignAcacia, 3), new Object[]{"PPP","PPP"," s ",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 4)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemSignBigOak, 3), new Object[]{"PPP","PPP"," s ",'s', "stickWood", 'P', new ItemStack(Blocks.planks, 1, 5)}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.sign, 3), new Object[]{"PPP","PPP"," s ",'s', "stickWood", 'P', "plankWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.wooden_pressure_plate, 8), new Object[]{"PP", 'P', "plankWood"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.stone_button, 12), new Object[]{"S", 'S', "stone"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.stone_pressure_plate, 8), new Object[]{"SS", 'S', "stone"}));
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockRedNetherBrickFence, 6), new Object[]{"RbR","RbR", 'R', new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 5), 'b', Items.netherbrick});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockBlackNetherBrickFence, 6), new Object[]{"RbR","RbR", 'R', new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 2), 'b', Items.netherbrick});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockRedNetherBrickStairs, 4), new Object[]{"  B"," BB","BBB", 'B', new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(VanillaEnhanced.blockBlackNetherBrickStairs, 4), new Object[]{"  B"," BB","BBB", 'B', new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 2)});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemDiamondApple, 1, 0), new Object[]{" d ", "dad", " d ", 'd', "gemDiamond", 'a', Items.apple}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemDiamondApple, 1, 1), new Object[]{"dDd", "DaD", "dDd", 'd', "gemDiamond", 'D', "blockDiamond", 'a', Items.apple}));
		GameRegistry.addShapelessRecipe(new ItemStack(VanillaEnhanced.itemPieApple), new Object[]{Items.apple, Items.apple, Items.egg, Items.sugar});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemCakeCarrot, 1, 0), new Object[]{"M M", "SES", "CCC", 'M', Items.milk_bucket, 'S', Items.sugar, 'E', Items.egg, 'C', Items.carrot}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemCakeChocolate, 1, 0), new Object[]{"MCM", "SES", "WCW", 'M', Items.milk_bucket, 'S', Items.sugar, 'E', Items.egg, 'C', new ItemStack(Items.dye, 1, 3), 'W', Items.wheat}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemCakeVelvet, 1, 0), new Object[]{"MRM", "SES", "WRW", 'M', Items.milk_bucket, 'S', Items.sugar, 'E', Items.egg, 'R', new ItemStack(Items.dye, 1, 1), 'W', Items.wheat}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(VanillaEnhanced.itemCakeIceCream, 1, 0), new Object[]{"SMS", "sss", 'M', Items.milk_bucket, 'S', Items.sugar, 's', Items.snowball}));
		
		//Tools and Armour
		
		//Smelting
		GameRegistry.addSmelting(VanillaEnhanced.blockOreRuby, new ItemStack(VanillaEnhanced.itemRuby), 6);
		GameRegistry.addSmelting(VanillaEnhanced.blockOreSapphire, new ItemStack(VanillaEnhanced.itemSapphire), 5.5F);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.blockOreMetal), new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 0), 2F);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.blockOreMetal, 1, 1), new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 1), 2.25F);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.blockOreMetal, 1, 2), new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 2), 6F);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.blockOreMetal, 1, 3), new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 3), 6F);
		GameRegistry.addSmelting(VanillaEnhanced.blockOreBlazicite, new ItemStack(VanillaEnhanced.itemIngotBlazicite), 6);
		GameRegistry.addSmelting(VanillaEnhanced.blockOreAnthracite, new ItemStack(VanillaEnhanced.itemAnthracite), 5);
		GameRegistry.addSmelting(VanillaEnhanced.blockStrippedLog, new ItemStack(Items.coal, 1, 1), 0.15F);
		GameRegistry.addSmelting(VanillaEnhanced.blockStrippedLog2, new ItemStack(Items.coal, 1, 1), 0.15F);
		
		GameRegistry.addSmelting(Items.golden_helmet, new ItemStack(Items.gold_nugget), 10F);
		GameRegistry.addSmelting(Items.golden_chestplate, new ItemStack(Items.gold_nugget), 10F);
		GameRegistry.addSmelting(Items.golden_leggings, new ItemStack(Items.gold_nugget), 10F);
		GameRegistry.addSmelting(Items.golden_boots, new ItemStack(Items.gold_nugget), 10F);
		GameRegistry.addSmelting(Items.golden_sword, new ItemStack(Items.gold_nugget), 10F);
		GameRegistry.addSmelting(Items.golden_pickaxe, new ItemStack(Items.gold_nugget), 10F);
		GameRegistry.addSmelting(Items.golden_axe, new ItemStack(Items.gold_nugget), 10F);
		GameRegistry.addSmelting(Items.golden_shovel, new ItemStack(Items.gold_nugget), 10F);
		GameRegistry.addSmelting(Items.golden_hoe, new ItemStack(Items.gold_nugget), 10F);
		GameRegistry.addSmelting(Items.golden_horse_armor, new ItemStack(Items.gold_nugget, 6), 10F);

		GameRegistry.addSmelting(Items.iron_helmet, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.iron_chestplate, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.iron_leggings, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.iron_boots, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.chainmail_helmet, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.chainmail_chestplate, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.chainmail_leggings, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.chainmail_boots, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.iron_sword, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.iron_pickaxe, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.iron_axe, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.iron_shovel, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.iron_hoe, new ItemStack(VanillaEnhanced.itemNuggetIron), 10F);
		GameRegistry.addSmelting(Items.iron_horse_armor, new ItemStack(VanillaEnhanced.itemNuggetIron, 6), 10F);
		
		GameRegistry.addSmelting(VanillaEnhanced.itemTinHelmet, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 0), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemTinChestplate, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 0), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemTinLeggings, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 0), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemTinBoots, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 0), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemTinSword, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 0), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemTinPickaxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 0), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemTinAxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 0), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemTinSpade, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 0), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemTinHoe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 0), 10F);
		
		GameRegistry.addSmelting(VanillaEnhanced.itemCopperHelmet, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 1), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemCopperChestplate, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 1), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemCopperLeggings, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 1), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemCopperBoots, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 1), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemCopperSword, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 1), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemCopperPickaxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 1), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemCopperAxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 1), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemCopperSpade, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 1), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemCopperHoe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 1), 10F);
		
		GameRegistry.addSmelting(VanillaEnhanced.itemOsmiumHelmet, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 2), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemOsmiumChestplate, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 2), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemOsmiumLeggings, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 2), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemOsmiumBoots, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 2), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemOsmiumSword, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 2), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemOsmiumPickaxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 2), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemOsmiumAxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 2), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemOsmiumSpade, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 2), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemOsmiumHoe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 2), 10F);
		
		GameRegistry.addSmelting(VanillaEnhanced.itemIridiumHelmet, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 3), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemIridiumChestplate, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 3), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemIridiumLeggings, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 3), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemIridiumBoots, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 3), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemIridiumSword, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 3), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemIridiumPickaxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 3), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemIridiumAxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 3), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemIridiumSpade, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 3), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemIridiumHoe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 3), 10F);
		
		GameRegistry.addSmelting(VanillaEnhanced.itemBronzeHelmet, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 4), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemBronzeChestplate, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 4), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemBronzeLeggings, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 4), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemBronzeBoots, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 4), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemBronzeSword, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 4), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemBronzePickaxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 4), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemBronzeAxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 4), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemBronzeSpade, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 4), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemBronzeHoe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 4), 10F);
		
		GameRegistry.addSmelting(VanillaEnhanced.itemSteelHelmet, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 5), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemSteelChestplate, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 5), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemSteelLeggings, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 5), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemSteelBoots, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 5), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemSteelSword, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 5), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemSteelPickaxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 5), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemSteelAxe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 5), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemSteelSpade, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 5), 10F);
		GameRegistry.addSmelting(VanillaEnhanced.itemSteelHoe, new ItemStack(VanillaEnhanced.itemNuggetMetal, 1, 5), 10F);
		
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 0), new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 0), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 1), new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 1), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 2), new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 2), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 3), new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 3), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 4), new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 4), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDustMetal, 1, 5), new ItemStack(VanillaEnhanced.itemIngotMetal, 1, 5), 0);

		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDust, 1, 3), new ItemStack(Items.iron_ingot), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDust, 1, 4), new ItemStack(Items.gold_ingot), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDust, 1, 5), new ItemStack(VanillaEnhanced.itemIngotBlazicite), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDust, 1, 6), new ItemStack(Items.diamond), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDust, 1, 7), new ItemStack(Items.emerald), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDust, 1, 8), new ItemStack(VanillaEnhanced.itemRuby), 0);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.itemDust, 1, 9), new ItemStack(VanillaEnhanced.itemSapphire), 0);

		GameRegistry.addSmelting(Blocks.nether_brick, new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 0), 10F);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 2), new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 3), 10F);
		GameRegistry.addSmelting(new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 5), new ItemStack(VanillaEnhanced.blockNewNetherBrick, 1, 6), 10F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 2), 10F);
	}

}

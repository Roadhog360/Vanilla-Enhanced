package roadhog.venhanced;

import java.util.List;

import org.lwjgl.opengl.Display;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import roadhog.venhanced.block.BlockAlwaysOnLamp;
import roadhog.venhanced.block.BlockAnthracite;
import roadhog.venhanced.block.BlockBark;
import roadhog.venhanced.block.BlockBarkNew;
import roadhog.venhanced.block.BlockBarrier;
import roadhog.venhanced.block.BlockBlaze;
import roadhog.venhanced.block.BlockBone;
import roadhog.venhanced.block.BlockBrickDyed;
import roadhog.venhanced.block.BlockCauldronLava;
import roadhog.venhanced.block.BlockCauldronWater;
import roadhog.venhanced.block.BlockCharcoal;
import roadhog.venhanced.block.BlockCobblePaver;
import roadhog.venhanced.block.BlockConcrete;
import roadhog.venhanced.block.BlockConcretePowder;
import roadhog.venhanced.block.BlockCrate;
import roadhog.venhanced.block.BlockForcefield;
import roadhog.venhanced.block.BlockGem;
import roadhog.venhanced.block.BlockGlowingObsidian;
import roadhog.venhanced.block.BlockGoldWorkbench;
import roadhog.venhanced.block.BlockLantern;
import roadhog.venhanced.block.BlockLavaStationary;
import roadhog.venhanced.block.BlockMacerator;
import roadhog.venhanced.block.BlockMagma;
import roadhog.venhanced.block.BlockMetal;
import roadhog.venhanced.block.BlockMissing;
import roadhog.venhanced.block.BlockMyceliumPath;
import roadhog.venhanced.block.BlockNetherWart;
import roadhog.venhanced.block.BlockNewButtonWood;
import roadhog.venhanced.block.BlockNewCake;
import roadhog.venhanced.block.BlockNewFenceGateRock;
import roadhog.venhanced.block.BlockNewFenceGateWood;
import roadhog.venhanced.block.BlockNewFenceWood;
import roadhog.venhanced.block.BlockNewFlower;
import roadhog.venhanced.block.BlockNewNetherBrick;
import roadhog.venhanced.block.BlockNewNetherBrickFence;
import roadhog.venhanced.block.BlockNewRockSlab;
import roadhog.venhanced.block.BlockNewStairs;
import roadhog.venhanced.block.BlockNewPressurePlateWood;
import roadhog.venhanced.block.BlockNewSandstone;
import roadhog.venhanced.block.BlockNewSign;
import roadhog.venhanced.block.BlockNewTrapDoorWood;
import roadhog.venhanced.block.BlockNewWorkbench;
import roadhog.venhanced.block.BlockOreAnthracite;
import roadhog.venhanced.block.BlockOreBlazicite;
import roadhog.venhanced.block.BlockOreMetal;
import roadhog.venhanced.block.BlockOreNetherGold;
import roadhog.venhanced.block.BlockOreNetherMetal;
import roadhog.venhanced.block.BlockOreRuby;
import roadhog.venhanced.block.BlockOreSapphire;
import roadhog.venhanced.block.BlockPolishedStone;
import roadhog.venhanced.block.BlockRedSandstone;
import roadhog.venhanced.block.BlockScaffolding;
import roadhog.venhanced.block.BlockSteelScaffolding;
import roadhog.venhanced.block.BlockStrippedLog;
import roadhog.venhanced.block.BlockStrippedLogNew;
import roadhog.venhanced.block.BlockStrippedWood;
import roadhog.venhanced.block.BlockStrippedWoodNew;
import roadhog.venhanced.block.BlockTest;
import roadhog.venhanced.block.BlockVenhPot;
import roadhog.venhanced.block.BlockWaterStationary;
import roadhog.venhanced.block.replace.BlockFenceNether;
import roadhog.venhanced.block.replace.BlockFenceWood;
import roadhog.venhanced.block.replace.BlockWallRock;
import roadhog.venhanced.handler.ClusterOreGen;
import roadhog.venhanced.handler.FuelHandler;
import roadhog.venhanced.handler.GuiHandler;
import roadhog.venhanced.handler.RecipeHandler;
import roadhog.venhanced.handler.RecipeRemover;
import roadhog.venhanced.handler.SingleOreGen;
import roadhog.venhanced.handler.VanillaEventHandler;
import roadhog.venhanced.item.ItemAnthracite;
import roadhog.venhanced.item.ItemArmourClass;
import roadhog.venhanced.item.ItemAxeClass;
import roadhog.venhanced.item.ItemBlazicite;
import roadhog.venhanced.item.ItemBlaziciteAxe;
import roadhog.venhanced.item.ItemBlaziciteHoe;
import roadhog.venhanced.item.ItemBlazicitePickaxe;
import roadhog.venhanced.item.ItemBlaziciteSpade;
import roadhog.venhanced.item.ItemBlaziciteSword;
import roadhog.venhanced.item.ItemCreativeEnderPearl;
import roadhog.venhanced.item.ItemDiamondApple;
import roadhog.venhanced.item.ItemDust;
import roadhog.venhanced.item.ItemDustMetal;
import roadhog.venhanced.item.ItemHoeClass;
import roadhog.venhanced.item.ItemIngotMetal;
import roadhog.venhanced.item.ItemNewSign;
import roadhog.venhanced.item.ItemNuggetMetal;
import roadhog.venhanced.item.ItemPickaxeClass;
import roadhog.venhanced.item.ItemShard;
import roadhog.venhanced.item.ItemSpadeClass;
import roadhog.venhanced.item.ItemSwordClass;
import roadhog.venhanced.item.ItemWitheredBone;
import roadhog.venhanced.item.itemblock.BlockBarkItem;
import roadhog.venhanced.item.itemblock.BlockBarkNewItem;
import roadhog.venhanced.item.itemblock.BlockBrickDyedItem;
import roadhog.venhanced.item.itemblock.BlockConcreteItem;
import roadhog.venhanced.item.itemblock.BlockConcretePowderItem;
import roadhog.venhanced.item.itemblock.BlockMetalItem;
import roadhog.venhanced.item.itemblock.BlockNewNetherBrickItem;
import roadhog.venhanced.item.itemblock.BlockNewRockSlabItem;
import roadhog.venhanced.item.itemblock.BlockNewSandstoneItem;
import roadhog.venhanced.item.itemblock.BlockNewWorkbenchItem;
import roadhog.venhanced.item.itemblock.BlockOreBlaziciteItem;
import roadhog.venhanced.item.itemblock.BlockOreMetalItem;
import roadhog.venhanced.item.itemblock.BlockPaeoniaItem;
import roadhog.venhanced.item.itemblock.BlockRedSandstoneItem;
import roadhog.venhanced.item.itemblock.BlockRoseItem;
import roadhog.venhanced.item.itemblock.BlockStrippedLogItem;
import roadhog.venhanced.item.itemblock.BlockStrippedLogNewItem;
import roadhog.venhanced.proxy.ProxyCommon;
import roadhog.venhanced.tileentity.TileEntityNewSign;

@Mod(modid = VanillaEnhanced.modid, name = VanillaEnhanced.name, version = VanillaEnhanced.version)
public class VanillaEnhanced {
	
	public static final String modid = "venh";
	public static final String version = "1.0";
	public static final String name = "Vanilla Enhanced";
	
	@Instance(modid)
	public static VanillaEnhanced instance;
	
	//Misc. Items
	public static Item itemRuby;
	public static Item itemAnthracite;
	public static Item itemSapphire;
	public static Item itemIngotMetal;
	public static Item itemNuggetMetal;
	public static Item itemNuggetIron;
	public static Item itemIngotBlazicite;
	public static Item itemNuggetBlazicite;
	public static Item itemShard;
	public static Item itemDust;
	public static Item itemDustMetal;
	public static Item itemWitheredBone;
	public static Item itemWitheredBonemeal;
	public static Item itemPieApple;
	public static Item itemCakeCarrot;
	public static Item itemCakeChocolate;
	public static Item itemCakeVelvet;
	public static Item itemCakeIceCream;
	
	//Food
	public static Item itemDiamondApple;
	
	//Tools
	public static Item itemRubySword;
	public static Item itemRubySpade;
	public static Item itemRubyPickaxe;
	public static Item itemRubyAxe;
	public static Item itemRubyHoe;
	public static Item itemEmeraldSword;
	public static Item itemEmeraldSpade;
	public static Item itemEmeraldPickaxe;
	public static Item itemEmeraldAxe;
	public static Item itemEmeraldHoe;
	public static Item itemTinSword;
	public static Item itemTinSpade;
	public static Item itemTinPickaxe;
	public static Item itemTinAxe;
	public static Item itemTinHoe;
	public static Item itemCopperSword;
	public static Item itemCopperSpade;
	public static Item itemCopperPickaxe;
	public static Item itemCopperAxe;
	public static Item itemCopperHoe;
	public static Item itemOsmiumSword;
	public static Item itemOsmiumSpade;
	public static Item itemOsmiumPickaxe;
	public static Item itemOsmiumAxe;
	public static Item itemOsmiumHoe;
	public static Item itemIridiumSword;
	public static Item itemIridiumSpade;
	public static Item itemIridiumPickaxe;
	public static Item itemIridiumAxe;
	public static Item itemIridiumHoe;
	public static Item itemBlaziciteSword;
	public static Item itemBlaziciteSpade;
	public static Item itemBlazicitePickaxe;
	public static Item itemBlaziciteAxe;
	public static Item itemBlaziciteHoe;
	public static Item itemBronzeSword;
	public static Item itemBronzeSpade;
	public static Item itemBronzePickaxe;
	public static Item itemBronzeAxe;
	public static Item itemBronzeHoe;
	public static Item itemSteelSword;
	public static Item itemSteelSpade;
	public static Item itemSteelPickaxe;
	public static Item itemSteelAxe;
	public static Item itemSteelHoe;
	public static Item itemBoneSword;
	public static Item itemBoneSpade;
	public static Item itemBonePickaxe;
	public static Item itemBoneAxe;
	public static Item itemBoneHoe;
	
	//Armour
	public static Item itemEmeraldHelmet;
	public static Item itemEmeraldChestplate;
	public static Item itemEmeraldLeggings;
	public static Item itemEmeraldBoots;
	public static Item itemSapphireHelmet;
	public static Item itemSapphireChestplate;
	public static Item itemSapphireLeggings;
	public static Item itemSapphireBoots;
	public static Item itemTinHelmet;
	public static Item itemTinChestplate;
	public static Item itemTinLeggings;
	public static Item itemTinBoots;
	public static Item itemCopperHelmet;
	public static Item itemCopperChestplate;
	public static Item itemCopperLeggings;
	public static Item itemCopperBoots;
	public static Item itemOsmiumHelmet;
	public static Item itemOsmiumChestplate;
	public static Item itemOsmiumLeggings;
	public static Item itemOsmiumBoots;
	public static Item itemIridiumHelmet;
	public static Item itemIridiumChestplate;
	public static Item itemIridiumLeggings;
	public static Item itemIridiumBoots;
	public static Item itemBlaziciteHelmet;
	public static Item itemBlaziciteChestplate;
	public static Item itemBlaziciteLeggings;
	public static Item itemBlaziciteBoots;
	public static Item itemBronzeHelmet;
	public static Item itemBronzeChestplate;
	public static Item itemBronzeLeggings;
	public static Item itemBronzeBoots;
	public static Item itemSteelHelmet;
	public static Item itemSteelChestplate;
	public static Item itemSteelLeggings;
	public static Item itemSteelBoots;
	
	//Signs
	public static Item itemSignSpruce;
	public static Item itemSignBirch;
	public static Item itemSignJungle;
	public static Item itemSignAcacia;
	public static Item itemSignBigOak;
	
	public static Item itemChocolateCookie;
	public static Item itemCreativeEnderPearl;
	public static Item blockCauldronWater;
	
	@SidedProxy(clientSide = "roadhog.venhanced.proxy.ProxyClient", serverSide = "roadhog.venhanced.proxy.ProxyCommon")
	public static ProxyCommon venhProxy;
	
	//Sound Types
	
	//Tool Materials(name, harvestLevel, durability, mining speed, damage, enchantability)
	public static final Item.ToolMaterial boneToolMaterial = EnumHelper.addToolMaterial("boneToolMaterial", 1, 192, 3.0F, .5F, 26);
	public static final Item.ToolMaterial tinToolMaterial = EnumHelper.addToolMaterial("tinToolMaterial", 1, 142, 4.0F, 2.0F, 7);
	public static final Item.ToolMaterial copperToolMaterial = EnumHelper.addToolMaterial("copperToolMaterial", 2, 185, 5.0F, 2.5F, 12);
	public static final Item.ToolMaterial osmiumToolMaterial = EnumHelper.addToolMaterial("osmiumToolMaterial", 3, 2264, 5.0F, 2.75F, 8);
	public static final Item.ToolMaterial iridiumToolMaterial = EnumHelper.addToolMaterial("iridiumToolMaterial", 3, 1072, 10.0F, 3.25F, 14);
	public static final Item.ToolMaterial rubyToolMaterial = EnumHelper.addToolMaterial("rubyToolMaterial", 3, 846, 7.0F, 2.5F, 15);
	public static final Item.ToolMaterial emeraldToolMaterial = EnumHelper.addToolMaterial("emeraldToolMaterial", 2, 472, 6.0F, 2.25F, 22);
	public static final Item.ToolMaterial blaziciteToolMaterial = EnumHelper.addToolMaterial("blaziciteToolMaterial", 3, 906, 6.0F, 2.25F, 7);
	public static final Item.ToolMaterial bronzeToolMaterial = EnumHelper.addToolMaterial("bronzeToolMaterial", 2, 412, 6.0F, 2.0F, 14);
	public static final Item.ToolMaterial steelToolMaterial = EnumHelper.addToolMaterial("steelToolMaterial", 2, 525, 6.75F, 2.0F, 14);
	
	//Armour Materials(name, durabilityx16, protection, enchantability)
	public static final ItemArmor.ArmorMaterial emeraldArmourMaterial = EnumHelper.addArmorMaterial("emeraldArmourMaterial", 17, new int[]{3,6,5,2}, 25);
	public static final ItemArmor.ArmorMaterial sapphireArmourMaterial = EnumHelper.addArmorMaterial("sapphireArmourMaterial", 15, new int[]{2,6,5,2}, 5);
	public static final ItemArmor.ArmorMaterial tinArmourMaterial = EnumHelper.addArmorMaterial("tinArmourMaterial", 10, new int[]{2,4,3,1}, 4);
	public static final ItemArmor.ArmorMaterial copperArmourMaterial = EnumHelper.addArmorMaterial("copperArmourMaterial", 12, new int[]{2,5,4,1}, 7);
	public static final ItemArmor.ArmorMaterial iridiumArmourMaterial = EnumHelper.addArmorMaterial("iridiumArmourMaterial", 26, new int[]{3,8,6,3}, 12);
	public static final ItemArmor.ArmorMaterial osmiumArmourMaterial = EnumHelper.addArmorMaterial("osmiumArmourMaterial", 36, new int[]{3,6,5,2}, 5);
	public static final ItemArmor.ArmorMaterial blaziciteArmourMaterial = EnumHelper.addArmorMaterial("blaziciteArmourMaterial", 21, new int[]{3,7,5,3}, 4);
	public static final ItemArmor.ArmorMaterial bronzeArmourMaterial = EnumHelper.addArmorMaterial("bronzeArmourMaterial", 16, new int[]{2,6,5,2}, 7);
	public static final ItemArmor.ArmorMaterial steelArmourMaterial = EnumHelper.addArmorMaterial("steelArmourMaterial", 18, new int[]{3,6,6,3}, 7);
	
	//Ores
	public static Block blockOreRuby;
	public static Block blockOreAnthracite;
	public static Block blockOreMetal;
	public static Block blockOreSapphire;
	
	//Nether Ores
	public static Block blockOreBlazicite;
	
	public static Block blockOreNetherCoal;
	public static Block blockOreNetherIron;
	public static Block blockOreNetherRedstone;
	public static Block blockOreNetherLapis;
	public static Block blockOreNetherGold;
	public static Block blockOreNetherEmerald;
	public static Block blockOreNetherDiamond;
	
	public static Block blockOreNetherAnthracite;
	public static Block blockOreNetherMetal;
	
	//Blocks
	public static Block blockRuby;
	public static Block blockSapphire;
	public static Block blockCharcoal;
	public static Block blockBlaze;
	public static Block blockNewNetherBrick;
	public static Block blockBark;
	public static Block blockBark2;
	public static Block blockStrippedLog;
	public static Block blockStrippedLog2;
	public static Block blockStrippedWood;
	public static Block blockStrippedWood2;
	public static Block blockPolishedStone;
	public static Block blockCobblePaver;
	public static Block blockNewSandstone;
	public static Block blockRedSandstone;
	public static Block blockAnthracite;
	public static Block blockGlowingObsidian;
	public static Block blockMissing;
	public static Block blockRose;
	public static Block blockPaeonia;
	public static Block blockConcretePowder;
	public static Block blockConcrete;
	public static Block blockBone;
	public static Block blockMagma;
	public static Block blockMetal;
	public static Block blockNewWorkbench;
	public static Block blockGoldWorkbench;
	public static Block blockMacerator;
	public static Block blockCrate;
	public static Block blockStickyCrate;
	public static Block blockNetherWart;
	public static Block blockOakScaffolding;
	public static Block blockSpruceScaffolding;
	public static Block blockBirchScaffolding;
	public static Block blockJungleScaffolding;
	public static Block blockAcaciaScaffolding;
	public static Block blockBigOakScaffolding;
	public static Block blockSteelScaffolding;
	public static Block blockBrickDyed;
	public static Block blockCauldronLava;
	public static Block blockMyceliumSupport;
	public static Block blockLantern;
	public static Block blockCakeCarrot;
	public static Block blockCakeChocolate;
	public static Block blockCakeVelvet;
	public static Block blockCakeIceCream;
	
	//Stairs, Slabs, Fences, Walls, Pressure Plates, Buttons etc
	public static Block blockRedNetherBrickFence;
	public static Block blockBlackNetherBrickFence;
	public static Block blockRedNetherBrickStairs;
	public static Block blockBlackNetherBrickStairs;
	public static Block blockRedSandstoneStairs;
	public static Block blockNewRockSlab;
	public static Block blockBlackNetherBrickSlab;
	public static Block blockNewRockDoubleSlab;
	public static Block blockBlackNetherBrickDoubleSlab;
	public static Block blockFenceSpruce;
	public static Block blockFenceBirch;
	public static Block blockFenceJungle;
	public static Block blockFenceAcacia;
	public static Block blockFenceBigOak;
	public static Block blockPressurePlateSpruce;
	public static Block blockPressurePlateBirch;
	public static Block blockPressurePlateJungle;
	public static Block blockPressurePlateAcacia;
	public static Block blockPressurePlateBigOak;
	public static Block blockButtonSpruce;
	public static Block blockButtonBirch;
	public static Block blockButtonJungle;
	public static Block blockButtonAcacia;
	public static Block blockButtonBigOak;
	public static Block blockFenceGateSpruce;
	public static Block blockFenceGateBirch;
	public static Block blockFenceGateJungle;
	public static Block blockFenceGateAcacia;
	public static Block blockFenceGateBigOak;
	public static Block blockFenceGateNetherBrick;
	public static Block blockFenceGateRedNetherBrick;
	public static Block blockFenceGateBlackNetherBrick;
	public static Block blockStandingSignSpruce;
	public static Block blockStandingSignBirch;
	public static Block blockStandingSignJungle;
	public static Block blockStandingSignAcacia;
	public static Block blockStandingSignBigOak;
	public static Block blockWallSignSpruce;
	public static Block blockWallSignBirch;
	public static Block blockWallSignJungle;
	public static Block blockWallSignAcacia;
	public static Block blockWallSignBigOak;
	public static Block blockTrapDoorSpruce;
	public static Block blockTrapDoorBirch;
	public static Block blockTrapDoorJungle;
	public static Block blockTrapDoorAcacia;
	public static Block blockTrapDoorBigOak;
	public static Block blockTrapDoorLadder;
	
	public static Block blockLavaStationary;
	public static Block blockWaterStationary;
	public static Block blockAlwaysOnLamp;
	public static Block blockVenhPot;
	
	public static Block blockTest;
	public static Block blockForcefield;
	public static Block blockBarrier;

	//Render IDs
	public static final int renderID_CauldronLava = RenderingRegistry.getNextAvailableRenderId();
	public static final int renderID_Lantern = RenderingRegistry.getNextAvailableRenderId();
	public static final int renderID_VenhTrapdoor = RenderingRegistry.getNextAvailableRenderId();
	public static final int renderID_VenhFence = RenderingRegistry.getNextAvailableRenderId();
	
	//GUI IDs
	public static final int guiID_BlockNewWorkbench = 0;
	public static final int guiID_BlockMacerator = 1;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		if (event.getSide() == Side.CLIENT) {
			Display.setTitle("Minecraft 1.7.10 (Vanilla Enhanced 1.0)");
		}
		
		VanillaEventHandler.overrideDefaultSettings();
				
		//Ores
		blockOreRuby = new BlockOreRuby(Material.rock).setBlockName("BlockOreRuby").setBlockTextureName("venh:blockOreRuby").setCreativeTab(tabVenhBuilding);
		blockOreAnthracite = new BlockOreAnthracite(Material.rock).setBlockName("BlockOreAnthracite").setBlockTextureName("venh:blockOreAnthracite").setCreativeTab(tabVenhBuilding);
		blockOreMetal = new BlockOreMetal(Material.rock).setBlockName("BlockOreMetal").setCreativeTab(tabVenhBuilding);
		blockOreSapphire = new BlockOreSapphire(Material.rock).setBlockName("BlockOreSapphire").setBlockTextureName("venh:blockOreSapphire").setCreativeTab(tabVenhBuilding);
		
		//Nether Ores
		blockOreBlazicite = new BlockOreBlazicite(Material.rock).setBlockName("BlockOreBlazicite").setBlockTextureName("venh:blockOreBlazicite").setCreativeTab(tabVenhBuilding);
		
//		blockOreNetherCoal = new BlockOreNetherCoal(Material.rock).setBlockName("BlockOreNetherCoal").setBlockTextureName("venh:blockOreNetherCoal").setCreativeTab(tabVenhDecoration);
//	 	blockOreNetherIron = new BlockOreNetherIron(Material.rock).setBlockName("BlockOreNetherIron").setBlockTextureName("venh:blockOreNetherIron").setCreativeTab(tabVenhDecoration);
//	 	blockOreNetherRedstone = new BlockOreNetherRedstone(Material.rock).setBlockName("BlockOreNetherRedstone").setBlockTextureName("venh:blockOreNetherRedstone").setCreativeTab(tabVenhDecoration);
//	 	blockOreNetherLapis = new BlockOreNetherLapis(Material.rock).setBlockName("BlockOreNetherLapis").setBlockTextureName("venh:blockOreNetherLapis").setCreativeTab(tabVenhDecoration);
//	 	blockOreNetherEmerald = new BlockOreNetherEmerald(Material.rock).setBlockName("BlockOreNetherEmerald").setBlockTextureName("venh:blockOreNetherEmerald").setCreativeTab(tabVenhDecoration);
//	 	blockOreNetherDiamond = new BlockOreNetherDiamond(Material.rock).setBlockName("BlockOreNetherDiamond").setBlockTextureName("venh:blockOreNetherDiamond").setCreativeTab(tabVenhDecoration);
//	 	blockOreNetherAnthracite = new BlockOreNetherAnthracite(Material.rock).setBlockName("BlockOreNetherAnthracite").setBlockTextureName("venh:blockOreNetherAnthracite").setCreativeTab(tabVenhDecoration);
		
	 	blockOreNetherGold = new BlockOreNetherGold(Material.rock).setBlockName("BlockOreNetherGold").setBlockTextureName("venh:blockOreNetherGold").setCreativeTab(tabVenhBuilding);
	 	blockOreNetherMetal = new BlockOreNetherMetal(Material.rock).setBlockName("BlockOreNetherMetal").setCreativeTab(tabVenhBuilding);
		
		//Blocks
		blockRuby = new BlockGem(Material.iron).setBlockName("BlockRuby").setBlockTextureName("venh:blockRuby").setCreativeTab(tabVenhBuilding);
		blockSapphire = new BlockGem(Material.iron).setBlockName("BlockSapphire").setBlockTextureName("venh:blockSapphire").setCreativeTab(tabVenhBuilding);
		blockCharcoal = new BlockCharcoal(Material.packedIce).setBlockName("BlockCharcoal").setBlockTextureName("venh:blockCharcoal").setCreativeTab(tabVenhBuilding);
		blockAnthracite = new BlockAnthracite(Material.rock).setBlockName("BlockAnthracite").setBlockTextureName("venh:blockAnthracite").setCreativeTab(tabVenhBuilding);
		blockMetal = new BlockMetal(Material.iron).setBlockName("BlockMetal").setCreativeTab(tabVenhBuilding);
		blockBlaze = new BlockBlaze(Material.iron).setBlockName("BlockBlaze").setBlockTextureName("venh:blockBlaze").setCreativeTab(tabVenhBuilding);
		blockPolishedStone = new BlockPolishedStone(Material.rock).setBlockName("BlockPolishedStone").setBlockTextureName("minecraft:stone_slab_top").setCreativeTab(tabVenhBuilding);
		blockCobblePaver = new BlockCobblePaver(Material.rock).setBlockName("BlockCobblePaver").setBlockTextureName("minecraft:furnace_top").setCreativeTab(tabVenhBuilding);
		blockNewNetherBrick = new BlockNewNetherBrick(Material.rock).setBlockName("BlockNewNetherBrick").setCreativeTab(tabVenhBuilding);
		blockNewSandstone = new BlockNewSandstone(Material.rock).setBlockName("BlockNewSandstone").setBlockTextureName("minecraft:sandstone").setCreativeTab(tabVenhBuilding);
		blockRedSandstone = new BlockRedSandstone(Material.rock).setBlockName("BlockRedSandstone").setBlockTextureName("venh:blockRedSandstone").setCreativeTab(tabVenhBuilding);
		blockBark = new BlockBark().setBlockName("BlockBark").setCreativeTab(tabVenhBuilding);
		blockBark2 = new BlockBarkNew().setBlockName("BlockBark").setCreativeTab(tabVenhBuilding);
		blockStrippedLog = new BlockStrippedLog().setBlockName("BlockStrippedLog").setCreativeTab(tabVenhBuilding);
		blockStrippedLog2 = new BlockStrippedLogNew().setBlockName("BlockStrippedLog").setCreativeTab(tabVenhBuilding);
		blockStrippedWood = new BlockStrippedWood().setBlockName("BlockStrippedWood").setCreativeTab(tabVenhBuilding);
		blockStrippedWood2 = new BlockStrippedWoodNew().setBlockName("BlockStrippedWood").setCreativeTab(tabVenhBuilding);
		blockCrate = new BlockCrate(Material.wood).setBlockName("BlockCrate").setBlockTextureName("minecraft:piston_top_normal").setCreativeTab(tabVenhDecoration);
		blockStickyCrate = new BlockCrate(Material.wood).setBlockName("BlockCrateSticky").setBlockTextureName("minecraft:piston_top_sticky").setCreativeTab(tabVenhDecoration);
		blockGlowingObsidian = new BlockGlowingObsidian(Material.rock).setBlockName("BlockGlowingObsidian").setBlockTextureName("venh:blockGlowingObsidian").setCreativeTab(tabVenhBuilding);
		blockMissing = new BlockMissing(Material.rock).setBlockName("BlockMissing").setBlockTextureName("venh:blockMissing").setCreativeTab(tabVenhBuilding);
		blockRose = new BlockNewFlower(Material.plants).setBlockName("BlockRose").setBlockTextureName("venh:blockRose").setCreativeTab(tabVenhDecoration);
		blockPaeonia = new BlockNewFlower(Material.plants).setBlockName("BlockPaeonia").setBlockTextureName("minecraft:flower_paeonia").setCreativeTab(tabVenhDecoration);
		blockConcretePowder = new BlockConcretePowder(Material.sand).setBlockName("BlockConcretePowder").setCreativeTab(tabVenhBuilding);
		blockConcrete = new BlockConcrete(Material.rock).setBlockName("BlockConcrete").setCreativeTab(tabVenhBuilding);
		blockBone = new BlockBone(Material.rock).setBlockName("BlockBone").setBlockTextureName("venh:blockBone").setCreativeTab(tabVenhBuilding);
		blockMagma = new BlockMagma(Material.rock).setBlockName("BlockMagma").setBlockTextureName("venh:blockMagma").setCreativeTab(tabVenhDecoration);
		blockNewWorkbench = new BlockNewWorkbench(Material.wood).setBlockName("BlockNewWorkbench").setCreativeTab(tabVenhDecoration);
		blockGoldWorkbench = new BlockGoldWorkbench(Material.iron).setBlockName("BlockGoldWorkbench").setCreativeTab(null);
		blockMacerator = new BlockMacerator(Material.rock).setBlockName("BlockMacerator").setCreativeTab(tabVenhDecoration);
		blockNetherWart = new BlockNetherWart(Material.wood).setBlockName("BlockNetherWart").setBlockTextureName("venh:blockNetherWart").setCreativeTab(tabVenhBuilding);
		blockOakScaffolding = new BlockScaffolding(Material.wood).setBlockName("BlockOakScaffolding").setCreativeTab(tabVenhDecoration);
		blockSpruceScaffolding = new BlockScaffolding(Material.wood).setBlockName("BlockSpruceScaffolding").setCreativeTab(tabVenhDecoration);
		blockBirchScaffolding = new BlockScaffolding(Material.wood).setBlockName("BlockBirchScaffolding").setCreativeTab(tabVenhDecoration);
		blockJungleScaffolding = new BlockScaffolding(Material.wood).setBlockName("BlockJungleScaffolding").setCreativeTab(tabVenhDecoration);
		blockAcaciaScaffolding = new BlockScaffolding(Material.wood).setBlockName("BlockAcaciaScaffolding").setCreativeTab(tabVenhDecoration);
		blockBigOakScaffolding = new BlockScaffolding(Material.wood).setBlockName("BlockBigOakScaffolding").setCreativeTab(tabVenhDecoration);
		blockSteelScaffolding = new BlockSteelScaffolding(Material.piston).setBlockName("BlockSteelScaffolding").setCreativeTab(tabVenhDecoration);
		blockBrickDyed = new BlockBrickDyed(Material.rock).setBlockName("BlockBrickDyed").setCreativeTab(tabVenhBuilding);
		blockCauldronLava = new BlockCauldronLava().setBlockName("BlockCauldronLava").setBlockTextureName("minecraft:cauldron").setCreativeTab(tabHidden);
		blockCauldronWater = new BlockCauldronWater().setUnlocalizedName("BlockCauldronWater").setTextureName("venh:itemCauldronWater").setCreativeTab(tabHidden);
		blockMyceliumSupport = new BlockMyceliumPath().setBlockName("BlockMyceliumPath").setBlockTextureName("venh:blockMyceliumPath").setCreativeTab(tabVenhDecoration);
		blockLantern = new BlockLantern(Material.piston).setBlockName("BlockLantern").setBlockTextureName("venh:blockLantern").setCreativeTab(tabVenhDecoration);
		blockCakeCarrot = new BlockNewCake().setBlockName("BlockCakeCarrot").setBlockTextureName("venh:blockCakeCarrot").setCreativeTab(null);
		blockCakeChocolate = new BlockNewCake().setBlockName("BlockCakeChocolate").setBlockTextureName("venh:blockCakeChocolate").setCreativeTab(null);
		blockCakeVelvet = new BlockNewCake().setBlockName("BlockCakeVelvet").setBlockTextureName("venh:blockCakeVelvet").setCreativeTab(null);
		blockCakeIceCream = new BlockNewCake().setBlockName("BlockCakeIceCream").setBlockTextureName("venh:blockCakeIceCream").setStepSound(Block.soundTypeSnow).setCreativeTab(null);
		
		//Stairs, Slabs, Fences, Walls
		blockRedNetherBrickFence = new BlockNewNetherBrickFence("venh:blockNetherBrickRed", Material.rock).setBlockName("BlockRedNetherBrickFence").setCreativeTab(tabVenhDecoration);
		blockBlackNetherBrickFence = new BlockNewNetherBrickFence("venh:blockNetherBrickBlack", Material.rock).setBlockName("BlockBlackNetherBrickFence").setCreativeTab(tabVenhDecoration);
		blockRedNetherBrickStairs = new BlockNewStairs(blockNewNetherBrick, 5).setBlockName("BlockRedNetherBrickStairs").setCreativeTab(tabVenhDecoration);
		blockBlackNetherBrickStairs = new BlockNewStairs(blockNewNetherBrick, 2).setBlockName("BlockBlackNetherBrickStairs").setCreativeTab(tabVenhDecoration);
		blockRedSandstoneStairs = new BlockNewStairs(blockRedSandstone, 0).setBlockName("BlockRedSandstoneStairs").setCreativeTab(tabVenhDecoration);
		blockNewRockSlab = new BlockNewRockSlab(false, Material.rock).setBlockName("BlockNewRockSlab").setCreativeTab(tabVenhDecoration);
		blockNewRockDoubleSlab = new BlockNewRockSlab(true, Material.rock).setBlockName("BlockNewRockDoubleSlab").setCreativeTab(null);
		blockFenceSpruce = new BlockNewFenceWood("planks_spruce", Blocks.fence.getMaterial()).setBlockName("BlockFenceSpruce").setCreativeTab(tabVenhDecoration);
		blockFenceBirch = new BlockNewFenceWood("planks_birch", Blocks.fence.getMaterial()).setBlockName("BlockFenceBirch").setCreativeTab(tabVenhDecoration);
		blockFenceJungle = new BlockNewFenceWood("planks_jungle", Blocks.fence.getMaterial()).setBlockName("BlockFenceJungle").setCreativeTab(tabVenhDecoration);
		blockFenceAcacia = new BlockNewFenceWood("planks_acacia", Blocks.fence.getMaterial()).setBlockName("BlockFenceAcacia").setCreativeTab(tabVenhDecoration);
		blockFenceBigOak = new BlockNewFenceWood("planks_big_oak", Blocks.fence.getMaterial()).setBlockName("BlockFenceBigOak").setCreativeTab(tabVenhDecoration);
		blockPressurePlateSpruce = new BlockNewPressurePlateWood("planks_spruce", Blocks.wooden_pressure_plate.getMaterial(), BlockPressurePlate.Sensitivity.everything).setBlockName("BlockPressurePlateSpruce");
		blockPressurePlateBirch = new BlockNewPressurePlateWood("planks_birch", Blocks.wooden_pressure_plate.getMaterial(), BlockPressurePlate.Sensitivity.everything).setBlockName("BlockPressurePlateBirch");
		blockPressurePlateJungle = new BlockNewPressurePlateWood("planks_jungle", Blocks.wooden_pressure_plate.getMaterial(), BlockPressurePlate.Sensitivity.everything).setBlockName("BlockPressurePlateJungle");
		blockPressurePlateAcacia = new BlockNewPressurePlateWood("planks_acacia", Blocks.wooden_pressure_plate.getMaterial(), BlockPressurePlate.Sensitivity.everything).setBlockName("BlockPressurePlateAcacia");
		blockPressurePlateBigOak = new BlockNewPressurePlateWood("planks_big_oak", Blocks.wooden_pressure_plate.getMaterial(), BlockPressurePlate.Sensitivity.everything).setBlockName("BlockPressurePlateBigOak");
		blockButtonSpruce = new BlockNewButtonWood().setBlockName("BlockButtonSpruce").setBlockTextureName("planks_spruce").setCreativeTab(tabVenhDecoration);
		blockButtonBirch = new BlockNewButtonWood().setBlockName("BlockButtonBirch").setBlockTextureName("planks_birch").setCreativeTab(tabVenhDecoration);
		blockButtonJungle = new BlockNewButtonWood().setBlockName("BlockButtonJungle").setBlockTextureName("planks_jungle").setCreativeTab(tabVenhDecoration);
		blockButtonAcacia = new BlockNewButtonWood().setBlockName("BlockButtonAcacia").setBlockTextureName("planks_acacia").setCreativeTab(tabVenhDecoration);
		blockButtonBigOak = new BlockNewButtonWood().setBlockName("BlockButtonBigOak").setBlockTextureName("planks_big_oak").setCreativeTab(tabVenhDecoration);
		blockFenceGateSpruce = new BlockNewFenceGateWood().setBlockName("BlockFenceGateSpruce").setCreativeTab(tabVenhDecoration);
		blockFenceGateBirch = new BlockNewFenceGateWood().setBlockName("BlockFenceGateBirch").setCreativeTab(tabVenhDecoration);
		blockFenceGateJungle = new BlockNewFenceGateWood().setBlockName("BlockFenceGateJungle").setCreativeTab(tabVenhDecoration);
		blockFenceGateAcacia = new BlockNewFenceGateWood().setBlockName("BlockFenceGateAcacia").setCreativeTab(tabVenhDecoration);
		blockFenceGateBigOak = new BlockNewFenceGateWood().setBlockName("BlockFenceGateBigOak").setCreativeTab(tabVenhDecoration);
		blockFenceGateNetherBrick = new BlockNewFenceGateRock(Material.rock).setBlockName("BlockFenceGateNetherBrick").setCreativeTab(tabVenhDecoration);
		blockFenceGateRedNetherBrick = new BlockNewFenceGateRock(Material.rock).setBlockName("BlockFenceGateRedNetherBrick").setCreativeTab(tabVenhDecoration);
		blockFenceGateBlackNetherBrick = new BlockNewFenceGateRock(Material.rock).setBlockName("BlockFenceGateBlackNetherBrick").setCreativeTab(tabVenhDecoration);
		blockTrapDoorSpruce = new BlockNewTrapDoorWood(Material.wood).setBlockName("BlockTrapDoorSpruce").setBlockTextureName("venh:blockTrapdoorSpruce").setCreativeTab(tabVenhDecoration);
		blockTrapDoorBirch = new BlockNewTrapDoorWood(Material.wood).setBlockName("BlockTrapDoorBirch").setBlockTextureName("venh:blockTrapdoorBirch").setCreativeTab(tabVenhDecoration);
		blockTrapDoorJungle = new BlockNewTrapDoorWood(Material.wood).setBlockName("BlockTrapDoorJungle").setBlockTextureName("venh:blockTrapdoorJungle").setCreativeTab(tabVenhDecoration);
		blockTrapDoorAcacia = new BlockNewTrapDoorWood(Material.wood).setBlockName("BlockTrapDoorAcacia").setBlockTextureName("venh:blockTrapdoorAcacia").setCreativeTab(tabVenhDecoration);
		blockTrapDoorBigOak = new BlockNewTrapDoorWood(Material.wood).setBlockName("BlockTrapDoorBigOak").setBlockTextureName("venh:blockTrapdoorBigOak").setCreativeTab(tabVenhDecoration);
		blockTrapDoorLadder = new BlockNewTrapDoorWood(Material.wood).setBlockName("BlockTrapDoorLadder").setBlockTextureName("venh:blockTrapdoorLadder").setCreativeTab(tabVenhDecoration);
		
		//Creative
		blockLavaStationary = new BlockLavaStationary(Material.lava).setBlockName("BlockLavaStationary").setCreativeTab(VanillaEnhanced.tabHidden);
		blockWaterStationary = new BlockWaterStationary(Material.water).setBlockName("BlockWaterStationary").setCreativeTab(VanillaEnhanced.tabHidden);
		blockAlwaysOnLamp = new BlockAlwaysOnLamp(Material.glass).setBlockName("BlockAlwaysOnLamp").setBlockTextureName("minecraft:redstone_lamp_on").setCreativeTab(VanillaEnhanced.tabHidden);
		blockBarrier = new BlockBarrier(Material.rock).setBlockName("BlockBarrier").setBlockTextureName("minecraft:glass_red").setCreativeTab(tabHidden);
		
		//Technical
		blockTest = new BlockTest().setBlockName(null).setCreativeTab(null);
		blockForcefield = new BlockForcefield(Material.air).setBlockName("BlockForcefield").setCreativeTab(null);
		blockVenhPot = new BlockVenhPot().setBlockName("BlockVenhPot").setBlockTextureName("minecraft:flower_pot").setCreativeTab(null);
		blockStandingSignSpruce = new BlockNewSign(TileEntityNewSign.class, true).setBlockName("BlockStandingSignSpruce");
		blockWallSignSpruce = new BlockNewSign(TileEntityNewSign.class, false).setBlockName("BlockWallSignSpruce");
		blockStandingSignBirch = new BlockNewSign(TileEntityNewSign.class, true).setBlockName("BlockStandingSignBirch");
		blockWallSignBirch = new BlockNewSign(TileEntityNewSign.class, false).setBlockName("BlockWallSignBirch");
		blockStandingSignJungle = new BlockNewSign(TileEntityNewSign.class, true).setBlockName("BlockStandingSignJungle");
		blockWallSignJungle = new BlockNewSign(TileEntityNewSign.class, false).setBlockName("BlockWallSignJungle");
		blockStandingSignAcacia = new BlockNewSign(TileEntityNewSign.class, true).setBlockName("BlockStandingSignAcacia");
		blockWallSignAcacia = new BlockNewSign(TileEntityNewSign.class, false).setBlockName("BlockWallSignAcacia");
		blockStandingSignBigOak = new BlockNewSign(TileEntityNewSign.class, true).setBlockName("BlockStandingSignBigOak");
		blockWallSignBigOak = new BlockNewSign(TileEntityNewSign.class, false).setBlockName("BlockWallSignBigOak");
		
		//Misc. Items
		itemAnthracite = new ItemAnthracite().setUnlocalizedName("ItemAnthracite").setTextureName("venh:itemAnthracite").setCreativeTab(tabVenhMaterials);
		itemIngotMetal = new ItemIngotMetal().setUnlocalizedName("ItemIngotMetal").setCreativeTab(tabVenhMaterials);
		itemNuggetMetal = new ItemNuggetMetal().setUnlocalizedName("ItemNuggetMetal").setCreativeTab(tabVenhMaterials);
		itemNuggetIron = new Item().setUnlocalizedName("ItemNuggetIron").setTextureName("venh:itemNuggetIron").setCreativeTab(tabVenhMaterials);
		itemNuggetBlazicite = new ItemBlazicite().setUnlocalizedName("ItemNuggetBlazicite").setTextureName("venh:itemNuggetBlazicite").setCreativeTab(tabVenhMaterials);
		itemRuby = new Item().setUnlocalizedName("ItemRuby").setTextureName("minecraft:ruby").setCreativeTab(tabVenhMaterials);
		itemSapphire = new Item().setUnlocalizedName("ItemSapphire").setTextureName("venh:itemSapphire").setCreativeTab(tabVenhMaterials);
		itemIngotBlazicite = new ItemBlazicite().setUnlocalizedName("ItemIngotBlazicite").setTextureName("venh:itemIngotBlazicite").setCreativeTab(tabVenhMaterials);
		itemShard = new ItemShard().setUnlocalizedName("ItemShard").setTextureName("venh:ItemShard").setCreativeTab(tabVenhMaterials);
		itemDust = new ItemDust().setUnlocalizedName("ItemDust").setCreativeTab(tabVenhMaterials);
		itemDustMetal = new ItemDustMetal().setUnlocalizedName("ItemDustMetal").setCreativeTab(tabVenhMaterials);
		itemWitheredBone = new ItemWitheredBone().setFull3D().setUnlocalizedName("ItemWitheredBone").setTextureName("venh:itemWitheredBone").setCreativeTab(tabVenhMaterials);
		itemWitheredBonemeal = new ItemWitheredBone().setUnlocalizedName("ItemWitheredBonemeal").setTextureName("venh:itemWitheredBonemeal").setCreativeTab(tabVenhMaterials);
		itemPieApple = new ItemFood(11, 0.8F, false).setUnlocalizedName("ItemPieApple").setTextureName("venh:itemApplePie").setCreativeTab(CreativeTabs.tabFood);
		itemCakeCarrot = new ItemReed(VanillaEnhanced.blockCakeCarrot).setUnlocalizedName("ItemCakeCarrot").setMaxStackSize(1).setTextureName("venh:itemCakeCarrot").setCreativeTab(CreativeTabs.tabFood);
		itemCakeChocolate = new ItemReed(VanillaEnhanced.blockCakeChocolate).setUnlocalizedName("ItemCakeChocolate").setMaxStackSize(1).setTextureName("venh:itemCakeChocolate").setCreativeTab(CreativeTabs.tabFood);
		itemCakeVelvet = new ItemReed(VanillaEnhanced.blockCakeVelvet).setUnlocalizedName("ItemCakeVelvet").setMaxStackSize(1).setTextureName("venh:itemCakeVelvet").setCreativeTab(CreativeTabs.tabFood);
		itemCakeIceCream = new ItemReed(VanillaEnhanced.blockCakeIceCream).setUnlocalizedName("ItemCakeIceCream").setMaxStackSize(1).setTextureName("venh:itemCakeIceCream").setCreativeTab(CreativeTabs.tabFood);
		
		//Food
		itemDiamondApple = new ItemDiamondApple(6, 1.75F, false).setUnlocalizedName("ItemDiamondApple").setTextureName("venh:itemDiamondApple").setCreativeTab(CreativeTabs.tabFood);
		
		//Tools
		itemRubySword = new ItemSwordClass(rubyToolMaterial).setUnlocalizedName("ItemRubySword").setTextureName("venh:itemRubySword").setCreativeTab(tabVenhCombat);
		itemRubyPickaxe = new ItemPickaxeClass(rubyToolMaterial).setUnlocalizedName("ItemRubyPickaxe").setTextureName("venh:itemRubyPickaxe").setCreativeTab(tabVenhTools);        
		itemRubySpade = new ItemSpadeClass(rubyToolMaterial).setUnlocalizedName("ItemRubySpade").setTextureName("venh:itemRubySpade").setCreativeTab(tabVenhTools);                
		itemRubyAxe = new ItemAxeClass(rubyToolMaterial).setUnlocalizedName("ItemRubyAxe").setTextureName("venh:itemRubyAxe").setCreativeTab(tabVenhTools);
		itemRubyHoe = new ItemHoeClass(rubyToolMaterial).setUnlocalizedName("ItemRubyHoe").setTextureName("venh:itemRubyHoe").setCreativeTab(tabVenhTools);                        
		itemEmeraldSword = new ItemSwordClass(emeraldToolMaterial).setUnlocalizedName("ItemEmeraldSword").setTextureName("venh:itemEmeraldSword").setCreativeTab(tabVenhCombat);
		itemEmeraldPickaxe = new ItemPickaxeClass(emeraldToolMaterial).setUnlocalizedName("ItemEmeraldPickaxe").setTextureName("venh:itemEmeraldPickaxe").setCreativeTab(tabVenhTools);
		itemEmeraldSpade = new ItemSpadeClass(emeraldToolMaterial).setUnlocalizedName("ItemEmeraldSpade").setTextureName("venh:itemEmeraldSpade").setCreativeTab(tabVenhTools);
		itemEmeraldAxe = new ItemAxeClass(emeraldToolMaterial).setUnlocalizedName("ItemEmeraldAxe").setTextureName("venh:itemEmeraldAxe").setCreativeTab(tabVenhTools);
		itemEmeraldHoe = new ItemHoeClass(emeraldToolMaterial).setUnlocalizedName("ItemEmeraldHoe").setTextureName("venh:itemEmeraldHoe").setCreativeTab(tabVenhTools);
		itemTinSword = new ItemSwordClass(tinToolMaterial).setUnlocalizedName("ItemTinSword").setTextureName("venh:itemTinSword").setCreativeTab(tabVenhCombat);
		itemTinPickaxe = new ItemPickaxeClass(tinToolMaterial).setUnlocalizedName("ItemTinPickaxe").setTextureName("venh:itemTinPickaxe").setCreativeTab(tabVenhTools);
		itemTinSpade = new ItemSpadeClass(tinToolMaterial).setUnlocalizedName("ItemTinSpade").setTextureName("venh:itemTinSpade").setCreativeTab(tabVenhTools);
		itemTinAxe = new ItemAxeClass(tinToolMaterial).setUnlocalizedName("ItemTinAxe").setTextureName("venh:itemTinAxe").setCreativeTab(tabVenhTools);
		itemTinHoe = new ItemHoeClass(tinToolMaterial).setUnlocalizedName("ItemTinHoe").setTextureName("venh:itemTinHoe").setCreativeTab(tabVenhTools);
		itemCopperSword = new ItemSwordClass(copperToolMaterial).setUnlocalizedName("ItemCopperSword").setTextureName("venh:itemCopperSword").setCreativeTab(tabVenhCombat);
		itemCopperPickaxe = new ItemPickaxeClass(copperToolMaterial).setUnlocalizedName("ItemCopperPickaxe").setTextureName("venh:itemCopperPickaxe").setCreativeTab(tabVenhTools);
		itemCopperSpade = new ItemSpadeClass(copperToolMaterial).setUnlocalizedName("ItemCopperSpade").setTextureName("venh:itemCopperSpade").setCreativeTab(tabVenhTools);
		itemCopperAxe = new ItemAxeClass(copperToolMaterial).setUnlocalizedName("ItemCopperAxe").setTextureName("venh:itemCopperAxe").setCreativeTab(tabVenhTools);
		itemCopperHoe = new ItemHoeClass(copperToolMaterial).setUnlocalizedName("ItemCopperHoe").setTextureName("venh:itemCopperHoe").setCreativeTab(tabVenhTools);
		itemOsmiumSword = new ItemSwordClass(osmiumToolMaterial).setUnlocalizedName("ItemOsmiumSword").setTextureName("venh:itemOsmiumSword").setCreativeTab(tabVenhCombat);
		itemOsmiumPickaxe = new ItemPickaxeClass(osmiumToolMaterial).setUnlocalizedName("ItemOsmiumPickaxe").setTextureName("venh:itemOsmiumPickaxe").setCreativeTab(tabVenhTools);
		itemOsmiumSpade = new ItemSpadeClass(osmiumToolMaterial).setUnlocalizedName("ItemOsmiumSpade").setTextureName("venh:itemOsmiumSpade").setCreativeTab(tabVenhTools);
		itemOsmiumAxe = new ItemAxeClass(osmiumToolMaterial).setUnlocalizedName("ItemOsmiumAxe").setTextureName("venh:itemOsmiumAxe").setCreativeTab(tabVenhTools);
		itemOsmiumHoe = new ItemHoeClass(osmiumToolMaterial).setUnlocalizedName("ItemOsmiumHoe").setTextureName("venh:itemOsmiumHoe").setCreativeTab(tabVenhTools);
		itemIridiumSword = new ItemSwordClass(iridiumToolMaterial).setUnlocalizedName("ItemIridiumSword").setTextureName("venh:itemIridiumSword").setCreativeTab(tabVenhCombat);
		itemIridiumPickaxe = new ItemPickaxeClass(iridiumToolMaterial).setUnlocalizedName("ItemIridiumPickaxe").setTextureName("venh:itemIridiumPickaxe").setCreativeTab(tabVenhTools);
		itemIridiumSpade = new ItemSpadeClass(iridiumToolMaterial).setUnlocalizedName("ItemIridiumSpade").setTextureName("venh:itemIridiumSpade").setCreativeTab(tabVenhTools);
		itemIridiumAxe = new ItemAxeClass(iridiumToolMaterial).setUnlocalizedName("ItemIridiumAxe").setTextureName("venh:itemIridiumAxe").setCreativeTab(tabVenhTools);
		itemIridiumHoe = new ItemHoeClass(iridiumToolMaterial).setUnlocalizedName("ItemIridiumHoe").setTextureName("venh:itemIridiumHoe").setCreativeTab(tabVenhTools);
		itemBlaziciteSword = new ItemBlaziciteSword(blaziciteToolMaterial).setUnlocalizedName("ItemBlaziciteSword").setTextureName("venh:itemBlaziciteSword").setCreativeTab(tabVenhCombat);
		itemBlazicitePickaxe = new ItemBlazicitePickaxe(blaziciteToolMaterial).setUnlocalizedName("ItemBlazicitePickaxe").setTextureName("venh:itemBlazicitePickaxe").setCreativeTab(tabVenhTools);
		itemBlaziciteSpade = new ItemBlaziciteSpade(blaziciteToolMaterial).setUnlocalizedName("ItemBlaziciteSpade").setTextureName("venh:itemBlaziciteSpade").setCreativeTab(tabVenhTools);
		itemBlaziciteAxe = new ItemBlaziciteAxe(blaziciteToolMaterial).setUnlocalizedName("ItemBlaziciteAxe").setTextureName("venh:itemBlaziciteAxe").setCreativeTab(tabVenhTools);
		itemBlaziciteHoe = new ItemBlaziciteHoe(blaziciteToolMaterial).setUnlocalizedName("ItemBlaziciteHoe").setTextureName("venh:itemBlaziciteHoe").setCreativeTab(tabVenhTools);
		itemBronzeSword = new ItemSwordClass(bronzeToolMaterial).setUnlocalizedName("ItemBronzeSword").setTextureName("venh:itemBronzeSword").setCreativeTab(tabVenhCombat);
		itemBronzePickaxe = new ItemPickaxeClass(bronzeToolMaterial).setUnlocalizedName("ItemBronzePickaxe").setTextureName("venh:itemBronzePickaxe").setCreativeTab(tabVenhTools);
		itemBronzeSpade = new ItemSpadeClass(bronzeToolMaterial).setUnlocalizedName("ItemBronzeSpade").setTextureName("venh:itemBronzeSpade").setCreativeTab(tabVenhTools);
		itemBronzeAxe = new ItemAxeClass(bronzeToolMaterial).setUnlocalizedName("ItemBronzeAxe").setTextureName("venh:itemBronzeAxe").setCreativeTab(tabVenhTools);
		itemBronzeHoe = new ItemHoeClass(bronzeToolMaterial).setUnlocalizedName("ItemBronzeHoe").setTextureName("venh:itemBronzeHoe").setCreativeTab(tabVenhTools);
		itemSteelSword = new ItemSwordClass(steelToolMaterial).setUnlocalizedName("ItemSteelSword").setTextureName("venh:itemSteelSword").setCreativeTab(tabVenhCombat);
		itemSteelPickaxe = new ItemPickaxeClass(steelToolMaterial).setUnlocalizedName("ItemSteelPickaxe").setTextureName("venh:itemSteelPickaxe").setCreativeTab(tabVenhTools);
		itemSteelSpade = new ItemSpadeClass(steelToolMaterial).setUnlocalizedName("ItemSteelSpade").setTextureName("venh:itemSteelSpade").setCreativeTab(tabVenhTools);
		itemSteelAxe = new ItemAxeClass(steelToolMaterial).setUnlocalizedName("ItemSteelAxe").setTextureName("venh:itemSteelAxe").setCreativeTab(tabVenhTools);
		itemSteelHoe = new ItemHoeClass(steelToolMaterial).setUnlocalizedName("ItemSteelHoe").setTextureName("venh:itemSteelHoe").setCreativeTab(tabVenhTools);
		itemBoneSword = new ItemSwordClass(boneToolMaterial).setUnlocalizedName("ItemBoneSword").setTextureName("venh:itemBoneSword").setCreativeTab(tabVenhCombat);
		itemBonePickaxe = new ItemPickaxeClass(boneToolMaterial).setUnlocalizedName("ItemBonePickaxe").setTextureName("venh:itemBonePickaxe").setCreativeTab(tabVenhTools);
		itemBoneSpade = new ItemSpadeClass(boneToolMaterial).setUnlocalizedName("ItemBoneSpade").setTextureName("venh:itemBoneSpade").setCreativeTab(tabVenhTools);
		itemBoneAxe = new ItemAxeClass(boneToolMaterial).setUnlocalizedName("ItemBoneAxe").setTextureName("venh:itemBoneAxe").setCreativeTab(tabVenhTools);
		itemBoneHoe = new ItemHoeClass(boneToolMaterial).setUnlocalizedName("ItemBoneHoe").setTextureName("venh:itemBoneHoe").setCreativeTab(tabVenhTools);
		
		//Armour
		itemEmeraldHelmet = new ItemArmourClass(emeraldArmourMaterial, 0).setUnlocalizedName("ItemEmeraldHelmet").setTextureName("venh:itemEmeraldHelmet").setCreativeTab(tabVenhCombat);
		itemEmeraldChestplate = new ItemArmourClass(emeraldArmourMaterial, 1).setUnlocalizedName("ItemEmeraldChestplate").setTextureName("venh:itemEmeraldChestplate").setCreativeTab(tabVenhCombat);
		itemEmeraldLeggings = new ItemArmourClass(emeraldArmourMaterial, 2).setUnlocalizedName("ItemEmeraldLeggings").setTextureName("venh:itemEmeraldLeggings").setCreativeTab(tabVenhCombat);
		itemEmeraldBoots = new ItemArmourClass(emeraldArmourMaterial, 3).setUnlocalizedName("ItemEmeraldBoots").setTextureName("venh:itemEmeraldBoots").setCreativeTab(tabVenhCombat);
		itemSapphireHelmet = new ItemArmourClass(sapphireArmourMaterial, 0).setUnlocalizedName("ItemSapphireHelmet").setTextureName("venh:itemSapphireHelmet").setCreativeTab(tabVenhCombat);
		itemSapphireChestplate = new ItemArmourClass(sapphireArmourMaterial, 1).setUnlocalizedName("ItemSapphireChestplate").setTextureName("venh:itemSapphireChestplate").setCreativeTab(tabVenhCombat);
		itemSapphireLeggings = new ItemArmourClass(sapphireArmourMaterial, 2).setUnlocalizedName("ItemSapphireLeggings").setTextureName("venh:itemSapphireLeggings").setCreativeTab(tabVenhCombat);
		itemSapphireBoots = new ItemArmourClass(sapphireArmourMaterial, 3).setUnlocalizedName("ItemSapphireBoots").setTextureName("venh:itemSapphireBoots").setCreativeTab(tabVenhCombat);
		itemTinHelmet = new ItemArmourClass(tinArmourMaterial, 0).setUnlocalizedName("ItemTinHelmet").setTextureName("venh:itemTinHelmet").setCreativeTab(tabVenhCombat);
		itemTinChestplate = new ItemArmourClass(tinArmourMaterial, 1).setUnlocalizedName("ItemTinChestplate").setTextureName("venh:itemTinChestplate").setCreativeTab(tabVenhCombat);
		itemTinLeggings = new ItemArmourClass(tinArmourMaterial, 2).setUnlocalizedName("ItemTinLeggings").setTextureName("venh:itemTinLeggings").setCreativeTab(tabVenhCombat);
		itemTinBoots = new ItemArmourClass(tinArmourMaterial, 3).setUnlocalizedName("ItemTinBoots").setTextureName("venh:itemTinBoots").setCreativeTab(tabVenhCombat);
		itemCopperHelmet = new ItemArmourClass(copperArmourMaterial, 0).setUnlocalizedName("ItemCopperHelmet").setTextureName("venh:itemCopperHelmet").setCreativeTab(tabVenhCombat);
		itemCopperChestplate = new ItemArmourClass(copperArmourMaterial, 1).setUnlocalizedName("ItemCopperChestplate").setTextureName("venh:itemCopperChestplate").setCreativeTab(tabVenhCombat);
		itemCopperLeggings = new ItemArmourClass(copperArmourMaterial, 2).setUnlocalizedName("ItemCopperLeggings").setTextureName("venh:itemCopperLeggings").setCreativeTab(tabVenhCombat);
		itemCopperBoots = new ItemArmourClass(copperArmourMaterial, 3).setUnlocalizedName("ItemCopperBoots").setTextureName("venh:itemCopperBoots").setCreativeTab(tabVenhCombat);
		itemOsmiumHelmet = new ItemArmourClass(osmiumArmourMaterial, 0).setUnlocalizedName("ItemOsmiumHelmet").setTextureName("venh:itemOsmiumHelmet").setCreativeTab(tabVenhCombat);
		itemOsmiumChestplate = new ItemArmourClass(osmiumArmourMaterial, 1).setUnlocalizedName("ItemOsmiumChestplate").setTextureName("venh:itemOsmiumChestplate").setCreativeTab(tabVenhCombat);
		itemOsmiumLeggings = new ItemArmourClass(osmiumArmourMaterial, 2).setUnlocalizedName("ItemOsmiumLeggings").setTextureName("venh:itemOsmiumLeggings").setCreativeTab(tabVenhCombat);
		itemOsmiumBoots = new ItemArmourClass(osmiumArmourMaterial, 3).setUnlocalizedName("ItemOsmiumBoots").setTextureName("venh:itemOsmiumBoots").setCreativeTab(tabVenhCombat);
		itemIridiumHelmet = new ItemArmourClass(iridiumArmourMaterial, 0).setUnlocalizedName("ItemIridiumHelmet").setTextureName("venh:itemIridiumHelmet").setCreativeTab(tabVenhCombat);
		itemIridiumChestplate = new ItemArmourClass(iridiumArmourMaterial, 1).setUnlocalizedName("ItemIridiumChestplate").setTextureName("venh:itemIridiumChestplate").setCreativeTab(tabVenhCombat);
		itemIridiumLeggings = new ItemArmourClass(iridiumArmourMaterial, 2).setUnlocalizedName("ItemIridiumLeggings").setTextureName("venh:itemIridiumLeggings").setCreativeTab(tabVenhCombat);
		itemIridiumBoots = new ItemArmourClass(iridiumArmourMaterial, 3).setUnlocalizedName("ItemIridiumBoots").setTextureName("venh:itemIridiumBoots").setCreativeTab(tabVenhCombat);
		itemBlaziciteHelmet = new ItemArmourClass(blaziciteArmourMaterial, 0).setUnlocalizedName("ItemBlaziciteHelmet").setTextureName("venh:itemBlaziciteHelmet").setCreativeTab(tabVenhCombat);
		itemBlaziciteChestplate = new ItemArmourClass(blaziciteArmourMaterial, 1).setUnlocalizedName("ItemBlaziciteChestplate").setTextureName("venh:itemBlaziciteChestplate").setCreativeTab(tabVenhCombat);
		itemBlaziciteLeggings = new ItemArmourClass(blaziciteArmourMaterial, 2).setUnlocalizedName("ItemBlaziciteLeggings").setTextureName("venh:itemBlaziciteLeggings").setCreativeTab(tabVenhCombat);
		itemBlaziciteBoots = new ItemArmourClass(blaziciteArmourMaterial, 3).setUnlocalizedName("ItemBlaziciteBoots").setTextureName("venh:itemBlaziciteBoots").setCreativeTab(tabVenhCombat);
		itemBronzeHelmet = new ItemArmourClass(bronzeArmourMaterial, 0).setUnlocalizedName("ItemBronzeHelmet").setTextureName("venh:itemBronzeHelmet").setCreativeTab(tabVenhCombat);
		itemBronzeChestplate = new ItemArmourClass(bronzeArmourMaterial, 1).setUnlocalizedName("ItemBronzeChestplate").setTextureName("venh:itemBronzeChestplate").setCreativeTab(tabVenhCombat);
		itemBronzeLeggings = new ItemArmourClass(bronzeArmourMaterial, 2).setUnlocalizedName("ItemBronzeLeggings").setTextureName("venh:itemBronzeLeggings").setCreativeTab(tabVenhCombat);
		itemBronzeBoots = new ItemArmourClass(bronzeArmourMaterial, 3).setUnlocalizedName("ItemBronzeBoots").setTextureName("venh:itemBronzeBoots").setCreativeTab(tabVenhCombat);
		itemSteelHelmet = new ItemArmourClass(steelArmourMaterial, 0).setUnlocalizedName("ItemSteelHelmet").setTextureName("venh:itemSteelHelmet").setCreativeTab(tabVenhCombat);
		itemSteelChestplate = new ItemArmourClass(steelArmourMaterial, 1).setUnlocalizedName("ItemSteelChestplate").setTextureName("venh:itemSteelChestplate").setCreativeTab(tabVenhCombat);
		itemSteelLeggings = new ItemArmourClass(steelArmourMaterial, 2).setUnlocalizedName("ItemSteelLeggings").setTextureName("venh:itemSteelLeggings").setCreativeTab(tabVenhCombat);
		itemSteelBoots = new ItemArmourClass(steelArmourMaterial, 3).setUnlocalizedName("ItemSteelBoots").setTextureName("venh:itemSteelBoots").setCreativeTab(tabVenhCombat);
		
		//Signs
		itemSignSpruce = new ItemNewSign().setUnlocalizedName("ItemSignSpruce").setTextureName("venh:itemSignSpruce").setCreativeTab(tabVenhDecoration);
		itemSignBirch = new ItemNewSign().setUnlocalizedName("ItemSignBirch").setTextureName("venh:itemSignBirch").setCreativeTab(tabVenhDecoration);
		itemSignJungle = new ItemNewSign().setUnlocalizedName("ItemSignJungle").setTextureName("venh:itemSignJungle").setCreativeTab(tabVenhDecoration);
		itemSignAcacia = new ItemNewSign().setUnlocalizedName("ItemSignAcacia").setTextureName("venh:itemSignAcacia").setCreativeTab(tabVenhDecoration);
		itemSignBigOak = new ItemNewSign().setUnlocalizedName("ItemSignBigOak").setTextureName("venh:itemSignBigOak").setCreativeTab(tabVenhDecoration);
		
		itemChocolateCookie = new ItemFood(20, 20, false).setUnlocalizedName("ItemChocolateCookie").setTextureName("venh:itemChocolateCookie").setCreativeTab(CreativeTabs.tabFood);
		itemCreativeEnderPearl = new ItemCreativeEnderPearl().setUnlocalizedName("ItemCreativeEnderPearl").setTextureName("minecraft:ender_pearl").setCreativeTab(tabHidden);

		//Ores
		GameRegistry.registerBlock(blockOreMetal, BlockOreMetalItem.class, blockOreMetal.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockOreRuby, blockOreRuby.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockOreSapphire, blockOreSapphire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockOreAnthracite, blockOreAnthracite.getUnlocalizedName().substring(5));
		
		//Nether Ores
		GameRegistry.registerBlock(blockOreBlazicite, BlockOreBlaziciteItem.class, blockOreBlazicite.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockOreNetherGold, blockOreNetherGold.getUnlocalizedName().substring(5));

//		GameRegistry.registerBlock(blockOreNetherMetal, BlockOreNetherMetalItem.class, blockOreNetherMetal.getUnlocalizedName().substring(5));
//		GameRegistry.registerBlock(blockOreNetherAnthracite, blockOreNetherAnthracite.getUnlocalizedName().substring(5));
		
		//Blocks
		GameRegistry.registerBlock(blockMetal, BlockMetalItem.class, blockMetal.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockRuby, blockRuby.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockSapphire, blockSapphire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockCharcoal, blockCharcoal.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockAnthracite, blockAnthracite.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBlaze, blockBlaze.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockPolishedStone, blockPolishedStone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockCobblePaver, blockCobblePaver.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockNewSandstone, BlockNewSandstoneItem.class, blockNewSandstone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockRedSandstone, BlockRedSandstoneItem.class, blockRedSandstone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockNewWorkbench, BlockNewWorkbenchItem.class, blockNewWorkbench.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockGoldWorkbench, blockGoldWorkbench.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockMacerator, blockMacerator.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBark, BlockBarkItem.class, blockBark.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBark2, BlockBarkNewItem.class, blockBark2.getUnlocalizedName().substring(5) + "2");
		GameRegistry.registerBlock(blockStrippedLog, BlockStrippedLogItem.class, blockStrippedLog.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockStrippedLog2, BlockStrippedLogNewItem.class, blockStrippedLog2.getUnlocalizedName().substring(5) + "2");
		GameRegistry.registerBlock(blockStrippedWood, BlockStrippedLogItem.class, blockStrippedWood.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockStrippedWood2, BlockStrippedLogNewItem.class, blockStrippedWood2.getUnlocalizedName().substring(5) + "2");
		GameRegistry.registerBlock(blockCrate, blockCrate.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockNetherWart, blockNetherWart.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockStickyCrate, blockStickyCrate.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockMagma, blockMagma.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBone, blockBone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockGlowingObsidian, blockGlowingObsidian.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockMissing, blockMissing.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockRose, BlockRoseItem.class, blockRose.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockPaeonia, BlockPaeoniaItem.class, blockPaeonia.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockConcretePowder, BlockConcretePowderItem.class, blockConcretePowder.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockConcrete, BlockConcreteItem.class, blockConcrete.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockOakScaffolding, blockOakScaffolding.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockSpruceScaffolding, blockSpruceScaffolding.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBirchScaffolding, blockBirchScaffolding.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockJungleScaffolding, blockJungleScaffolding.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockAcaciaScaffolding, blockAcaciaScaffolding.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBigOakScaffolding, blockBigOakScaffolding.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockSteelScaffolding, blockSteelScaffolding.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBrickDyed, BlockBrickDyedItem.class, blockBrickDyed.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockCauldronLava, blockCauldronLava.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(blockCauldronWater, blockCauldronWater.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockMyceliumSupport, blockMyceliumSupport.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockLantern, blockLantern.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockCakeCarrot, blockCakeCarrot.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockCakeChocolate, blockCakeChocolate.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockCakeVelvet, blockCakeVelvet.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockCakeIceCream, blockCakeIceCream.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(blockNewNetherBrick, BlockNewNetherBrickItem.class, blockNewNetherBrick.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockRedNetherBrickFence, blockRedNetherBrickFence.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBlackNetherBrickFence, blockBlackNetherBrickFence.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockRedNetherBrickStairs, blockRedNetherBrickStairs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBlackNetherBrickStairs, blockBlackNetherBrickStairs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockRedSandstoneStairs, blockRedSandstoneStairs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockNewRockSlab, BlockNewRockSlabItem.class, blockNewRockSlab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockNewRockDoubleSlab, BlockNewRockSlabItem.class, blockNewRockDoubleSlab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceSpruce, blockFenceSpruce.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceBirch, blockFenceBirch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceJungle, blockFenceJungle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceAcacia, blockFenceAcacia.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceBigOak, blockFenceBigOak.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockPressurePlateSpruce, blockPressurePlateSpruce.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockPressurePlateBirch, blockPressurePlateBirch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockPressurePlateJungle, blockPressurePlateJungle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockPressurePlateAcacia, blockPressurePlateAcacia.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockPressurePlateBigOak, blockPressurePlateBigOak.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockButtonSpruce, blockButtonSpruce.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockButtonBirch, blockButtonBirch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockButtonJungle, blockButtonJungle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockButtonAcacia, blockButtonAcacia.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockButtonBigOak, blockButtonBigOak.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceGateSpruce, blockFenceGateSpruce.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceGateBirch, blockFenceGateBirch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceGateJungle, blockFenceGateJungle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceGateAcacia, blockFenceGateAcacia.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceGateBigOak, blockFenceGateBigOak.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceGateNetherBrick, blockFenceGateNetherBrick.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceGateRedNetherBrick, blockFenceGateRedNetherBrick.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFenceGateBlackNetherBrick, blockFenceGateBlackNetherBrick.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockTrapDoorSpruce, blockTrapDoorSpruce.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockTrapDoorBirch, blockTrapDoorBirch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockTrapDoorJungle, blockTrapDoorJungle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockTrapDoorAcacia, blockTrapDoorAcacia.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockTrapDoorBigOak, blockTrapDoorBigOak.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockTrapDoorLadder, blockTrapDoorLadder.getUnlocalizedName().substring(5));
		
		
		GameRegistry.registerBlock(blockWaterStationary, blockWaterStationary.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockLavaStationary, blockLavaStationary.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockAlwaysOnLamp, blockAlwaysOnLamp.getUnlocalizedName().substring(5));
		
		GameRegistry.registerBlock(blockTest, blockTest.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockForcefield, blockForcefield.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBarrier, blockBarrier.getUnlocalizedName().substring(5));
		
		GameRegistry.registerBlock(blockVenhPot, blockVenhPot.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockStandingSignSpruce, blockStandingSignSpruce.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockWallSignSpruce, blockWallSignSpruce.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockStandingSignBirch, blockStandingSignBirch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockWallSignBirch, blockWallSignBirch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockStandingSignJungle, blockStandingSignJungle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockWallSignJungle, blockWallSignJungle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockStandingSignAcacia, blockStandingSignAcacia.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockWallSignAcacia, blockWallSignAcacia.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockStandingSignBigOak, blockStandingSignBigOak.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockWallSignBigOak, blockWallSignBigOak.getUnlocalizedName().substring(5));
		
		//Misc. Items
		GameRegistry.registerItem(itemIngotMetal, itemIngotMetal.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemNuggetMetal, itemNuggetMetal.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemNuggetIron, itemNuggetIron.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemIngotBlazicite, itemIngotBlazicite.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemNuggetBlazicite, itemNuggetBlazicite.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemShard, itemShard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemAnthracite, itemAnthracite.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemRuby, itemRuby.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSapphire, itemSapphire.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemDust, itemDust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemDustMetal, itemDustMetal.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemWitheredBone, itemWitheredBone.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemWitheredBonemeal, itemWitheredBonemeal.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemPieApple, itemPieApple.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCakeCarrot, itemCakeCarrot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCakeChocolate, itemCakeChocolate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCakeVelvet, itemCakeVelvet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCakeIceCream, itemCakeIceCream.getUnlocalizedName().substring(5));
		
		//Food
		GameRegistry.registerItem(itemDiamondApple, itemDiamondApple.getUnlocalizedName().substring(5));
		
		//Tools
		GameRegistry.registerItem(itemTinSword, itemTinSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTinSpade, itemTinSpade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTinPickaxe, itemTinPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTinAxe, itemTinAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTinHoe, itemTinHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCopperSword, itemCopperSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCopperSpade, itemCopperSpade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCopperPickaxe, itemCopperPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCopperAxe, itemCopperAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCopperHoe, itemCopperHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemOsmiumSword, itemOsmiumSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemOsmiumSpade, itemOsmiumSpade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemOsmiumPickaxe, itemOsmiumPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemOsmiumAxe, itemOsmiumAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemOsmiumHoe, itemOsmiumHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemIridiumSword, itemIridiumSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemIridiumSpade, itemIridiumSpade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemIridiumPickaxe, itemIridiumPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemIridiumAxe, itemIridiumAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemIridiumHoe, itemIridiumHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBlaziciteSword, itemBlaziciteSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBlaziciteSpade, itemBlaziciteSpade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBlazicitePickaxe, itemBlazicitePickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBlaziciteAxe, itemBlaziciteAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBlaziciteHoe, itemBlaziciteHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemRubySword, itemRubySword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemRubySpade, itemRubySpade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemRubyPickaxe, itemRubyPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemRubyAxe, itemRubyAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemRubyHoe, itemRubyHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemEmeraldSword, itemEmeraldSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemEmeraldSpade, itemEmeraldSpade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemEmeraldPickaxe, itemEmeraldPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemEmeraldAxe, itemEmeraldAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemEmeraldHoe, itemEmeraldHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBronzeSword, itemBronzeSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBronzeSpade, itemBronzeSpade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBronzePickaxe, itemBronzePickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBronzeAxe, itemBronzeAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBronzeHoe, itemBronzeHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSteelSword, itemSteelSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSteelSpade, itemSteelSpade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSteelPickaxe, itemSteelPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSteelAxe, itemSteelAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSteelHoe, itemSteelHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBoneSword, itemBoneSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBoneSpade, itemBoneSpade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBonePickaxe, itemBonePickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBoneAxe, itemBoneAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBoneHoe, itemBoneHoe.getUnlocalizedName().substring(5));
		
		//Armour
		GameRegistry.registerItem(itemTinHelmet, itemTinHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTinChestplate, itemTinChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTinLeggings, itemTinLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTinBoots, itemTinBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCopperHelmet, itemCopperHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCopperChestplate, itemCopperChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCopperLeggings, itemCopperLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCopperBoots, itemCopperBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemOsmiumHelmet, itemOsmiumHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemOsmiumChestplate, itemOsmiumChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemOsmiumLeggings, itemOsmiumLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemOsmiumBoots, itemOsmiumBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemIridiumHelmet, itemIridiumHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemIridiumChestplate, itemIridiumChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemIridiumLeggings, itemIridiumLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemIridiumBoots, itemIridiumBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBlaziciteHelmet, itemBlaziciteHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBlaziciteChestplate, itemBlaziciteChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBlaziciteLeggings, itemBlaziciteLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBlaziciteBoots, itemBlaziciteBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemEmeraldHelmet, itemEmeraldHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemEmeraldChestplate, itemEmeraldChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemEmeraldLeggings, itemEmeraldLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemEmeraldBoots, itemEmeraldBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSapphireHelmet, itemSapphireHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSapphireChestplate, itemSapphireChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSapphireLeggings, itemSapphireLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSapphireBoots, itemSapphireBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBronzeHelmet, itemBronzeHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBronzeChestplate, itemBronzeChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBronzeLeggings, itemBronzeLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBronzeBoots, itemBronzeBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSteelHelmet, itemSteelHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSteelChestplate, itemSteelChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSteelLeggings, itemSteelLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSteelBoots, itemSteelBoots.getUnlocalizedName().substring(5));
		
		//Signs
		GameRegistry.registerItem(itemSignSpruce, itemSignSpruce.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSignBirch, itemSignBirch.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSignJungle, itemSignJungle.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSignAcacia, itemSignAcacia.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemSignBigOak, itemSignBigOak.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(itemChocolateCookie, itemChocolateCookie.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCreativeEnderPearl, itemCreativeEnderPearl.getUnlocalizedName().substring(5));
		
		//Tile Entities
		GameRegistry.registerTileEntity(TileEntityNewSign.class, "newSign");
		
		//Fuel Handling
		GameRegistry.registerFuelHandler(new FuelHandler());
		
		//Ores Generation
		GameRegistry.registerWorldGenerator(new ClusterOreGen(), 0);
		GameRegistry.registerWorldGenerator(new SingleOreGen(), 0);
		
		//Rendering
		venhProxy.registerRenderer();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		//Proxy, TileEntity, entity, GUI and packet handling
		OreDictionary();
		MinecraftForge.EVENT_BUS.register(new VanillaEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		//Fire (Encouragement, Flammability)
		Blocks.fire.setFireInfo(blockCharcoal, 5, 10);
		Blocks.fire.setFireInfo(blockAnthracite, 5, 3);
		Blocks.fire.setFireInfo(blockBark, 5, 15);
		Blocks.fire.setFireInfo(blockBark2, 5, 15);
		Blocks.fire.setFireInfo(blockStrippedLog, 5, 5);
		Blocks.fire.setFireInfo(blockStrippedLog2, 5, 5);
		Blocks.fire.setFireInfo(blockStrippedWood, 5, 5);
		Blocks.fire.setFireInfo(blockStrippedWood2, 5, 5);
		Blocks.fire.setFireInfo(blockCrate, 5, 20);
		Blocks.fire.setFireInfo(blockStickyCrate, 5, 20);
		Blocks.fire.setFireInfo(blockOakScaffolding, 10, 35);
		Blocks.fire.setFireInfo(blockSpruceScaffolding, 10, 35);
		Blocks.fire.setFireInfo(blockBirchScaffolding, 10, 35);
		Blocks.fire.setFireInfo(blockJungleScaffolding, 10, 35);
		Blocks.fire.setFireInfo(blockAcaciaScaffolding, 10, 35);
		Blocks.fire.setFireInfo(blockBigOakScaffolding, 10, 35);
        Blocks.fire.setFireInfo(blockFenceSpruce, 5, 20);
        Blocks.fire.setFireInfo(blockFenceBirch, 5, 20);
        Blocks.fire.setFireInfo(blockFenceJungle, 5, 20);
        Blocks.fire.setFireInfo(blockFenceAcacia, 5, 20);
        Blocks.fire.setFireInfo(blockFenceBigOak, 5, 20);
        Blocks.fire.setFireInfo(Blocks.fence_gate, 5, 20);
        Blocks.fire.setFireInfo(blockFenceGateSpruce, 5, 20);
        Blocks.fire.setFireInfo(blockFenceGateBirch, 5, 20);
        Blocks.fire.setFireInfo(blockFenceGateJungle, 5, 20);
        Blocks.fire.setFireInfo(blockFenceGateAcacia, 5, 20);
        Blocks.fire.setFireInfo(blockFenceGateBigOak, 5, 20);
        Blocks.fire.setFireInfo(Blocks.wooden_button, 15, 25);
        Blocks.fire.setFireInfo(blockButtonSpruce, 15, 25);
        Blocks.fire.setFireInfo(blockButtonBirch, 15, 25);
        Blocks.fire.setFireInfo(blockButtonJungle, 15, 25);
        Blocks.fire.setFireInfo(blockButtonAcacia, 15, 25);
        Blocks.fire.setFireInfo(blockButtonBigOak, 15, 25);
        Blocks.fire.setFireInfo(Blocks.wooden_pressure_plate, 15, 20);
        Blocks.fire.setFireInfo(blockPressurePlateSpruce, 15, 20);
        Blocks.fire.setFireInfo(blockPressurePlateBirch, 15, 20);
        Blocks.fire.setFireInfo(blockPressurePlateJungle, 15, 20);
        Blocks.fire.setFireInfo(blockPressurePlateAcacia, 15, 20);
        Blocks.fire.setFireInfo(blockPressurePlateBigOak, 15, 20);
		
		//Vanilla recipe replacements
		RecipeRemover.removeRecipe();
		RecipeHandler.addRecipes();

	}

	public static void OreDictionary(){
		//OreDictionary
		OreDictionary.registerOre("logWood", new ItemStack(blockStrippedLog));
		OreDictionary.registerOre("logWood", new ItemStack(blockStrippedLog2));
		OreDictionary.registerOre("gemRuby", new ItemStack(itemRuby));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 0));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 1));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 2));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 3));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 4));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 5));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 6));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 7));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 8));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 9));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 10));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 11));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 12));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 13));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 14));
		OreDictionary.registerOre("blockBrick", new ItemStack(blockBrickDyed, 1, 15));
		OreDictionary.registerOre("blockBrick", new ItemStack(Blocks.brick_block));
		OreDictionary.registerOre("blockRuby", new ItemStack(blockRuby));
		OreDictionary.registerOre("gemSapphire", new ItemStack(itemSapphire));
		OreDictionary.registerOre("ingotTin", new ItemStack(itemIngotMetal, 1, 0));
		OreDictionary.registerOre("ingotCopper", new ItemStack(itemIngotMetal, 1, 1));
		OreDictionary.registerOre("ingotOsmium", new ItemStack(itemIngotMetal, 1, 2));
		OreDictionary.registerOre("ingotIridium", new ItemStack(itemIngotMetal, 1, 3));
		OreDictionary.registerOre("ingotBronze", new ItemStack(itemIngotMetal, 1, 4));
		OreDictionary.registerOre("ingotSteel", new ItemStack(itemIngotMetal, 1, 5));
		OreDictionary.registerOre("nuggetTin", new ItemStack(itemNuggetMetal, 1, 0));
		OreDictionary.registerOre("nuggetIron", new ItemStack(itemNuggetIron));
		OreDictionary.registerOre("nuggetBlazicite", new ItemStack(itemNuggetBlazicite));
		OreDictionary.registerOre("nuggetCopper", new ItemStack(itemNuggetMetal, 1, 1));
		OreDictionary.registerOre("nuggetOsmium", new ItemStack(itemNuggetMetal, 1, 2));
		OreDictionary.registerOre("nuggetIridium", new ItemStack(itemNuggetMetal, 1, 3));
		OreDictionary.registerOre("nuggetBronze", new ItemStack(itemNuggetMetal, 1, 4));
		OreDictionary.registerOre("nuggetSteel", new ItemStack(itemNuggetMetal, 1, 5));
		OreDictionary.registerOre("ingotBlazicite", new ItemStack(itemIngotBlazicite, 1));
		OreDictionary.registerOre("nuggetCoal", new ItemStack(itemShard, 1, 0));
		OreDictionary.registerOre("nuggetCoal", new ItemStack(itemShard, 1, 1));
		OreDictionary.registerOre("nuggetAnthracite", new ItemStack(itemShard, 1, 2));
		OreDictionary.registerOre("nuggetDiamond", new ItemStack(itemShard, 1, 3));
		OreDictionary.registerOre("nuggetEmerald", new ItemStack(itemShard, 1, 4));
		OreDictionary.registerOre("nuggetRuby", new ItemStack(itemShard, 1, 5));
		OreDictionary.registerOre("nuggetSapphire", new ItemStack(itemShard, 1, 6));
		OreDictionary.registerOre("nuggetBlazicite", new ItemStack(itemNuggetBlazicite, 1));
		OreDictionary.registerOre("blockSapphire", new ItemStack(blockSapphire));
		OreDictionary.registerOre("blockTin", new ItemStack(blockMetal, 1, 0));
		OreDictionary.registerOre("blockCopper", new ItemStack(blockMetal, 1, 1));
		OreDictionary.registerOre("blockOsmium", new ItemStack(blockMetal, 1, 2));
		OreDictionary.registerOre("blockIridium", new ItemStack(blockMetal, 1, 3));
		OreDictionary.registerOre("blockBronze", new ItemStack(blockMetal, 1, 4));
		OreDictionary.registerOre("blockSteel", new ItemStack(blockMetal, 1, 5));
		OreDictionary.registerOre("oreRuby", new ItemStack(blockOreRuby));
		OreDictionary.registerOre("blockCharcoal", new ItemStack(blockCharcoal));
		OreDictionary.registerOre("redSandstone", new ItemStack(blockRedSandstone));
		OreDictionary.registerOre("itemAnthracite", new ItemStack(itemAnthracite));
		OreDictionary.registerOre("dustTin", new ItemStack(itemDustMetal, 1, 0));
		OreDictionary.registerOre("dustCopper", new ItemStack(itemDustMetal, 1, 1));
		OreDictionary.registerOre("dustOsmium", new ItemStack(itemDustMetal, 1, 2));
		OreDictionary.registerOre("dustIridium", new ItemStack(itemDustMetal, 1, 3));
		OreDictionary.registerOre("dustBronze", new ItemStack(itemDustMetal, 1, 4));
		OreDictionary.registerOre("dustSteel", new ItemStack(itemDustMetal, 1, 5));
		OreDictionary.registerOre("dustCoal", new ItemStack(itemDust, 1, 0));
		OreDictionary.registerOre("dustCoal", new ItemStack(itemDust, 1, 1));
		OreDictionary.registerOre("dustCharcoal", new ItemStack(itemDust, 1, 1));
		OreDictionary.registerOre("dustAnthracite", new ItemStack(itemDust, 1, 2));
		OreDictionary.registerOre("dustIron", new ItemStack(itemDust, 1, 3));
		OreDictionary.registerOre("dustGold", new ItemStack(itemDust, 1, 4));
		OreDictionary.registerOre("dustBlazicite", new ItemStack(itemDust, 1, 5));
		OreDictionary.registerOre("dustDiamond", new ItemStack(itemDust, 1, 6));
		OreDictionary.registerOre("dustEmerald", new ItemStack(itemDust, 1, 7));
		OreDictionary.registerOre("dustRuby", new ItemStack(itemDust, 1, 8));
		OreDictionary.registerOre("dustSapphire", new ItemStack(itemDust, 1, 9));
		OreDictionary.registerOre("blockScaffold", new ItemStack(blockOakScaffolding));
		OreDictionary.registerOre("blockScaffold", new ItemStack(blockSpruceScaffolding));
		OreDictionary.registerOre("blockScaffold", new ItemStack(blockBirchScaffolding));
		OreDictionary.registerOre("blockScaffold", new ItemStack(blockJungleScaffolding));
		OreDictionary.registerOre("blockScaffold", new ItemStack(blockAcaciaScaffolding));
		OreDictionary.registerOre("blockScaffold", new ItemStack(blockBigOakScaffolding));
	}
	
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    	
	}
    
	public static CreativeTabs tabVenhBuilding = new CreativeTabs("tabVenhBuilding"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return new ItemStack(blockBlaze).getItem();
		}
	};
    
	public static CreativeTabs tabVenhDecoration = new CreativeTabs("tabVenhDecoration"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return new ItemStack(blockLantern).getItem();
		}
	};
	
	public static CreativeTabs tabVenhMaterials = new CreativeTabs("tabVenhMaterials"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return new ItemStack(itemSapphire).getItem();
		}
	};

	public static CreativeTabs tabVenhTools = new CreativeTabs("tabVenhTools"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return new ItemStack(itemCopperAxe).getItem();
		}
	};
	
	public static CreativeTabs tabVenhCombat = new CreativeTabs("tabVenhCombat"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return new ItemStack(itemEmeraldSword).getItem();
		}
	};

	public static CreativeTabs tabHidden = new CreativeTabs("tabVenhHidden"){
		
	    @SideOnly(Side.CLIENT) 
	    public void getSubBlocks(Item item, CreativeTabs creative, List list)
	    {
	        list.add(new ItemStack(Blocks.double_stone_slab, 1, 0).getItem());
	    }
	    
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return new ItemStack(Blocks.command_block).getItem();
			
		}
	};
	
}

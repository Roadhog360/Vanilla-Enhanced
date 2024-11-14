package roadhog.venhanced.handler;

import java.util.Random;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class ClusterOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId)
		{
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		
		}
	}
	
	public boolean isMesa(World world, int chunkX, int chunkZ) {
		if((world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.mesaPlateau_F) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.mesaPlateau) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.mesa)) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Generation params, in this order:
	 *  Block to generate
	 *  Metadata of block
	 *  world
	 *  rand
	 *  x
	 *  z
	 *  Minimum vein size.
	 *  Maximum vein size.
	 *  Rarity (Float)
	 *  Minimum Y level.
	 *  Maximum Y Level.
	 *  Block to replace.
	 */
	
	public void generateEnd(World world, Random rand, int x, int z) {
		
	}
	
	public void generateOverworld(World world, Random rand, int x, int z) {
		generateOre(VanillaEnhanced.blockOreAnthracite, 0, world, rand, x, z, 8, 16, 1.6F, 1, 24, Blocks.stone);
		generateOre(VanillaEnhanced.blockOreMetal, 0, world, rand, x, z, 8, 14, 35, 40, 128, Blocks.stone);
		generateOre(VanillaEnhanced.blockOreMetal, 1, world, rand, x, z, 8, 12, 25, 20, 80, Blocks.stone);
		generateOre(VanillaEnhanced.blockOreMetal, 2, world, rand, x, z, 2, 8, 0.40F, -14, 16, Blocks.stone);
		generateOre(VanillaEnhanced.blockOreMetal, 3, world, rand, x, z, 2, 8, 0.40F, -14, 16, Blocks.stone);
		generateOre(Blocks.stone, 0, world, rand, x, z, 34, 35, 12, 0, 16, Blocks.diamond_ore);
		
		if (isMesa(world, x * 16, z * 16)) {
			generateOre(Blocks.gold_ore, 0, world, rand, x, z, 3, 10, 5, 4, 64, Blocks.stone);
		}
	}
	
	public void generateNether(World world, Random rand, int x, int z) {
		generateOre(VanillaEnhanced.blockNewNetherBrick, 0, world, rand, x, z, 12, 18, 140, 1, 128, Blocks.nether_brick);
		generateOre(VanillaEnhanced.blockNewNetherBrick, 1, world, rand, x, z, 12, 14, 65, 1, 128, Blocks.nether_brick);
		generateOre(VanillaEnhanced.blockMagma, 0, world, rand, x, z, 20, 48, 3, 23, 38, Blocks.netherrack);
		generateOre(VanillaEnhanced.blockOreBlazicite, 0, world, rand, x, z, 3, 6, 1, 1, 136, Blocks.netherrack);
		generateOre(VanillaEnhanced.blockOreNetherGold, 0, world, rand, x, z, 6, 12, 4, 1, 127, Blocks.netherrack);
		
	}
	
	public void generateOre(Block block, int meta, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, float chance, int minY, int maxY, Block generateIn) {
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block, meta, veinSize, generateIn);
		for(int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}
}

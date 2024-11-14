package roadhog.venhanced.handler;

import java.util.Random;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.terraingen.BiomeEvent;
import cpw.mods.fml.common.IWorldGenerator;

public class SingleOreGen implements IWorldGenerator {

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
	
	public boolean isTaiga(World world, int chunkX, int chunkZ) {
		if((world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.getBiome(158)) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.getBiome(133)) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.iceMountains) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.icePlains) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.taiga) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.taigaHills) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.megaTaigaHills) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.megaTaiga) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.coldTaigaHills) ||
				(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.coldTaiga)) {
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
	 *  Rarity (Float)
	 *  Minimum Y level.
	 *  Maximum Y Level.
	 *  Block to replace.
	 */
	
	public void generateEnd(World world, Random rand, int x, int z) {
		
	}
	
	public void generateOverworld(World world, Random rand, int x, int z) {
		if (isMesa(world, x * 16, z * 16)) {
			generateOre(VanillaEnhanced.blockOreRuby, 0, world, rand, x, z, 6, 4, 24, Blocks.stone);
		} if (isTaiga(world, x * 16, z * 16)) {
			generateOre(VanillaEnhanced.blockOreSapphire, 0, world, rand, x, z, 7, 4, 24, Blocks.stone);
		}
	}
	
	public void generateNether(World world, Random rand, int x, int z) {
		
	}
	
	public void generateOre(Block block, int meta, World world, Random random, int chunkX, int chunkZ, float chance, int minY, int maxY, Block generateIn) {
		int veinSize = 1;
		int heightRange = maxY - minY;
		
		int xRand = chunkX * 16 + random.nextInt(16);
		int yRand = random.nextInt(heightRange) + minY;
		int zRand = chunkZ * 16 + random.nextInt(16);

		for(int i = 0; i < chance; i++) {
			if (world.getBlock(xRand, yRand, zRand) == generateIn)
				world.setBlock(xRand, yRand, zRand, block, meta, 2);
		}
	}
}

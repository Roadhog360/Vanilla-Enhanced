package roadhog.venhanced.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import roadhog.venhanced.renderer.block.RenderCauldronLava;
import roadhog.venhanced.renderer.block.RenderLantern;
import roadhog.venhanced.renderer.block.RenderNewFence;
import roadhog.venhanced.renderer.block.RenderNewTrapdoor;
import roadhog.venhanced.renderer.tileentity.RenderNewSign;
import roadhog.venhanced.tileentity.TileEntityNewSign;

public class ProxyClient extends ProxyCommon {
	
	public void registerRenderer() {
		RenderingRegistry.registerBlockHandler(new RenderCauldronLava());
		RenderingRegistry.registerBlockHandler(new RenderLantern());
		RenderingRegistry.registerBlockHandler(new RenderNewTrapdoor());
		RenderingRegistry.registerBlockHandler(new RenderNewFence());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNewSign.class, new RenderNewSign());
	}

	public void registerTileEntitySpecialRenderer() {
		
	}

}

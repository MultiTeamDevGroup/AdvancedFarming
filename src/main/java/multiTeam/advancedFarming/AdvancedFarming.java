package multiteam.advancedfarming;

import multiteam.advancedfarming.block.ModBlocks;
import multiteam.advancedfarming.item.ModItems;
import multiteam.advancedfarming.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = AdvancedFarming.MODID, version = AdvancedFarming.VERSION)
public class AdvancedFarming
{
    public static final String MODID = "advancedfarming";
    public static final String VERSION = "0.1";
    
    @Instance(MODID)
    public static AdvancedFarming INSTANCE;
    
    @SidedProxy(serverSide = "multiteam.advancedfarming.proxy.CommonProxy", clientSide = "multiteam.advancedfarming.proxy.ClientProxy")
   	public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(this,  new ModGuiHandler());
    }
    
    @EventHandler
    public void init(final FMLInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void serverStarting(final FMLServerStartingEvent event) {
    	
    }
    
    @EventHandler
    public void serverStopped(final FMLServerStoppedEvent event) {
    	
    }
    
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
    	@SubscribeEvent
    	public static void registerBlocks(RegistryEvent.Register<Block> event) {
    		ModBlocks.register(event.getRegistry());
    	}
    	
    	@SubscribeEvent
    	public static void registerItems(RegistryEvent.Register<Item> event) {
    		ModItems.register(event.getRegistry());
    		ModBlocks.registerItemBlocks(event.getRegistry());
    	}
    	
    	@SubscribeEvent
    	public static void registerItems(ModelRegistryEvent event) {
    		ModItems.registerModels();
    		ModBlocks.registerModels();
    	}
    }
}

package roburrito.fantasticcreatures;

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
import roburrito.fantasticcreatures.block.ModBlocks;
import roburrito.fantasticcreatures.client.MicrobiologyTab;
import roburrito.fantasticcreatures.item.ModItems;
import roburrito.fantasticcreatures.proxy.CommonProxy;
import roburrito.fantasticcreatures.recipe.ModRecipes;

@Mod(modid = FantasticCreatures.MODID, version = FantasticCreatures.VERSION)
public class FantasticCreatures
{
    public static final String MODID = "fantasticcreatures";
    public static final String NAME = "Fantastic Creatures";
    public static final String VERSION = "0.2";
    
    public static final MicrobiologyTab microbiologyTab = new MicrobiologyTab();
    
    @Instance(MODID)
    public static FantasticCreatures instance;
    
    
    @SidedProxy(serverSide = "roburrito.fantasticcreatures.proxy.CommonProxy", clientSide = "roburrito.fantasticcreatures.proxy.ClientProxy")
   	public static CommonProxy proxy;

    //public static NetworkWrapper network;
    
    /*
     * static {
     * 	FluidRegistry.enableUniversalBucket();
     * }
     */
    
    @EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(this,  new ModGuiHandler());
    }
    
    @EventHandler
    public void init(final FMLInitializationEvent event) {
    	ModRecipes.init();
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
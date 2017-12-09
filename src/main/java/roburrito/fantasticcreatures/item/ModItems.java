package roburrito.fantasticcreatures.item;

import java.util.HashSet;
import java.util.Set;

import akka.event.Logging.InitializeLogger;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import roburrito.fantasticcreatures.FantasticCreatures;

public class ModItems {
	static CreativeTabs microTab = FantasticCreatures.microbiologyTab;
	
	public static final ItemBase AMINO_ACID_ALIPATHIC = new ItemBase("amino_acid_alipathic").setCreativeTab(microTab);
	public static final ItemBase AMINO_ACID_ACIDIC = new ItemBase("amino_acid_acidic").setCreativeTab(microTab);
	public static final ItemBase AMINO_ACID_AROMATIC = new ItemBase("amino_acid_aromatic").setCreativeTab(microTab);
	public static final ItemBase AMINO_ACID_BASIC = new ItemBase("amino_acid_basic").setCreativeTab(microTab);
	public static final ItemBase AMINO_ACID_CYCLIC = new ItemBase("amino_acid_cyclic").setCreativeTab(microTab);
	public static final ItemBase AMINO_ACID_HYDROXYLIC = new ItemBase("amino_acid_hydroxylic").setCreativeTab(microTab);
	public static final ItemBase AMINO_ACID_SULFEROUS = new ItemBase("amino_acid_sulferous").setCreativeTab(microTab);
	
	public static final ItemBase GENOME = new ItemBase("genome").setCreativeTab(microTab);
	public static final ItemOre INGOT_COPPER = new ItemOre("ingot_copper", "ingotCopper").setCreativeTab(CreativeTabs.MATERIALS);
	
	public static final ItemBase SUGAR_FRUCTOSE = new ItemBase("sugar_fructose").setCreativeTab(microTab);
	public static final ItemBase SUGAR_GLUCOSE = new ItemBase("sugar_glucose").setCreativeTab(microTab);
	public static final ItemBase SUGAR_SUCROSE = new ItemBase("sugar_sucrose").setCreativeTab(microTab);
	
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				AMINO_ACID_ALIPATHIC,
				AMINO_ACID_ACIDIC,
				AMINO_ACID_AROMATIC,
				AMINO_ACID_BASIC,
				AMINO_ACID_CYCLIC,
				AMINO_ACID_HYDROXYLIC,
				AMINO_ACID_SULFEROUS,
				GENOME,
				INGOT_COPPER,
				SUGAR_FRUCTOSE,
				SUGAR_GLUCOSE,
				SUGAR_SUCROSE
		);
	}
	
	public static void registerModels() {
		AMINO_ACID_ALIPATHIC.registerItemModel();
		AMINO_ACID_ACIDIC.registerItemModel();
		AMINO_ACID_AROMATIC.registerItemModel();
		AMINO_ACID_BASIC.registerItemModel();
		AMINO_ACID_CYCLIC.registerItemModel();
		AMINO_ACID_HYDROXYLIC.registerItemModel();
		AMINO_ACID_SULFEROUS.registerItemModel();
		INGOT_COPPER.registerItemModel();
		GENOME.registerItemModel();
		SUGAR_FRUCTOSE.registerItemModel();
		SUGAR_GLUCOSE.registerItemModel();
		SUGAR_SUCROSE.registerItemModel();
	}
}

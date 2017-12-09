package roburrito.fantasticcreatures.stats;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.stats.StatCrafting;
import net.minecraft.util.text.TextComponentTranslation;

public class ModStats {
	protected static final Map<String, StatBase> ID_TO_STAT_MAP = Maps.<String, StatBase>newHashMap();
	public static final List<StatBase> ALL_STATS = Lists.<StatBase>newArrayList();
	public static final List<StatBase> BASIC_STATS = Lists.<StatBase>newArrayList();
	public static final List<StatCrafting> USE_ITEM_STATS = Lists.<StatCrafting>newArrayList();
	public static final List<StatCrafting> MINE_BLOCK_STATS = Lists.<StatCrafting>newArrayList();
	
	public static final StatBase PETRI_DISH_INTERACTION = (new StatBasic("stat.petriDishInteraction", new TextComponentTranslation("stat.petriDishInteraction", new Object[0]))).registerStat();
}

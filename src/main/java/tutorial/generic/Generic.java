package tutorial.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//import cpw.mods.fml.common.network.NetworkMod; // not used in 1.7
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="GenericModID", name="jdmmod", version="0.0.1")
//@NetworkMod(clientSideRequired=true) // not used in 1.7
public class Generic {
	
	public static Item genericItem;
	public static Item genericIngot;
	
	public static Block genericDirt;
	public static Block genericOre;

	// The instance of your mod that Forge uses.
	@Instance(value = "GenericModID")
	public static Generic instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="tutorial.generic.client.ClientProxy", serverSide="tutorial.generic.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler // used in 1.6.2
	//@PreInit    // used in 1.5.2
	public void preInit(FMLPreInitializationEvent event) {
		
        genericItem = new GenericItem();
        genericIngot = new GenericItem()
                        .setMaxStackSize(16)
                        .setUnlocalizedName("genericIngot")
                        .setTextureName("jdmmod:genericIngot");

    	
    	genericDirt = new GenericBlock(Material.ground)
    		.setHardness(0.5F)
    		.setStepSound(Block.soundTypeGravel)
    		.setBlockName("genericDirt")
    		.setCreativeTab(CreativeTabs.tabBlock);
    	
    	genericOre = new GenericOre(Material.rock);

        // The second parameter is an unique registry identifier (not the displayed name)
        // Please don't use genericItem.getUnlocalizedName(), or you will make Lex sad
        GameRegistry.registerItem(genericItem, "genericItem");
        GameRegistry.registerItem(genericIngot, "genericIngot");
        
        GameRegistry.registerBlock(genericDirt, "genericDirt");
        GameRegistry.registerBlock(genericOre, "genericOre");
	}
	
	@EventHandler // used in 1.6.2
	//@Init       // used in 1.5.2
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}
	
	@EventHandler // used in 1.6.2
	//@PostInit   // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}
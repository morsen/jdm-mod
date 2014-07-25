package tutorial.generic;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericOre extends Block {

	public GenericOre(Material material) {
		super(material);
		setHarvestLevel("pickaxe", 3);
		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundTypePiston); // sounds got renamed, look in Block class for what blocks have what sounds
		setBlockName("genericOre"); // changed in 1.7
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName("jdmmod:genericOre");
	}
	
	//If the block's drop is an item.
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Generic.genericIngot;
	}

}

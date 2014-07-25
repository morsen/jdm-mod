package tutorial.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GenericBlock extends Block {

	public GenericBlock(Material material) {
		super(material);
		setHarvestLevel("shovel",0);
		setBlockTextureName("jdmmod:genericDirt");
	}

}

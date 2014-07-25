package tutorial.generic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericItem extends Item {

	public GenericItem() {
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("genericItem");
		setTextureName("jdmmod:genericItem");
	}
}
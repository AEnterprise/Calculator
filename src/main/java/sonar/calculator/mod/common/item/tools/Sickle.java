package sonar.calculator.mod.common.item.tools;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sonar.calculator.mod.integration.planting.TreeHarvestRecipes;
import sonar.core.common.item.SonarItem;
import sonar.core.network.PacketInventorySync;
import sonar.core.network.SonarPackets;
import sonar.core.utils.helpers.FontHelper;
import sonar.core.utils.helpers.InventoryHelper;
import sonar.core.utils.helpers.SonarHelper;

public class Sickle extends SonarItem {

	public Random rand = new Random();

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if (!player.canPlayerEdit(x, y, z, par7, stack)) {
			return false;
		}		
		if (!InventoryHelper.isPlayerInventoryFull(player)) {
			ItemStack[] stacks = TreeHarvestRecipes.harvestLeaves(world, x, y, z, world.getBlockMetadata(x, y, z));
			if (stacks != null) {
				for (ItemStack harvest : stacks) {
					player.inventory.addItemStackToInventory(SonarHelper.restoreItemStack(harvest, 1));
				}
			}
			return true;
		} else if (!world.isRemote) {
			FontHelper.sendMessage(FontHelper.translate("inv.full"), world, player);
		}
	
		return false;
	}

}
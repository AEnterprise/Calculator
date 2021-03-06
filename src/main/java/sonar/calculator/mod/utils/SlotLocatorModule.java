package sonar.calculator.mod.utils;

import sonar.calculator.mod.Calculator;
import sonar.calculator.mod.common.tileentity.generators.TileEntityCalculatorLocator;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotLocatorModule extends Slot {

	public TileEntityCalculatorLocator locator;

	public SlotLocatorModule(TileEntityCalculatorLocator locator, int index, int x, int y) {
		super(locator, index, x, y);
		this.locator = locator;
	}

	public boolean isItemValid(ItemStack stack) {
		if (stack != null && stack.getItem() == Calculator.itemLocatorModule) {
			return true;
		}
		return false;
	}

	public void onSlotChanged() {
		super.onSlotChanged();
		locator.createOwner();
	}
}

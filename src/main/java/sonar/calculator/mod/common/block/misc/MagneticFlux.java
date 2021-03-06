package sonar.calculator.mod.common.block.misc;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sonar.calculator.mod.Calculator;
import sonar.calculator.mod.common.tileentity.misc.TileEntityMagneticFlux;
import sonar.calculator.mod.network.CalculatorGui;
import sonar.core.common.block.SonarMachineBlock;
import sonar.core.utils.SonarMaterials;

public class MagneticFlux extends SonarMachineBlock {

	public MagneticFlux() {
		super(SonarMaterials.machine);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
	}

	public boolean hasSpecialRenderer() {
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityMagneticFlux();
	}

	@Override
	public boolean operateBlock(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
		if (player != null) {
			if (!world.isRemote) {
				player.openGui(Calculator.instance, CalculatorGui.MagneticFlux, world, x, y, z);
			}
		}
		return true;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		super.canPlaceBlockAt(world, x, y, z);
		for (int Y = Math.max(y - 4, 0); Y < Math.min(256, y + 4); Y++) {
			for (int X = x - 4; X <= x + 4; X++) {
				for (int Z = z - 4; Z <= z + 4; Z++) {
					if (world.getBlock(X, Y, Z) == Calculator.magneticFlux) {
						return false;
					}
				}
			}
		}
		return true;
	}

}

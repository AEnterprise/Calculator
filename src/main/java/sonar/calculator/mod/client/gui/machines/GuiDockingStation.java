package sonar.calculator.mod.client.gui.machines;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import sonar.calculator.mod.Calculator;
import sonar.calculator.mod.CalculatorConfig;
import sonar.calculator.mod.common.containers.ContainerDockingStation;
import sonar.calculator.mod.common.recipes.RecipeRegistry;
import sonar.calculator.mod.common.tileentity.machines.TileEntityDockingStation;
import sonar.core.utils.helpers.FontHelper;

public class GuiDockingStation extends GuiContainer {
	public static final ResourceLocation calculatorTex = new ResourceLocation("Calculator:textures/gui/dockingstation/calculator.png");
	public static final ResourceLocation scientificTex = new ResourceLocation("Calculator:textures/gui/dockingstation/scientific.png");
	public static final ResourceLocation atomicTex = new ResourceLocation("Calculator:textures/gui/dockingstation/atomic.png");
	public static final ResourceLocation flawlessTex = new ResourceLocation("Calculator:textures/gui/dockingstation/flawless.png");

	public TileEntityDockingStation entity;

	public GuiDockingStation(InventoryPlayer inventoryPlayer, TileEntityDockingStation entity) {
		super(new ContainerDockingStation(inventoryPlayer, entity));

		this.entity = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		FontHelper.textCentre(FontHelper.translate(entity.getInventoryName()), xSize, 6, 0);
		FontHelper.textCentre(FontHelper.formatStorage(entity.storage.getEnergyStored()), this.xSize, 64, 2);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		if (entity.calcStack != null) {
			if (entity.calcStack.getItem() == Calculator.itemCalculator) {
				Minecraft.getMinecraft().getTextureManager().bindTexture(calculatorTex);
				drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
				if (this.entity.currentSpeed != 0 && this.entity.cookTime != 0) {
					int l = this.entity.cookTime * 13 / this.entity.currentSpeed;
					drawTexturedModalRect(this.guiLeft + 109, this.guiTop + 34, 176, 10, l, 7);
				}
			}
			if (entity.calcStack.getItem() == Calculator.itemScientificCalculator) {
				Minecraft.getMinecraft().getTextureManager().bindTexture(scientificTex);
				drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
				if (this.entity.currentSpeed != 0 && this.entity.cookTime != 0) {
					int l = this.entity.cookTime * 13 / this.entity.currentSpeed;
					drawTexturedModalRect(this.guiLeft + 109, this.guiTop + 34, 176, 10, l, 7);
				}
			}
			if (entity.calcStack.getItem() == Item.getItemFromBlock(Calculator.atomiccalculatorBlock)) {
				Minecraft.getMinecraft().getTextureManager().bindTexture(atomicTex);
				drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
				if (this.entity.currentSpeed != 0 && this.entity.cookTime != 0) {
					int l = this.entity.cookTime * 11 / this.entity.currentSpeed;
					drawTexturedModalRect(this.guiLeft + 110, this.guiTop + 35, 176, 10, l, 7);
				}
			}
			if (entity.calcStack.getItem() == Calculator.itemFlawlessCalculator) {
				Minecraft.getMinecraft().getTextureManager().bindTexture(flawlessTex);
				drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
				if (this.entity.currentSpeed != 0 && this.entity.cookTime != 0) {
					int l = this.entity.cookTime * 11 / this.entity.currentSpeed;
					drawTexturedModalRect(this.guiLeft + 131, this.guiTop + 38, 176, 10, l, 7);
				}
			}
		}

		int k = this.entity.storage.getEnergyStored() * 78 / this.entity.storage.getMaxEnergyStored();
		int j = 78 - k;
		drawTexturedModalRect(this.guiLeft + 49, this.guiTop + 63, 176, 0, k, 10);

	}
}

package krelox.metallurgychests.blocks.gui;

import it.hurts.metallurgy_reforged.material.ModMetals;
import krelox.metallurgychests.Tags;
import krelox.metallurgychests.blocks.containers.ContainerSilverChest;
import krelox.metallurgychests.blocks.tileentities.TileEntitySilverChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiSilverChest extends GuiContainer
{
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Tags.MOD_ID, "textures/gui/silver_chest.png");
	private final TileEntitySilverChest te;
	
	public GuiSilverChest(InventoryPlayer playerInventory, TileEntitySilverChest chestInventory, EntityPlayer player) 
	{
		super(new ContainerSilverChest(playerInventory, chestInventory, player));
		this.te = chestInventory;
		
		this.xSize = 176;
		this.ySize = 260;
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 10, 9, ModMetals.SILVER.getStats().getColorHex());
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		GuiSilverChest.drawModalRectWithCustomSizedTexture(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize, 256, 260);
	}
}
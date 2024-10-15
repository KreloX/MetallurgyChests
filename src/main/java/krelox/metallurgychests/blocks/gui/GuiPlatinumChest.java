package krelox.metallurgychests.blocks.gui;

import it.hurts.metallurgy_reforged.material.ModMetals;
import krelox.metallurgychests.Tags;
import krelox.metallurgychests.blocks.containers.ContainerPlatinumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityPlatinumChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiPlatinumChest extends GuiContainer
{
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Tags.MOD_ID, "textures/gui/platinum_chest.png");
	private final TileEntityPlatinumChest te;
	
	public GuiPlatinumChest(InventoryPlayer playerInventory, TileEntityPlatinumChest chestInventory, EntityPlayer player) 
	{
		super(new ContainerPlatinumChest(playerInventory, chestInventory, player));
		this.te = chestInventory;
		
		this.xSize = 230;
		this.ySize = 278;
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
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 10, 9, ModMetals.PLATINUM.getStats().getColorHex());
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		GuiPlatinumChest.drawModalRectWithCustomSizedTexture(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize, 256, 278);
	}
}
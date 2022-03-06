package krelox.metallurgychests.blocks.gui;

import it.hurts.metallurgy_reforged.material.ModMetals;
import krelox.metallurgychests.blocks.containers.ContainerRubraciumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityRubraciumChest;
import krelox.metallurgychests.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiRubraciumChest extends GuiContainer
{
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MODID + ":textures/gui/rubracium_chest.png");
	private final TileEntityRubraciumChest te;
	
	public GuiRubraciumChest(InventoryPlayer playerInventory, TileEntityRubraciumChest chestInventory, EntityPlayer player) 
	{
		super(new ContainerRubraciumChest(playerInventory, chestInventory, player));
		this.te = chestInventory;
		
		this.xSize = 194;
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
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 10, 9, ModMetals.RUBRACIUM.getStats().getColorHex());
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		GuiRubraciumChest.drawModalRectWithCustomSizedTexture(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize, 256, 278);
	}
}
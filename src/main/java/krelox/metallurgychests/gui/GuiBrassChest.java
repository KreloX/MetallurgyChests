package krelox.metallurgychests.gui;

import it.hurts.metallurgy_reforged.material.ModMetals;
import krelox.metallurgychests.Tags;
import krelox.metallurgychests.container.ContainerBrassChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiBrassChest extends GuiContainer {
    private static final ResourceLocation CHEST_GUI_TEXTURE = new ResourceLocation(Tags.MOD_ID, "textures/gui/brass_chest.png");
    private final IInventory chestInventory;

    public GuiBrassChest(IInventory playerInventory, IInventory chestInventory, EntityPlayer player) {
        super(new ContainerBrassChest(playerInventory, chestInventory, player));
        this.chestInventory = chestInventory;

        xSize = 176;
        ySize = 224;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        fontRenderer.drawString(chestInventory.getDisplayName().getUnformattedText(), 10, 9, ModMetals.BRASS.getStats().getColorHex());
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(CHEST_GUI_TEXTURE);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
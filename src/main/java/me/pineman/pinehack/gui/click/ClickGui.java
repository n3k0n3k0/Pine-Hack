package me.pineman.pinehack.gui.click;

import me.pineman.pinehack.Main;
import me.pineman.pinehack.module.Category;
import me.pineman.pinehack.module.Module;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class ClickGui extends GuiScreen {

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        drawRect(150, 2, 220, 14, 0x80000000);
        mc.fontRenderer.drawString("Client", 152, 4, 0xffffffff);
        drawRect(250, 2, 322, 14, 0x80000000);
        mc.fontRenderer.drawString("Combat", 252, 4, 0xffffffff);
        drawRect(350, 2, 432, 14, 0x80000000);
        mc.fontRenderer.drawString("Exploits", 352, 4, 0xffffffff);
        drawRect(450, 2, 506, 14, 0x80000000);
        mc.fontRenderer.drawString("Movement", 452, 4, 0xffffffff);
        drawRect(550, 2, 612, 14, 0x80000000);
        mc.fontRenderer.drawString("Render", 552, 4, 0xffffffff);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public int placeForHackY(Module m) {

        if(m.getCategory().equals(Category.COMBAT)) return Category.placeInListCombat(m) * 14;
        if(m.getCategory().equals(Category.CLIENT)) return Category.placeInListClient(m) * 14;
        if(m.getCategory().equals(Category.EXPLOITS)) return Category.placeInListExploits(m) * 14;
        if(m.getCategory().equals(Category.MOVEMENT)) return Category.placeInListMovement(m) * 14;
        if(m.getCategory().equals(Category.RENDER)) return Category.placeInListRender(m) * 14;

        return 0;
    }

    public int placeForHackX(Module m) {

        if(m.getCategory().equals(Category.COMBAT)) return 150;
        if(m.getCategory().equals(Category.CLIENT)) return 250;
        if(m.getCategory().equals(Category.EXPLOITS)) return 350;
        if(m.getCategory().equals(Category.MOVEMENT)) return 450;
        if(m.getCategory().equals(Category.RENDER)) return 550;

        return 0;
    }

    @Override
    public void initGui() {
        for(int i = 1; i < Main.moduleManager.getModules(); i++) {
            Module m = Main.moduleManager.getModuleList().get(i);
            buttonList.add(new GuiButton(i, placeForHackX(m), placeForHackY(m), 25 + (m.getName().length() * 3) + m.getName().length(), 14, m.getName()));
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        for(int i = 1; i < Main.moduleManager.getModules(); i++) {
            if(button.id == i) {
                Main.moduleManager.getModuleList().get(i).toggle();
            }
        }
    }
}

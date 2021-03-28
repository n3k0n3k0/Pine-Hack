package me.pineman.pinehack.ui;

import me.pineman.pinehack.Main;
import me.pineman.pinehack.module.Module;
import me.pineman.pinehack.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Hud extends Gui {

    private Minecraft mc = Minecraft.getMinecraft();

    public static class ModuleComparator implements Comparator<Module> {

        @Override
        public int compare(Module arg0, Module arg1) {
            if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
                return -1;
            }
            if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
                return 1;
            }
            return 0;
        }
    }

    private final ResourceLocation watermark = new ResourceLocation(Reference.MOD_ID, "textures/watermark.png");

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        Collections.sort(Main.moduleManager.modules, new ModuleComparator());
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;
        // I tried to render watermark but no work
        if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
            mc.renderEngine.bindTexture(watermark);
            drawScaledCustomSizeModalRect(0, 20, 0, 0,50, 50, 50,50, 50, 50);
        }

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            fr.drawStringWithShadow("Pine Hack" + " " + Reference.VERSION, 2, 1, 0xffffffff);
            fr.drawStringWithShadow("Fps: " + Minecraft.getDebugFPS(), 2, 10, 0xffffffff);
        }

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            int y = 2;
            final int[] counter = {1};
            for (Module mod : Main.moduleManager.getModuleList())
                if (!mod.getName().equalsIgnoreCase("") && mod.isToggled()) {
                    fr.drawStringWithShadow(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 2, y, rainbow(counter[0] * 300));
                    y += fr.FONT_HEIGHT;
                    counter[0]++;
                }
        }
    }
        public static int rainbow(int delay) {
            double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
            rainbowState %= 360;
            return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}

package me.pineman.pinehack.module.modules.render;

import me.pineman.pinehack.module.Category;
import me.pineman.pinehack.module.Module;
import net.minecraft.client.Minecraft;

public class NoRender extends Module {
    Minecraft mc = Minecraft.getMinecraft();
    public NoRender() {
        super("NoRender", "Doesnt render certain things", Category.RENDER);
    }

    @Override
    public void onEnable() {
        mc.player.sendChatMessage("Penis");
        this.toggle();
    }
}

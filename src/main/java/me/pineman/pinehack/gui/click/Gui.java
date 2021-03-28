package me.pineman.pinehack.gui.click;

import me.pineman.pinehack.module.Category;
import me.pineman.pinehack.module.Module;
import org.lwjgl.input.Keyboard;

import static me.pineman.pinehack.util.Util.mc;

public class Gui extends Module {
    public Gui() {
        super("ClickGui", "i think its pretty obvious what this is", Category.RENDER);
        this.setKey(Keyboard.KEY_RSHIFT);
    }

    public void onEnable() {
        mc.displayGuiScreen(new ClickGui());
    }
}

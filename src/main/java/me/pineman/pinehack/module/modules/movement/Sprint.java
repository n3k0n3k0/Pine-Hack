package me.pineman.pinehack.module.modules.movement;

import me.pineman.pinehack.module.Category;
import me.pineman.pinehack.module.Module;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", "auto runs when you hold w", Category.MOVEMENT);
        this.setKey(Keyboard.KEY_M);
    }
}

package me.pineman.pinehack.module.modules.movement;

import me.pineman.pinehack.module.Category;
import me.pineman.pinehack.module.Module;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class AutoWalk extends Module {
    public AutoWalk() {
        super("AutoWalk", "Automatically moves forward", Category.MOVEMENT);
        this.setKey(Keyboard.KEY_N);
    }

    @SubscribeEvent
    public void onUpdateInput(InputUpdateEvent event) {
        event.getMovementInput().moveForward = 1.0f;
    }
}
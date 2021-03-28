package me.pineman.pinehack.module.modules.movement;

import java.util.Objects;

import me.pineman.pinehack.module.Category;
import me.pineman.pinehack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import org.lwjgl.input.Keyboard;

public class AntiLevitate extends Module {
    public AntiLevitate() {
        super("AntiLevitate", "Removes shulker levitation", Category.MOVEMENT);
    }

    public void onUpdate() {
        if (Minecraft.getMinecraft().player.isPotionActive(Objects.requireNonNull(Potion.getPotionFromResourceLocation((String)"Levitation")))) {
            Minecraft.getMinecraft().player.removeActivePotionEffect(Potion.getPotionFromResourceLocation((String)"Levitation"));
        }
    }
}

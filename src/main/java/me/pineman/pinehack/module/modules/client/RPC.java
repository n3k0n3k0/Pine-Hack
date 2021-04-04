package me.pineman.pinehack.module.modules.client;

import me.pineman.pinehack.module.Category;
import me.pineman.pinehack.module.Module;
import me.pineman.pinehack.rpc.Discord;
import org.lwjgl.input.Keyboard;

public class RPC extends Module {

    public RPC() {
        super("Discord RPC", "Custom Discord rich presence for Pinehack", Category.CLIENT);
        this.setKey(Keyboard.KEY_M);
    }

    public void onEnable(){
        Discord.startRPC();
    }

    public void onDisable(){
        Discord.stopRPC();
    }

}

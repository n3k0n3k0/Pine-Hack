package me.pineman.pinehack;

import me.pineman.pinehack.module.Module;
import me.pineman.pinehack.module.ModuleManager;
import me.pineman.pinehack.proxy.CommonProxy;
import me.pineman.pinehack.rpc.Discord;
import me.pineman.pinehack.ui.Hud;
import me.pineman.pinehack.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.input.Keyboard;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    public static ModuleManager moduleManager;
    public static Hud hud;
    public static final Logger LOGGER = LogManager.getLogger((String)"Pineman");

    @Instance
    public Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void PreInt (FMLPreInitializationEvent event) {
        LOGGER.info("pinehack fucked your mom -Pineman");
        LOGGER.info("cat cat small cat");
    }

    @EventHandler
    public void init (FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(instance);
        MinecraftForge.EVENT_BUS.register(new Hud());
        moduleManager = new ModuleManager();
        hud = new Hud();
        Display.setTitle((String)"Pinehack - v" + Reference.VERSION);
    }

    @EventHandler
    public void PostInit (FMLPreInitializationEvent event) {

    }

    @SubscribeEvent
    public void key(KeyInputEvent e) {
        if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
            return;
        try {
            if(Keyboard.isCreated()) {
                if(Keyboard.getEventKeyState()) {
                    int keyCode = Keyboard.getEventKey();
                    if(keyCode <= 0)
                        return;
                    for(Module m : moduleManager.modules) {
                        if(m.getKey() == keyCode && keyCode > 0) {
                            m.toggle();
                        }
                    }

                }
            }
            } catch (Exception q) { q.printStackTrace(); }
    }
}

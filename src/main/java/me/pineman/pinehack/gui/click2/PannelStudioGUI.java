package me.pineman.pinehack.gui.click2;

//source: https://github.com/lukflug/PanelStudio

import com.lukflug.panelstudio.ClickGUI;
import com.lukflug.panelstudio.Interface;
import com.lukflug.panelstudio.mc12.MinecraftGUI;
import com.lukflug.panelstudio.settings.Toggleable;
import com.lukflug.panelstudio.theme.Theme;
import org.lwjgl.util.Color;
import org.lwjgl.util.Point;

public class CoolGUI extends MinecraftGUI {
    private final Toggleable colorToggle;
    private final Interface guiInterface;
    private final Theme theme;
    private final ClickGUI gui;

    public CoolGUI() {
        // Initialize necessary fields
        colorToggle = CoolSettings.colorModel; // <-- Toggleable indicating whether to use the RGB or HSB model for color settings
        guiInterface = new GUIInterface(true) {
            @Override
            protected String getResourcePrefix() {
                return "coolhack:gui/";
            }

            @Override
            public void drawString(Point pos, String s, Color c) {
                end();
                CoolFont.drawString(s,pos.x,pos.y,c);
                begin();
            }

            @Override
            public int getFontWidth(String s) {
                return CoolFont.getFontWidth(s);
            }

            @Override
            public int getFontHeight() {
                return CoolFont.getFontHeight();
            }
        };
        theme=new GameSenseTheme(new SettingsColorScheme(CoolSettings.activeColor,CoolSettings.inactiveColor,CoolSettings.backgroundColor,CoolSettings.outlineColor,CoolSettings.fontColor,CoolSettings.opacity),height,2,5); // <-- Can be replaced by another theme (could be a custom one)
        gui=new ClickGUI(guiInterface,null);
        // Populate the ClickGUI with modules and settings
        for (CoolCategory category: categories) {
            DraggableContainer panel=new DraggableContainer(category.name,null,theme.getPanelRenderer(),new SimpleToggleable(false),new SettingsAnimation(CoolSettings.animationSpeed),null,new Point(x,y),width); // <-- Width and default position of the panels needs to be defined
            gui.addComponent(panel);
            for (CoolModule module: category) {
                CollapsibleContainer container=new CollapsibleContainer(module.name,null,theme.getContainerRenderer(),new SimpleToggleable(false),new SettingsAnimation(CoolSettings.animationSpeed),module); // <-- It is recommended that the module-class implements Toggleable
                panel.addComponent(container);
                for (CoolSetting setting: module) {
                    if (setting instanceof Toggleable) container.addComponent(new BooleanComponent(setting.name,null,theme.getComponentRenderer(),(Toggleable)setting));
                    else if (setting instanceof NumberSetting) container.addComponent(new NumberComponent(setting.name,null,theme.getComponentRenderer(),(NumberSetting)setting,setting.min,setting.max));
                    else if (setting instanceof EnumSetting) container.addComponent(new EnumComponent(setting.name,null,theme.getComponentRenderer(),(EnumSetting)setting));
                    else if (setting instanceof ColorSetting) container.addComponent(new ColorComponent(setting.name,null,theme.getContainerRenderer(),new SettingsAnimation(CoolSettings.animationSpeed),theme.getComponentRenderer(),(ColorSetting)setting,setting.alpha,setting.rainbowEnabled,colorToggle));
                }
                container.addComponent(new KeybindComponent(theme.getComponentRenderer(),module.getKeybind()));
            }
        }
    }

    @Override
    protected ClickGUI getGUI() {
        return gui;
    }

    @Override
    protected GUIInterface getInterface() {
        return guiInterface;
    }

    @Override
    protected int getScrollSpeed() {
        return CoolSettings.scrollSpeed.getValue();
    }
}

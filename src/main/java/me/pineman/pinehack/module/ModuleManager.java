package me.pineman.pinehack.module;

import me.pineman.pinehack.Main;
import me.pineman.pinehack.gui.click.Gui;
import me.pineman.pinehack.module.modules.combat.AutoArmor;
import me.pineman.pinehack.module.modules.movement.AntiLevitate;
import me.pineman.pinehack.module.modules.movement.AutoWalk;
import me.pineman.pinehack.module.modules.movement.Sprint;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public ArrayList<Module> modules;

    public ModuleManager() {
        (modules = new ArrayList<Module>()).clear();
        //movement
        this.modules.add(new Sprint());
        this.modules.add(new AutoWalk());
        this.modules.add(new AntiLevitate());
        //combat
        this.modules.add(new AutoArmor());
        //render
        this.modules.add(new Gui());
    }

    public Module getModule (String name) {
        for(Module m : this.modules) {
            if(m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Module> getModuleList() {
        return this.modules;
    }

    public int getModules() {
        return modules.size();
    }

    public static List<Module> getModulesByCategory(Category c) {
        List<Module> modules = new ArrayList<Module>();

        for(Module m : Main.moduleManager.modules) {
            if(m.getCategory() == c)
                modules.add(m);
        }
        return modules;
    }


}

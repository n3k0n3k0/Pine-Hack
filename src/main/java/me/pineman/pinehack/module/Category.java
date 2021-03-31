package me.pineman.pinehack.module;

import me.pineman.pinehack.Main;

public enum Category {
    COMBAT("Combat"), RENDER("Render"), MOVEMENT("Movement"), CLIENT("Client");

    public String name;
    public int moduleIndex;

    Category(String name) {
        this.name = name;
    }
    public static int size(Category cat) {
        int i = 0;

        for(Module m : Main.moduleManager.getModuleList()) {
            if(m.getCategory().equals(cat)) {
                i++;
            }
        }

        return 0;
    }

    public static int placeInListRender(Module m) {
        int i = 0;

        for(Module mod : Main.moduleManager.getModuleList()) {
            if(mod.getCategory().equals(RENDER) && !mod.equals(m)) {
                i++;
                continue;
            }

            if(mod.getCategory().equals(RENDER) && mod.equals(m)) {
                return i;
            }
        }

        return 0;
    }

    public static int placeInListCombat(Module m) {
        int i = 1;

        for(Module mod : Main.moduleManager.getModuleList()) {
            if(mod.getCategory().equals(COMBAT) && !mod.equals(m)) {
                i++;
                continue;
            }

            if(mod.getCategory().equals(COMBAT) && mod.equals(m)) {
                return i;
            }
        }

        return 0;
    }

    public static int placeInListMovement(Module m) {
        int i = 1;

        for(Module mod : Main.moduleManager.getModuleList()) {
            if(mod.getCategory().equals(MOVEMENT) && !mod.equals(m)) {
                i++;
                continue;
            }

            if(mod.getCategory().equals(MOVEMENT) && mod.equals(m)) {
                return i;
            }
        }

        return 0;
    }

    public static int placeInListClient(Module m) {
        int i = 1;

        for(Module mod : Main.moduleManager.getModuleList()) {
            if(mod.getCategory().equals(CLIENT) && !mod.equals(m)) {
                i++;
                continue;
            }

            if(mod.getCategory().equals(CLIENT) && mod.equals(m)) {
                return i;
            }
        }

        return 0;
    }
}

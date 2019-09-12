package uvmidnight.totaltinkers;


import net.minecraftforge.common.config.Configuration;
import uvmidnight.totaltinkers.experimental.Experimental;
import uvmidnight.totaltinkers.newweapons.NewWeapons;
import uvmidnight.totaltinkers.oldweapons.OldWeapons;

import java.util.ArrayList;

public class ModConfig {

    public static void readConfig(ArrayList<IModule> Modules) {
        Configuration cfg = TotalTinkers.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e) {
            TotalTinkers.logger.warn("Problem loading config file!", e);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }


    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment("Enabled Modules", "What Modules are enabled");
        boolean oldWeapons = cfg.getBoolean("Old Weapons Enabled?", "Enabled Modules", true, "Should the old 1.7 weapons be added, born anew");
        boolean newWeapons = cfg.getBoolean("New Weapons Enabled?", "Enabled Modules", true, "Should new relatively polished weapons be added");
        boolean experimental = cfg.getBoolean("Experimental Enabled?", "Enabled Modules", true, "Should the experimental module be enabled. Nothing in the module is enabled by default");
        if (oldWeapons) {
            TotalTinkers.Modules.add(new OldWeapons());
        }

        if (newWeapons) {
            TotalTinkers.Modules.add(new NewWeapons());
        }
        if (experimental) {
            TotalTinkers.Modules.add(new Experimental());
        }

        for (IModule module : TotalTinkers.Modules) {
            module.buildConfig(cfg);
        }
    }

}

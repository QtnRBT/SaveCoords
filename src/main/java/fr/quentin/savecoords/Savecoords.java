package fr.quentin.savecoords;

import fr.quentin.savecoords.commands.SaveCoordsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Savecoords extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getCommand("save-coords").setExecutor(new SaveCoordsCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

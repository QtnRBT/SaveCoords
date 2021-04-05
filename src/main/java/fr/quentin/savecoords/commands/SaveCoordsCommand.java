package fr.quentin.savecoords.commands;

import fr.quentin.savecoords.Savecoords;
import fr.quentin.savecoords.utils.DiscordWebhook;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SaveCoordsCommand implements CommandExecutor {

    private Savecoords main;

    public SaveCoordsCommand(Savecoords savecoords) {
        this.main = savecoords;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getLabel().equalsIgnoreCase("save-coords")) {
            if(sender instanceof Player) {

                Player p = (Player) sender;
                Location l = p.getLocation();
                int x = l.getBlockX();
                int y = l.getBlockY();
                int z = l.getBlockZ();
                World w = l.getWorld();

                String text = "";

                for (String arg : args) {
                    text += arg + " ";
                }

                if(w.getEnvironment() == World.Environment.NORMAL) {
                    String s = main.getConfig().getString("webhook-url-overworld");
                    String content = "(" + w.getName() + ")" + "`" + x + " " + y + " " + z + "` : " + text;
                    DiscordWebhook dw = new DiscordWebhook(s);
                    dw.setContent(content);
                    try {
                        dw.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if(w.getEnvironment() == World.Environment.NETHER) {
                    String s = main.getConfig().getString("webhook-url-nether");
                    String content = "(" + w.getName() + ")" + "`" + x + " " + y + " " + z + "` : " + text;
                    DiscordWebhook dw = new DiscordWebhook(s);
                    dw.setContent(content);
                    try {
                        dw.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if(w.getEnvironment() == World.Environment.THE_END) {
                    String s = main.getConfig().getString("webhook-url-the-end");
                    String content = "(" + w.getName() + ")" + "`" + x + " " + y + " " + z + "` : " + text;
                    DiscordWebhook dw = new DiscordWebhook(s);
                    dw.setContent(content);
                    try {
                        dw.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return false;
    }
}

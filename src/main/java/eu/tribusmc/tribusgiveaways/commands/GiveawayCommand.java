package eu.tribusmc.tribusgiveaways.commands;

import eu.tribusmc.tribusgiveaways.commands.sub.AddRewardCommand;
import org.bukkit.command.CommandSender;

public class GiveawayCommand extends CommandManager{


    public GiveawayCommand() {
        super("giveaway", "tribus.admin", false);

        super.registerSubCommand(new AddRewardCommand());
    }

    @Override
    protected void execute(CommandSender sender, String[] args) {





    }
}

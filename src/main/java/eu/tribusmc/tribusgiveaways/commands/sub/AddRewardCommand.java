package eu.tribusmc.tribusgiveaways.commands.sub;

import eu.tribusmc.tribusgiveaways.Core;
import eu.tribusmc.tribusgiveaways.WinnerPlace;
import eu.tribusmc.tribusgiveaways.objects.Reward;
import eu.tribusmc.tribusgiveaways.objects.Winner;
import eu.tribusmc.tribusgiveaways.storage.RewardCollector;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class AddRewardCommand extends SubCommand {

    public AddRewardCommand() {
        super("giveaway", "addreward", "tribus.admin", "<winnerplace> <command>");
    }

    @Override
    public void executeSub(CommandSender s, String[] args) {
        if (args.length < 1) {
            s.sendMessage("testing");
            return;
        }

        String winnerPlace = args[0];

        if (!isMatching(winnerPlace)) {
            s.sendMessage("lalallalalalal");
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < args.length; i++) {
            stringBuilder.append(args[i]).append(" ");
        }


        Reward reward = null;

        if (Core.i.getRewardCollector().getRewards() != null) {

            if (Core.i.getRewardCollector().isCollected(WinnerPlace.valueOf(winnerPlace))) {
                reward = Core.i.getRewardCollector().fetchByWinnerPlace(WinnerPlace.valueOf(winnerPlace));
                Core.i.getRewardCollector().getRewards().remove(reward);
                reward.getCommands().add(stringBuilder.toString());
                Core.i.getRewardCollector().collect(reward);
            }
        }


        Core.i.getRewardCollector().collect(new Reward(WinnerPlace.valueOf(winnerPlace), stringBuilder.toString()));
    }


    private boolean isMatching(String winnerPlace) {
        return Arrays.stream(WinnerPlace.values()).filter(wp -> wp.name().equalsIgnoreCase(winnerPlace.toUpperCase(Locale.ROOT))).findFirst().orElse(null) != null;
    }
}

package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.command.AConversionCommand;

public class identityCommand extends AConversionCommand {
    @Override
    public double convert(int v) {
        return v;
    }

    @Override
    public String getName() {
        return "identity";
    }
}

package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.command.AConversionCommand;

public class identityCommand extends AConversionCommand {

    @Override
    public String getName() {
        return "identity";
    }
    @Override
    public double convert(double v) {
        return v;
    }
}

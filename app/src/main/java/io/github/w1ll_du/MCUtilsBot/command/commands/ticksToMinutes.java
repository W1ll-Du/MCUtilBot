package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.command.AConversionCommand;

public class ticksToMinutes extends AConversionCommand {

    @Override
    public String getName() {
        return "ticksToMinutes";
    }

    @Override
    public double convert(double v) {
        return v / 1200;
    }
}
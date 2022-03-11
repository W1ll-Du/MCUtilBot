package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.command.AConversionCommand;

public class ticksToHours extends AConversionCommand {

    @Override
    public String getName() {
        return "ticksToHours";
    }

    @Override
    public double convert(int v) {
         return v / 72000.0;
    }
}
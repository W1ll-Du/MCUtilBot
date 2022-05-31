package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.command.AConversionCommand;

public class cmToMCommand extends AConversionCommand {

    @Override
    public String getName() {
        return "cmToM";
    }

    @Override
    public double convert(double v) {
        return v / 100;
    }
}
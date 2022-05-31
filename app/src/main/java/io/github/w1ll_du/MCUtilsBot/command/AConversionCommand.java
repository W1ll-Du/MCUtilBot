package io.github.w1ll_du.MCUtilsBot.command;

public abstract class AConversionCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        if (ctx.getArgs().size() == 0) {
            ctx.getChannel().sendMessage("Missing Arguments: [value]").queue();
            return;
        }
        try {
            ctx.getChannel().sendMessage(String.valueOf(convert(Double.parseDouble(ctx.getArgs().get(0))))).queue();
        } catch (NumberFormatException e) {
            ctx.getChannel().sendMessage("Not a number").queue();
        }
    }

    @Override
    public AConversionCommand getConverter() {
        return this;
    }

    public abstract double convert(double v);
}

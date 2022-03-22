package io.github.w1ll_du.MCUtilsBot.command;

public abstract class AConversionCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        if (ctx.getArgs().size() < 1) {
            ctx.getChannel().sendMessage("Missing Arguments: [value]]").queue();
            return;
        }
        ctx.getChannel().sendMessage(String.valueOf(convert(Integer.parseInt(ctx.getArgs().get(0))))).queue();
    }

    @Override
    public AConversionCommand getConverter() {
        return this;
    }

    public abstract double convert(int v);
}

package main.program.Commands;

import main.program.Data;
import main.program.Factory.ICommand;

public class POP implements ICommand {

    @Override
    public void doCommand(String[] com_args, Data calcData) {
        calcData.pop_stack();
    }
}

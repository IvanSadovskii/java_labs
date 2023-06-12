package main.program.Commands;

import main.program.Data;
import main.program.Factory.ICommand;
import java.util.EmptyStackException;

public class POP implements ICommand {

    @Override
    public void doCommand(String[] com_args, Data calcData) {
        try {
            calcData.pop_stack();
        }
        catch (EmptyStackException ex){
            ex.printStackTrace();
        }
    }
}

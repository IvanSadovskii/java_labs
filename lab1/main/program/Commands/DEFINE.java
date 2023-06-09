package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;

public class DEFINE implements ICommand{
    @Override
    public void doCommand(String[] com_args, Data calcData) {
        calcData.putKeyValue(com_args[1], Double.valueOf(com_args[2]));
    }
}

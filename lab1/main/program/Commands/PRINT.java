package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;

public class PRINT implements ICommand{
    @Override
    public void doCommand(String[] com_args, Data calcData) {
        System.out.println(calcData.getTopElem());
    }
}

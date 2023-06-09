package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;

public class SQRT implements ICommand{
    @Override
    public void doCommand(String[] com_args, Data calcData) {
        Double first_value = calcData.getTopElem();
        calcData.pop_stack();
        //обработать

        calcData.push_stack(Math.sqrt(first_value));
    }
}

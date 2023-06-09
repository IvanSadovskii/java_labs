package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;
import static main.program.Exeption.isNumeric;

public class PUSH implements ICommand{

    @Override
    public void doCommand(String[] com_args, Data calcData) {
        if (isNumeric(com_args[1])){
            calcData.push_stack(Double.valueOf(com_args[1]));
        }
        else {
            calcData.push_stack(calcData.getKeyValue(com_args[1]));
        }
    }
}

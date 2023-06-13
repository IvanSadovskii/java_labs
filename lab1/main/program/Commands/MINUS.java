package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;
import java.util.EmptyStackException;

public class MINUS implements ICommand{
    @Override
    public void doCommand(String[] com_args, Data calcData) {
        try {
            Double first_value = calcData.getTopElem();
            calcData.pop_stack();
            Double second_value = calcData.getTopElem();
            calcData.pop_stack();
            //обработать

            calcData.push_stack(first_value - second_value);
        }
        catch (EmptyStackException ex){
            ex.printStackTrace();
            throw new EmptyStackException();
        }
    }
}

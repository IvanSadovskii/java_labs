package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;

public class DIVIDE implements ICommand{
    @Override
    public void doCommand(String[] com_args, Data calcData) {
        Double first_value = calcData.getTopElem();
        calcData.pop_stack();
        Double second_value = calcData.getTopElem();
        calcData.pop_stack();
        //обработать + проверка второго на 0

        calcData.push_stack(first_value/second_value);
    }
}

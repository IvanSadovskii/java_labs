package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;
import java.util.EmptyStackException;

public class SQRT implements ICommand{
    @Override
    public void doCommand(String[] com_args, Data calcData) {
        try {
            Double first_value = calcData.getTopElem();
            if (first_value < 0){
                throw new ArithmeticException("Ошибка: вычисляется корень из отрицательного числа");
            }
            calcData.pop_stack();

            calcData.push_stack(Math.sqrt(first_value));
        }
        catch (EmptyStackException | ArithmeticException ex){
            ex.printStackTrace();
        }
    }
}

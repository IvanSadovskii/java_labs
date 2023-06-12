package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;
import java.util.EmptyStackException;

public class DIVIDE implements ICommand{
    @Override
    public void doCommand(String[] com_args, Data calcData) {
        try {
            Double first_value = calcData.getTopElem();
            calcData.pop_stack();
            Double second_value = calcData.getTopElem();
            calcData.pop_stack();

            if (first_value == 0) {
                throw new ArithmeticException("Ошибка: деление на ноль");
            }

            calcData.push_stack(first_value / second_value);
        } catch (EmptyStackException | ArithmeticException ex) {
            ex.printStackTrace();
        }
    }

}

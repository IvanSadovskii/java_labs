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
            if (second_value == 0) {
                throw new ArithmeticException("Ошибка: деление на ноль");
            }
            else {
                calcData.pop_stack();
                calcData.push_stack(first_value / second_value);
            }

        } catch (EmptyStackException ex){
            ex.printStackTrace();
            throw new EmptyStackException();
        }
        catch (ArithmeticException ex){
            ex.printStackTrace();
            throw new ArithmeticException();
        }

    }

}

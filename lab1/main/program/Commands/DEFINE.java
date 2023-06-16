package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;
import main.program.InputCheck;
import java.util.InputMismatchException;
import main.program.CONSTS;

public class DEFINE implements ICommand{
    @Override
    public void doCommand(String[] com_args, Data calcData) {
        try {
            if (!(Character.isAlphabetic(com_args[CONSTS.SECOND_ELEM_ID].charAt(CONSTS.ZERO)) && InputCheck.isNumeric(com_args[CONSTS.THIRD_ELEM_ID]))){
                throw new InputMismatchException("Ошибка ввода аргументов команды");
            }
            calcData.putKeyValue(com_args[CONSTS.SECOND_ELEM_ID], Double.valueOf(com_args[CONSTS.THIRD_ELEM_ID]));
        }
        catch(InputMismatchException ex){
            ex.printStackTrace();
            throw new InputMismatchException();
        }
    }
}

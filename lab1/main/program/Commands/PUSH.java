package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import main.program.InputCheck;
import main.program.CONSTS;

public class PUSH implements ICommand{

    @Override
    public void doCommand(String[] com_args, Data calcData) {
            try {
                if (InputCheck.isNumeric(com_args[CONSTS.SECOND_ELEM_ID])) {
                    calcData.push_stack(Double.valueOf(com_args[CONSTS.SECOND_ELEM_ID]));
                } else {
                    if (!Character.isAlphabetic(com_args[CONSTS.SECOND_ELEM_ID].charAt(CONSTS.ZERO))){
                        throw new InputMismatchException("Ошибка ввода аргументов команды");
                    }
                    calcData.push_stack(calcData.getKeyValue(com_args[CONSTS.SECOND_ELEM_ID]));
                }
            }
            catch (NoSuchElementException ex){
                ex.printStackTrace();
                throw new NoSuchElementException();
            }
        }

}

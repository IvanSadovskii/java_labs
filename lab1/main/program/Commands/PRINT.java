package main.program.Commands;
import main.program.Data;
import main.program.Factory.ICommand;
import java.util.EmptyStackException;

public class PRINT implements ICommand{
    @Override
    public void doCommand(String[] com_args, Data calcData) {
        try {
            System.out.println(calcData.getTopElem());
        }
        catch (EmptyStackException ex){
            ex.printStackTrace();
            throw new EmptyStackException();
        }
    }
}

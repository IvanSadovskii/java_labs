package main.program.Factory;
import main.program.Data;

public interface ICommand {
    void doCommand (String[] com_args, Data calcData);
}


package main.program;

import main.program.Factory.FactoryCommand;
import main.program.Factory.ICommand;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        ICommand cmd = factory.setCommand("pop");
        data.push_stack(1.1);
        data.push_stack(2.1);
        cmd.doCommand(null, data);
        cmd = factory.setCommand("print");
        cmd.doCommand(null, data);
    }
}

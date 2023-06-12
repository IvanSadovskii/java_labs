package main.program.Factory;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;


public class FactoryCommand {
    private final Map<String, ICommand> commands = new HashMap<>(); //сюда кладем созданные комманды с фабрики по ключ значению

    public FactoryCommand() {

        InputStream in = FactoryCommand.class.getResourceAsStream("commandConfig.properties");
        Properties config = new Properties();
        try {
            config.load(in);

            for (String Command_name : config.stringPropertyNames()) {
                String clsName = config.getProperty(Command_name);
                ICommand cmd_obj = (ICommand) Class.forName(clsName).getDeclaredConstructor().newInstance();
                commands.put(Command_name, cmd_obj);
            }
        }
        catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex){
            ex.printStackTrace();
        }
    }

    public ICommand setCommand(String cmd_name){
        try {
            if (!commands.containsKey(cmd_name)){
                throw new NoSuchElementException("Ошибка ввода команды");
            }
        }
        catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
        return commands.get(cmd_name);
    }
}

package main.program.Factory;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;


public class FactoryCommand {
    private final Map<String, ICommand> commands = new HashMap<>(); //сюда кладем созданные комманды с фабрики по ключ значению

    public FactoryCommand() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InputStream in = FactoryCommand.class.getResourceAsStream("commandConfig.properties");
        Properties config = new Properties();
        config.load(in); // обработать

        for (String Command_name : config.stringPropertyNames()) {
            String clsName = config.getProperty(Command_name);
            ICommand cmd_obj = (ICommand) Class.forName(clsName).getDeclaredConstructor().newInstance();
            //тут с проки обработать + обработка стэка
            commands.put(Command_name, cmd_obj);
        }
    }

    public ICommand setCommand(String cmd_name){
        return commands.get(cmd_name);
    }
}

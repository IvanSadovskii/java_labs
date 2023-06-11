package main.program;

import main.program.Factory.FactoryCommand;
import main.program.Factory.ICommand;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        String[] input;

        try {
            File file = new File("C:\\Users\\black\\Desktop\\in.txt");
            // обработать
            Scanner scanner = new Scanner(file);
            //обработать
            while (scanner.hasNextLine()) {

                input = scanner.nextLine().split(" "); //убрать магию + обработать

                ICommand cmd = factory.setCommand(input[0]); // магия
                cmd.doCommand(input, data);

            }
        }
        catch (FileNotFoundException e){
            System.out.println("Ошибка при открытии файла, введите команды в консоль (для выхода exit)");
            Scanner console = new Scanner(System.in);
            String line_input;

            while (!(line_input = console.nextLine()).equals("exit")){
                //обработка
                input = line_input.split(" ");
                ICommand cmd = factory.setCommand(input[0]); // магия
                cmd.doCommand(input, data);

            }


        }

    }
}

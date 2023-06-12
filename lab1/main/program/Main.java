package main.program;

import main.program.Factory.FactoryCommand;
import main.program.Factory.ICommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        String[] input;


        try {
            File file = new File("in.txt");
            // обработать
            Scanner scanner = new Scanner(file);
            //обработать
            while (scanner.hasNextLine()) {

                input = scanner.nextLine().split(CONSTS.SPACE_SYMBOL); //убрать магию + обработать

                ICommand cmd = factory.setCommand(input[CONSTS.FIRST_ELEM_ID]); // магия
                cmd.doCommand(input, data);

            }
        }
        catch (FileNotFoundException e){
            System.err.println("Ошибка при открытии файла, введите команды в консоль (для выхода exit)");

            Scanner console = new Scanner(System.in);
            String line_input;

            while (!(line_input = console.nextLine()).equals("exit")){
                input = line_input.split(CONSTS.SPACE_SYMBOL);
                ICommand cmd = factory.setCommand(input[CONSTS.FIRST_ELEM_ID]);
                cmd.doCommand(input, data);

            }

        }

    }
}

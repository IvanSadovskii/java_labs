package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.program.*;
import main.program.Factory.*;
import java.util.EmptyStackException;
import java.util.InputMismatchException;


class calcTests {
    @Test
    public void Plus_test1() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "23"}, data);
        cmd.doCommand(new String[]{"push", "32"}, data);
        cmd = factory.setCommand("+");
        cmd.doCommand(null, data);

        assertEquals(55, data.getTopElem());
    }
    @Test
    public void Plus_test2() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "66.5"}, data);
        cmd.doCommand(new String[]{"push", "3.2"}, data);
        cmd = factory.setCommand("+");
        cmd.doCommand(null, data);

        assertEquals(69.7, data.getTopElem());
    }
    @Test
    public void Plus_test_empty() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "0"}, data);
        cmd = factory.setCommand("+");

        ICommand finalCmd = cmd;
        assertThrows(EmptyStackException.class, () -> finalCmd.doCommand(null, data));
    }

    @Test
    public void Minus_test1() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "-45"}, data);
        cmd.doCommand(new String[]{"push", "0"}, data);
        cmd = factory.setCommand("-");
        cmd.doCommand(null, data);

        assertEquals(45, data.getTopElem());
    }
    @Test
    public void Minus_test2() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "50"}, data);
        cmd.doCommand(new String[]{"push", "4.5"}, data);
        cmd = factory.setCommand("-");
        cmd.doCommand(null, data);

        assertEquals(-45.5, data.getTopElem());
    }
    @Test
    public void Minus_test_empty() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "0"}, data);
        cmd = factory.setCommand("-");

        ICommand finalCmd = cmd;
        assertThrows(EmptyStackException.class, () -> finalCmd.doCommand(null, data));
    }

    @Test
    public void Mul_test1() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "12"}, data);
        cmd.doCommand(new String[]{"push", "12"}, data);
        cmd = factory.setCommand("*");
        cmd.doCommand(null, data);

        assertEquals(144, data.getTopElem());
    }
    @Test
    public void Mul_test2() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "45"}, data);
        cmd.doCommand(new String[]{"push", "101"}, data);
        cmd = factory.setCommand("*");
        cmd.doCommand(null, data);

        assertEquals(4545, data.getTopElem());
    }
    @Test
    public void Mul_test_empty() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "0"}, data);
        cmd = factory.setCommand("*");

        ICommand finalCmd = cmd;
        assertThrows(EmptyStackException.class, () -> finalCmd.doCommand(null, data));
    }

    @Test
    public void Sqrt_test1() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "9"}, data);
        cmd = factory.setCommand("sqrt");
        cmd.doCommand(null, data);

        assertEquals(3, data.getTopElem());
    }
    @Test
    public void Sqrt_test2() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "144"}, data);
        cmd = factory.setCommand("sqrt");
        cmd.doCommand(null, data);

        assertEquals(12, data.getTopElem());
    }
    
    @Test
    public void Sqrt_test_empty() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();


        ICommand cmd  = factory.setCommand("sqrt");

        ICommand finalCmd = cmd;
        assertThrows(EmptyStackException.class, () -> finalCmd.doCommand(null, data));
    }

    @Test
    public void Sqrt_minus_val_test() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "-2"}, data);
        cmd = factory.setCommand("sqrt");

        ICommand finalCmd = cmd;
        assertThrows(ArithmeticException.class, () -> finalCmd.doCommand(null, data));
    }

    @Test
    public void div_By_Zero() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();


        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "0"}, data);
        cmd.doCommand(new String[]{"push", "123"}, data);
        cmd = factory.setCommand("/");

        ICommand finalCmd = cmd;
        assertThrows(ArithmeticException.class, () -> finalCmd.doCommand(null, data));
    }

    @Test
    public void Div_test1() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "5"}, data);
        cmd.doCommand(new String[]{"push", "45"}, data);
        cmd = factory.setCommand("/");
        cmd.doCommand(null, data);

        assertEquals(9, data.getTopElem());
    }

    @Test
    public void Div_test2() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "-7"}, data);
        cmd.doCommand(new String[]{"push", "686"}, data);
        cmd = factory.setCommand("/");
        cmd.doCommand(null, data);

        assertEquals(-98, data.getTopElem());
    }
    @Test
    public void Div_test_empty() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "0"}, data);
        cmd = factory.setCommand("/");

        ICommand finalCmd = cmd;
        assertThrows(EmptyStackException.class, () -> finalCmd.doCommand(null, data));
    }
    @Test
    public void push_test1() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "0"}, data);

        assertEquals(0, data.getTopElem());

    }

    @Test
    public void push_test2() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "a"}, data);

        assertEquals(null, data.getKeyValue("a"));

    }

    @Test
    public void pop_test() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        

        ICommand cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "0"}, data);
        cmd.doCommand(new String[]{"push", "1"}, data);

        cmd = factory.setCommand("pop");
        cmd.doCommand(null, data);

        assertEquals(0, data.getTopElem());
    }

    @Test
    public void define_test() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();
        

        ICommand cmd = factory.setCommand("define");
        cmd.doCommand(new String[]{"define", "a","4"}, data);
        cmd = factory.setCommand("push");
        cmd.doCommand(new String[]{"push", "a"}, data);

        assertEquals(4, data.getKeyValue("a"));
    }

    @Test
    public void define_wrong_test1() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("define");

        ICommand finalCmd = cmd;
        assertThrows(InputMismatchException.class, () -> finalCmd.doCommand(new String[]{"define", "-","4"}, data));
    }
    @Test
    public void define_wrong_test2() {
        Data data = new Data();
        FactoryCommand factory = new FactoryCommand();

        ICommand cmd = factory.setCommand("define");

        ICommand finalCmd = cmd;
        assertThrows(InputMismatchException.class, () -> finalCmd.doCommand(new String[]{"define", "a","-"}, data));
    }















}
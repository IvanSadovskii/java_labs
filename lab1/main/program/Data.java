package main.program;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Data {
    public Data() {
        param = new HashMap<>();
        stack = new Stack<Double>();
    }

    public Double getKeyValue (String key){
        return param.get(key);
    }
    public void putKeyValue (String key, Double value){
        param.put(key,value);
    }

    public Double getTopElem() {
        return stack.peek();
    }

    public void push_stack(Double value) {
        stack.push(value);
    }

    public void pop_stack() {
        stack.pop();
    }

    private Map<String, Double> param;
    private Stack<Double> stack;
}

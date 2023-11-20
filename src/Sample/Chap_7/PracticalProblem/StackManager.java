package Sample.Chap_7.PracticalProblem;
import java.util.*;

interface IStack<T> {
    T pop();
    boolean push(T ob);
}

class MyStack<T> implements IStack<T> {
    private Vector<T> stack = new Vector<T>();
    public T pop() {
        if (stack.isEmpty()) { return null; }
        T temp = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return temp;
    }

    public boolean push(T ob) {
        stack.add(ob);
        return true;
    }
}

public class StackManager {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();
        for (int i = 0; i < 10; i++) { stack.push(i); }
        while (true) {
            Integer n = stack.pop();
            if (n == null) { break; }
            System.out.print(n + " ");
        }
    }
}

package Sample.Chap_5.PracticalProblem;
import java.util.Scanner;

abstract class Calc {
    protected int a, b;
    public void setValue(int a, int b) { this.a = a; this.b = b; }
    abstract int calculate();
}

class Add extends Calc {
    public int calculate() { return a + b;}
}

class Sub extends Calc {
    public int calculate() { return a - b;}
}

class Mul extends Calc {
    public int calculate() { return a * b;}
}

class Div extends Calc {
    public int calculate() { return a / b;}
}
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        String oper;
        System.out.print("두 정수와 연산자를 입력하시오>>");
        a = scanner.nextInt();
        b = scanner.nextInt();
        oper = scanner.next();
        switch (oper) {
            case "+" -> {
                Add add = new Add();
                add.setValue(a, b);
                System.out.println(add.calculate());
            }
            case "-" -> {
                Sub sub = new Sub();
                sub.setValue(a, b);
                System.out.println(sub.calculate());
            }
            case "*" -> {
                Mul mul = new Mul();
                mul.setValue(a, b);
                System.out.println(mul.calculate());
            }
            case "/" -> {
                Div div = new Div();
                div.setValue(a, b);
                System.out.println(div.calculate());
            }
        }
    }
}

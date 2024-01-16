package JavaStudy.Chap_5.PracticalProblem;
import java.util.InputMismatchException;
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
        Calc calc;
        while (true) {
            try {
                System.out.print("두 정수와 연산자를 입력하시오>>");
                a = scanner.nextInt();
                b = scanner.nextInt();
                oper = scanner.next();
                if (!oper.equals("+") && !oper.equals("-") && !oper.equals("*") && !oper.equals("/")) {
                    System.out.println("알맞은 연삱를 입력해주십시오");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("알맞은 정수를 입력해주십시오");
                scanner.nextLine();
            }
        }

        switch (oper) {
            case "+" -> calc = new Add();
            case "-" -> calc = new Sub();
            case "*" -> calc = new Mul();
            default -> calc = new Div();
        }

        calc.setValue(a, b);
        System.out.println(calc.calculate());
    }
}

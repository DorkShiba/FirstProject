package Sample.Chap_4.PracticalProblem;
import java.util.InputMismatchException;
import java.util.Scanner;

// Problem 11
public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        String operator;

        while (true) {
            try {
                System.out.print("두 정수와 연산자를 입력하시오>>");
                a = scanner.nextInt();
                b = scanner.nextInt();
                operator = scanner.next();

                if (!operator.equals("+") && !operator.equals("-") &&
                        !operator.equals("*") && !operator.equals("/")) {
                    System.out.println("제대로 된 연산자를 입력해주세요");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("두 정수와 연산자를 공백으로 구분해 제대로 입력해주세요");
                scanner.nextLine();
            }
        }

        if (operator.equals("+")) {
            Add.setValue(a, b);
            System.out.println(Add.calculate());
        } else if (operator.equals("-")) {
            Sub.setValue(a, b);
            System.out.println(Sub.calculate());
        } else if (operator.equals("*")) {
            Mul.setValue(a, b);
            System.out.println(Mul.calculate());
        } else {
            Div.setValue(a, b);
            System.out.println(Div.calculate());
        }
    }
}

class Add {
    private static int a, b;

    public static void setValue(int a, int b) { Add.a = a; Add.b = b; }

    public static int calculate() { return Add.a + Add.b; }
}

class Sub {
    private static int a, b;

    public static void setValue(int a, int b) { Sub.a = a; Sub.b = b; }

    public static int calculate() { return Sub.a + Sub.b; }
}

class Mul {
    private static int a, b;

    public static void setValue(int a, int b) { Mul.a = a; Mul.b = b; }

    public static int calculate() { return Mul.a + Mul.b; }
}

class Div {
    private static int a, b;

    public static void setValue(int a, int b) { Div.a = a; Div.b = b; }

    public static int calculate() { return Div.a + Div.b; }
}
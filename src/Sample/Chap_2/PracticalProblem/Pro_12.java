package Sample.Chap_2.PracticalProblem;
import java.util.Scanner;

public class Pro_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("연산>>");
        double operand1 = scanner.nextDouble();
        String operator = scanner.next();
        double operand2 = scanner.nextDouble();
        double result = 0;

        // (1) if-else 문 이용
        if (operator.equals("+")) { result = operand1 + operand2; }
        else if (operator.equals("-")) { result = operand1 - operand2; }
        else if (operator.equals("*")) { result = operand1 * operand2; }
        else if (operator.equals("/")) {
            if (operand2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                scanner.close();
                return;  // 즉시 메서드 종료 가능
            } else { result = operand1 / operand2; }
        } else { System.out.println("연산자 잘못 입력"); }

        System.out.println(operand1 + operator + operand2 + "의 계산 결과는 " + result);

        // (2) switch 문 이용
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    scanner.close();
                    return;
                } else { result = operand1 / operand2; }
                break;
            default:
                System.out.println("연산자 잘못 입력");
        }

        System.out.println(operand1 + operator + operand2 + "의 계산 결과는 " + result);
    }
}

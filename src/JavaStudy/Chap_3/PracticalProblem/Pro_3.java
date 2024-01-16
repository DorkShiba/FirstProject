package JavaStudy.Chap_3.PracticalProblem;
import java.util.Scanner;

public class Pro_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        System.out.print("정수를 입력하시오>>");
        n = scanner.nextInt();

        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}

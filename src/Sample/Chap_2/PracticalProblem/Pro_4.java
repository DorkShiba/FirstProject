package Sample.Chap_2.PracticalProblem;
import java.util.Scanner;

public class Pro_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 3개 입력>>");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a > b) { if (a < c) { System.out.println(a); } }
        else if (a > c) { System.out.println(a); }
        else if (b > c) { System.out.println(c); }
        else { System.out.println(b); }

        scanner.close();
    }
}

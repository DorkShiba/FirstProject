package Sample.Chap_2.PracticalProblem;
import java.util.Scanner;

public class Pro_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 3개를 입력하시오>>");
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();

        // 내가 쓴 답안
//        if (a > b && a > c) {
//            System.out.println((a < b + c)? "삼각형이 됩니다": "");
//        } else if (b > a && b > c) {
//            System.out.println((b < a + c)? "삼각형이 됩니다": "");
//        } else if (c > a && c > b) {
//            System.out.println((c < b + a)? "삼각형이 됩니다": "");
//        }

        if ((a + b) <= c || (b + c) <= a || (a + c) <= b) { System.out.println("삼각형이 될 수 없습니다."); }
        else { System.out.println("삼각형이 됩니다."); }

        scanner.close();
    }
}

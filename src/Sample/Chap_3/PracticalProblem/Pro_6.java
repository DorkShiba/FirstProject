package Sample.Chap_3.PracticalProblem;
import java.util.Scanner;

public class Pro_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int money, count;
        int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
        System.out.print("금액을 입력하시오>>");
        money = scanner.nextInt();

        for (int i: unit) {
            count = money / i;
            if (count != 0) {
                System.out.println(i + "원 짜리 : " + count + "개");
                money -= count * i;
            }
        }

        scanner.close();
    }
}

package JavaStudy.Chap_3.PracticalProblem;
import java.util.Scanner;

public class Pro_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[10];
        System.out.print("양의 정수 10개를 입력하시오>>");
        for (int i = 0; i < arr.length; i++) { arr[i] = scanner.nextInt(); }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0) { System.out.print(arr[i] + " "); }
        }

        scanner.close();
    }
}

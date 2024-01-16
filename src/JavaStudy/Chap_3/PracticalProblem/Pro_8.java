package JavaStudy.Chap_3.PracticalProblem;
import java.util.Scanner;

public class Pro_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        System.out.print("정수 몇개?");
        n = scanner.nextInt();
        int[][] arr = new int[(n/10) + 1][];
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) { arr[i] = new int[10]; }
            else { arr[i] = new int[n%10]; }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) { arr[i][j] = (int)(Math.random() * 100 + 1); }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

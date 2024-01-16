package JavaStudy.Chap_3.PracticalProblem;
import java.lang.Math;

public class Pro_7 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int i, sum = 0;

        System.out.print("랜덤한 정수들 : ");
        for (int j = 0; j < arr.length; j++) {
            i = (int)(Math.random() * 10 + 1);
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println();

        System.out.println((double)sum / 10);
    }
}

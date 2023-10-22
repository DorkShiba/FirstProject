package Sample.Chap_2.PracticalProblem;
import java.util.Scanner;

public class Pro_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("원의 중심과 반지름 입력>>");
        float cirx = scanner.nextFloat(), ciry = scanner.nextFloat();
        float rad = scanner.nextFloat();

        System.out.print("점 입력>>");
        float x = scanner.nextFloat(), y = scanner.nextFloat();

        float xpow = (x - cirx) * (x - cirx);
        float ypow = (y - ciry) * (y - ciry);

        if (xpow + ypow <= rad * rad) { System.out.println("점 (" + x + ", " + y + ")는 원 안에 있다."); }
        else { System.out.println("점 (" + x + ", " + y + ")는 원 밖에 있다."); }

        scanner.close();
    }
}

package JavaStudy.Chap_2.PracticalProblem;
import java.util.Scanner;

public class Pro_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫번째 원의 중심과 반지름 입력>>");
        double x1 = scanner.nextDouble(), y1 = scanner.nextDouble(), rad1 = scanner.nextDouble();

        System.out.print("두번째 원의 중심과 반지름 입력>>");
        double x2 = scanner.nextDouble(), y2 = scanner.nextDouble(), rad2 = scanner.nextDouble();

        double dis_x = Math.pow(x1 - x2, 2);
        double dis_y = Math.pow(y1 - y2, 2);
        if (Math.sqrt(dis_x + dis_y) <= rad1 + rad2) { System.out.println("두 원은 서로 겹친다"); }
        else { System.out.println("두 원은 서록 겹치지 않는다"); }

        scanner.close();
    }
}

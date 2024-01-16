package JavaStudy.Chap_2.PracticalProblem;
import java.util.Scanner;

public class Pro_8 {
    public static boolean isRect(int x, int y, int rectx1, int recty1,
                                 int rectx2, int recty2) {
        if ((x >= rectx1 && x <= rectx2) && (y >= recty1 && y <= recty2)) { return true; }
        else { return false; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("직사각형을 이루는 두 점 (x, y)의 좌표를 입력하시오>>");
        int x1 = scanner.nextInt(), y1 = scanner.nextInt();
        int x2 = scanner.nextInt(), y2 = scanner.nextInt();

        // 내가 쓴 답안
//        if (isRect(x1, y1, 100, 100, 200, 200) || isRect(x2, y2, 100, 100, 200, 200) ||
//        isRect(x1, y2, 100, 100, 200, 200) || isRect(x2, y1, 100, 100, 200, 200)) {
//            System.out.println("충돌합니다");
//        } else {
//            System.out.println("충돌하지 않습니다");
//        }

        if (isRect(x1, y1, 100, 100, 200, 200) ||
            isRect(x2, y2, 100, 100, 200, 200) ||
            isRect(x1, y2, 100, 100, 200, 200) ||
            isRect(x2, y1, 100, 100, 200, 200)) { System.out.println("충돌합니다."); }
        else if (isRect(100, 100, x1, y1, x2, y2) ||
                isRect(200, 200, x1, y1, x2, y2) ||
                isRect(100, 200, x1, y1, x2, y2) ||
                isRect(200, 100, x1, y1, x2, y2)) { System.out.println("충돌합니다."); }
        else { System.out.println("충돌하지 않습니다."); }

        scanner.close();
    }
}

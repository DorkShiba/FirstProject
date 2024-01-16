package JavaStudy.Chap_3.PracticalProblem;
import java.util.Scanner;

public class Pro_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rsp = {"가위", "바위", "보"};
        String ans;
        int comp;

        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
        while (true) {
            System.out.print("가위 바위 보!>>");
            ans = scanner.next();
            if (ans.equals("그만")) {
                scanner.close();
                return;
            }

            comp = (int)(Math.random() * 3);
            if (ans.equals(rsp[comp])) {
                System.out.println("사용자 = " + ans + " , 컴퓨터 = " + rsp[comp] + ", 비겼습니다.");
            } else {
                if (comp == 0) {
                    if (ans.equals("바위")) {
                        System.out.println("사용자 = " + ans + " , 컴퓨터 = " + rsp[comp] + ", 사용자가 이겼습니다.");
                    } else {
                        System.out.println("사용자 = " + ans + " , 컴퓨터 = " + rsp[comp] + ", 컴퓨터가 이겼습니다.");
                    }
                } else if (comp == 1) {
                    if (ans.equals("가위")) {
                        System.out.println("사용자 = " + ans + " , 컴퓨터 = " + rsp[comp] + ", 컴퓨터가 이겼습니다.");
                    } else {
                        System.out.println("사용자 = " + ans + " , 컴퓨터 = " + rsp[comp] + ", 사용자가 이겼습니다.");
                    }
                } else {
                    if (ans.equals("가위")) {
                        System.out.println("사용자 = " + ans + " , 컴퓨터 = " + rsp[comp] + ", 사용자가 이겼습니다.");
                    } else {
                        System.out.println("사용자 = " + ans + " , 컴퓨터 = " + rsp[comp] + ", 컴퓨터가 이겼습니다.");
                    }
                }
            }
        }
    }
}

package JavaStudy.Chap_2;
import java.util.Scanner;

public class _02_OpenChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");

        System.out.print("철수 >> ");
        String cheolsu = scanner.next();

        System.out.print("영희 >> ");
        String yeonghi = scanner.next();

        if (cheolsu.equals("가위")) {
            switch (yeonghi) {
                case "가위": System.out.println("비겼습니다"); break;
                case "바위": System.out.println("영희가 이겼습니다"); break;
                case "보": System.out.println("철수가 이겼습니다"); break;
                default: System.out.println("영희의 값이 잘못되었습니다");
            }
        } else if (cheolsu.equals("바위")) {
            switch (yeonghi) {
                case "가위": System.out.println("철수가 이겼습니다"); break;
                case "바위": System.out.println("비겼습니다"); break;
                case "보": System.out.println("영희가 이겼습니다"); break;
                default: System.out.println("영희의 값이 잘못되었습니다");
            }
        } else if (cheolsu.equals("보")) {
            switch (yeonghi) {
                case "가위": System.out.println("영희가 이겼습니다"); break;
                case "바위": System.out.println("철수가 이겼습니다"); break;
                case "보": System.out.println("비겼습니다"); break;
                default: System.out.println("영희의 값이 잘못되었습니다");
            }
        } else { System.out.println("철수의 값이 잘못되었습니다"); }

        scanner.close();
    }
}

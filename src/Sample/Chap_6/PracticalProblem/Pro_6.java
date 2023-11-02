package Sample.Chap_6.PracticalProblem;
import java.util.Calendar;
import java.util.Scanner;

public class Pro_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("10초에 더 가까운 사람이 이기는 게임입니다.");

        System.out.print("A start <Enter> key >>");
        scanner.nextLine();

        Calendar a1 = Calendar.getInstance();
        int aStartSec = a1.get(Calendar.SECOND);
        System.out.println("Now is " + aStartSec);

        System.out.print("After 10 sec <Enter> key >>");
        scanner.nextLine();

        Calendar a2 = Calendar.getInstance();
        int aEndSec = a2.get(Calendar.SECOND);
        System.out.println("Now is " + aEndSec);

        System.out.print("B start <Enter> key >>");
        scanner.nextLine();

        Calendar b1 = Calendar.getInstance();
        int bStartSec = b1.get(Calendar.SECOND);
        System.out.println("Now is " + bStartSec);

        System.out.print("After 10 sec <Enter> key >>");
        scanner.nextLine();

        Calendar b2 = Calendar.getInstance();
        int bEndSec = b2.get(Calendar.SECOND);
        System.out.println("Now is " + bEndSec);

        if (aEndSec < aStartSec) { aEndSec += 60; }
        if (bEndSec < bStartSec) { bEndSec += 60; }

        int aGap = aEndSec - aStartSec;
        int bGap = bEndSec - bStartSec;
        char win = (aGap < bGap)? 'A': 'B';
        System.out.println("A's result is " + aGap + ", B's result is " + bGap + ", Winner is " + win);
    }
}

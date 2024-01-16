package JavaStudy.Chap_3.PracticalProblem;
import java.util.Scanner;

public class Pro_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char c;
        String s;
        System.out.print("소문자 알파벳 하나를 입력하시오>>");
        s = scanner.next();
        c = s.charAt(0);

        for (int i = (int) c; i >= (int) 'a'; i--) {
            for (int j = (int) 'a'; j <= i; j++) {
                System.out.print((char) j);
            }
            System.out.println();
        }

        scanner.close();
    }
}

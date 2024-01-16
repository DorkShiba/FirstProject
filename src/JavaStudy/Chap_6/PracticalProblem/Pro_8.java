package JavaStudy.Chap_6.PracticalProblem;
import java.util.Scanner;

public class Pro_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력하세요. 빈칸이 있어도 되고 영어 한글 모두 가능");
        String str = scanner.nextLine();
        int count = 1;
        int L = str.length();
        while (count <= L) {
            str = str.substring(1, L).concat(str.substring(0, 1));
            System.out.println(str);
            count++;
        }
    }
}

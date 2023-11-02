package Sample.Chap_6.PracticalProblem;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Pro_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        while (true) {
            System.out.print(">>");
            str = scanner.nextLine();
            if (str.equals("그만")) {
                System.out.println("StringTokenizer quit");
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            System.out.println("Token is " + st.countTokens());
        }

        while (true) {
            System.out.print(">>");
            str = scanner.nextLine();
            if (str.equals("그만")) {
                System.out.println("String quit");
                break;
            }

            String[] tokens = str.split(" ");
            System.out.println("Token is " + tokens.length);
        }
    }
}

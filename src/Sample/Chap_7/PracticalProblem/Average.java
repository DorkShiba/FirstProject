package Sample.Chap_7.PracticalProblem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Average {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Character> grade = new ArrayList<>();
    public static void getGrade() {
        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
        for (int i = 0; i < 6; i++) {
            String input = scanner.next();
            grade.add(input.charAt(0));
        }
    }

    public static void main(String[] args) {
        getGrade();
        double sum = 0;
        for (int i = 0; i < grade.size(); i++) {
            switch (grade.get(i)) {
                case 'A' -> sum += 4.0;
                case 'B' -> sum += 3.0;
                case 'C' -> sum += 2.0;
                case 'D' -> sum += 1.0;
                default -> sum += 0;
            }
        }

        System.out.println(sum / 6);
    }
}

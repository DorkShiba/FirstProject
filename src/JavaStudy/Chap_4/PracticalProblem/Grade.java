package JavaStudy.Chap_4.PracticalProblem;
import java.util.InputMismatchException;
import java.util.Scanner;

// Problem 2
public class Grade {
    private int math;  // 수학 점수
    private int science;  // 과학 점수
    private int english;  // 영어 점수

    public Grade(int math, int science, int english) {
        this.math = math;
        this.science = science;
        this.english = english;
    }

    // 필드 게터
    public int getMath() { return this.math; }
    public int getScience() { return this.science; }
    public int getEnglish() { return this.english; }

    // 필드 세터
    public void setMath(int math) { this.math = math; }
    public void setScience(int science) { this.science = science; }
    public void setEnglish(int english) { this.english = english; }

    // 점수들의 평균을 리턴하는 메소드
    public int average() {
        return ((this.math + this.science + this.english) / 3);
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int math, science, english;

        while (true) {
            try {
                System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
                math = scanner.nextInt();
                science = scanner.nextInt();
                english = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("정수인 숫자를 입력해 주세요");
                scanner.nextLine();
            }
        }

        Grade me = new Grade(math, science, english);
        System.out.println("평균은 " + me.average());

        scanner.close();
    }
}

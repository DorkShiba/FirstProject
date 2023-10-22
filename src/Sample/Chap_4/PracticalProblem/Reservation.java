package Sample.Chap_4.PracticalProblem;
import java.util.InputMismatchException;
import java.util.Scanner;

// Problem 12
public class Reservation {
    private Seat[][] seats = new Seat[3][10];
    private final Scanner scanner = new Scanner(System.in);

    public Reservation() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) { this.seats[i][j] = new Seat(); }
        }
    }

    public void partShow(int grade) {
        if (grade - 1 == 0) { System.out.print("S>> "); }
        else if (grade - 1 == 1 ) { System.out.print("A>> "); }
        else { System.out.print("B>> "); }

        for (int i = 0; i < 10; i++) {
            System.out.print(this.seats[grade-1][i].getName() + " ");
        }
        System.out.println();
    }

    public int inputGrade() {
        int grade;
        while (true) {
            try {
                System.out.print("좌석구분 S(1), A(2), B(3)>>");
                grade = this.scanner.nextInt();

                if (grade < 1 || grade > 3) {
                    System.out.println("1 ~ 3의 정수를 입력해주세요");
                    continue;
                }
                this.partShow(grade);
                break;
            } catch (InputMismatchException e) {
                System.out.println("1 ~ 3의 정수를 입력해주세요");
                this.scanner.nextLine();
            }
        }

        return grade;
    }

    public void reserve() {
        int grade, num;
        String name;

        grade = inputGrade();
        while (true) {
            try {
                System.out.print("이름>>");
                name = scanner.next();
                System.out.print("번호>>");
                num = scanner.nextInt();

                if (!this.seats[grade-1][num-1].getName().equals("---")) {
                    System.out.println("이미 예약된 자리입니다.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("좌석번호로 1 ~ 10의 정수를 입력해주세요");
                this.scanner.nextLine();
            }
        }

        this.seats[grade-1][num-1].setName(name);
    }

    public void show() {
        for (int i = 1; i <= 3; i++) { this.partShow(i); }
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }

    public void cancel() {
        int grade;
        String name;
        boolean find = false;


        grade = inputGrade();
        while (!find) {
            System.out.print("이름>>");
            name = this.scanner.next();
            for (int i = 0; i < 10; i++) {
                if (this.seats[grade - 1][i].getName().equals(name)) {
                    this.seats[grade - 1][i].setName();
                    find = true;
                }
            }

            if (!find) { System.out.println("없는 이름입니다."); }
        }
    }

    public void run() {
        int job;

        while (true) {
            while (true) {
                try {
                    System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
                    job = this.scanner.nextInt();

                    if (job < 1 || job > 4) {
                        System.out.println("1 ~ 4의 정수를 입력해주세요");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("1 ~ 4의 정수를 입력해주세요");
                    this.scanner.nextLine();
                }
            }

            if (job == 1) { this.reserve(); }
            else if (job == 2) { this.show(); }
            else if (job == 3) { this.cancel(); }
            else {
                this.scanner.close();
                break;
            }
        }
    }

    public static void main(String[] args) {
        Reservation r = new Reservation();
        System.out.println("명품콘서트홀 예약 시스템입니다.");
        r.run();
    }
}

class Seat {
    private String name; // 자리 주인 이름

    public Seat() { this.name = "---"; }

    // 필드 게터, 세터
    public String getName() { return this.name; }
    public void setName() { this.name = "---"; }
    public void setName(String name) { this.name = name; }
}

package JavaStudy.Chap_4.PracticalProblem;
import java.util.InputMismatchException;
import java.util.Scanner;

// Problem 7
class Day {
    private String work;  // 이 날에 해야할 일

    // 필드 세터
    public void set(String work) { this.work = work; }

    // 핃드 게터
    public String get() { return work; }

    // 이 날 해야할 일을 출력하는 메소드
    public void show() {
        if (work == null) { System.out.println("없습니다."); }
        else { System.out.println(work + "입니다."); }
    }
}

public class MonthSchedule {
    private Day[] month;  // 이번달 날짜들
    private Scanner scanner = new Scanner(System.in);  // 스캐너

    public MonthSchedule(int days) {
        this.month = new Day[days + 1];
        for (int i = 1; i < days + 1; i++) { this.month[i] = new Day(); }
    }

    // 필드 게터
    public Day[] getMonth() { return this.month; }

    // 필드 세터
    public void setMonth(int days) {
        this.month = new Day[days + 1];
        for (int i = 1; i < days + 1; i++) { this.month[i] = new Day(); }
    }

    // 특정 날에 일정을 추가하는 메소드
    public void input(int day, String work) {
        this.month[day].set(work);
        System.out.println();
    }

    // 특정 날의 일정을 출력하는 메소드
    public void view(int day) {
        System.out.print(day + "일의 할 일은 ");
        this.month[day].show();
        System.out.println();
    }

    // 프로그램 종료 메소드
    public void finish() {
        System.out.println("프로그램을 종료합니다.");
        this.scanner.close();
    }

    // 일정 관리 프로그램 작동 메소드
    public void run() {
        int job;  // 이번 턴의 작업
        int days = this.month.length - 1;

        while (true) {
            while (true) {
                try {
                    System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
                    job = this.scanner.nextInt();

                    if (job < 1 || job > 3) {
                        System.out.println("1 ~ 3의 정수를 입력해주세요");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("1 ~ 3의 정수를 입력해주세요");
                    this.scanner.nextLine();
                }
            }

            if (job == 1) {
                int day;
                String work;

                while (true) {
                    try {
                        System.out.print("날짜(1~" + days + ")?");
                        day = this.scanner.nextInt();

                        if (day < 1 || day > days) {
                            System.out.println("1 ~ " + days + "의 정수를 입력해주세요");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("1 ~ " + days + "의 정수를 입력해주세요");
                        this.scanner.nextLine();
                    }
                }

                System.out.print("할일(빈칸없이입력)?");
                work = this.scanner.next();

                this.input(day, work);
            } else if (job == 2) {
                int day;
                while (true) {
                    try {
                        System.out.print("날짜(1~" + days + ")?");
                        day = this.scanner.nextInt();

                        if (day < 1 || day > days) {
                            System.out.println("1 ~ " + days + "의 정수를 입력해주세요");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("1 ~ " + days + "의 정수를 입력해주세요");
                        this.scanner.nextLine();
                    }
                }

                this.view(day);
            } else if (job == 3) {
                this.finish();
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("이번달 스케쥴 관리 프로그램.");
        MonthSchedule april = new MonthSchedule(30);
        april.run();
    }
}

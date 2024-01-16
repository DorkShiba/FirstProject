package JavaStudy.Chap_7.PracticalProblem;
import java.util.*;

class Candidate {
    private String name;
    private double grade;
    public Candidate(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() { return name; }
}

public class ScholarshipManage {
    private HashMap<Double, Candidate> scholar = new HashMap<>();
    private double cut;
    static Scanner scanner = new Scanner(System.in);
    public void setCut(double cut) { this.cut = cut; }

    public HashMap<Double, Candidate> getScholar() { return scholar; }

    public void inputCandidate() {
        System.out.println("미래장학금관리시스템입니다.");
        String name;
        Double grade;
        for (int i = 0; i < 5; i++) {
            while (true) {
                try {
                    System.out.print("이름과 학점>> ");
                    name = scanner.next();
                    grade = scanner.nextDouble();
                    if (grade > 4.5 || grade < 0) {
                        System.out.println("학점은 0 ~ 4.5의 실수로 입력해주세요");
                        continue;
                    }
                    scholar.put(grade, new Candidate(name, grade));
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("학점은 0 ~ 4.5의 실수로 입력해주세요");
                    scanner.nextLine();
                }
            }
        }
    }

    public void printScholarStudent() {
        Set<Double> grades = scholar.keySet();
        Iterator<Double> it = grades.iterator();
        System.out.print("장학생 명단: ");
        while (it.hasNext()) {
            double curr = it.next();
            if (curr >= cut) {
                System.out.print(scholar.get(curr).getName() + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ScholarshipManage sm = new ScholarshipManage();
        sm.inputCandidate();
        double cut;
        while (true) {
            try {
                System.out.print("장학생 선발 학점 기준 입력>> ");
                cut = scanner.nextDouble();
                if (cut < 0 || cut > 4.5) {
                    System.out.println("0 ~ 4.5의 실수 점수를 입력해주세요");
                    continue;
                }
                sm.setCut(cut);
                break;
            } catch (InputMismatchException e) {
                System.out.println("0 ~ 4.5의 실수 점수를 입력해주세요");
                scanner.nextLine();
            }
        }
        sm.printScholarStudent();
    }
}

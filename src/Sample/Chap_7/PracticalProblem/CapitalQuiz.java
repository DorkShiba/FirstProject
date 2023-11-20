package Sample.Chap_7.PracticalProblem;
import java.util.*;

class Nation {
    private String country, capital;
    public Nation(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }

    public String getCountry() { return country; }
    public String getCapital() { return capital; }
}

public class CapitalQuiz {
    Vector<Nation> list = new Vector<>();
    static Scanner scanner = new Scanner(System.in);

    public boolean contains(String str) {
        var it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getCountry().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void input() {
        String country, capital;
        System.out.println("현재 " + list.size() + "개 나라와 수도가 입력되어 있습니다.");
        while (true) {
            System.out.print("나라와 수도 입력 " + (list.size() + 1) + " >> ");
            country = scanner.next();
            if (country.equals("그만")) { break; }
            capital = scanner.next();

            if (contains(country)) {
                System.out.println(country + "는 이미 있습니다!");
            } else {
                list.add(new Nation(country, capital));
            }
        }
    }

    public void quiz() {
        String enter;
        while (true) {
            int pro = (int) (Math.random() * list.size());
            System.out.print(list.get(pro).getCountry() + "의 수도는? ");
            enter = scanner.next();
            if (enter.equals("그만")) { break; }

            if (enter.equals(list.get(pro).getCapital())) {
                System.out.println("정답!!");
            } else {
                System.out.println("아닙니다!!");
            }
        }
    }

    public void finish() {
        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
    public void run() {
        System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
        int which;
        while (true) {
            while (true) {
                try {
                    System.out.print("입력: 1, 퀴즈: 2, 종료: 3 >> ");
                    which = scanner.nextInt();
                    if (which < 1 || which > 3) {
                        System.out.println("1 ~ 3의 정수를 입력해주세요");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("1 ~ 3의 정수를 입력해주세요");
                    scanner.nextLine();
                }
            }

            if (which == 1) { input(); }
            else if (which == 2) { quiz(); }
            else { finish(); break; }
        }
    }

    public static void main(String[] args) {
        CapitalQuiz cq = new CapitalQuiz();
        cq.run();
    }
}

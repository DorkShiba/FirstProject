package Sample.Chap_7.PracticalProblem;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PopulationSearch {
    HashMap<String, Integer> nations = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public void addCountry() {
        String name;
        int popul;
        System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");
        while (true) {
            System.out.print("나라 이름, 인구 >> ");
            name = scanner.next();
            if (name.equals("그만")) { break; }
            while (true) {
                try {
                    popul = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("인구 수를 정수로 입력해주세요");
                    scanner.nextLine();
                }
            }
            nations.put(name, popul);
        }
    }

    public static void main(String[] args) {
        PopulationSearch ps = new PopulationSearch();
        String name;
        ps.addCountry();
        while (true) {
            System.out.print("인구 검색 >> ");
            name = scanner.next();
            if (name.equals("그만")) { break; }
            if (ps.nations.containsKey(name)) {
                System.out.println(name + "의 인구는 " + ps.nations.get(name));
            } else {
                System.out.println(name + "나라는 없습니다.");
            }
        }
        scanner.close();
    }
}

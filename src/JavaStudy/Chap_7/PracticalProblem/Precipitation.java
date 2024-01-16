package JavaStudy.Chap_7.PracticalProblem;
import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

public class Precipitation {
    Vector<Integer> prec = new Vector<>();
    static Scanner scanner = new Scanner(System.in);

    public int iterate() {
        Iterator<Integer> it = prec.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int curr = it.next();
            System.out.print(curr + " ");
            sum += curr;
        }
        System.out.println();
        return sum;
    }
    public static void main(String[] args) {
        int rain;
        Precipitation p = new Precipitation();
        while (true) {
            System.out.print("강수량 입력 (0 입력 시 종료)>> ");
            rain = scanner.nextInt();
            if (rain == 0) { break; }
            p.prec.add(rain);
            System.out.println("현재 평균 " + p.iterate() / p.prec.size());
        }
    }
}

package JavaStudy.Chap_7.PracticalProblem;
import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

public class MaxInt {
    static Vector<Integer> v = new Vector<>();
    static Scanner scanner = new Scanner(System.in);

    public static void getNumber() {
        System.out.print("정수(-1이 입력될 때까지)>>");
        while(true) {
            int n = scanner.nextInt();
            if (n == -1) break;
            v.add(n);
        }
    }

    public static int getMax() {
        Iterator<Integer> it = v.iterator();
        int max = v.get(0);
        int curr;
        while (it.hasNext()) {
            max = Math.max(it.next(), max);
        }
        return max;
    }
    public static void main(String[] args) {
        getNumber();
        System.out.println("가장 큰 수는 " + getMax());
    }
}

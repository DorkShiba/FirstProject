package Sample.Chap_3;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class _03_OpenChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        double[][] arr = new double[4][];
        int N = rand.nextInt(100);
        int ans = 0, count = 1, less = 0, larger = 99;
        String replay;

        System.out.println("수를 결정하였습니다. 맞추어 보세요");
        while (ans != N) {
            try {
                System.out.println(less + "-" + larger);
                System.out.print(count + ">>");
                ans = scanner.nextInt();

                if (ans <= less || ans >= larger) {
                    System.out.println(less + "와 " + larger + "사이의 수를 입력해주세요");
                    continue;
                }

                if (ans > N) {
                    System.out.println("더 낮게");
                    larger = ans;
                    count++;
                }
                else if (ans < N) {
                    System.out.println("더 높게");
                    less = ans;
                    count++;
                }
                else {
                    System.out.println("맞았습니다.");
                    System.out.print("다시하시겠습니까(y/n)>>");
                    replay = scanner.next();

                    if (replay.equals("y")) {
                        ans = 0;
                        less = 0;
                        larger = 99;
                        count = 1;
                        N = rand.nextInt(100);
                        System.out.println("수를 결정하였습니다. 맞추어 보세요");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }

        scanner.close();
    }
}

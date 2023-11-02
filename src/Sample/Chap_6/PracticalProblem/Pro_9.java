package Sample.Chap_6.PracticalProblem;
import java.util.Scanner;

public class Pro_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rsp = {"Scissor", "Rock", "Paper"};
        while (true) {
            System.out.print("You[Scissor(1), Rock(2), Paper(3), Quit(4)]>>");
            int your = scanner.nextInt();
            if (your == 4) { break; }
            int computer = (int)(Math.random() * 3 + 1);
            System.out.println("You " + rsp[your - 1] + " : Computer " + rsp[computer - 1]);
            switch (your) {
                case 1 -> {
                    switch (computer) {
                        case 1 -> System.out.println("Draw");
                        case 2 -> System.out.println("Computer wins");
                        default -> System.out.println("You win");
                    }
                } case 2 -> {
                    switch (computer) {
                        case 1 -> System.out.println("You win");
                        case 2 -> System.out.println("Draw");
                        default -> System.out.println("Computer wins");
                    }
                } default -> {
                    switch (computer) {
                        case 1 -> System.out.println("Computer wins");
                        case 2 -> System.out.println("You win");
                        default -> System.out.println("Draw");
                    }
                }
            }
        }
    }
}

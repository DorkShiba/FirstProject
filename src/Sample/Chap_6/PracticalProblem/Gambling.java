package Sample.Chap_6.PracticalProblem;
import java.util.Scanner;

class Person {
    private String name;
    public Person(String name) { this.name = name; }
    public String getName() { return name; }
    public String toString() { return "[" + name + "]"; }
}

public class Gambling {
    private Scanner scanner = new Scanner(System.in);
    private Person[] player;
    public Gambling() {
        System.out.print("갬블링 게임에 참여할 선수 숫자>>");
        int num = scanner.nextInt();
        player = new Person[num];
        scanner.nextLine();
    }

    public void getPlayer() {
        for (int i = 1; i <= player.length; i++) {
            System.out.print(i + "번째 선수 이름 >> ");
            String name = scanner.nextLine();
            player[i - 1] = new Person(name);
        }
    }

    public void run() {
        boolean end = false;
        while (!end) {
            for (int i = 0; i < player.length; i++) {
                System.out.print(player[i] + ": <Enter>");
                scanner.nextLine();
                int a = (int)(Math.random() * 3 + 1);
                int b = (int)(Math.random() * 3 + 1);
                int c = (int)(Math.random() * 3 + 1);
                System.out.print("\t " + a + " " + b + " " + c + " ");
                if (a == b && b == c) {
                    System.out.println(player[i].getName() + "님이 이겼습니다!");
                    end = true;
                    break;
                } else {
                    System.out.println("아쉽군요!");
                }
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Gambling gb = new Gambling();
        gb.getPlayer();
        gb.run();
    }
}

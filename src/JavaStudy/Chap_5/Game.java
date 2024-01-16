package JavaStudy.Chap_5;
import java.util.Scanner;
import java.util.Random;

class Bear extends GameObject {
    private char shape = 'B';

    public Bear(int startX, int startY, int distance) { super(startX, startY, distance); }

    protected void move() {
        Scanner scanner = new Scanner(System.in);
        String dir;

        while (true) {
            System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
            dir = scanner.next();

            if (!dir.equals("a") && !dir.equals("s") && !dir.equals("d") && !dir.equals("f")) {
                System.out.println("제대로 된 방향을 입력해주십시오");
                continue;
            }
            break;
        }

        switch (dir) {
            case "a" -> {
                if (this.x - this.distance < 0) { System.out.println("이동할 수 없습니다"); }
                else { this.x -= this.distance; }
            }
            case "s" -> {
                if (this.y + this.distance > 9) { System.out.println("이동할 수 없습니다"); }
                else { this.y += this.distance; }
            }
            case "d" -> {
                if (this.y - this.distance < 0) { System.out.println("이동할 수 없습니다"); }
                else { this.y -= this.distance; }
            }
            case "f" -> {
                if (this.x + this.distance > 19) { System.out.println("이동할 수 없습니다"); }
                else { this.x += this.distance; }
            }
        }
    }

    protected char getShape() { return this.shape; }
}

class Fish extends GameObject {
    private char shape = '@';
    private int count = 0;

    public Fish(int startX, int startY, int distance) { super(startX, startY, distance); }

    protected void move() {
        if (count < 3) { count++; }
        else {
            while (true) {
                Random random = new Random();
                int dir = random.nextInt(4);
                switch (dir) {
                    case 0 -> {
                        if (this.x - this.distance < 0) { continue; }
                        else { this.x -= this.distance; }
                    }
                    case 1 -> {
                        if (this.y + this.distance > 9) { continue; }
                        else { this.y += this.distance; }
                    }
                    case 2 -> {
                        if (this.y - this.distance < 0) { continue; }
                        else { this.y -= this.distance; }
                    }
                    case 3 -> {
                        if (this.x + this.distance > 19) { continue; }
                        else { this.x += this.distance; }
                    }
                }
                break;
            }

            count = (count == 4)? 0: count + 1;
        }
    }

    protected char getShape() { return this.shape; }
}

public class Game {
    private char[][] gameBoard = new char[10][20];
    public Game() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) { this.gameBoard[i][j] = '-'; }
        }
    }

    public void putObject(GameObject p) { this.gameBoard[p.getY()][p.getX()] = p.getShape(); }
    public void resetObject(GameObject p) { this.gameBoard[p.getY()][p.getX()] = '-'; }

    public void showBoard() {
        for (char[] i: this.gameBoard) {
            for (char j: i) { System.out.print(j); }
            System.out.println();
        }
    }

    public void moveObject(Bear b, Fish f) {
        this.resetObject(b);
        this.resetObject(f);

        f.move();
        this.putObject(f);

        b.move();
        this.putObject(b);
    }

    public void run() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int bearDis, fishDis;

        System.out.print("Bear의 속도를 입력해주세요>>");
        bearDis = scanner.nextInt();
        System.out.print("Fish의 속도를 입력해주세요>>");
        fishDis = scanner.nextInt();

        Bear b = new Bear(0, 0, bearDis);
        Fish f = new Fish(random.nextInt(20), random.nextInt(10), fishDis);

        this.putObject(b);
        this.putObject(f);

        while (true) {
            this.showBoard();
            this.moveObject(b, f);

            if (f.collide(b)) {
                this.showBoard();
                System.out.println("Bear Wins!!");
                break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.**");
        Game game = new Game();
        game.run();
    }
}

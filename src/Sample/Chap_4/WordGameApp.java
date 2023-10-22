package Sample.Chap_4;
import java.util.InputMismatchException;
import java.util.Scanner;

class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public String getWordFromUser(Scanner scanner) {
        System.out.print(this.name + ">>");
        return scanner.next();
    }

    public boolean checkSuccess(String prev, String curr) {
        int lastIndex = prev.length() - 1;
        char lastChar = prev.charAt(lastIndex);
        char firstChar = curr.charAt(0);

        if (lastChar == firstChar) { return true; }
        else {
            System.out.println(this.name + "이 졌습니다.");
            return false;
        }
    }
}

public class WordGameApp {
    Player[] players;  // 참가자 리스트
    Scanner scanner;  // 스캐너
    String currentWord = "아버지";  // 현재 단어, 처음은 아버지
    String nextWord; // 다음 단어
    int order = 0; // 현재 참가자 순서

    public WordGameApp() {
        this.scanner = new Scanner(System.in);  // 스캐너를 만듦
    }


    public void makePlayers(int playerNum) {
        // 참가자 수를 입력받아 참가자 리스트를 만드는 메소드
        this.players = new Player[playerNum];
        for (int i = 0; i < playerNum; i++) {
            System.out.print("참가자의 이름을 입력하세요>>");
            this.players[i] = new Player(this.scanner.next());
        }
    }

    public void run(int playerNum) {
        makePlayers(playerNum);  // 먼저 참가자 수에 따라 참가자 리스트 작성
        System.out.println("시작하는 단어는 " + this.currentWord + "입니다");

        this.nextWord = this.players[this.order].getWordFromUser(this.scanner);  // 다음 단어를 받음
        while (this.players[this.order].checkSuccess(this.currentWord, this.nextWord)) {
            this.currentWord = this.nextWord;  // 끝말잇기가 성공하면 현재 단어를 바꿈
            this.order = (this.order == this.players.length - 1)? 0: this.order + 1;  // 순서도 바꿈
            this.nextWord = this.players[this.order].getWordFromUser(this.scanner);  // 다음 단어를 받음
        }
    }

    public static void main(String[] args) {
        WordGameApp gameApp = new WordGameApp();  // 끝말잇기 객체
        int playerNum = 0;  // 끝말잇기 참가자 수

        System.out.println("끝말잇기 게임을 시작합니다...");
        while (true) {
            try {
                System.out.print("게임에 참가하는 인원은 몇명입니까>>");
                playerNum = gameApp.scanner.nextInt();  // 참가자 수를 받음
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주십시오");
                gameApp.scanner.nextLine();
            }
        }

        gameApp.run(playerNum);  // 끝말잇기 시작

        gameApp.scanner.close();
    }
}
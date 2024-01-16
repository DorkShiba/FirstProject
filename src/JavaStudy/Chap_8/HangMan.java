package JavaStudy.Chap_8;

import java.util.*;
import java.io.*;

public class HangMan {
    public static void main(String[] args) {
        Scanner scanner = null;  // 파일 스캐너
        Vector<String> wordVector = new Vector<>();  // 단어를 저장하는 벡터
        Scanner enter = new Scanner(System.in);  // 사용자 입력 스캐너

        try {
            // 스캐너를 문자 스트림인 FileReader와 연결
            scanner = new Scanner(new FileReader("C:\\Codeit\\Java_programming\\Java_Workspace\\src\\Sample\\Chap_8\\words.txt"));

            // 파일에 있는 단어들을 벡터에 저장함
            while (scanner.hasNext()) {
                String word = scanner.nextLine().trim();  // 한 라인 단위로 읽음, 단어장에 /n은 없다
                wordVector.add(word);
            }
        } catch (IOException e) {
            System.out.println("error");
        }

        // Run the game
        System.out.println("Now, start the Hang Man game.");

        int index;  // wordVector의 인덱스, 즉 문제로 낼 단어의 인덱스
        String problem;  // 문제로 낼 단어
        Vector<Integer> hide = new Vector<>();  // 단어의 숨겨진 부분의 위치를 저장하는 벡터
        char userInput;  // 유저가 입력한 답(알파벳)

        RunGame: while (true) {
            hide.clear();  // 숨겨진 부분을 담은 벡터를 초기화 함

            // 문제로 낼 단어 결정
            index = (int) (Math.random() * wordVector.size());
            problem = wordVector.get(index);

            // 단어에서 숨길 부분 결정
            while (hide.size() != 2) {
                int temp = (int)(Math.random() * problem.length());  // 위치 범위는 0 ~ 단어길이-1
                if (!hide.contains(temp)) { hide.add(temp); }  // 나온 숫자가 벡터에 없으면 넣음
            }

            // 문제 단어 출력
            for (int i = 0; i < problem.length(); i++) {
                if (hide.contains(i)) { System.out.print('-'); }  // 숨기는 부분은 '-'로
                else { System.out.print(problem.charAt(i)); }  // 아닌 부분은 본래 알파벳
            } System.out.println();

            // 사용자 입력 받기
            int count = 5;  // 시도 횟수 5회
            while (true) {
                System.out.print(">> ");
                userInput = enter.next().charAt(0);

                // hide 벡터가 담은 인덱스의 알파벳과 사용자가 입력한 알파벳이 동일하면 해당 인덱스를 벡터에서 삭제
                for (int i = 0; i < hide.size(); i++) {
                    if (problem.charAt(hide.get(i)) == userInput) { hide.remove(hide.get(i)); }
                }

                // 다시 단어 출력
                for (int i = 0; i < problem.length(); i++) {
                    if (hide.contains(i)) { System.out.print('-'); }
                    else { System.out.print(problem.charAt(i)); }
                } System.out.println();

                // hide 벡터가 비면(= 유저가 모든 알파벳을 맞추면) 해당 문제 종료
                if (hide.isEmpty()) { break; }

                // 아직 모든 알파벳을 맞추지 못 했을 경우
                count--;
                if (count == 0) {  // 모든 기회를 소진하면 실패
                    System.out.println("5 times fail");
                    System.out.println(problem);
                    break;
                }
            }

            // 또 행맨 게임을 할 것인지 입력 받기
            while (true) {
                System.out.print("Next(y/n)? ");
                String restart = enter.next();

                if (restart.equals("n")) {
                    break RunGame;
                } else if (!restart.equals("y")) {  // 사용자 입력이 y도 n도 아니면 다시 입력
                    System.out.println("please enter 'y' or 'n'");
                    continue;
                }

                break;
            }
        }
    }
}

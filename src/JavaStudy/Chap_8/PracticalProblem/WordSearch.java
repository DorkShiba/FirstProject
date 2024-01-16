package JavaStudy.Chap_8.PracticalProblem;

import java.util.*;
import java.io.*;

// Problem 12
public class WordSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        System.out.print("대상 파일명 입력>> ");
        String name = scanner.next();

        File file = new File(name);
        Scanner fileScan = null;
        try {
            fileScan = new Scanner(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Vector<String> lines = new Vector<>();
        int num = 1;
        while (fileScan.hasNext()) {
            lines.add(num + ": " + fileScan.nextLine());
            num++;
        }
        fileScan.close();

        String word;
        boolean find;
        while (true) {
            find = false;
            System.out.print("검색할 단어나 문장>> ");
            word = scanner.next();

            if (word.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains(word)) {
                    System.out.println(line);
                    find = true;
                }
            }

            if (!find) {
                System.out.println("없습니다.");
            }
        }
        scanner.close();
    }
}

package JavaStudy.Chap_8.PracticalProblem;

import java.util.*;
import java.io.*;

// Problem 11
public class WordPrint {
    public static void main(String[] args) {
        File words = new File("C:\\Codeit\\Java_programming\\Java_Workspace\\src\\Sample\\Chap_8\\words.txt");
        Vector<String> wordVector = new Vector<>();
        Scanner scanner = new Scanner(System.in);

        try {
            FileReader fr = new FileReader(words);
            BufferedReader br = new BufferedReader(fr, 1024);

            String line;
            while (true) {
                line = br.readLine();
                if (line == null) { break; }
                wordVector.add(line);
            }

            System.out.println("프로젝트 폴더 밑의 " + words.getName() + "파일을 읽었습니다...");
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String start;
        boolean find;
        while (true) {
            find = false;
            System.out.print("단어 >> ");
            start = scanner.next();

            if (start.equals("그만")) { break; }

            for (int i = 0; i < wordVector.size(); i++) {
                if (wordVector.get(i).startsWith(start)) {
                    System.out.println(wordVector.get(i));
                    find = true;
                }
            }
            if (!find) {
                System.out.println("발견할 수 없음");
            }
        }
        System.out.println("종료합니다...");
    }
}

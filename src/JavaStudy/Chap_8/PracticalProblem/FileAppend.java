package JavaStudy.Chap_8.PracticalProblem;

import java.util.Scanner;
import java.io.*;

// Problem 6
public class FileAppend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");

        System.out.print("첫번째 파일 이름을 입력하세요 >> ");
        String src = scanner.nextLine();
        System.out.print("두번째 파일 이름을 입력하세요 >> ");
        String dest = scanner.nextLine();

        File f1 = new File(src);
        File f2 = new File(dest);

        try {
            FileReader fr = new FileReader(f1);
            FileWriter fw = new FileWriter("appended.txt");

            char[] buf = new char[1024];
            int count;
            while (true) {
                count = fr.read(buf);
                if (count == -1) { break; }
                fw.write(buf, 0, count);
            }

            fr = new FileReader(f2);
            while (true) {
                count = fr.read(buf);
                if (count == -1) { break; }
                fw.write(buf, 0, count);
            }
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

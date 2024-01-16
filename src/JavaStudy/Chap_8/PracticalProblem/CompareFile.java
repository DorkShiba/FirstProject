package JavaStudy.Chap_8.PracticalProblem;

import java.util.Scanner;
import java.io.*;

// Problem 5
public class CompareFile {
    public static boolean compareFile(FileInputStream fin1, FileInputStream fin2) throws IOException {
        byte[] b1 = new byte[1024];
        byte[] b2 = new byte[1024];

        int c, d;
        while (true) {
            c = fin1.read(b1, 0, b1.length);  // File 1에서 읽어들인 문자의 양
            d = fin2.read(b2, 0, b2.length);  // File 2에서 읽어들인 문자의 양

            // 두 파일에서 읽어들인 문자 양이 다르면 다른 파일
            if (c != d) { return false; }

            // -1이면 파일 읽기 끝
            if (c == -1) { break; }

            // 읽어들인 문자들 중 다른 것이 있으면 다른 파일
            for (int i = 0; i < c; i++) {
                if (b1[i] != b2[i]) { return false; }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");

        System.out.print("첫번째 파일 이름을 입력하세요>> ");
        String first = scanner.next();
        System.out.print("두번째 파일 이름을 입력하세요>> ");
        String second = scanner.next();

        System.out.println(first + "와 " + second + "를 비교합니다.");

        FileInputStream fin1 = null;
        FileInputStream fin2 = null;
        try {
            fin1 = new FileInputStream(first);
            fin2 = new FileInputStream(second);

            if (compareFile(fin1, fin2)) {
                System.out.println("파일이 같습니다");
            } else {
                System.out.println("파일이 다릅니다");
            }

            fin1.close();
            fin2.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}

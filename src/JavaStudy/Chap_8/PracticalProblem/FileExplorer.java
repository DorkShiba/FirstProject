package JavaStudy.Chap_8.PracticalProblem;

import java.util.*;
import java.io.*;

// Problem 13
public class FileExplorer {
    public static void main(String[] args) {
        System.out.println("***** 파일 탐색기입니다. *****");
        Scanner scanner = new Scanner(System.in);
        File file = new File("c:\\");
        while (true) {
            System.out.println("\t[" + file.getPath() + "]\t");
            File[] fileList = file.listFiles();

            String fd;
            for (int i = 0; i < fileList.length; i++) {
                File curr = fileList[i];
                if (curr.isFile()) { fd = "file"; }
                else { fd = "dir"; }

//                System.out.println(fd + "\t\t" + curr.length() + "바이트\t\t" + curr.getName());
                System.out.printf("%-4s\t\t%d바이트\t\t%20s\n", fd, curr.length(), curr.getName());
            }

            System.out.print(">> ");
            StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
            String first = st.nextToken();
            if (first.equals("그만")) {
                break;
            } else if (first.equals("..")) {
                file = new File(file.getParent());
            } else {
                try {
                    if (first.equals("mkdir")) {
                        String second = st.nextToken();
                        File temp = new File(file.getPath() + "\\" + second);
                        if (temp.mkdir()) {
                            System.out.println(second + " 디렉터리를 생성했습니다.");
                        } else {
                            System.out.println("생성 실패");
                        }
                    } else if (first.equals("rename")) {
                        String second = st.nextToken();
                        String third = st.nextToken();
                        if ((new File(file.getPath() + "\\" + second)).renameTo(
                                new File(file.getPath() + "\\" + third))) System.out.println("complete");
                        System.out.println(second + "를 " + third + "로 이름 변경했습니다.");
                    } else {
                        if (!(new File(file.getPath() + "\\" + first)).exists()) {
                            System.out.println("디렉터리가 없습니다.");
                        } else {
                            file = new File(file.getPath() + "\\" + first);
                        }
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("파일명이 주어지지 않았습니다.");
                }
            }
        }
        scanner.close();
    }
}

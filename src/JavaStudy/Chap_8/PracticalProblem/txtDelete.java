package JavaStudy.Chap_8.PracticalProblem;

import java.io.*;

// Problem 9
public class txtDelete {
    public static void main(String[] args) {
        File directory = new File("c:\\temp");
        File[] list = directory.listFiles();

        int count = 0;
        System.out.println(directory.getPath() + "디렉터리의 .txt 파일을 모두 삭제합니다....");
        for (File f: list) {
            if (!f.isFile()) { continue; }
            if (f.getPath().lastIndexOf(".txt") != -1) {
                System.out.println(f.getPath() + " 삭제");
                f.delete();
                count++;
            }
        }

        System.out.println("총 " + count + "개의 .txt 파일을 삭제하였습니다.");
    }
}

package JavaStudy.Chap_8.PracticalProblem;

import java.io.*;

// Problem 8
public class MaxSizeFile {
    public static void main(String[] args) {
        File directory = new File("c:\\Temp");
        File[] fileList = directory.listFiles();
        long max = 0;
        File maxFile = null;
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                maxFile = (fileList[i].length() > max)? fileList[i]: maxFile;
                max = maxFile.length();
            }
        }

        System.out.println("가장 큰 파일은 " + maxFile.getPath() + " " + max + "바이트");
    }
}

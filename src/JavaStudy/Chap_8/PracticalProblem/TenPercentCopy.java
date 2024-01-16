package JavaStudy.Chap_8.PracticalProblem;

import java.io.*;

// Problem 7
public class TenPercentCopy {
    public static void main(String[] args) {
        File src = new File("C:\\Temp\\copyimg.jpg");
        File dest = new File("pro7.jpg");
        long tenPercent = src.length() / 10;
        long progress = 0;
        long readNum = 0;
        byte[] buf = new byte[1024];
        int c;

        System.out.println(src.getName() + "을/를 " + dest.getName() + "로 복사합니다.");
        System.out.println("10%마다 *을 출력합니다.");
        try {
            FileInputStream fin = new FileInputStream(src);
            FileOutputStream fout = new FileOutputStream(dest);

//            while (true) {
//                readNum = fin.read(buf, 0, buf.length);
//                if (readNum == -1) {
//                    if (progress > 0) {
//                        System.out.println('*');
//                        break;
//                    }
//                }
//
//                fout.write(buf, 0, (int) readNum);
//                progress += readNum;
//                if (progress >= tenPercent) {
//                    System.out.print('*');
//                    progress = 0;
//                }
//            }

            while ((c = fin.read()) != -1) {
                progress++;
                fout.write(c);
                if (progress >= tenPercent) {
                    System.out.print('*');
                    progress = 0;
                }
            }

            fin.close();
            fout.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}

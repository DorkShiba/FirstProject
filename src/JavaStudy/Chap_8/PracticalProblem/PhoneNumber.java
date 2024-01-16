package JavaStudy.Chap_8.PracticalProblem;

import java.util.Scanner;
import java.io.*;

// Problem 1
public class PhoneNumber {
    public static void main(String[] args) {
        File phone = new File("C:\\Codeit\\Java_programming\\Java_Workspace\\src\\Sample\\Chap_8\\PracticalProblem\\phone.txt");
        FileWriter fw = null;
        Scanner scanner = new Scanner(System.in);
        String name, number;

        System.out.println("전화번호 입력 프로그램입니다.");
        try {
            fw = new FileWriter("C:\\Codeit\\Java_programming\\Java_Workspace\\src\\Sample\\Chap_8\\PracticalProblem\\phone.txt");
            while (true) {
                System.out.print("이름 전화번호 >> ");
                name = scanner.next();
                if (name.equals("그만")) { break; }
                number = scanner.next();

                fw.write(name + " " + number + "\n");
            }

            fw.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}

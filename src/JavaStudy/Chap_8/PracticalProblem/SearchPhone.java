package JavaStudy.Chap_8.PracticalProblem;

import java.util.*;
import java.io.*;

// Problem 10
public class SearchPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner phoneScan = null;
        HashMap<String, String> phoneBook = new HashMap<>();

        try {
            phoneScan = new Scanner(new FileReader("C:\\Codeit\\Java_programming\\Java_Workspace\\src\\Sample\\Chap_8\\PracticalProblem\\phone.txt"));
        } catch (IOException e) {
            System.out.println("error");
        }

        while (phoneScan.hasNext()) {
            String line = phoneScan.nextLine();
            phoneBook.put(line.split(" ")[0], line.split(" ")[1]);
        }
        System.out.println("총 " + phoneBook.size() + "개의 전화번호를 읽었습니다.");

        String name;
        while (true) {
            System.out.print("이름 >> ");
            name = scanner.next();
            if (name.equals("그만")) { break; }

            System.out.println(phoneBook.getOrDefault(name, "찾는 이름이 없습니다."));
        }

        scanner.close();
        phoneScan.close();
    }
}

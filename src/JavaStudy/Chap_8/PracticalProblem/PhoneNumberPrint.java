package JavaStudy.Chap_8.PracticalProblem;

import java.io.*;

// Problem 2
public class PhoneNumberPrint {
    public static void main(String[] args) {
        File phone = new File("C:\\Codeit\\Java_programming\\Java_Workspace\\src\\Sample\\Chap_8\\PracticalProblem\\phone.txt");
        FileReader fr = null;
        BufferedReader br = null;
        int c;
        String str;

        try {
            fr = new FileReader(phone);
            br = new BufferedReader(fr, 20);
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            fr.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}

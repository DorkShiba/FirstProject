package JavaStudy.Chap_8.PracticalProblem;

import java.io.*;

// Problem 4
public class WithLineNumber {
    public static void main(String[] args) {
        File f = new File("c:\\windows\\system.ini");
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr, 1024);

            String line;
            int num = 1;
            while (true) {
                line = br.readLine();
                if (line == null) { break; }

                System.out.printf("%2d: %s%n", num, line);
                num++;
            }

            fr.close();
            br.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}

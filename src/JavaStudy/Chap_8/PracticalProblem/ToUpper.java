package JavaStudy.Chap_8.PracticalProblem;

import java.io.*;

// Problem 3
public class ToUpper {
    public static void main(String[] args) {
        File f = new File("c:\\windows\\system.ini");
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr, 1024);
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) { break; }
                line = line.toUpperCase();
                System.out.println(line);
            }
            fr.close();
            br.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}

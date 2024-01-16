package JavaStudy.Chap_6;
import java.util.Scanner;
import java.lang.StringBuffer;

// Chap 6 Open Challenge
public class Histogram {
    private static Scanner scanner = new Scanner(System.in);
    public static String readString() {
        StringBuffer sb = new StringBuffer();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals(";")) { break; }
            sb.append(line);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer[] alphabet = new StringBuffer[26];
        for (int i = 0; i < alphabet.length; i++) { alphabet[i] = new StringBuffer(); }
        System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");

        String text = readString();
        text = text.toUpperCase();

        int gap = 'A';
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int code = text.codePointAt(i);
            if (Character.isAlphabetic(c)) {
                alphabet[code - gap].append("-");
            }
        }

        System.out.println("히스토그램을 그립니다.");
        for (int i = 0; i < alphabet.length; i++) {
            System.out.print((char)(i + gap));
            System.out.println(alphabet[i]);
        }
    }
}

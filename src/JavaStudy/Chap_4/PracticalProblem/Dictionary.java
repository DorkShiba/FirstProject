package JavaStudy.Chap_4.PracticalProblem;
import java.util.Scanner;

// Problem 10
public class Dictionary {
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word) {
        for (int i = 0; i < kor.length; i++) {
            if (kor[i].equals(word)) {
                return word + "은/는 " + eng[i];
            }
        }

        return word + "은/는 저의 사전에 없습니다.";
    }

    public static void main(String[] args) {
        System.out.println("한영 단어 검색 프로그램입니다.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("한글 단어?");
        String word = scanner.next();
        while(!word.equals("그만")) {
            System.out.println(kor2Eng(word));
            System.out.print("한글 단어?");
            word = scanner.next();
        }
    }
}

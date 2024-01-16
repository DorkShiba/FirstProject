package JavaStudy.Chap_3.PracticalProblem;

public class Pro_13 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if ((i/10) % 3 == 0 && i > 9) {
                if ((i%10) % 3 == 0 && i % 10 != 0) {
                    System.out.println(i + " 박수 짝짝");
                } else {
                    System.out.println(i + " 박수 짝");
                }
            } else {
                if ((i%10) % 3 == 0 && i % 10 != 0) {
                    System.out.println(i + " 박수 짝");
                }
            }
        }
    }
}

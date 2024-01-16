package JavaStudy.Chap_3.PracticalProblem;

public class Pro_1 {
    public static void main(String[] args) {
        int sum1 = 0, i = 0;
        while (i < 100) {
            sum1 += i;
            i += 2;
        }

        int sum2 = 0;
        for (int j = 0; j < 100; j += 2) {
            sum2 += j;
        }

        int sum3 = 0, k = 0;
        do {
            sum3 += k;
            k += 2;
        } while (k < 100);

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
        /*
        1) 100 미만의 짝수들의 합을 구하는 코드 | 2450
        2) Pro_1 클래스로 완성함 (위 코드)
        3) Pro_1 클래스 내부에 완성함 (위 코드)
        4) Pro_1 클래스 내부에 완성함 (위 코드)
         */
    }
}

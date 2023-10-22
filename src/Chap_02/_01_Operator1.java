package Chap_02;

public class _01_Operator1 {
    public static void main(String[] args) {
        // 산술 연산자

        // 일반 연산
        System.out.println(4 + 2);  // 6
        System.out.println(4 - 2);  // 2
        System.out.println(4 * 2);  // 8
        System.out.println(4 / 2);  // 2
        System.out.println(5 / 2);  // 2  정수 간 연산에서는 실수 결과에서 소숫점 이하를 버림

        System.out.println(4 % 2);  // 4를 2로 나눈 나머지 > 0
        System.out.println(5 % 2);  // 1

        // 증감 연산 ++, --
        int a = 10;
        System.out.println("a1" + a);
        a++;
        System.out.println("a2" + a);
        System.out.println("a3" + ++a);

        System.out.println("a4" + a);
        System.out.println("a5" + a++);
        System.out.println("a6" + a);
    }
}

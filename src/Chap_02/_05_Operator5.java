package Chap_02;

public class _05_Operator5 {
    public static void main(String[] args) {
        // 삼항 연산자
        // 결과 = 조건 ? 참일 때 값 : 거짓일 때 결과
        int b = 5, c = 3;
        int a = (b > c) ? b : c;

        System.out.println(a); // 4
    }
}

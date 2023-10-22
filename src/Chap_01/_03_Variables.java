package Chap_01;

public class _03_Variables {
    public static void main(String[] args) {
        String name;
        name = "임성민";  // == String name = "임성민";

        int hour = 15;

        System.out.println(name + "님, " + hour + "시에요.");

        double score = 90.5;
        char grade = 'A';
        name = "강백호";

        System.out.println(name + "님의 평균 점수는 " + score + "점이고, 등급은 " + grade + "입니다.");

        boolean pass = true;
        System.out.println("이번시험은 " + pass);

        // double은 상대적으로 정밀한 데이터를 저장하기 적합하다.
        // float이란 실수형 자료형도 있다.
        double d = 3.14123456789;  // 소숫점이 있는 실수는 기본적으로 double 자료형으로 취급되기에 float 자료형으로 저장하려면
        float f = 3.14123456789f;  // 실수 뒤에 F나 f를 붙여서 저장한다.
        // float 자료형은 정밀하게 소수를 표현하지 못하기에 최대 자리에서 반올림하여 표현한다.

        System.out.println(d);
        System.out.println(f);

        long l = 1000000000000L; // int 자료형이 저장할 수 있는 크기는 -21억 ~ 21억 정도인데 그 범위를 초과하면 에러
        // 따라서 큰 수를 저장할 땐 long 자료형을 사용하며, 이때도 수 뒤에 L이나 l을 붙여줘야 한다.

        l = 1_000_000_000_000L; // 이렇게 언더바로 끊어서 표현도 가능하다

        System.out.println(l);
    }
}

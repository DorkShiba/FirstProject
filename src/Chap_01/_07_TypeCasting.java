package Chap_01;

public class _07_TypeCasting {
    public static void main(String[] args) {
        // 형변환
//        int score = 93 + 98.8;  정수 + 실수 이므로 오류
        int score = 93;

        System.out.println(score);  // 93
        System.out.println((float) score);  // 93.0
        System.out.println((double) score);  // 93.0

        float score2 = 93.3F;
        double score3 = 98.8;
        System.out.println((int) score2);  // 93
        System.out.println((int) score3);  // 98

        // int > long > float > double  (자동 형변환됨)
        // double > float > long > int  (수동으로 해야됨)

        // 숫자를 문자열로
        String s1 = String.valueOf(93);
        System.out.println("숫자 > 문자");
        System.out.println(s1);  // 93

        s1 = Integer.toString(94);
        System.out.println(s1);  // 94

        String s2 = String.valueOf(98.8);
        s2 = Double.toString(98.8);
        System.out.println(s2);  // 98.8

        // 문자열을 숫자로
        System.out.println("문자열 > 숫자");
        int i = Integer.parseInt("93");  // 팔싱한다 라고 표현한다
        System.out.println(i);  // 93

        double d = Double.parseDouble("98.8");
        System.out.println(d);  // 98.8
    }
}

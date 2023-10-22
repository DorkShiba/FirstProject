package Chap_03;

public class _02_String2 {
    public static void main(String[] args) {
        String s = "I like Java and Python and C.";

        // 문자열 변환
        System.out.println(s.replace(" and ", ", "));  // "and"를 콤마로 변환
        System.out.println(s.substring(7));  // 인덱스 7부터 끝까지 잘라냄
        System.out.println(s.substring(s.indexOf("Java")));  // "Java"의 위치 = 7

        // 시작위치는 "Java"의 위치를 포함하는데, 끝위치는 '.'의 위치를 포함하지 않음
        // 시작위치부터 끝위치 직전까지 잘라내는 메서드
        System.out.println(s.substring(s.indexOf("Java"), s.lastIndexOf('.')));

        // 공백제거
        String t = "              I like Java.          ";
        System.out.println(t.trim());  // 앞뒤공백 모두 제거

        // 문자열 결합
        String a = "Java";
        String b = "Python";
        System.out.println(a + b);
        System.out.println(a + ',' + b);
        System.out.println(a.concat(",").concat(b));
    }
}

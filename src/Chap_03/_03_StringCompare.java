package Chap_03;

public class _03_StringCompare {
    public static void main(String[] args) {
        // 문자열 비교
        String a = "Java";
        String b = "Python";

        System.out.println(a.equals(b));  // 두 문자열이 같은지
        System.out.println(a.equals("Java"));
        System.out.println(b.equalsIgnoreCase("python"));  // 대소문자 구분없이 문자가 같은지 확인

        a = "1234";
        b = "1234";
    }
}

package Chap_03;

public class _01_String1 {
    public static void main(String[] args) {
        // 문자열
        String s = "I like Java and Python and C.";

        // 문자열의 길이
        System.out.println("length: " + s.length());  // 29

        // 대소문자 변환
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s);

        // 포함관계
        System.out.println("Java is in string: " + s.contains("Java"));  // "Java" 포함 여부
        System.out.println("C# is in string: " + s.contains("C#"));

        System.out.println("Java's index is " + s.indexOf("Java"));  // "Java"라는 문구의 위치 7
        System.out.println("C#'s index is " + s.indexOf("C#"));  // "C#"이란 문구는 없기에 -1 출력
        System.out.println("and's index is " +
                s.indexOf("and"));  // "and"란 문구는 중복 되기에 맨 처음 나오는 인덱스
        System.out.println("and's last index is " +
                s.lastIndexOf("and")); // "and"의 위치를 뒤에서 부터 도출

        System.out.println("String starts with 'I like': " +
                s.startsWith("I like"));  // "I like"로 시작하는지 여부
        System.out.println("String starts with 'You are': " +
                s.startsWith("You are"));
        System.out.println("String ends with 'C.': " +
                s.endsWith("C."));  // "C."으로 끝나는지 여부
    }
}

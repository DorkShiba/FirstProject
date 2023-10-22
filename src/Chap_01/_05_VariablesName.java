package Chap_01;

public class _05_VariablesName {
    public static void main(String[] args) {
        // 변수 네이밍
        // 1. 저장하는 값에 어울리는 이름
        // 2. 밑줄( _ ), 문자, 숫자 사용가능, 공백 사용 불가
        // 3. 변수 이름은 밑줄 또는 문자로 시작 (숫자는 불가)
        // 4. 한 단어 또는 두 개 이상 단어의 연속
        // 5. 문자로 시작할 시, 소문자로 시작, 그 외 각 단어의 첫 글자는 대문자
        // 6. 예약어는 사용 불가
        // 7. 절대 변하지 않는 상수는 대문자로

        String a = "John";  // x
        String name = "John";  // 권장

        String age;
        String _age;
        // String 1age;  불가
        String ageOfUser;
        String age_of_user;
        // String age of user 불가

        // String void; 불가(예약어)
        double pi = 3.14;
        final double PI = 3.14;  // 파이 값은 변하지 않으므로 대문자로 작명 권장, final 예약어를 붙이면 상수가 됨 이후 수정 불가
    }
}

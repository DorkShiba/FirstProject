package Sample.Chap_6.PracticalProblem;
import java.lang.StringBuffer;
import java.util.Scanner;

public class StringEditor {
    private StringBuffer sb;
    private Scanner scanner = new Scanner(System.in);
    public StringEditor() {
        System.out.print(">>");
        String str = scanner.nextLine();
        sb = new StringBuffer(str);
    }
    public int find(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '!') { return i; }
        }
        return -1;
    }

    public void edit() {
        String command;
        while (true) {
            System.out.print("명령: ");
            command = scanner.nextLine();

            if (command.equals("그만")) {
                System.out.println("종료합니다");
                break;
            }

            int index = find(command);  // ! 위치 찾기

            if (index < 1) {  // ! 앞에 아무 문자열도 없으면 잘못된 명령
                System.out.println("잘못된 명령입니다!");
                continue;
            }

            String before = command.substring(0, index);  // 수정 전 문자열
            String after = command.substring(index+1);  // 수정 후 문자열

            int editIndex = sb.indexOf(before);  // 원 문자열에서 수정할 문자열이 있는 위치
            if (editIndex < 0) {  // 원 문자열에 수정할 문자열이 없을 때
                System.out.println("찾을 수 없습니다!");
                continue;
            }

            // 문자열 수정 후 수정된 문자열 출력
            sb.replace(editIndex, editIndex + before.length(), after);
            System.out.println(sb.toString());
        }

        scanner.close();
    }
    public static void main(String[] args) {
        StringEditor se = new StringEditor();
        se.edit();
    }
}

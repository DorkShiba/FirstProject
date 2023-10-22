package Sample.Chap_5.PracticalProblem;
import java.util.InputMismatchException;
import java.util.Scanner;

interface Stack {
    int length();
    int capacity();
    String pop();
    boolean push(String val);
}

class StringStack implements Stack {
    private int volume;
    private int len;
    private String[] stack;
    public StringStack(int volume) {
        this.volume = volume;
        stack = new String[volume];
        len = 0;
    }

    public int capacity() { return volume; }
    public int length() { return len; }

    public boolean push(String val) {
        if (len == volume) { return false; }
        else {
            stack[len] = val;
            len++;
            return true;
        }
    }

    public String pop() {
        String str = stack[len-1];
        stack[len-1] = null;
        len--;
        return str;
    }

}

public class StackApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vol; String str;

        while (true) {
            try {
                System.out.print("총 스택 저장공간 크기 입력 >> ");
                vol = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("올바른 정수를 입력해주세요");
                scanner.nextLine();
            }
        }

        StringStack s = new StringStack(vol);
        System.out.print("문자열 입력 >> ");
        str = scanner.next();

        while (!str.equals("그만")) {
            if (!s.push(str)) {
                System.out.println("스택이 꽉 차서 푸시 불가!");
            }
            System.out.print("문자열 입력 >> ");
            str = scanner.next();
        }

        System.out.print("스택에 저장된 모든 문자열 팝 : ");
        int L = s.length();
        for (int i = 0; i < L; i++) {
            System.out.print(s.pop() + " ");
        }

        scanner.close();
    }
}

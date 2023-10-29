package Sample.Chap_6;

import java.util.Calendar;
import java.util.StringTokenizer;

public class _06_ {
    public static void main(String[] args) {
        String a = "abc";
        System.out.println(a == "abc");
        String b = new String(a);
        System.out.println(a == b);
    }
}

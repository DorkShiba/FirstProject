package Sample.Chap_6;

import java.util.Calendar;
import java.util.StringTokenizer;

public class _06_ {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("abc def");
        String str = sb.toString();
        String a = "xy";
        System.out.println(sb.indexOf(a));
    }
}

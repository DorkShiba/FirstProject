package JavaStudy.Chap_6.PracticalProblem;
import java.util.Calendar;

public class Pro_5 {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        System.out.println("Now is " + hour + ":" + now.get(Calendar.MINUTE));
        if (hour >= 4 && hour <= 12) {
            System.out.println("Good Morning");
        } else if (hour <= 18 && hour >= 4) {
            System.out.println("Good Afternoon");
        } else if (hour <= 22 && hour >= 4) {
            System.out.println("Good Evening");
        } else {
            System.out.println("Good Night");
        }
    }
}

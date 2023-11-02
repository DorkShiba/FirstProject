package Sample.Chap_6.PracticalProblem.main;
import Sample.Chap_6.PracticalProblem.etc.Calc;

public class MainApp {
    public static void main(String[] args) {
        Calc c = new Calc(10, 20);
        System.out.println(c.sum());
    }
}

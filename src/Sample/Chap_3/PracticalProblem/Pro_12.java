package Sample.Chap_3.PracticalProblem;

public class Pro_12 {
    public static void main(String[] args) {
        int sum = 0;
        for (String s: args) {
            try {
                sum += Integer.parseInt(s);
            } catch(NumberFormatException e) {
                continue;
            }
        }

        System.out.println(sum);
    }
}

package Sample.Chap_3.PracticalProblem;

public class Pro_11 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }

        System.out.println((double)sum / args.length);
    }
}

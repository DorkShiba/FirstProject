package Sample.Chap_3.PracticalProblem;

public class Pro_10 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        int x, y, count = 0;

        while (count < 10) {
            x = (int)(Math.random() * 4);
            y = (int)(Math.random() * 4);
            if (arr[x][y] == 0) {
                arr[x][y] = (int)(Math.random() * 10 + 1);
                count++;
            }
        }

        for (int[] i: arr) {
            for (int j: i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}

package JavaStudy.Chap_4.PracticalProblem;

// Problem 9
class ArrayUtil {
    // 두 정수 배열을 받아 합쳐진 배열을 리턴하는 메소드
    public static int[] concat(int[] a, int[] b) {
        int[] newArr = new int[a.length + b.length];
        for (int i = 0; i < newArr.length; i++) {
            if (i < a.length) { newArr[i] = a[i]; }
            else { newArr[i] = b[i - a.length]; }
        }

        return newArr;
    }

    // 정수 배열을 받아 출력하는 메소드
    public static void print(int[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }
}

public class StaticEx {
    public static void main(String[] args) {
        int[] array1 = {1, 5, 7, 9};
        int[] array2 = {3, 6, -1, 100, 77};
        int[] array3 = ArrayUtil.concat(array1, array2);
        ArrayUtil.print(array3);
    }
}

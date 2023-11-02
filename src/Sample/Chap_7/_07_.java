package Sample.Chap_7;

class A<T> {
    Object[] a = new Object[5];
    int b;
    int l;
    public A(int b) {
        this.b = b;
        l = 0;
    }
    void get(T a) {
        this.a[l] = a;
        l++;
    }
}
public class _07_ {
    static <T> void toStack(T[] a, A<T> gs) {
        for (int i = 0; i < a.length; i++) {
            gs.get(a[i]);
        }
    }

    public static void main(String[] args) {
        Object[] oArr = new Object[5];
        A<Object> oA = new A<Object>(5);
        toStack(oArr, oA);

        String[] sArr = new String[5];
        A<String> sA = new A<String>(5);
        toStack(sArr, sA);

        toStack(sArr, oA);
    }
}

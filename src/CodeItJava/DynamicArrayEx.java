package CodeItJava;

public class DynamicArrayEx<E> {
    Object[] arr;
    int size;

    public DynamicArrayEx() { this(5); }
    public DynamicArrayEx(int length) {
        arr = new Object[length];
        this.size = 0;
    }

    private void toTwiceArray() {
        Object[] newArr = new Object[size * 2];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    private void toHalfArray() {
        Object[] newArr = new Object[size];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    public void append(E e) {
        if (size == arr.length) { toTwiceArray(); }
        arr[size] = e;
        size++;
    }

    public void insert(E e, int index) {
        if (size == arr.length) { toTwiceArray(); }

        for (int i = size; i > index; i--) { arr[i] = arr[i-1]; }
        arr[index] = e;
        size++;
    }

    public E pop() {
        if (size == 0) { return null; }

        Object temp = arr[size-1];
        size--;
        arr[size] = null;
        if (size <= arr.length / 2) {
            toHalfArray();
        }

        return (E) temp;
    }

    public E delete(int index) {
        if (size == 0 || index >= size || index < 0) { return null; }

        Object temp = arr[index];
        for (int i = index; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        arr[size] = null;
        if (size <= arr.length / 2) {
            toHalfArray();
        }

        return (E) temp;
    }

    public void delete(int start, int end) {
        if (size == 0 || start < 0 || end > size || start > end) { return; }
        for (int i = start; i < size - (end - start); i++) {
            arr[i] = arr[i + (end - start)];
        }
        for (int i = size - (end - start); i < size; i++) { arr[i] = null; }
        size -= (end - start);

        if (size <= arr.length / 2) { toHalfArray(); }
    }

    public E get(int index) {
        return (E) arr[index];
    }

    public int capacity() { return arr.length; }
    public int size() { return size; }

    public static void main(String[] args) {
        DynamicArrayEx<Integer> arr = new DynamicArrayEx<>();
        System.out.println("Insert");
        for (int i = 0; i < 30; i++) {
            arr.insert(i, 0);
            System.out.println(arr.capacity() + " " + arr.size());
        }

        System.out.println("Show all");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        System.out.println("pop");
        for (int i = 0; i < 10; i++) {
            System.out.println(arr.pop());
        }

        System.out.println("capacity and size");
        System.out.println(arr.capacity() + " " + arr.size());

        System.out.println("all delete");
        arr.delete(0, arr.size);
        System.out.println(arr.capacity() + " " + arr.size());
    }
}

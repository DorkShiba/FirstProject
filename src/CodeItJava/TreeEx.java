package CodeItJava;

class TNode<E> {
    private E data;
    private Object[] children;
    private int childNum;

    public TNode(E data) { this(data, 2); }
    public TNode(E data, int child_num) {
        this.data = data;
        children = new Object[child_num];
        childNum = 0;
    }

    public void data(E data) { this.data = data; }
    public E data() { return data; }

    public void child(TNode<E> node, int index) {
        if (index >= children.length || index < 0) { return; }
        else {
            children[index] = node;
            childNum++;
        }
    }
    public void child(E data, int index) { child(new TNode<>(data), index); }
    public TNode<E> child(int index) {
        if (index >= children.length || index < 0) { return null; }
        else { return (TNode<E>) children[index]; }
    }

    public int childNum() { return childNum; }
    public int maxChild() { return children.length; }
    public boolean hasChild() { return children[0] != null; }
}

class BinaryTree<E> {
    private TNode<E> root;
    protected int size;
    public BinaryTree() {
        root = null;
        size = 0;
    }
    public BinaryTree(E data) { this(new TNode<>(data)); }
    public BinaryTree(TNode<E> node) {
        root = node;
        size = 1;
    }

    public void root(TNode<E> node) {
        if (size == 0) {
            root = node;
            size++;
        } else { root = node; }
    }
    public void root(E data) { root(new TNode<>(data)); }
    public TNode<E> root() { return root; }

    public void traverse(TNode<E> root) {
        if (root.child(0) != null) { traverse(root.child(0)); }
        System.out.println(root.data());
        if (root.child(1) != null) { traverse(root.child(1)); }
    }

    public boolean empty() { return size == 0; }
    public String toString() {
        String res = "|";

        return "";
    }
}

public class TreeEx {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>(1);
        bt.root().child(2, 0);
        bt.root().child(3, 1);
        bt.root().child(0).child(4, 0);
        bt.root().child(0).child(5, 1);
        bt.root().child(1).child(6, 0);
        bt.root().child(1).child(7, 1);
        bt.traverse(bt.root());
    }
}

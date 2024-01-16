package CodeItJava;
import java.util.Scanner;



class Node<E> {
    private E data;
    private Node<E> next;
    public Node(E data) {
        this.data = data;
        next = null;
    }

    public void data(E data) { this.data = data; }
    public E data() { return data; }

    public void next(Node<E> e) { this.next = e; }
    public Node<E> next() { return next; }

    public boolean hasNext() { return next != null; }

    public String toString() { return data.toString(); }
}

class DNode<E> extends Node<E> {
    private DNode<E> prev;
    public DNode(E data) {
        super(data);
        prev = null;
    }

    public DNode<E> next() { return (DNode<E>) super.next(); }

    public void prev(DNode<E> e) { this.prev = e; }
    public DNode<E> prev() { return prev; }

    public boolean hasPrev() { return prev != null; }
}

class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    protected int size;

    // constructor
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public LinkedList(E data) { this(new Node<>(data)); }
    public LinkedList(Node<E> node) {
        head = node;
        tail = node;
        size = 1;
    }

    public void head(Node<E> node) {
        if (size == 0) {
            head = node;
            tail = node;
            size = 1;
        } else { head = node; }
    }
    public void head(E data) {
        Node<E> node = new Node<>(data);
        head(node);
    }
    public Node<E> head() { return head; }

    public void tail(Node<E> node) {
        if (size == 0) { head(node); }
        else { tail = node; }
    }
    public void tail(E data) { tail(new Node<>(data)); }
    public Node<E> tail() { return tail; }

    public int size() { return size; }

    public Node<E> get(int index) {
        if (index > size-1 || index < 0) { return null; }

        int count = 0;
        Node<E> temp = head;
        while (count != index) {
            temp = temp.next();
            count++;
        }

        return temp;
    }

    // 삽입 연산
    public void insert(E data, int index) {
        if (index > size || index < 0) { return; }

        Node<E> node = new Node<>(data);
        if (index == 0) { prepend(data); }
        else if (index == size) { append(data); }
        else {
            Node<E> temp = get(index - 1);
            node.next(temp.next());
            temp.next(node);
            size++;
        }
    }

    // 가장 앞 삽입 연산
    public void prepend(E data) {
        Node<E> node = new Node<>(data);
        node.next(head);
        head = node;
        size++;
    }

    // 추가(맨 뒤 삽입) 연산
    public void append(E data) {
        Node<E> node = new Node<>(data);
        if (size == 0) { head = node; }
        else { tail.next(node); }
        tail = node;
        size++;
    }

    // 맨 뒤(tail 노드) 삭제 연산
    public Node<E> pop() {
        if (size == 0) { return null; }

        Node<E> node = tail;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> temp = get(size - 2);
            temp.next(null);
            tail = temp;
        }
        size--;

        return node;
    }

    // 맨 앞(head 노드) 삭제 연산
    public Node<E> popLeft() {
        if (size < 2) { return pop(); }

        Node<E> node = head;
        head = head.next();
        size--;

        return node;
    }

    // 삭제 연산
    public Node<E> delete(int index) {
        if (index < 0 || index >= size) { return null; }

        if (index == 0) { return popLeft(); }
        else if (index == size - 1) { return pop(); }

        Node<E> temp = get(index - 1);
        Node<E> node = temp.next();
        temp.next(temp.next().next());
        size--;

        return node;
    }

    public boolean empty() { return size == 0; }
    public String toString() {
        String res = "|";
        int count = 0;
        Node<E> it = head;
        while (count != size) {
            res = res.concat(it.toString() + "|");
            it = it.next();
            count++;
        }

        return res;
    }
}

class DoublyLinkedList<E> extends LinkedList<E> {
    public DoublyLinkedList() { super(); }
    public DoublyLinkedList(E data) {
        super(new DNode<>(data));
    }

    public void head(E data) { this.head(new DNode<>(data)); }
    public DNode<E> head() {
        if (super.head() == null) { return null; }
        else { return (DNode<E>) super.head(); }
    }

    public void tail(E data) { this.tail(new DNode<>(data)); }
    public DNode<E> tail() {
        if (super.tail() == null) { return null; }
        else { return (DNode<E>) super.tail(); }
    }

    public DNode<E> get(int index) { return (DNode<E>) super.get(index); }

    public void prepend(E data) {
        DNode<E> node = new DNode<>(data);
        if (size() == 0) {
            this.head(node);
        } else {
            node.next(this.head());
            this.head().prev(node);
            this.head(node);
            size++;
        }
    }

    public void append(E data) {
        DNode<E> node = new DNode<>(data);
        if (size == 0) {
            this.head(node);
        } else {
            this.tail().next(node);
            node.prev(this.tail());
            tail(node);
            size++;
        }
    }

    public void insert(E data, int index) {
        DNode<E> node = new DNode<>(data);
        if (index < 0 || index > size()) { return; }

        if (index == 0) { prepend(data); }
        else if (index == size()) { append(data); }
        else {
            DNode<E> temp = get(index - 1);
            node.next(temp.next());
            node.next().prev(node);
            node.prev(temp);
            temp.next(node);
            size++;
        }
    }

    public DNode<E> pop() {
        if (size == 0) { return null; }
        else { return (DNode<E>) super.pop(); }
    }

    public DNode<E> popLeft() {
        if (size == 0) { return null; }
        else if (size == 1) { return (DNode<E>) super.popLeft(); }

        DNode<E> node = head();
        head().next().prev(null);
        head(head().next());
        size--;

        return node;
    }

    public DNode<E> delete(int index) {
        if (index < 0 || index >= size) { return null; }

        if (index == 0) { return this.popLeft(); }
        else if (index == size - 1) { return this.pop(); }

        DNode<E> node = get(index);
        node.prev().next(node.next());
        node.next().prev(node.prev());

        return node;
    }
}

public class LinkedListEx {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(0);
        for (int i = 1; i < 21; i++) {
            dll.prepend(i);
        }
        System.out.println(dll);

        dll.popLeft();
        System.out.println(dll);

        dll.pop();
        System.out.println(dll);
    }
}

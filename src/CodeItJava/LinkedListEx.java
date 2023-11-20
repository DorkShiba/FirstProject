package CodeItJava;
import java.util.Scanner;

class Node<E> {
    private E data;
    private Node next;
    public Node(E data) {
        this.data = data;
        next = null;
    }

    // setter
    public void setData(E data) { this.data = data; }
    public void setNext(Node e) { next = e; }

    // getter
    public E getData() { return data; }
    public Node getNext() { return next; }

    public boolean hasNext() { return next != null; }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    // constructor
    public LinkedList() {
        this(null);
        size = 0;
    }
    public LinkedList(Node node) {
        head = node;
        tail = node;
        size = 1;
    }

    // setter
    public void setHead(Node head) { this.head = head; }
    public void setTail(Node tail) { this.tail = tail; }

    // getter
    public Node getHead() { return head; }
    public Node getTail() { return tail; }
    public int size() { return size; }

    public <E> void append(E data) {
        Node<E> node = new Node<>(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public <E> void insert(E data, int index) {
        Node<E> node = new Node<>(data);
        if (size == 0) {
            if (index != 0) { return; }
            head = node;
            tail = node;
        } else {
            if (index > size) { return; }
            else if (index == 0) {
                node.setNext(head);
                head = node;
                size++;
                return;
            }

            int count = 0;
            Node temp = head;
            while (count != index - 1) {
                temp = temp.getNext();
                count++;
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        size++;
    }

    public Node pop() {
        if (size == 0) { return null; }

        Node node = tail;
        Node it = head;
        while (!it.getNext().equals(tail)) {
            it = it.getNext();
        }
        it.setNext(null);
        tail = it;
        size--;
        return node;
    }

    public void delete(int index) {
        if (size == 0) { return; }

        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }

        int count = 0;
        Node it = head;
        while (count != index - 1) {
            it = it.getNext();
            count++;
        }
        it.setNext(it.getNext().getNext());
        size--;
    }

    public boolean empty() { return head == null; }
}
public class LinkedListEx {
    public static void main(String[] args) {
        Node<String> a = new Node<>("Hello");
        Scanner scanner = new Scanner(System.in);
        LinkedList ll = new LinkedList(a);
        String str = "";
        while (!str.equals("quit") && !str.equals("그만")) {
            System.out.print(">> ");
            str = scanner.nextLine();
            String[] spl = str.split(" ");

            switch (spl[0]) {
                case "int" -> ll.append(Integer.parseInt(spl[1]));
                case "double" -> ll.append(Double.parseDouble(spl[1]));
                case "boolean" -> ll.append(Boolean.parseBoolean(spl[1]));
                case "char" -> ll.append(spl[1].charAt(0));
                default -> ll.append(spl[1]);
            }
        }
    }
}

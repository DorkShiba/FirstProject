package CodeItJava;
import java.util.Scanner;

class HNode<K, V> extends Node<V> {
    private K key;
    public HNode(K key, V value) {
        super(value);
        this.key = key;
    }

    public void key(K key) { this.key = key; }
    public K key() { return key; }

    public HNode<K, V> next() { return (HNode<K, V>) super.next(); }

    public String toString() { return key.toString().concat(": " + data().toString()); }
}

class HashLinkedList<K, V> extends LinkedList<V> {
    public HashLinkedList() { this(null); }
    public HashLinkedList(HNode<K, V> node) { super(node); }
    public HashLinkedList(K key, V value) { super(new HNode<>(key, value)); }

    public void head(K key, V value) { head(new HNode<>(key, value)); }
    public HNode<K, V> head() {
        if (super.head() == null) { return null; }
        else { return (HNode<K, V>) super.head(); }
    }

    public void tail(K key, V value) { tail(new HNode<>(key, value)); }
    public HNode<K, V> tail() {
        if (super.tail() == null) { return null; }
        else { return (HNode<K, V>) super.tail(); }
    }

    public HNode<K, V> get(K key) {
        int count = 0;
        HNode<K, V> it = head();
        while (count != size) {
            if (it.key().equals(key)) { return it; }
            it = it.next();
            count++;
        }
        return null;
    }

    public boolean contains(K key) { return get(key) != null; }

    public void append(K key, V value) {
        HNode<K, V> node = new HNode<>(key, value);
        if (size == 0) { this.head(node); }

        this.tail().next(node);
        tail(node);
        size++;
    }

    public HNode<K, V> delete(K key) {
        if (!contains(key)) { return null; }

        int count = 0;
        HNode<K, V> it = head();
        while (count != size) {
            if (it.key().equals(key)) { break; }
            it = it.next();
            count++;
        }

        if (count == 0) { return (HNode<K, V>) popLeft(); }
        else if (count == size - 1) { return (HNode<K, V>) pop(); }
        else { return (HNode<K, V>) delete(count); }
    }

    public String toString() {
        String res = "|";
        int count = 0;
        HNode<K, V> it = head();
        while (count != size) {
            res = res.concat(it.toString());
            count++;
        }

        return res;
    }
}

class HashTable<K, V> {
    private Object[] table;
    protected int size;
    public HashTable() { this(30); }
    public HashTable(int size) {
        this.size = size;
        table = new Object[size];
    }

    public int size() { return size; }

    public int hash(K key) { return key.hashCode() % size; }

    public void put(K key, V value) {
        int index = hash(key);
        System.out.println(index + " index");
        if (table[index] != null) {
            HashLinkedList<K, V> temp = (HashLinkedList<K, V>) table[index];
            if (temp.contains(key)) { temp.get(key).data(value); }
            else { temp.append(key, value); }
        } else {
            table[index] = new HashLinkedList<>(key, value);
        }
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) { return null; }

        HashLinkedList<K, V> hll = (HashLinkedList<K, V>) table[index];
        if (hll.contains(key)) { return hll.get(key).data(); }
        else { return null; }
    }

    public boolean contains(K key) {
        int index = hash(key);
        if (table[index] == null) { return false; }
        HashLinkedList<K, V> temp = (HashLinkedList<K, V>) table[index];
        return temp.contains(key);
    }

    public void delete(K key) {
        int index = hash(key);
        if (table[index] == null) { return; }

        HashLinkedList<K, V> temp = (HashLinkedList<K, V>) table[index];
        if (!temp.contains(key)) { return; }
        else {
            temp.delete(key);
        }
    }
}

public class HashTableEx {
    public static void main(String[] args) {
        HashTable<String, String> ht = new HashTable<>();
        ht.put("Lim", "SM");
        ht.put("Kim", "MG");
        ht.put("Lee", "HS");
        ht.put("Pak", "GG");

        System.out.println(ht.contains("Lim") + " whether Lim exists");
        System.out.println(ht.contains("Hwang") + " whether Hwang exists");

        System.out.println(ht.get("Lee") + " Lee's value");
        System.out.println(ht.hash("Lim"));

        System.out.println(ht.contains("Pak"));
        ht.delete("Pak");
        System.out.println(ht.contains("Pak"));
    }
}

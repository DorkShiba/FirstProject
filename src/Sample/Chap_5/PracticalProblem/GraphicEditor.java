package Sample.Chap_5.PracticalProblem;

abstract class Shape {
    private Shape next;
    public Shape() { next = null; }
    public void setNext(Shape obj) { next = obj; }
    public Shape getNext() { return next; }
    public abstract void draw();
}

class Line {
    public void draw() {
        System.out.println("Line");
    }
}

class Rect {
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle {
    public void draw() {
        System.out.println("Circle");
    }
}

public class GraphicEditor {
    private static Shape start, last;
    public static void insert(Shape s) {
        last.setNext(s);
        last = s;
    }

    public static void delete(int num) {
        Shape temp = start;
        int count = 0;
        while (temp != last) {
            if (count == num - 1) {
                
            }
        }
    }
    public static void main(String[] args) {
    }
}

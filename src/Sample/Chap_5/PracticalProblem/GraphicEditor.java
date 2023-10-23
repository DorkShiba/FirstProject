package Sample.Chap_5.PracticalProblem;
import java.util.Scanner;

abstract class Shape {
    private Shape next;
    public Shape() { next = null; }
    public void setNext(Shape obj) { next = obj; }
    public Shape getNext() { return next; }
    public abstract void draw();
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

public class GraphicEditor {
    private Shape start, last;
    private int length;
    private Scanner scanner;
    public GraphicEditor() {
        start = null; last = null;
        length = 0;
        scanner = new Scanner(System.in);
    }

    public void run() {
        int work;
        System.out.println("그래픽 에디터 beauty를 실행합니다.");
        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            work = scanner.nextInt();
            if (work == 1) { insert(); }
            else if (work == 2) { delete(); }
            else if (work == 3) { allShow(); }
            else { finish(); break; }
        }
    }

    private void insert() {
        Shape s;
        int which;
        System.out.print("Line(1), Rect(2), Circle(3)>>");
        which = scanner.nextInt();
        switch (which) {
            case 1 -> s = new Line();
            case 2 -> s = new Rect();
            default -> s = new Circle();
        }

        if (length == 0) {
            start = s;
            last = s;
            length++;
        } else {
            last.setNext(s);
            last = s;
            length++;
        }
    }

    private void delete() {
        int num;
        System.out.print("삭제할 도형의 위치>>");
        num = scanner.nextInt();
        if (num - 1 > length) { System.out.println("삭제할 수 없습니다."); }
        else {
            int count = 1;
            Shape temp = start;
            while (true) {
                if (count == num - 1) {
                    temp.setNext(temp.getNext().getNext());
                    break;
                } else {
                    count++;
                    temp = temp.getNext();
                }
            }
            length--;
        }
    }

    private void allShow() {
        Shape temp = start;
        while (temp != null) {
            temp.draw();
            temp = temp.getNext();
        }
    }

    private void finish() {
        scanner.close();
        System.out.println("beauty를 종료합니다.");
    }

    public static void main(String[] args) {
        GraphicEditor ge = new GraphicEditor();
        ge.run();
    }
}

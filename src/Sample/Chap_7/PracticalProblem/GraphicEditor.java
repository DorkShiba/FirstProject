package Sample.Chap_7.PracticalProblem;

import java.util.*;

abstract class Shape {
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
    private Vector<Shape> graphic = new Vector<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        int work;
        System.out.println("그래픽 에디터 beauty를 실행합니다.");
        while (true) {
            while (true) {
                try {
                    System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
                    work = scanner.nextInt();
                    if (work < 1 || work > 4) {
                        System.out.println("1 ~ 4의 정수를 입력해주세요");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("1 ~ 4의 정수를 입력해주세요");
                    scanner.nextLine();
                }
            }

            if (work == 1) { insert(); }
            else if (work == 2) { delete(); }
            else if (work == 3) { allShow(); }
            else { finish(); break; }
        }
    }

    private void insert() {
        Shape s;
        int which;
        while (true) {
            try {
                System.out.print("Line(1), Rect(2), Circle(3)>>");
                which = scanner.nextInt();
                if (which < 1 || which > 3) {
                    System.out.println("1 ~ 3의 정수를 입력해주세요");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("1 ~ 3의 정수를 입력해주세요");
                scanner.nextLine();
            }
        }

        switch (which) {
            case 1 -> s = new Line();
            case 2 -> s = new Rect();
            default -> s = new Circle();
        }
        graphic.add(s);
    }

    private void delete() {
        int num;
        System.out.print("삭제할 도형의 위치>>");
        num = scanner.nextInt();
        if (num - 1 > graphic.size() || num < 1) { System.out.println("삭제할 수 없습니다."); }
        else {
            graphic.remove(num - 1);
        }
    }

    private void allShow() {
        var it = graphic.iterator();
        while (it.hasNext()) {
            it.next().draw();
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
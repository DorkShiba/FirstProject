package JavaStudy.Chap_5.PracticalProblem;

interface Shape2 {
    final double PI = 3.14;
    void draw();
    double getArea();
    default public void redraw() {
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}
class Circle2 implements Shape2 {
    private int radius;
    public Circle2(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("반지름이 " + radius + "인 원입니다.");
    }

    public double getArea() {
        return radius * radius * PI;
    }
}

class Oval implements Shape2 {
    private int width, height;
    public Oval(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println(width + "x" + height + "에 내접하는 타원");
    }

    public double getArea() {
        return width * height * PI / 4;
    }
}

class Rect2 implements Shape2 {
    private int width, height;
    public Rect2(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println(width + "x" + height + "크기의 사각형");
    }

    public double getArea() {
        return width * height;
    }
}

public class ShapeApp {
    public static void main(String[] args) {
        Shape2[] list = new Shape2[3];
        list[0] = new Circle2(10);
        list[1] = new Oval(20, 30);
        list[2] = new Rect2(10, 40);
        for (int i = 0; i<list.length; i++) {
            list[i].redraw();
            System.out.println("Area is " + list[i].getArea());
        }
    }
}

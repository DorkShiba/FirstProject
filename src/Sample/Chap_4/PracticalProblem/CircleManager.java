package Sample.Chap_4.PracticalProblem;
import java.util.InputMismatchException;
import java.util.Scanner;

// Problem 5, 6
class Circle {
    private double x, y;  // 원의 중심의 좌표
    private int radius;  // 원의 반지름 길이
    private final static double PI = 3.14;  // 원주율 값(static 필드)
    public static Circle maxCircle;  // 가장 넓이가 큰 원(static 필드)

    public Circle(double x, double y, int radius) {
        this.x = x; this.y = y;
        this.radius = radius;

        // 현재까지 가장 넓이가 큰 원과 비교해 넓이가 더 넓으면 maxCircle을 바꿈
        if (maxCircle == null || this.area() > maxCircle.area()) {
            maxCircle = this;
        }
    }

    // 필드 게터
    public double getX() { return this.x; }
    public double getY() { return this.y; }
    public int getRadius() { return this.radius; }

    // 필드 세터
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setRadius(int radius) { this.radius = radius; }

    // 원의 정보를 설명하는 메소드
    public void show() {
        System.out.println("(" + this.x + "," + this.y + ")" + this.radius);
    }

    // 원의 넓이를 리턴하는 메소드
    public double area() {
        return Circle.PI * Math.pow(this.radius, 2);
    }

    // 가장 넓이가 큰 원을 설명하는 메소드
    public static void maxCircleShow() {
        System.out.print("가장 면적이 큰 원은 ");
        System.out.println("(" + maxCircle.x + "," + maxCircle.y + ")" + maxCircle.radius);
    }
}

public class CircleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle[] c = new Circle[3];
        double x, y;
        int radius;

        for (int i = 0; i < c.length; i++) {
            while (true) {
                try {
                    System.out.print("x, y, radius >>");
                    x = scanner.nextDouble();
                    y = scanner.nextDouble();
                    radius = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("중심좌표는 실수, 반지름은 정수를 입력해 주세요.");
                    scanner.nextLine();
                }
            }

            c[i] = new Circle(x, y, radius);
        }

        Circle.maxCircleShow();

        scanner.close();
    }
}

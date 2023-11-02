package Sample.Chap_6.PracticalProblem;

public class Circle {
    private int x, y, radius;
    public Circle(int x, int y, int radius) { this.x = x; this.y = y; this.radius = radius; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getRadius() { return radius; }
    public String toString() { return "Circle(" + x + "," + y + ")반지름" + radius; }
    public boolean equals(Object obj) {
        if (!(obj instanceof Circle c)) {
            return false;
        }

        return x == c.getX() && y == c.getY();
    }

    public static void main(String[] args) {
        Circle a = new Circle(2, 3, 5);
        Circle b = new Circle(2, 3, 30);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        if (a.equals(b)) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }
    }
}

package Sample.Chap_5.PracticalProblem;

public class PositivePoint extends Point {
    // Constructor
    public PositivePoint() { super(0, 0); }
    public PositivePoint(int x, int y) {
        super(x, y);
        if (x < 0 || y < 0) { super.move(0, 0); }
    }

    public void move(int x, int y) {
        if (x >=0 && y >= 0) { super.move(x, y); }
    }

    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")의 점";
    }

    public static void main(String[] args) {
        PositivePoint p = new PositivePoint();
        p.move(10, 10);
        System.out.println(p);

        p.move(-5, 5);
        System.out.println(p);

        PositivePoint p2 = new PositivePoint(-10, -10);
        System.out.println(p2);
    }
}

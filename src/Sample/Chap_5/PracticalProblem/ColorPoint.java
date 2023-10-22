package Sample.Chap_5.PracticalProblem;

import java.awt.*;

public class ColorPoint extends Point {
    private String color;
    public ColorPoint() { this(0, 0, "Black"); }
    public ColorPoint(int x, int y) { this(x, y, "Black"); }
    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public void setXY(int x, int y) { super.move(x, y); }
    public void setColor(String color) { this.color = color; }
    public String toString() {
        return color + "색의 (" + this.getX() + "," + this.getY() + ")의 점";
    }

    public static void main(String[] args) {
        ColorPoint zp = new ColorPoint();
        System.out.println(zp.toString());

        ColorPoint cp = new ColorPoint(10, 10);
        cp.setXY(5, 5);
        cp.setColor("Red");
        System.out.println(cp.toString());
    }
}

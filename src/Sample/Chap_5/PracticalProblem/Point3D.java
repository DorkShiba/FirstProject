package Sample.Chap_5.PracticalProblem;

public class Point3D extends Point {
    private int z;
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public String toString() {
        return "(" + this.getX() + "," + this.getY() + "," + z + ")의 점";
    }

    public void moveUp() { z++; }
    public void moveDown() { z--; }
    public void move(int x, int y, int z) {
        super.move(x, y);
        this.z = z;
    }

    public static void main(String[] args) {
        Point3D p = new Point3D(1, 2, 3);
        System.out.println(p.toString());

        p.moveUp();
        System.out.println(p.toString());

        p.moveDown();
        p.move(10, 10);
        System.out.println(p.toString());

        p.move(100, 200, 300);
        System.out.println(p.toString());
    }
}

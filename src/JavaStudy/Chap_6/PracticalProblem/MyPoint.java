package JavaStudy.Chap_6.PracticalProblem;

public class MyPoint {
    private int x, y;
    public MyPoint(int x, int y) { this.x = x; this.y = y; }
    public String toString() { return "Point(" + x + "," + y + ")"; }
    public int getX() { return x; }
    public int getY() { return y; }
    @Override
    public boolean equals(Object obj) {
        MyPoint p = (MyPoint)obj;
        return (x == p.getX() && y == p.getY());
    }

    public static void main(String[] args) {
        MyPoint p = new MyPoint(3, 50);
        MyPoint q = new MyPoint(4, 50);
        System.out.println(p);
        if (p.equals(q)) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }
    }
}

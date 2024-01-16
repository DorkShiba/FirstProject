package JavaStudy.Chap_4.PracticalProblem;

// Problem 4
public class Rectangle {
    private int x;  // 좌하단 점 x 좌표
    private int y;  // 좌하단 점 y 좌표
    private int width;  // 직사각형 가로 길이
    private int height;  // 직사각형 세로 길이

    public Rectangle(int x, int y, int width, int height) {
        this.x = x; this.y = y;
        this.width = width; this.height = height;
    }

    // 필드 게터
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    // 필드 세터
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    // 직사각형의 넓이를 리턴하는 메소드
    public int square() {
        return width * height;
    }

    // 직사각형의 정보를 설명하는 메소드
    public void show() {
        System.out.println("(" + this.x + "," + this.y + ")에서 크기가 " +
                this.width + "x" + this.height + "인 사각형");
    }

    // 매개변수로 받은 직사각형이 현재 직사각형 안에 들어있는지 리턴하는 메소드
    public boolean contains(Rectangle r) {
        return this.x < r.getX() && this.x + this.width > r.getX() + r.getWidth() &&
                this.y < r.getY() && this.y + this.height > r.getY() + r.getHeight();
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(1, 1, 10, 10);

        r.show();
        System.out.println("s의 면적은 " + s.square());
        if (t.contains(r)) { System.out.println("t는 r을 포함한다"); }
        if (t.contains(s)) { System.out.println("t는 s를 포함한다"); }
    }
}

package Sample.Chap_5;

public abstract class GameObject {
    protected int distance;  // 한 번 이동 거리
    protected int x, y;  // 현재 위치
    public GameObject(int startX, int startY, int distance) {
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public boolean collide(GameObject p) {
        return (this.x == p.getX() && this.y == p.getY());
    }

    protected abstract void move();  // 이동한 후의 새로운 위치로 좌표 변경
    protected abstract char getShape();  // 객체 모양 문자 리턴
}
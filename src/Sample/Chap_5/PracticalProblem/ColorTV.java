package Sample.Chap_5.PracticalProblem;

public class ColorTV extends TV {
    private int resolution;
    public ColorTV(int size, int resolution) {
        super(size);
        this.resolution = resolution;
    }

    public int getResolution() { return resolution; }
    public void printProperty() {
        System.out.println(this.getSize() + "인치 " + resolution + "컬러");
    }
}

class TV {
    private int size;
    public TV(int size) { this.size = size; }
    protected int getSize() { return size; }
}
